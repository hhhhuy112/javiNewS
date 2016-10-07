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
			username: {
				required: true,
				minlength:3,
			},
			password: {
				required: true,
				minlength:8,
				
			},
			fullname: {
				required: true,
			},
			address: {
				required: true,
				
			},
			phone: {
				required: true,
				digits:true,
			},
		},
		messages: {
			username: {
				required: "Vui lòng nhập vào username",
				minlength:"Vui lòng nhập ít nhất 3 ký tự ",
			},
			password: {
				required: "Vui lòng nhập vào password",
				minlength:"Vui lòng nhập ít nhất 8 ký tự  ",
				
			},
			fullname: {
				required: "Vui lòng nhập vào fullname ",
				
			},
			address: {
				required: "Vui lòng nhập vào địa chỉ ",
				
			},
			phone: {
				required: "Vui lòng nhập vào số phone",
				digits:"Vui lòng nhập vào số",
			},
			
		},
		
		
	});
});
	
</script>
<style>
	.error{
		color:red;
	}
</style>
	<div class="module">
		 <h2><span>Thêm người dùng </span></h2>
		 <div style="color:red">
		<%
			String msg = request.getParameter("msg");
			if(msg!=null){
				out.print(msg);
			}
		%>
		</div>
		 <div class="module-body">
			<form id="form" action="<%=request.getContextPath() %>/admin/add-users" method="post">
				<p>
					<label>Tên đăng nhập</label>
					<input type="text" name="username" value="" class="input-medium" />
				</p><br/>
				<p>
					<label>Mật khẩu</label>
					<input type="password" name="password" value="" class="input-medium" />
				</p>
				<p>
					<label>Họ và tên</label>
					<input type="text" name="fullname" value="" class="input-medium" />
				</p>
				<p>
					<label>Address</label>
					<input type="text" name="address" value="" class="input-medium" />
				</p>
				<p>
					<label>phone</label>
					<input type="text" name="phone" value="" class="input-medium" />
				</p>
				<fieldset>
					<input class="submit-green" name="add" type="submit" value="Add" /> 
					<input class="submit-gray" name="reset" type="reset" value="Reset" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 