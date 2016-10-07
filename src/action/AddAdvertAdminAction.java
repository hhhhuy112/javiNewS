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
 * Servlet implementation class AddAdvertAdminAction
 */
public class AddAdvertAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAdvertAdminAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		if (userLogin == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		AdvertBO advertBO = new AdvertBO();
		String type = request.getParameter("type");
		if (!"load".equals(type)) {
			String nameAdvert = "", link = "", picture = "";
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			try {
				List<FileItem> formitems = upload.parseRequest(request);
				for (FileItem item : formitems) {
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
						// khac file
						// title = request.getParameter("tentin");
						switch (name) {
						case "name":
							nameAdvert = value;
							break;
						case "link":
							link = value;
							break;
						case "picture":
							picture = value;
							break;
						}
					} else {
						// la file
						String fileName = item.getName();
						if (item.getSize() != 0) {
							// tạo thư mục uploads
							String uploadDir = request.getServletContext().getRealPath("") + java.io.File.separator
									+ "files";
							File dir = new File(uploadDir);
							if (!dir.exists()) {
								dir.mkdirs();
							}
							String dinhDang = FilenameUtils.getExtension(fileName);
							if ("jpg".equals(dinhDang) || "png".equals(dinhDang)) {
								picture = "Bnews-" + System.nanoTime() + "." + dinhDang;
								// tao duong dan that den file tren dia
								String RealPathFile = uploadDir + File.separator + picture;

								// upload file lên ổ đĩa
								File file = new File(RealPathFile);
								// out.println(RealPathFile);
								try {
									item.write(file);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}else{
								Advert advert1=new Advert(0, nameAdvert, link, "chuaco");
								request.setAttribute("advert1", advert1);
								RequestDispatcher rd = request.getRequestDispatcher("addAdvert.jsp?msg=Chỉ được chọn file có đuôi .png hoặc .jpg");
								rd.forward(request, response);
							}
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Advert advert = new Advert(0, nameAdvert, link, picture);
			if (advertBO.addAdvert(advert)) {
				response.sendRedirect("list-advert");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("addAdvert.jsp?msg=Có lỗi xảy ra");
				rd.forward(request, response);
			}
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("addAdvert.jsp");
			rd.forward(request, response);
		}
	}
}
