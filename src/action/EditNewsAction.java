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

import bean.Category;
import bean.News;
import bean.Users;
import bo.CatBO;
import bo.NewsBO;

/**
 * Servlet implementation class EditNewsAction
 */

public class EditNewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditNewsAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		NewsBO newsBO = new NewsBO();
		CatBO catBO = new CatBO();
		ArrayList<Category> listCat = catBO.getListCat();
		request.setAttribute("listCat", listCat);
		String type = request.getParameter("type");
		if (!"load".equals(type)) {
			Date date =new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String datecreat= sdf.format(date); 
			String title = "", description = "", detail = "",description1 = "", detail1 = "", picture = "";
			int idNews = 0, idCat = 0;
			// String title = request.getParameter("tentin");
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
						case "idtintuc":
							idNews = Integer.parseInt(value);
							break;
						case "picture":
							picture = value;
							break;
						case "tentin":
							title = value;
							break;
						case "danhmuc":
							idCat = Integer.parseInt(value);
							break;
						case "mota":
							description = value;
							break;
						case "chitiet":
							detail = value;
							break;
						case "mota1":
							description1 = value;
							break;
						case "chitiet1":
							detail1 = value;
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
							
							String dinhDang=FilenameUtils.getExtension(fileName);
							if("jpg".equals(dinhDang)||"jpg".equals(dinhDang)){
							picture = "Bnews-" + System.nanoTime() + "." + dinhDang;
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
							}else{
								News news = new News();
								news.setIdNews(idNews);
								news.setTitle(title);
								news.setDescription(description1);
								news.setPicture(picture);
								news.setIdCat(idCat);
								news.setDetail(detail1);
								news.setDatecreat(datecreat);
								request.setAttribute("news", news);
								RequestDispatcher rd = request.getRequestDispatcher("editNews.jsp?msg1=Chỉ được chọn hình có đuôi .jpg hoặc .png");
								rd.forward(request, response);
								return;
							}
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			News news = new News();
			news.setIdNews(idNews);
			news.setTitle(title);
			news.setDescription(description);
			news.setPicture(picture);
			news.setIdCat(idCat);
			news.setDetail(detail);
			news.setDatecreat(datecreat);
			
			if(newsBO.editNews(news)==true){
				response.sendRedirect("list-news");
			}else{
				response.sendRedirect("/admin/list-news?msg=lỗi trong quá trình sửa");
			}
			out.println(news.getTitle()+picture);

		} else {
			int idNews =Integer.parseInt(request.getParameter("idnews")); 
			News news = newsBO.getDetail(idNews);
			request.setAttribute("news", news);
			RequestDispatcher rd = request.getRequestDispatcher("editNews.jsp");
			rd.forward(request, response);
		}
	}

}
