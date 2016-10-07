<%@page import="bean.Users"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
	  <% Users userLogin1 =(Users) session.getAttribute("userLogin");   
	  	if("admin".equals(userLogin1.getUsername()) ){
	  %>
		  <a href="<%=request.getContextPath() %>/admin/add-users" class="button">
			<span>Thêm <img src="<%=request.getContextPath()%>/templates/admin/images/plus-small.gif" alt="Thêm tin"></span>
		  </a>
		  <%} %>
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách</span></h2>
		<% String msg=request.getParameter("msg");
			if(msg!=null){
				out.println("<p style='color:red;font-weight:bold'>"+msg+"</p>");
			}
		%>
		<div class="module-table-body">
			<form action="">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Username</th>
						<th>Fullname</th>
						<th>address</th>
						<th>phone</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
				<%	
					ArrayList<Users> listUsers = (ArrayList<Users>)request.getAttribute("listUsers");
					int i=0;
					if(listUsers!=null){
						for(Users user:listUsers){
							i+=1;
							
							%>
							<tr>
							<td class="align-center"><%=i%></td>
							<td><%=user.getUsername() %></td>
							<td><%=user.getFullname() %></td>
							<td><%=user.getAddress() %></td>
							<td><%=user.getPhone() %></td>
							<td align="center">
							<%if("admin".equals(user.getUsername()) ){ 
								if("admin".equals(userLogin1.getUsername())){	
							%>
							<a href="<%=request.getContextPath()%>/admin/edit-users?username=<%=user.getUsername()%>">Sửa <img src="<%=request.getContextPath()%>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<%}}else{
								if(user.getUsername().equals(userLogin1.getUsername())||"admin".equals(userLogin1.getUsername())){	
							%>
								
								<a href="<%=request.getContextPath()%>/admin/edit-users?username=<%=user.getUsername()%>">Sửa <img src="<%=request.getContextPath()%>/templates/admin/images/pencil.gif" alt="edit" /></a>							
								<a href="<%=request.getContextPath()%>/admin/delete-users?username=<%=user.getUsername()%>" onClick="return confirm ('Are you sure?')">Xóa <img src="<%=request.getContextPath()%>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
								
							<%}
								
							} %>
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
				<%int tongTrang=(int )request.getAttribute("tongTrang");
					int trang=(int)request.getAttribute("trang");
																	
							if(tongTrang>1){%>
								 <span>Trang:</span>
							<% 	if(trang==1){
				%>
					<span><a href="<%=request.getContextPath()%>/admin/list-users?paper=1 " class="current">1</a></span> |
				<% 	}else{
				%>
					<span><a href="<%=request.getContextPath()%>/admin/list-users?paper=1" >1</a></span> |
				<% 
					}
					for(int j=2;j<=tongTrang;j++){
							if(j==trang){
				%>
							<span><a href="<%=request.getContextPath()%>/admin/list-users?paper=<%=j%>" class="current"><%=j %></a></span> 
							<%}else{%>
							<span><a href="<%=request.getContextPath()%>/admin/list-users?paper=<%=j%>"><%=j%></a></span>  
							<%}
							if(j!=tongTrang){
							%>
							|
				<%} }}%> 
				
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 