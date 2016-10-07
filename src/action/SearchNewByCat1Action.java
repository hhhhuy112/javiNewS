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
import bean.SplitPages;
import bean.Users;
import bo.CatBO;
import bo.NewsBO;
import bo.SplitPagesBO;

/**
 * Servlet implementation class SearchNewByCat1Action
 */
public class SearchNewByCat1Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int NUMBER_NEWS_PER_PAGE1=5;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNewByCat1Action() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
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
		NewsBO newsBO=new NewsBO();
		int idCat=Integer.parseInt(request.getParameter("danhmuc"));
		if(idCat==0){
			response.sendRedirect("admin/list-news");
			return;	
		}
		String t=request.getParameter("paper");
		int offset=0;
		int trang=1;
		if(t!=null){
			trang=Integer.parseInt(t);
			offset=(trang-1)*NUMBER_NEWS_PER_PAGE;
		}else{
			offset=0;
		}
		int sotin=newsBO.numberAllNews1();
		int	tongTrang=(int) Math.ceil(sotin/NUMBER_NEWS_PER_PAGE);
		request.setAttribute("tongTrang"  ,tongTrang);
		request.setAttribute("trang"  ,trang);
		ArrayList<News> listNewsByCat= newsBO.getListNewsByPage(offset, NUMBER_NEWS_PER_PAGE,idCat);
		CatBO catBO=new CatBO();
		ArrayList<Category> listCat=catBO.getListCat();
		request.setAttribute("listCat", listCat);
		request.setAttribute("listNews", listNewsByCat);
		RequestDispatcher rd = request.getRequestDispatcher("admin/indexNews.jsp?css=0&&idCat="+idCat);
		rd.forward(request, response);

	}
}


