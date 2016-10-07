<%@page import="bean.Advert"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
	
	<%
		String msg = request.getParameter("msg");
	if(msg!=null){
		out.print(msg);
	}
	%>
	<script>
$(document).ready(function(){
	$("#form").validate({
		rules: {
			name: {
				required: true,
			},
			link: {
				required: true,
			},
			
		},
		messages: {
			name: {
				required: "Vui lòng nhập vào tên",
			},
			link: {
				required: "Vui lòng nhập vào link",
			},
		},
		
		
	});
});
	
</script>
<style>
	.error{
		color:red;
		margin-left: 10px; 
	}
</style>
	<div class="module">
		 <h2><span>Thêm Quảng Cáo</span></h2>
		 <div class="module-body">
			<form id="form" action="<%=request.getContextPath() %>/admin/add-advert" enctype="multipart/form-data" method="post">
			<% Advert advert1=(Advert)request.getAttribute("advert1"); 
				if(advert1!=null){
			%>		
				<p>
					<label>Tên</label>
					<input type="text" name="name" value="<%=advert1.getName()%>" class="input-medium" />
				</p>
				<p>
					<label>Link</label>
					<input type="text" name="link" value="<%=advert1.getLink()%>" class="input-medium" />
				</p>
				<p>
					<label>Hình ảnh</label>
					<input type="file"  name="hinhanh" value="" />
				</p>
				<%
				String msg1 = request.getParameter("msg1");
					if(msg1!=null){
						out.print("<p style='color:red'>"+msg1+"</p>");
					}
				%>
			<%}else{ %>
				<p>
					<label>Tên</label>
					<input type="text" name="name" value="" class="input-medium" />
				</p>
				<p>
					<label>Link</label>
					<input type="text" name="link" value="" class="input-medium" />
				</p>
				<p>
					<label>Hình ảnh</label>
					<input type="file"  name="hinhanh" value="" />
				</p>
			<%} %>			
				<fieldset>
					<input class="submit-green" name="add" type="submit" value="Add" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập lại" />
				</fieldset>
				
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 