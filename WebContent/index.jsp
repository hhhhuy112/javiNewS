<%@page import="bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="templates/public/inc/header.jsp"%>
<%@include file="templates/public/inc/left_bar.jsp"%>

<div class="body-right fr">
	<% ArrayList<ArrayList<News>> listGet=(ArrayList<ArrayList<News>>)request.getAttribute("listget"); 
		if(listGet!=null){
			for(int i=0;i<listGet.size();i++){
				if(listGet.get(i)!=null){
	%>
	<div class="news-block">
	<h2 class="title-cat">
		<a href="<%=request.getContextPath()%>/home/list-news-cat?idCat=<%=listGet.get(i).get(0).getIdCat()%>" title=""><%=listGet.get(i).get(0).getNameCat()%></a>
	</h2>
	<div class="content-cat">
		<div class="item-left fl">
			<a href="<%=request.getContextPath()%>/home/detail-news?idNews=<%=listGet.get(i).get(0).getIdNews()%>" title=""><img src="<%=request.getContextPath()%>/files/<%=listGet.get(i).get(0).getPicture() %>" alt=""></a>
			<a href="<%=request.getContextPath()%>/home/detail-news?idNews=<%=listGet.get(i).get(0).getIdNews()%>" title="" class="title"><%=listGet.get(i).get(0).getTitle()%></a>
			<p><%=listGet.get(i).get(0).getDescription()%></p>
		</div>
			<% 
				for(int j=1;j<listGet.get(i).size();j++){
			%>
			<div class="item-right fr">
			<ul>
				<li><a href="<%=request.getContextPath()%>/home/detail-news?idNews=<%=listGet.get(i).get(j).getIdNews()%>" title="" class="title"><%=listGet.get(i).get(j).getTitle()%></a>
					<p class="cat-date">
						<a href="<%=request.getContextPath()%>/home/list-news-cat?idCat=<%=listGet.get(i).get(j).getIdCat()%>" title=""><%=listGet.get(i).get(j).getNameCat()%></a> <span>Cập nhật: <%=listGet.get(i).get(j).getDatecreat()%></span> <span>View: <%=listGet.get(i).get(j).getView()%></span>
					</p>
					<p class="preview"><%=listGet.get(i).get(j).getDescription()%></p></li>
			</ul>
			</div>
			<%} %>
			
						
						<div class="clr"></div>
	</div>
</div>
<%} }}%>
</div>
<div class="clr"></div>
</div>
</div>
<%@include file="templates/public/inc/footer.jsp"%>