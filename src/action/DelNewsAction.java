package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class DelNewsAction
 */
public class DelNewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelNewsAction() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users userLogin=(Users)session.getAttribute("userLogin");
		if(userLogin==null){
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		int idnews=Integer.parseInt(request.getParameter("idnews"));
		NewsBO newsBO=new NewsBO();
		News news=newsBO.getDetail(idnews);
		if(newsBO.delNews(idnews)==true){
			
			String uploadDir = request.getServletContext().getRealPath("") + java.io.File.separator
					+ "files";
			String RealPathFile = uploadDir + File.separator + news.getPicture();
			File file=new File(RealPathFile);
			file.delete();
			response.sendRedirect("list-news?css=0");
		}else{
			response.sendRedirect("list-news?msg=Co loi trong qua trinh xoa&&css=0");
		}
	}

}
