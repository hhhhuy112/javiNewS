<%@page import="bean.Support"%>
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
			fullname: {
				required: true,
			},
			skype: {
				required: true,
				email:true,
			},
			
			yahoo: {
				required: true,
				email:true,
			},
		},
		messages: {
			fullname: {
				required: "Vui lòng nhập vào tên người hỗ trợ",
			},
			skype: {
				required: "Vui lòng nhập vào nick skype",
				email:"Vui lòng nhập đúng định dạng email"
			},
			
			chitiet: {
				required: "Vui lòng nhập vào Chi Tiết",
				email:"Vui lòng nhập đúng định dạng email"
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
		 		Support support = (Support) request.getAttribute("support");
		 	%>
			<form id="form" action="<%=request.getContextPath() %>/admin/edit-support" method="post">
				<p>
					
					<input type="hidden" name="idsupport" value="<%=support.getIdSupport()%>">
					<label>Họ và tên</label>
					<input type="text" name="fullname" value="<%=support.getFulname() %>" class="input-medium" />
					<label>Skype</label>
					<input type="text" name="skype" value="<%=support.getSkype() %>" class="input-medium" />
					<label>Yahoo</label>
					<input type="text" name="yahoo" value="<%=support.getYahoo()%>" class="input-medium" />
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