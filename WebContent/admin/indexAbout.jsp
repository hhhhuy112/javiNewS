<%@page import="bean.About"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		 
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Giới thiệu</span></h2>
		
		<div class="module-table-body">
			<form action="">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Tên</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
				<%
					ArrayList<About> listAbout = (ArrayList<About>)request.getAttribute("listAbout");
					if(listAbout!=null){
						for(About about:listAbout){
							%>
							<tr>
							<td class="align-center"><%=about.getIdAbout()%></td>
							<td><a href="<%=request.getContextPath()%>/admin/edit-about?idAbout=<%=about.getIdAbout()%>"><%=about.getTitleAbout()%></a></td>
							<td align="center">
							<a href="<%=request.getContextPath()%>/admin/edit-about?idAbout=<%=about.getIdAbout()%>">Sửa <img src="<%=request.getContextPath()%>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath()%>/admin/del-about?idAbout=<%=about.getIdAbout()%>" onClick="return confirm ('Are you sure?')">Xóa <img src="<%=request.getContextPath()%>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
					</tr>
							<%
						}
					}
				%>
					
					
				</tbody>
			</table>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 <div class="pagination">           
			<div class="numbers">
				
				
			
				<%	int tongTrang=(int )request.getAttribute("tongTrang");
					int trang=(int)request.getAttribute("trang");
					if(tongTrang>1){%>
								<span>Trang:</span> 
				<%  if(trang==1){
				%>
					<span><a href="<%=request.getContextPath()%>/admin/list-about?paper=1 " class="current">1</a></span> |
				<% 	}else{
				%>
					<span><a href="<%=request.getContextPath()%>/admin/list-about?paper=1" >1</a></span> |
				<% 
					}
					for(int i=2;i<=tongTrang;i++){
							if(i==trang){
				%>
							<span><a href="<%=request.getContextPath()%>/admin/list-about?paper=<%=i%>" class="current"><%=i %></a></span> 
							<%}else{%>
							<span><a href="<%=request.getContextPath()%>/admin/list-about?paper=<%=i%>"><%=i%></a></span>  
							<%}
							if(i!=tongTrang){
							%>
							|
				<%} }}%> 

			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 