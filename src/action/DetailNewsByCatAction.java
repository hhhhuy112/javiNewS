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
import dao.NewsDAO;

/**
 * Servlet implementation class DetailNewsByCatAction
 */
public class DetailNewsByCatAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int NUM_PER_PAGE=4;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailNewsByCatAction() {
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
		NewsBO newsBO=new NewsBO();
		int idNews=Integer.parseInt(request.getParameter("idNews"));
		if(idNews>0){
		News news1 =newsBO.getDetail(idNews);	
		ArrayList<News> listNewsRel= newsBO.getlistRel(news1.getIdCat(),idNews,NUM_PER_PAGE);
		request.setAttribute("listNewsRel", listNewsRel);
		
		newsBO.setView(idNews);	
		News news=newsBO.getDetail(idNews);
		request.setAttribute("news", news);
		ArrayList<News> listNewsUnRel= newsBO.getlistUnRel(news1.getIdCat(),NUM_PER_PAGE);
		request.setAttribute("listNewsUnRel", listNewsUnRel);
		
		CatBO catBO=new CatBO();
		ArrayList<Category> listCat=catBO.getListCat();
		request.setAttribute("listCat", listCat);
		
		SupportBO supportBO=new SupportBO();
		ArrayList<Support> listSupport=supportBO.getListSupport();
		request.setAttribute("listSupport", listSupport);
		
		AdvertBO advertBO=new AdvertBO();
		ArrayList<Advert> listAdvert=advertBO.getListAdvert();
		request.setAttribute("listAdvert", listAdvert);
		
		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp?css=0");
		rd.forward(request, response);
		}
	}

}
