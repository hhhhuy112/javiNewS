<%@page import="bean.Advert"%>
<%@page import="bean.Support"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="main-body">
	<div class="main-content"><div class="body-left fl">
<div class="left-menu">
	<ul>
		<% ArrayList<Category> listCat=(ArrayList<Category>)request.getAttribute("listCat"); 
			if(listCat!=null){
				for(Category cat:listCat){
		%>
				<li class="parent"><a href="<%=request.getContextPath()%>/home/list-news-cat?idCat=<%=cat.getIdCat()%>"><%=cat.getNameCat()%></a></li>
		<%} }%>
	</ul>
	<div class="clr"></div>
</div>

<div class="support">
	<p>Hỗ trợ trực tuyến</p>
	<div class="yahoo">
		<ul>
			<% ArrayList<Support> listSupport=(ArrayList<Support>)request.getAttribute("listSupport"); 
				if(listSupport!=null){
					for(Support support: listSupport){
			%>
			<li>
				<a href="ymsgr:sendIM?<%=support.getYahoo()%>"
					title="Chat with <%=support.getFulname()%>"><%=support.getFulname()%></a>
			</li>
			<%} }%>
		</ul>
					
		<div class="clr"></div>
	</div>
	
	<div class="skype">
		<ul>
		<% 
				if(listSupport!=null){
					for(Support support: listSupport){
			%>
			<li>
				<a href="Skype:<%=support.getSkype()%>?chat" title="Chat with Mr.Sơn"><%=support.getFulname()%></a>
			</li>
			<%}} %>
		</ul>
		<div class="clr"></div>
	</div>
	<div class="orther">
		<p>
			Email: <span>trandangxuan@gmail.com</span>
		</p>
		<p>
			Số điện thoại: <span>0903154678</span>
		</p>
	</div>
</div>

<div class="advs">
	<%ArrayList<Advert> listAdvert=(ArrayList<Advert>)request.getAttribute("listAdvert"); 
		if(listAdvert!=null){
			for(Advert advert: listAdvert ){
	%>
		<a href="<%=advert.getLink()%>" title=""><img src="<%=request.getContextPath()%>/files/<%=advert.getPicture()%>" alt="" /></a>
	<%} }%>
	</div>
					
</div>
