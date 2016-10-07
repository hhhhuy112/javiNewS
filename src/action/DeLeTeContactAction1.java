package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.News;
import bean.Users;
import bo.ContactBO;
import bo.NewsBO;

/**
 * Servlet implementation class DeLeTeContactAction1
 */
public class DeLeTeContactAction1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeLeTeContactAction1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

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
		
		ContactBO contactBO=new ContactBO();
		if(value!=""){
			ArrayList<Integer> listIdContact =contactBO.getListIdContactCheckBox(value);
			
			if(contactBO.deleteCheckBox(listIdContact)==true){
				response.sendRedirect("admin/list-contact");
			}else{
				response.sendRedirect("admin/list-contact?msg=Loi trong qua trinh xoa");
			}
		}else{
				String idContact=request.getParameter("chk");
			if(	contactBO.delContact(Integer.parseInt(idContact))==true){
				response.sendRedirect("admin/list-contact");
			}else{
				response.sendRedirect("admin/list-contact?msg=Loi trong qua trinh xoa1");
			}
		}
		
	}

}
