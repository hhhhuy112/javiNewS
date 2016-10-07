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

import bean.Category;
import bean.SplitPages;
import bean.Users;
import bo.CatBO;
import bo.SplitPagesBO;
import dao.Database;

/**
 * Servlet implementation class ListCatAdminAction
 */

public class ListCatAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int NUMBER_NEWS_PER_PAGE1=5;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCatAdminAction() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
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
		CatBO catBO=new CatBO(); 
		String t=request.getParameter("paper");
		int offset=0;
		int trang=1;
		if(t!=null){
			trang=Integer.parseInt(t);
			offset=(trang-1)*NUMBER_NEWS_PER_PAGE;
		}else{
			offset=0;
		}
		int sotin=catBO.numberAllNews();
		int	tongTrang=(int) Math.ceil((float)sotin/NUMBER_NEWS_PER_PAGE);
		request.setAttribute("tongTrang"  ,tongTrang);
		request.setAttribute("trang"  ,trang);
		ArrayList<Category> listCat= catBO.getListCatByPage(offset, NUMBER_NEWS_PER_PAGE);
		
		//ArrayList<News> listNews=newsBO.getListNewsByCat(idCat);
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexCat.jsp?css=0");
		rd.forward(request, response);
	}

}
