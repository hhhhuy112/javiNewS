<%@page import="bean.About"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/templates/public/inc/header.jsp" %>
<%@include file="/templates/public/inc/left_bar.jsp" %>
<div class="body-right fr">
	<div class="news-block">
		<h2 class="title-cat">Giới thiệu website thông tin về Việt - Nhật</h2>
		<div class="content-cat1">
			<div class="content-detail gioithieu">
				<%ArrayList<About> listAbout=(ArrayList<About>)request.getAttribute("listAbout");
					if(listAbout!=null){
				%>
				<p><%=listAbout.get(0).getDetailAbout()%></p>
				<%} %>
			</div>							
		</div>
	</div>
		
</div>
<div class="clr"></div> 
<%@include file="/templates/public/inc/footer.jsp" %>   
