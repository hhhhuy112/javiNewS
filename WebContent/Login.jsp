<%@page import="bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">

	<div class="module">
		 <h2><span>Đăng nhập</span></h2>
		 <div style="color:red">
		<%
			String msg = request.getParameter("msg");
			if(msg!=null){
				out.print("<p style='color:red'>"+msg+"</p>");
			}
		%>
		</div>
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/login" method="post">
				<p>
					<label>Tên đăng nhập</label>
					<input type="text" name="username" value="" class="input-medium" />
				</p><br/>
				<p>
					<label>Mật khẩu</label>
					<input type="password" name="password" value="" class="input-medium" />
				</p>
				<fieldset>
					<input class="submit-green" name="login" type="submit" value="Login" /> 
					<input class="submit-gray" name="reset" type="reset" value="Reset" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 