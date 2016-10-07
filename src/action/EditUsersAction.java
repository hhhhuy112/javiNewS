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

import bean.Users;
import bo.UsersBO;


/**
 * Servlet implementation class EditUsersAction
 */

public class EditUsersAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUsersAction() {
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
		String css=request.getParameter("css");
		HttpSession session = request.getSession();
		Users userLogin=(Users)session.getAttribute("userLogin");
		if(userLogin==null){
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		
		String submit = request.getParameter("edit");
		String username = request.getParameter("username");
		if("abmin".equals(username)||username.equals(userLogin.getUsername())){
		UsersBO userBO = new UsersBO();
		if(submit!=null){
			
			Users users = new Users();
			String password = request.getParameter("password");
			String fullname = request.getParameter("fullname");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			users.setPassword(password);
			users.setUsername(username);
			users.setFullname(fullname);
			users.setAddress(address);
			users.setPhone(Integer.parseInt(phone));
			
			if(userBO.editUser(users)==true){
				if(css!=null){
				response.sendRedirect("list-users?css=1");
				}else{
					response.sendRedirect("list-users?css=2");
				}
			}	
			else{
				if(css!=null){
				RequestDispatcher rd = request.getRequestDispatcher("/admin/editUser.jsp?css=1&&msg=Có lỗi trong quá trình sửa");
				rd.forward(request, response);
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("/admin/editUser.jsp?css=2&&msg=Có lỗi trong quá trình sửa");
					rd.forward(request, response);
				}
			}
		}
		else{
			System.out.println(username);
			Users users = userBO.getUserDetail(username);
			request.setAttribute("user",users);
			if(css!=null){
			RequestDispatcher rd = request.getRequestDispatcher("editUser.jsp?css=1");
			rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("editUser.jsp?css=2");
				rd.forward(request, response);
			}
		}	
	}else{
		response.sendRedirect("list-users??css=2&&msg=Error!!!Don't edit");
	}
	}

}
