<%@page import="bean.Advert"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath()%>/admin/add-advert?type=load" class="button">
			<span>Thêm quảng cáo<img src="<%=request.getContextPath()%>/templates/admin/images/plus-small.gif" alt="Thêm quang cao"></span>
		  </a>
	  </div>
	  
	  <div class="clear"></div>
</div>
<% String msg=request.getParameter("msg"); 
	if(msg!=null){
		out.println("<p style='color:red;font-weight:blod;font-size:20px'>"+msg+"</p>");
	}
%>
<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách tin</span></h2>
		
		<div class="module-table-body">
			<form action="<%=request.getContextPath()%>/deleteck-advert" method="post" name="input">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Tên</th>
						<th style="width:20%">Link</th>
						<th style="width:16%; text-align: center;">Hình ảnh</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
						<th>
							 Xóa	
							 <input type="submit" name="xoa" value="DeleteSelected" onclick="DeLeTe()" />
						</th>
					</tr>
				</thead>
				<tbody id="ajax-data" >
					<%
						ArrayList<Advert> listAdvert= (ArrayList<Advert>)request.getAttribute("listAdvert");
						if(listAdvert!=null){
							for(Advert advert: listAdvert){
							%>
					<tr>
						<td class="align-center"><%=advert.getIdAdvert()%></td>
						<td><%=advert.getName()%></td>
						<td><a href="<%=advert.getLink()%>" title=""><%=advert.getLink()%></a></td>
						<td align="center">
						<%
							if(advert.getPicture()!=""){
						%>
						<img src="<%=request.getContextPath() %>/files/<%=advert.getPicture()%>" class="hoa" /></td>
						<%} else{
						
							out.print("-No image available-");
						} %>
						
						<td align="center">
							<a href="<%=request.getContextPath()%>/admin/edit-advert?type=load&idAdvert=<%=advert.getIdAdvert()%>">Sửa <img src="<%=request.getContextPath()%>/templates/admin/images/pencil.gif" alt="edit" /></a>
						</td>
						<td><input class="cb" type="checkbox" name="chk" value="<%=advert.getIdAdvert()%>"></td>
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
					<span><a href="<%=request.getContextPath()%>/admin/list-advert?paper=1 " class="current">1</a></span> |
				<% 	}else{
				%>
					<span><a href="<%=request.getContextPath()%>/admin/list-advert?paper=1" >1</a></span> |
				<% 
					}
					for(int i=2;i<=tongTrang;i++){
							if(i==trang){
				%>
							<span><a href="<%=request.getContextPath()%>/admin/list-advert?paper=<%=i%>" class="current"><%=i %></a></span> 
							<%}else{%>
							<span><a href="<%=request.getContextPath()%>/admin/list-advert?paper=<%=i%>"><%=i%></a></span>  
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
		var a=$("#searchcat").find(":selected").val()
			
	
	}
</script>	
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 