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

import bean.Advert;
import bean.Users;
import bo.AdvertBO;

/**
 * Servlet implementation class DeleteCkAdvertAdminAction
 */
public class DeleteCkAdvertAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCkAdvertAdminAction() {
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
		String value = request.getParameter("virtual");
		AdvertBO advertBO=new AdvertBO();
		if(value!=""){
			ArrayList<Integer> listIdAdvert=advertBO.getListIdAdvertCheckBox(value);
			ArrayList<Advert> listAdvertCheckBox=new ArrayList<Advert>();
			
			for(Integer idAdvert:listIdAdvert){
				Advert advert=advertBO.getDetail(idAdvert); 
					listAdvertCheckBox.add(advert);
			}
			if(advertBO.deleteCheckBox(listIdAdvert)==true){
				String uploadDir = request.getServletContext().getRealPath("") + java.io.File.separator
						+ "files";	
				for(Advert advert:listAdvertCheckBox){
						String RealPathFile = uploadDir + File.separator + advert.getPicture();
						File file=new File(RealPathFile);
						file.delete();
				}
				response.sendRedirect("admin/list-advert");
			}else{
				response.sendRedirect("admin/list-advert?msg=Loi trong qua trinh xoa");
			}
		}else{
			String idAdvert=request.getParameter("chk");
			Advert advert=advertBO.getDetail(Integer.parseInt(idAdvert));
			ArrayList<Integer> listIdAdvert=new ArrayList<Integer>();
			listIdAdvert.add(Integer.parseInt(idAdvert));
			if(advertBO.deleteCheckBox(listIdAdvert)==true){
				String uploadDir = request.getServletContext().getRealPath("") + java.io.File.separator
						+ "files";	
				String RealPathFile = uploadDir + File.separator + advert.getPicture();
				File file=new File(RealPathFile);
				file.delete();
				response.sendRedirect("admin/list-advert");
			}else{
				response.sendRedirect("admin/list-advert?msg=Loi trong qua trinh xoa");
			}
		}
		
		
	}

}
