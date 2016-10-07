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
import bean.Support;
import bean.Users;
import bo.AboutBO;
import bo.CatBO;
import bo.SupportBO;

/**
 * Servlet implementation class EditCatAction
 */
public class EditSupportAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSupportAdminAction() {
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
		SupportBO supportBO =new SupportBO(); 	
		String submit = request.getParameter("edit");
		if("Edit".equals(submit)){
			String fullname = request.getParameter("fullname");
			String idSupport = request.getParameter("idsupport");
			String skype = request.getParameter("skype");
			String yahoo = request.getParameter("yahoo");
			Support support =new Support(Integer.parseInt(idSupport), fullname, yahoo, skype);
			if(supportBO .editSupport(support)==true){
				response.sendRedirect("list-support?css=0");
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/editSupport.jsp?css=0&&msg=Có lỗi trong quá trình thêm");
				rd.forward(request, response);
			}
		}
		else{
			int idSupport= Integer.parseInt(request.getParameter("idSupport"));
			Support support= supportBO.getAboutDetail(idSupport);
			request.setAttribute("support",support);
			RequestDispatcher rd = request.getRequestDispatcher("editSupport.jsp?css=0");
			rd.forward(request, response);
		}
		
	}

}
