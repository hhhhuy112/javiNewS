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

import bean.About;
import bean.Advert;
import bean.Category;
import bean.Support;
import bo.AboutBO;
import bo.AdvertBO;
import bo.CatBO;
import bo.SupportBO;

/**
 * Servlet implementation class DetailAboutAction
 */
public class DetailAboutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailAboutAction() {
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
		String css=request.getParameter("css");
		AboutBO aboutBO=new AboutBO();
		ArrayList<About> listAbout= aboutBO.getListAboutByPage(0, 1);
		request.setAttribute("listAbout",listAbout);
		
		CatBO catBO=new CatBO();
		ArrayList<Category> listCat=catBO.getListCat();
		request.setAttribute("listCat", listCat);
		
		SupportBO supportBO=new SupportBO();
		ArrayList<Support> listSupport=supportBO.getListSupport();
		request.setAttribute("listSupport", listSupport);
		
		AdvertBO advertBO=new AdvertBO();
		ArrayList<Advert> listAdvert=advertBO.getListAdvert();
		request.setAttribute("listAdvert", listAdvert);
		
		RequestDispatcher rd = request.getRequestDispatcher("/gioithieu.jsp?css="+css);
		rd.forward(request, response);
	}

}
