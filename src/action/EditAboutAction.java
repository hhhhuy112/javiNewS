package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.About;
import bean.Category;
import bean.Users;
import bo.AboutBO;
import bo.CatBO;

/**
 * Servlet implementation class EditCatAction
 */
public class EditAboutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAboutAction() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Users userLogin=(Users)session.getAttribute("userLogin");
		if(userLogin==null){
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		AboutBO aboutBO=new AboutBO();
		String submit = request.getParameter("edit");
		if("Edit".equals(submit)){
			About about=new About();
			String title = request.getParameter("title");
			String idabout = request.getParameter("idabout");
			String detail = request.getParameter("detail");
			about.setIdAbout(Integer.parseInt(idabout));
			about.setTitleAbout(title);
			about.setDetailAbout(detail);
			
			if(aboutBO.editAbout(about)){
				response.sendRedirect("list-about?css=0");
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/indexAbout.jsp?css=0&&msg=Có lỗi trong quá trình thêm");
				rd.forward(request, response);
			}
		}
		else{
			int idAbout = Integer.parseInt(request.getParameter("idAbout"));
			About about = aboutBO.getAboutDetail(idAbout );
			
			request.setAttribute("about",about);
			RequestDispatcher rd = request.getRequestDispatcher("editAbout.jsp?css=0");
			rd.forward(request, response);
		}
		
	}

}
