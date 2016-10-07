<%@page import="bean.Category"%>
<%@page import="bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/admin/add-news?type=load" class="button">
			<span>Thêm tin <img src="<%=request.getContextPath() %>/templates/admin/images/plus-small.gif" alt="Thêm tin"></span>
		  </a>
	  </div>
	  
	  <div class="clear"></div>
</div>
<% String msg=request.getParameter("msg"); 
	if(msg!=null){
		out.println("<p style='color:red;font-weight:blod;font-size:20px'>"+msg+"</p>");
	}
%>
<form id="search2" action="<%=request.getContextPath()%>/search-news-cat" method="post">
	<div class="option">
		<label>Danh mục tin</label>
			<select id="searchcat"  name="danhmuc" class="input-short"  onchange="submit()">
				<option value=0>Tất cả tin tức</option>
				<% String idCat=request.getParameter("idCat");
					ArrayList<Category> listCat  = (ArrayList<Category>)request.getAttribute("listCat");
						if(listCat!=null){
							for(Category cat:listCat){
				%>
							<option value="<%=cat.getIdCat()%>" <%if(idCat!=null){int idCat1=Integer.parseInt(idCat);
								if(idCat1==cat.getIdCat()){out.println("selected");}
							} %>><%=cat.getNameCat()%></option>
				<%
							}
						}
				%>
		</select>
	</div>
</form>	


<form id="search3" action="<%=request.getContextPath()%>/search" method="post">
	
	<div class="search">
		<input type="text" name="search" value=""  />
	</div>
	<input type="submit" name="timKiem" value="Search" onclick="Search()"/>
</form>
<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách tin</span></h2>
		
		<div class="module-table-body">
			<form action="<%=request.getContextPath()%>/delete1" method="post" name="input">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Tên</th>
						<th style="width:20%">Danh mục</th>
						<th style="width:20%">Ngày đăng</th>
						<th style="width:20%">Người đăng</th>
						<th style="width:16%; text-align: center;">Hình ảnh</th>
						<th style="width:20%; text-align: center;">Chức năng</th>
						<th>
							 Xóa	
							 <input type="submit" name="xoa" value="DeleteSelected" onclick="DeLeTe()" />
						</th>
					</tr>
				</thead>
				<tbody id="ajax-data" >
					<%
						ArrayList<News> listNews = (ArrayList<News>)request.getAttribute("listNews");
						if(listNews!=null){
							for(News news : listNews){
							%>
					<tr>
						<td class="align-center"><%=news.getIdNews() %></td>
						<td><a href="<%=request.getContextPath()%>/admin/edit-news?type=load&idnews=<%=news.getIdNews()%>"><%=news.getTitle()%></a></td>
						<td><%=news.getNameCat()%></td>
						<td><%=news.getDatecreat()%></td>
						<td><a href="<%=request.getContextPath()%>/admin/edit-users?&username=<%=news.getUsername()%>"><%=news.getUsername()%></a></td>
						<td align="center">
						<%
							if(news.getPicture()!=""){
						%>
						<img src="<%=request.getContextPath() %>/files/<%=news.getPicture() %>" class="hoa" /></td>
						<%} else{
						
							out.print("-No image available-");
						}
							%>
						
						<td align="center">
							<a href="<%=request.getContextPath()%>/admin/edit-news?type=load&idnews=<%=news.getIdNews()%>">Sửa <img src="<%=request.getContextPath()%>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath()%>/admin/del-news?idnews=<%=news.getIdNews()%>" onClick="return confirm ('Are you sure?')">Xóa <img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
						<td><input class="cb" type="checkbox" name="chk" value="<%=news.getIdNews()%>"></td>
					</tr>	
					<%
						} }
					%>
					
				</tbody>
			</table>
				<input id="virtual" type="hidden" name="virtual" value="100"/>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 <div class="pagination">           
			<div class="numbers">
				<%int tongTrang=(int )request.getAttribute("tongTrang");
					int trang=(int)request.getAttribute("trang");
																	
							if(tongTrang>1){%>
								 <span>Trang:</span>
							<% 	if(trang==1){
				%>
					<span><a href="<%=request.getContextPath()%>/admin/list-news?paper=1 " class="current">1</a></span> |
				<% 	}else{
				%>
					<span><a href="<%=request.getContextPath()%>/admin/list-news?paper=1" >1</a></span> |
				<% 
					}
					for(int i=2;i<=tongTrang;i++){
							if(i==trang){
				%>
							<span><a href="<%=request.getContextPath()%>/admin/list-news?paper=<%=i%>" class="current"><%=i %></a></span> 
							<%}else{%>
							<span><a href="<%=request.getContextPath()%>/admin/list-news?paper=<%=i%>"><%=i%></a></span>  
							<%}
							if(i!=tongTrang){
							%>
							|
				<%} }}%> 
				
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	<script>
	function DeLeTe()
	{
		 var c_value = "";
		    for (var i=0; i < document.input.chk.length; i++)
		    
		        {
		            if (document.input.chk[i].checked)
		            {
		                c_value += (c_value?',':'')+document.input.chk[i].value;
		            }
		        } 
		    
		       $('#virtual').val(c_value);
				    
	}
	function Search()
	{ 
		var idCat=$("#searchcat").find(":selected").val()
		$('#virtual1').val(idCat);
		
	}
</script>	
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 