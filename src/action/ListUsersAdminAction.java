package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.News;
import bean.SplitPages;
import bean.Support;
import bean.Users;
import bo.NewsBO;
import bo.SplitPagesBO;
import bo.SupportBO;
import bo.UsersBO;

/**
 * Servlet implementation class ListUsersAdminAction
 */
@WebServlet("/ListUsersAdminAction")
public class ListUsersAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int NUMBER_NEWS_PER_PAGE1=5;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUsersAdminAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		Users userLogin=(Users)session.getAttribute("userLogin");
		if(userLogin==null){
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		int NUMBER_NEWS_PER_PAGE=NUMBER_NEWS_PER_PAGE1;
		SplitPagesBO splitPagesBO=new SplitPagesBO();
		SplitPages splitPages=splitPagesBO.getSplitPages();
		if(splitPages!=null){
			NUMBER_NEWS_PER_PAGE=splitPages.getNumAdmin();
		}
		UsersBO usersBO=new UsersBO();
		String t=request.getParameter("paper");
		int offset=0;
		int trang=1;
		if(t!=null){
			trang=Integer.parseInt(t);
			offset=(trang-1)*NUMBER_NEWS_PER_PAGE;
		}else{
			offset=0;
		}
		int sotin=usersBO.numberAllNews();
		int	tongTrang=(int) Math.ceil((float)sotin/NUMBER_NEWS_PER_PAGE);
		request.setAttribute("tongTrang"  ,tongTrang);
		request.setAttribute("trang"  ,trang);
		ArrayList<Users> listUsers= usersBO.getListUsersByPage(offset, NUMBER_NEWS_PER_PAGE);
		
		request.setAttribute("listUsers", listUsers);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexUsers.jsp");
		rd.forward(request, response);
	}
}
