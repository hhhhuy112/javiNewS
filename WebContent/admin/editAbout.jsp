<%@page import="bean.About"%>
<%@page import="bean.News"%>
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
			title: {
				required: true,
			},
			detail: {
				required: true,
			},
		},
		messages: {
			title: {
				required: "Vui lòng nhập vào tên tin",
			},
			
			
			detail: {
				required: "Vui lòng nhập vào Chi Tiết",
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
		 <h2><span>Sửa giới thiệu</span></h2>
			
		 <div class="module-body">
			<form id="form" action="<%=request.getContextPath() %>/admin/edit-about" method="post">
				<% About about =(About)request.getAttribute("about");
					if(about!=null){
				%>	
				<p>
					<input type="hidden"  name="idabout" value="<%=about.getIdAbout()%>" />
				</p>
				<p>
					<label>Tên tin</label>
					<input type="text" name="title" value="<%=about.getTitleAbout()%>" class="input-medium" />
				</p>
				<p>
					<label>Chi tiết</label>
					<textarea  name="detail" rows="7" cols="90" class="input-long ckeditor"><%=about.getDetailAbout()%></textarea>
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