<%@page import="bean.Advert"%>
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
				required: "Vui lòng nhập vào tên quảng cáo",
			},
			link: {
				required: "Vui lòng nhập vào Link",
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
		 <h2><span>Sửa quảng cáo</span></h2>
			
		 <div class="module-body">
			<form id="form" action="<%=request.getContextPath() %>/admin/edit-advert" enctype="multipart/form-data" method="post">
				<% Advert advert=(Advert)request.getAttribute("advert"); 
					if(advert!=null){
				%>	
				<p>
					<input type="hidden"  name="idAdvert" value="<%=advert.getIdAdvert()%>" />
				</p>
				<p>
					<label>Tên</label>
					<input type="text" name="name" value="<%=advert.getName()%>" class="input-medium" />
				</p>
				<p>
					<label>Link</label>
					<input type="text" name="link" value="<%=advert.getLink()%>" class="input-medium" />
				</p>
				
				<p>
					
					<label>Hình ảnh</label>
					<img style="height:30px;width:30px;" src="<%=request.getContextPath() %>/files/<%=advert.getPicture()%>" class="hoa" /></td>
					<input type="hidden"  name="picture" value="<%=advert.getPicture()%>" />
					<input type="file"  name="hinhanh" value="" />
					
				</p>
				
				<fieldset>
					<input class="submit-green" name="edit" type="submit" value="Edit" /> 
					<input class="submit-gray" name="reset" type="reset" value="reset" />
				</fieldset>
				<%} %>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 