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
import bo.NewsBO;
import bo.UsersBO;

/**
 * Servlet implementation class LoginAction
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
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
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String submit=request.getParameter("login");
		UsersBO usersBO=new UsersBO();
		if(submit!=null){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Users user=new Users(username, password, "fullname","address",0);
		Users userLogin = usersBO.checkLogin(user);
		if(userLogin!=null){
			HttpSession session = request.getSession();
			session.setAttribute("userLogin", userLogin);
			response.sendRedirect("admin");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp?msg=Sai tên đăng nhập hoặc mật khẩu");
			rd.forward(request, response);
		}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
	}

}
