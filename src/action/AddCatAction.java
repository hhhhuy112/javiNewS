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
import bo.CatBO;

/**
 * Servlet implementation class AddCatAction
 */

public class AddCatAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCatAction() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Users userLogin=(Users)session.getAttribute("userLogin");
		if(userLogin==null){
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		String submit = request.getParameter("add");
		CatBO catBO = new CatBO();
		if(submit!=null){
			String nameCat = request.getParameter("namecat");
			if(catBO.addCat(nameCat)){
				response.sendRedirect("list-cat");
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/addCat.jsp?css=0&&msg=Có lỗi trong quá trình thêm");
				rd.forward(request, response);
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addCat.jsp?css=0");
			rd.forward(request, response);
		}
	}

}
