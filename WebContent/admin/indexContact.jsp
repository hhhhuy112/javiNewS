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
		<h2><span>Thông tin liên hệ </span></h2>
		
		<div class="module-table-body">
			<form action="<%=request.getContextPath()%>/deletelck-contact" method="post" name="input">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Họ và tên</th>
						<th>Email</th>
						<th>Ngày liên hệ</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
						<th style="width:11%; text-align: center;">
							 Xóa	
							 <input  type="submit" name="xoa" value="DeleteSelected" onclick="DeLeTe()" />
						</th>
					</tr>
				</thead>
				<tbody>
				<%
					ArrayList<Contact> listContact= (ArrayList<Contact>)request.getAttribute("listContact");
					if(listContact!=null){
						for(Contact contact:listContact){
							%>
							<tr>
							<td class="align-center"><%=contact.getIdContact()%></td>
							<td><%=contact.getFullname()%></td>
							<td class="align-center"><%=contact.getEmail()%></td>
							<td class="align-center"><%=contact.getDatecreate()%></td>
							<td align="center">
								<a href="<%=request.getContextPath()%>/admin/view-contact?idContact=<%=contact.getIdContact()%>" >Xem</a>
							</td>
							<td>
								<input class="cb" type="checkbox" name="chk" value="<%=contact.getIdContact()%>">
							</td>
					</tr>
							<%
						}
					}
				%>
					
					
				</tbody>
			</table>
				<input id="virtual" type="hidden" name="virtual" value="0"/>
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
					<span><a href="<%=request.getContextPath()%>/admin/list-contact?paper=1 " class="current">1</a></span> |
				<% 	}else{
				%>
					<span><a href="<%=request.getContextPath()%>/admin/list-contact?paper=1" >1</a></span> |
				<% 
					}
					for(int i=2;i<=tongTrang;i++){
							if(i==trang){
				%>
							<span><a href="<%=request.getContextPath()%>/admin/list-contact?paper=<%=i%>" class="current"><%=i %></a></span> 
							<%}else{%>
							<span><a href="<%=request.getContextPath()%>/admin/list-contact?paper=<%=i%>"><%=i%></a></span>  
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
	
</script>	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 