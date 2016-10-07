package action;

import java.io.File;
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
import bean.Users;
import bo.NewsBO;

/**
 * Servlet implementation class DeLeTeNewsAction1
 */
public class DeLeTeNewsAction1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeLeTeNewsAction1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String value = request.getParameter("virtual");
		NewsBO newsBO=new NewsBO();
		if(value!=""){
			ArrayList<Integer> listIdNews =newsBO.getListIdNewsCheckBox(value);
			ArrayList<News> listNewsCheckBox=new ArrayList<News>();
			
			for(Integer idNews :listIdNews){
				News news=newsBO.getDetail(idNews); 
					listNewsCheckBox.add(news);
			}
			if(newsBO.deleteCheckBox(listIdNews)==true){
				String uploadDir = request.getServletContext().getRealPath("") + java.io.File.separator
						+ "files";	
				for(News news:listNewsCheckBox){
						String RealPathFile = uploadDir + File.separator + news.getPicture();
						File file=new File(RealPathFile);
						file.delete();
				}
				response.sendRedirect("admin/list-news?css=0");
			}else{
				response.sendRedirect("admin/list-news?msg=Loi trong qua trinh xoa&&css=0");
			}
		}else{
			String idNews=request.getParameter("chk");
			response.sendRedirect("admin/del-news?css=0&&idnews="+idNews);
		}
		
		
	}
}

