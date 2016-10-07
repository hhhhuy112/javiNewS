package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Advert;
import bean.Category;
import bean.Contact;
import bean.Support;
import bo.AdvertBO;
import bo.CatBO;
import bo.ContactBO;
import bo.SupportBO;

/**
 * Servlet implementation class AddContactAction
 */
public class AddContactAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactAction() {
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
		String submit = request.getParameter("submit");
		CatBO catBO=new CatBO();
		ArrayList<Category> listCat=catBO.getListCat();
		request.setAttribute("listCat", listCat);
		
		SupportBO supportBO=new SupportBO();
		ArrayList<Support> listSupport=supportBO.getListSupport();
		request.setAttribute("listSupport", listSupport);
		
		AdvertBO advertBO=new AdvertBO();
		ArrayList<Advert> listAdvert=advertBO.getListAdvert();
		request.setAttribute("listAdvert", listAdvert);
		
		ContactBO contactBO=new ContactBO();		
		if(submit!=null){
			Date date =new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String datecreat= sdf.format(date); 
			String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String website = request.getParameter("website");
			String content = request.getParameter("content");
			
			Contact contact=new Contact(0, name, email, Integer.parseInt(phone), website, content, datecreat);
			if(contactBO.addContact(contact)==true){
				RequestDispatcher rd = request.getRequestDispatcher("/lienhe.jsp?msg=Đã gửi thành công&&css=2");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/lienhe.jsp.jsp?msg=Có lỗi trong quá trình gửi&&css=2");
				rd.forward(request, response);
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/lienhe.jsp?css=2");
			rd.forward(request, response);
		}
	}

}
