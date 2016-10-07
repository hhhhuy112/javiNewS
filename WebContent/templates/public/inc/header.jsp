<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tin tức Việt - Nhật | JaviOnline.net</title>
<link href="<%=request.getContextPath()%>/templates/public/css/style.css" type="text/css"
	rel="stylesheet" />
<script src="<%=request.getContextPath()%>/templates/libraries/jquery-2.1.1.min.js"></script>
<script src="<%=request.getContextPath()%>/templates/libraries/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/templates/libraries/ckeditor/ckeditor.js"></script>	
</head>
<body>
	<a name="totop"></a>
	<div class="wrapper">
		<div id="top-nav">
			<div class="main-content">
				<p class="fl">
					<a href="lienhe9e5c.html?current=lienhe" title="">[+] Gửi ý kiến phản hồi cho chúng tôi</a>
				</p>
				<p class="fr mail-icon">
					<a href="lienhe9e5c.html?current=lienhe" title="">HOT line: 0909.123.456 - 064.3456.789</a>
				</p>
				<div class="clr"></div>
			</div>
		</div>

		<div id="top-menu">
			<div class="main-content">
				<%String css1=request.getParameter("css"); 
				int	css2=0;
					if(css1!=null){
					css2=Integer.parseInt(css1);
					}
				%>
				<ul>
					<li <%if(css1!=null){if(css2==0){ %> class="parent current" <%} }%>><a href="<%=request.getContextPath()%>/home">Trang chủ</a></li>
					<li <%if(css1!=null){if(css2==1){ %> class="parent current" <%} }%>><a href="<%=request.getContextPath()%>/home/detail-about?css=1">Giới thiệu</a></li>
					<li <%if(css1!=null){if(css2==2){ %> class="parent current" <%} }%>><a href="<%=request.getContextPath()%>/home/send-contact?css=2">Liên hệ</a></li>

				</ul>
				
				<div class="clr"></div>
				<div class="clr"></div>
			</div>
			
		</div>