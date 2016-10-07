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
import bean.SplitPages;
import bean.Support;
import bo.AdvertBO;
import bo.CatBO;
import bo.NewsBO;
import bo.SplitPagesBO;
import bo.SupportBO;

/**
 * Servlet implementation class ListNewsByCat
 */
@WebServlet("/ListNewsByCat")
public class ListNewsByCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public  static final int NUM_PER_PAGE1=4;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNewsByCat() {
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
		int NUM_PER_PAGE=NUM_PER_PAGE1;
		SplitPagesBO splitPagesBO=new SplitPagesBO();
		SplitPages splitPages=splitPagesBO.getSplitPages();
		if(splitPages!=null){
			NUM_PER_PAGE=splitPages.getNumPublic();
		}
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
		ArrayList<News> listNews= newsBO.getListNewsByCat(offset, NUM_PER_PAGE,idCat);
		request.setAttribute("listNewsByCat", listNews);
		CatBO catBO=new CatBO();
		Category cat=catBO.getCatDetail(idCat);
		request.setAttribute("cat", cat);
		ArrayList<Category> listCat=catBO.getListCat();
		request.setAttribute("listCat", listCat);
		
		SupportBO supportBO=new SupportBO();
		ArrayList<Support> listSupport=supportBO.getListSupport();
		request.setAttribute("listSupport", listSupport);
		
		AdvertBO advertBO=new AdvertBO();
		ArrayList<Advert> listAdvert=advertBO.getListAdvert();
		request.setAttribute("listAdvert", listAdvert);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/danhmuc.jsp?css=0");
		rd.forward(request, response);
	}
}


