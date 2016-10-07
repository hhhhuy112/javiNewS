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

import bean.Category;
import bean.Users;
import bo.CatBO;

/**
 * Servlet implementation class EditCatAction
 */
public class EditCatAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCatAction() {
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
		CatBO catBO = new CatBO();
		String submit = request.getParameter("edit");
		if("Edit".equals(submit)){
			Category cat = new Category();
			String nameCat = request.getParameter("namecat");
			String idCat = request.getParameter("idcat");
			cat.setIdCat(Integer.parseInt(idCat));
			cat.setNameCat(nameCat);
			
			if(catBO.editCat(cat)){
				response.sendRedirect("list-cat");
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/editCat.jsp?msg=Có lỗi trong quá trình thêm&&css=0");
				rd.forward(request, response);
			}
		}
		else{
			int idCat = Integer.parseInt(request.getParameter("idcat"));
			out.print(idCat);
			Category cat = catBO.getCatDetail(idCat);
			request.setAttribute("cat",cat);
			out.println(cat.getNameCat());
			RequestDispatcher rd = request.getRequestDispatcher("editCat.jsp&&css=0");
			rd.forward(request, response);
		}
		
	}

}
