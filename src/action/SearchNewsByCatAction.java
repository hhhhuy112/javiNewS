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

import bean.Category;
import bean.News;
import bo.CatBO;
import bo.NewsBO;

/**
 * Servlet implementation class SearchNewsByCatAction
 */
public class SearchNewsByCatAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public  static final int NUM_PER_PAGE=4;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNewsByCatAction() {
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
		PrintWriter out = response.getWriter();
		int  idCat;
		idCat=Integer.parseInt(request.getParameter("idCat"));
		
		NewsBO newsBO=new NewsBO();
		
		String t=request.getParameter("paper");
		int offset=0;
		int trang=1;
		if(t!=null){
			trang=Integer.parseInt(t);
			offset=(trang-1)*NUM_PER_PAGE;
		}else{
			offset=0;
		}
		int sotin=newsBO.numberAllNews(idCat);
		int	tongTrang=(int) Math.ceil((float)sotin/NUM_PER_PAGE);
		request.setAttribute("idCat", idCat);	
		request.setAttribute("tongTrang"  ,tongTrang);
		request.setAttribute("trang"  ,trang);
		ArrayList<News> listNews= newsBO.getListNewsByPage(offset, NUM_PER_PAGE, idCat);
		
		request.setAttribute("listNewsByCat", listNews);
		CatBO catBO=new CatBO();
		Category cat=catBO.getCatDetail(idCat);
		request.setAttribute("cat", cat);
		ArrayList<Category> listCat=catBO.getListCat();
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("danhmuc.jsp");
		rd.forward(request, response);
	}

}
