<%@page import="bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/templates/public/inc/header.jsp" %>
<%@include file="/templates/public/inc/left_bar.jsp" %>
<div class="body-right fr">
	
	<div class="news-block">
		<%ArrayList<News> listNews=(ArrayList<News>)request.getAttribute("listNewsByCat");
			Category cat=(Category)request.getAttribute("cat"); 
		if(listNews!=null){
	%>
		<h2 class="title-cat">
			<a href="" title=""><%=cat.getNameCat()%></a>
		</h2>
		<div class="content-cat1">
			<% for(int i=0;i<listNews.size();i++){ %>
			<div <%if(i==0) {%> class="item-top"<%}else{%>class="item"<%}%>>
				<div class="item-left fl">
					<a href="<%=request.getContextPath()%>/home/detail-news?idNews=<%=listNews.get(i).getIdNews()%>&&view=<%=listNews.get(i).getView()%>"
						title=""> 
						<img src="<%=request.getContextPath()%>/files/<%=listNews.get(i).getPicture()%>" alt=""/>;
					</a>
				</div>
				<div class="item-right-cat fr">
					<a href="<%=request.getContextPath()%>/home/detail-news?idNews=<%=listNews.get(i).getIdNews()%>&&view=<%=listNews.get(i).getView()%>"
						title="" class="title"><%=listNews.get(i).getTitle()%></a>
					<div style="margin: 10px;"></div>
					<p class="preview"><%=listNews.get(i).getDescription()%></p>
				</div>
				<div class="clr"></div>
			</div>			
			<%} %>
		</div>
		<%} %>			
		<div class="pager">
			<style>
.page-blue a {
	padding: 3px 7px;
	border: 1px solid green;
	background: green;
	color: #FFF;
	font-weight: bold;
	text-decoration: none;
}
.page-blue a:hover {
	padding: 3px 7px;
	border: 1px solid #144879;
	background: #144879;
	color: #FFF;
	font-weight: bold;
	text-decoration: none;
}

.page-blue .nav-current-page {
	padding: 3px 7px;
	border: 1px solid #144879;
	background: #144879;
	color: #FFF;
	font-weight: bold;
}
</style>
			<div class="page-blue">
								<%int tongTrang=(int )request.getAttribute("tongTrang");
									int trang=(int)request.getAttribute("trang");
																
									if(tongTrang>1){
										if(trang==1){
									%>
										<a href="<%=request.getContextPath()%>/home/list-news-cat?paper=1 &&idCat=<%=cat.getIdCat()%>" class="active">Trang1</a> |
									<% 	}else{
										%>
											<a href="<%=request.getContextPath()%>/home/list-news-cat?paper=1&&idCat=<%=cat.getIdCat()%>" >Trang1</a> |
										<% 
									}
										for(int j=2;j<=tongTrang;j++){
									if(j==trang){
								%>
								
											<a href="<%=request.getContextPath()%>/home/list-news-cat?paper=<%=j%>&&idCat=<%=cat.getIdCat()%>" class="active">Trang <%=j %></a> 
										<%}else{%>
									<a href="<%=request.getContextPath()%>/home/list-news-cat?paper=<%=j%>&&idCat=<%=cat.getIdCat()%> ">Trang <%=j%></a> 
								<%}
									if(j!=tongTrang){
										%>
										|
								
								<%}} }%>
			</div>
		</div>

	</div>

</div>
<div class="clr"></div>
</div>
</div>
<%@include file="/templates/public/inc/footer.jsp" %>