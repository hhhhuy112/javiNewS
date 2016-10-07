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
import bean.News;
import bean.Users;
import bo.CatBO;
import bo.NewsBO;

/**
 * Servlet implementation class SearchNewsAction
 */
public class SearchNewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int NUMBER_NEWS_PER_PAGE=5;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNewsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users userLogin=(Users)session.getAttribute("userLogin");
		if(userLogin==null){
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		PrintWriter out =response.getWriter();
		String nameNews=request.getParameter("search");
		NewsBO newsBO=new NewsBO();
		
		String t=request.getParameter("paper");
		int offset=0;
		int trang=1;
		if(t!=null){
			trang=Integer.parseInt(t);
			offset=(trang-1)*NUMBER_NEWS_PER_PAGE;
		}else{
			offset=0;
		}
	
		int sotin=newsBO.numberAllNews2(nameNews);
		
		int	tongTrang=(int) Math.ceil((float)sotin/NUMBER_NEWS_PER_PAGE);
		request.setAttribute("tongTrang"  ,tongTrang);
		request.setAttribute("trang"  ,trang);
		ArrayList<News> listNews= newsBO.getListNewsByPage2(offset, NUMBER_NEWS_PER_PAGE,nameNews);
		request.setAttribute("listNews", listNews);
		CatBO catBO=new CatBO();
		ArrayList<Category> listCat=catBO.getListCat();
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("admin/indexNews.jsp?css=0");
		rd.forward(request, response);
	}

}
