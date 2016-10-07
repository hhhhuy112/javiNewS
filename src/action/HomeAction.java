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

import bean.Advert;
import bean.Category;
import bean.News;
import bean.Support;
import bo.AdvertBO;
import bo.CatBO;
import bo.NewsBO;
import bo.SupportBO;

/**
 * Servlet implementation class HomeAction
 */
public class HomeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int NUMBER_NEWS_PER_PAGE=5;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeAction() {
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
		PrintWriter out = response.getWriter();
		CatBO catBO=new CatBO();
		ArrayList<Category> listCat=catBO.getListCat();
		request.setAttribute("listCat", listCat);
		
		NewsBO newsBO=new NewsBO();
		ArrayList<ArrayList<News>> listget=newsBO.getList(listCat,NUMBER_NEWS_PER_PAGE);
		request.setAttribute("listget", listget);
		
		SupportBO supportBO=new SupportBO();
		ArrayList<Support> listSupport=supportBO.getListSupport();
		request.setAttribute("listSupport", listSupport);
		
		AdvertBO advertBO=new AdvertBO();
		ArrayList<Advert> listAdvert=advertBO.getListAdvert();
		request.setAttribute("listAdvert", listAdvert);
		
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp?css=0");
		rd.forward(request, response);
	}

}
