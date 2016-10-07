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

import bean.SplitPages;
import bean.Users;
import bo.SplitPagesBO;

/**
 * Servlet implementation class SplitPagesAdminAction
 */
public class SplitPagesAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SplitPagesAdminAction() {
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
		SplitPagesBO splitPagesBO=new SplitPagesBO();
		String submit=request.getParameter("set");
		if(submit!=null){
			int numAdmin=Integer.parseInt(request.getParameter("admin"));
			int numPublic=Integer.parseInt(request.getParameter("public"));
			SplitPages spitPages=new SplitPages(numAdmin, numPublic);
			if(splitPagesBO.setSplitPages(spitPages)==true){
			SplitPages splitPages= splitPagesBO.getSplitPages();
			request.setAttribute("splitpages", splitPages);
			RequestDispatcher rd=request.getRequestDispatcher("phanTrang.jsp?msg=Ok BaBy!!Success&&css=0");
			rd.forward(request, response);
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("phanTrang.jsp?msg=Error&&css=0 ");
				rd.forward(request, response);
			}
		}else{
			SplitPages splitPages= splitPagesBO.getSplitPages();
			request.setAttribute("splitpages", splitPages);
			RequestDispatcher rd=request.getRequestDispatcher("phanTrang.jsp?css=0");
			rd.forward(request, response);
		}
	}

}
