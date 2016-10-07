package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import bean.Advert;
import bean.Users;
import bo.AdvertBO;

/**
 * Servlet implementation class EditAdvertAdminAction
 */
public class EditAdvertAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAdvertAdminAction() {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Users userLogin=(Users)session.getAttribute("userLogin");
		if(userLogin==null){
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		AdvertBO advertBO = new AdvertBO();
		String type = request.getParameter("type");
		if (!"load".equals(type)) {
			String nameAdvert = "", link= "", picture= "";
			int idAdvert= 0; 
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			try {
				List<FileItem> formitems = upload.parseRequest(request);
				for (FileItem item : formitems) {
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
						// khac file
						switch (name) {
						case "idAdvert":
							idAdvert= Integer.parseInt(value);
							break;
						case "name":
							nameAdvert= value;
							break;	
						case "picture":
							picture = value;
							break;
						case "link":
							link = value;
							break;
						}
						
					} else {
						// la file
						String fileName = item.getName();
						if (item.getSize()!=0) {
							// tạo thư mục uploads
							String uploadDir = request.getServletContext().getRealPath("") + java.io.File.separator
									+ "files";
							File dir = new File(uploadDir);
							
							
							picture = "Bnews-" + System.nanoTime() + "." + FilenameUtils.getExtension(fileName);
							// tao duong dan that den file tren dia
							String RealPathFile = uploadDir + File.separator + picture;

							out.println(RealPathFile);
							// upload file lên ổ đĩa
							File file = new File(RealPathFile);
							// out.println(RealPathFile);
								try {
									item.write(file);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Advert advert=new Advert(idAdvert, nameAdvert, link, picture);
			
			if(advertBO.editAdvert(advert)==true){
				response.sendRedirect("list-advert");
			}else{
				response.sendRedirect("/admin/list-advert?msg=lỗi trong quá trình sửa");
			}
		} else {
			int idAdvert=Integer.parseInt(request.getParameter("idAdvert")); 
			Advert advert= advertBO.getDetail(idAdvert);
			request.setAttribute("advert", advert);
			RequestDispatcher rd = request.getRequestDispatcher("editAdvert.jsp");
			rd.forward(request, response);
		}
	}
}


