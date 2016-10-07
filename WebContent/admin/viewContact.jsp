<%@page import="bean.Contact"%>
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
		<h2><span>Danh sách liên hệ</span></h2>
		
		<div class="module-table-body">
			<table id="myTable" class="tablesorter">
				<% Contact contact=(Contact)request.getAttribute("contactView"); %>
				<tr>
					<th>Họ và tên</th>
					<td><%=contact.getFullname()%></td>
				</tr>
				<tr>
					<th>Ngày gửi</th>
					<td><%=contact.getDatecreate()%></td>
				</tr>	
				<tr>
					<th>Phone</th>
					<td><%=contact.getPhone()%></td>
				</tr>
				<tr>
					<th>Website</th>
					<td><a href="<%=contact.getWebSite()%>" title=""><%=contact.getWebSite()%></a></td>
				</tr>
				<tr>
					<th>Nội dung</th>
					<td style="font-weight: bold"><%=contact.getDetail()%></td>
				</tr>								
					
			</table>
				
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 <div class="pagination">           
			
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 