<%@page import="bean.Users"%>
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
			
			password: {
				required: true,
				minlength:8,
				
			},
			fullname: {
				required: true,
				minlength:1,
				
			},
			address: {
				required: true,
				
			},
			phone: {
				required: true,
				minlength:1,
				digits:true,
				
			},
		},
		messages: {
			
			password: {
				required: "Vui lòng nhập vào password",
				minlength:"Vui lòng nhập ít nhất 8 ký tự  ",
				
			},
			fullname: {
				required: "Vui lòng nhập vào fullname ",
				minlength:"Vui lòng nhập ít nhất 1 ký tự ",
				
			},
			address: {
				required: "Vui lòng nhập vào địa chỉ",
				
			},
			phone: {
				required: "Vui lòng nhập vào phone",
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
		 <h2><span>Thêm</span></h2>
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
		 		Users users= (Users)request.getAttribute("user");
		 	%>
			<form id="form" action="<%=request.getContextPath() %>/admin/edit-users" method="post">
				<p>
					<label style="font-weight: bold ">Tên đăng nhập:<%=users.getUsername()%></label>
					<input type="hidden" name="username" value="<%=users.getUsername() %>" class="input-medium"  />
				</p>
				<p>
					<label>Mật khẩu</label>
					<input type="password" name="password" value="<%=users.getPassword() %>" class="input-medium" />
				</p>
				<p>
					<label>Họ và tên</label>
					<input type="text" name="fullname" value="<%=users.getFullname() %>" class="input-medium" />
				</p>
				<p>
					<label>Địa chỉ</label>
					<input type="text" name="address" value="<%=users.getAddress()%>" class="input-medium" />
				</p>
				<p>
					<label>Phone</label>
					<input type="text" name="phone" value="<%=users.getPhone()%>" class="input-medium" />
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