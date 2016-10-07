<%@page import="bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
<script>
$(document).ready(function(){
	$("#form").validate({
		rules: {
			
			namecat: {
				required: true,
				minlength:1, 				
			},
		
		},
		messages: {
			namecat: {
				required: "Vui lòng nhập vào tên danh mục tin ",
				minlength:"Tên danh mục tin phải co it nhat mot chu cai", 				
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
		 <h2><span>Sửa Danh Mục</span></h2>
		 <div style="color:red">
		<%
			String msg = request.getParameter("msg");
			if(msg!=null){
				out.print(msg);
			}
		%>
		</div>
		 <div class="module-body">
		 	<%
		 		Category cat = (Category) request.getAttribute("cat");
		 	%>
			<form id="form" action="<%=request.getContextPath() %>/admin/edit-cat" method="post">
				<p>
					<br/>
					<input type="hidden" name="idcat" value="<%=cat.getIdCat()%>">
					<input type="text" name="namecat" value="<%=cat.getNameCat() %>" class="input-medium" />
				</p>
				<fieldset>
					<input class="submit-green" name="edit" type="submit" value="Edit" /> 
					<input class="submit-gray" name="reset" type="reset" value="Reset" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 