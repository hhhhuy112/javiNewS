<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<script src="<%=request.getContextPath()%>/templates/libraries/jquery-2.1.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/templates/libraries/jquery.validate.js"></script>
		<script src="<%=request.getContextPath()%>/templates/libraries/ckeditor/ckeditor.js"></script>	
		<title>VinaTAB EDU - Admin template</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templates/admin/css/styles.css" media="screen" />
        
	</head>
	<body>
    	<!-- Header -->
        <div id="header">
            <!-- Header. Status part -->
            <div id="header-status">
                <div class="container_12">
                    <div class="grid_4">
                    	<ul class="user-pro">
                    	<%Users userLogin=(Users)session.getAttribute("userLogin"); 
                    		if(userLogin!=null){
                    	%>
							<li><a href="<%=request.getContextPath()%>/admin/logout">Logout</a></li>
							<li>Chào, <a href="<%=request.getContextPath()%>/admin/edit-users?username=<%=userLogin.getUsername()%>"><%=userLogin.getFullname()%></a></li>
                    	<%}else{ %>
                    		<li><a href="<%=request.getContextPath()%>/admin/login">Login</a></li>
							<li>Chào,bạn</li>
                    	<%} %>
                    	</ul>
                    </div>
                </div>
                <div style="clear:both;"></div>
            </div> <!-- End #header-status -->
            
            <!-- Header. Main part -->
            <div id="header-main">
                <div class="container_12">
                    <div class="grid_12">
                        <div id="logo">
                            <ul id="nav">
                        <%
                    		if(userLogin!=null){
                    	%>
                    	<%String css1=request.getParameter("css"); 
							int	css2=0;
							if(css1!=null){
							css2=Integer.parseInt(css1);
							}
						%>
                                <li <%if(css1!=null){if(css2==0){ %> id="current"<%} }%>><a href="<%=request.getContextPath()%>/admin?css=0">Quản trị</a></li>
                                <li <%if(css1!=null){if(css2==1){ %> id="current"<%} }%>><a href="<%=request.getContextPath()%>/admin/edit-users?username=<%=userLogin.getUsername()%>&&css=1">Tài khoản</a></li>
                                 <li <%if(css1!=null){if(css2==2){ %> id="current"<%} }%>><a href="<%=request.getContextPath()%>/admin/list-users?css=2">Người dùng</a></li>
                            <%} %>
                            </ul>
                        </div><!-- End. #Logo -->
						<script type="text/javascript" language="javascript">
						      function Link1(){
						         $(".L1").addId("current");
						      }
						</script>
                    </div><!-- End. .grid_12-->
                    <div style="clear: both;"></div>
                </div><!-- End. .container_12 -->
            </div> <!-- End #header-main -->
            <div style="clear: both;"></div>
            <!-- Sub navigation -->
            <div id="subnav">
                <div class="container_12">
                    <div class="grid_12">
                        <ul>
                        <%
                    		if(userLogin!=null){
                    	%>
                            <li><a href="<%=request.getContextPath()%>/admin/list-news">Tin tức</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/list-cat">Danh mục</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/list-about">Giới thiệu</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/list-contact">Liên hệ</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/list-support">Trợ giúp</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/list-advert">Quảng cáo</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/split-pages">Phân trang</a></li>
                        <%} %>
                        </ul>
                        
                    </div><!-- End. .grid_12-->
                </div><!-- End. .container_12 -->
                <div style="clear: both;"></div>
            </div> <!-- End #subnav -->
        </div> <!-- End #header -->
        
		<div class="container_12">