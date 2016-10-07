<%@page import="bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/templates/public/inc/header.jsp" %>
<%@include file="/templates/public/inc/left_bar.jsp" %>
<div class="body-right fr">
	<div class="news-block detail">
		<%
			News news = (News)request.getAttribute("news");
		%>
		<h1 class="title"><%=news.getTitle()%></h1>
		<p class="cat-date">
			<a title="" href="<%=request.getContextPath()%>/home/list-news-cat?idCat=<%=news.getIdCat()%>"><%=news.getNameCat()%></a> <span>Cập nhật: <%=news.getDatecreat()%></span> <span>View: <%=news.getView()%></span>
		</p>
		<div class="content-detail">
			<p
				style="padding-top: 1em; padding-bottom: 1em; outline: none; list-style: none; border-style: none; color: rgb(51, 51, 51); font-family: Arial; font-size: 14px; line-height: 21px;">
				<span
					style="outline: none; list-style: none; border-style: none; font-size: medium;">
					<p style="text-align:start"><%=news.getDetail()%></p>
				</span>
			</p>
		</div>
		<div class="orther-detail">
			<div class="orther-news">
				<p class="title orther-icon">Các tin khác</p>
				<div class="items">
					<ul>
					<%ArrayList<News> listNewsRel=(ArrayList<News>)request.getAttribute("listNewsRel"); 
						if(listNewsRel!=null){
							for(News news1:listNewsRel){
					%>
					<li>
							<a href="<%=request.getContextPath()%>/home/detail-news?idNews=<%=news1.getIdNews()%>"
							title="">
										<img alt="" src="<%=request.getContextPath()%>/files/<%=news1.getPicture()%>">
							</a>
							<p>
								<a href="<%=request.getContextPath()%>/home/detail-news?idNews=<%=news1.getIdNews()%>"
									title=""><%=news1.getTitle() %></a>
							</p>
					</li>
					<%} }%>
						</ul>
					<div class="clr"></div>
				</div>
				<div class="items-noimg">
					<ul>
					<%	ArrayList<News> listNewsUnRel=(ArrayList<News>)request.getAttribute("listNewsUnRel"); 
					if(listNewsUnRel!=null){
						for(int i=0;i<2;i++){
 					 %>
						<li><a href="<%=request.getContextPath()%>/home/detail-news?idNews=<%=listNewsUnRel.get(i).getIdNews()%>"
								title="">
							<%=listNewsUnRel.get(i).getTitle() %>
							</a>
						</li>
						<%}} %>
					</ul>
					<div class="clr"></div>
				</div>

				
			</div>
		</div>
	</div>
</div>
<div class="clr"></div>
</div>
</div>
 <%@include file="/templates/public/inc/footer.jsp" %>   