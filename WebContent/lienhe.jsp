<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>
<%@include file="/templates/public/inc/left_bar.jsp" %>
<script>
$(document).ready(function(){
	$("#fcontact").validate({
		rules: {
			
			name: {
				required: true,
			},
			email: {
				required: true,
				email:true,
			},
			phone: {
				required: true,
				digits:true,
			},
			website: {
				required: true,
			},
			content: {
				required: true,
			},
		
		},
		messages: {

			name: {
				required: "Vui lòng nhập vào họ tên ",
			},
			email: {
				required: "Vui lòng nhập vào email",
				email:"Vui lòng nhập đúng định dạng email",
			},
			phone: {
				required: "Vui lòng nhập vào số phone ",
				digits:"Vui lòng nhập vào số ",
			},
			website: {
				required: "Vui lòng nhập vào tên danh mục tin ",
			},
			content: {
				required: "Vui lòng nhập vào tên danh mục tin ",
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
<div class="body-right fr">
	<div class="news-block">
		<h2 class="title-cat">Liên hệ</h2>
		<div class="content-cat1">
			<div class="content-detail">
				<div class="FromBox">
					<h4>Liên hệ javionline.net</h4>
					<% String msg=request.getParameter("msg");
						if(msg!=null){
							out.println("<p style='color:red;font-weight:bold'>"+msg+"</p>");							
						}
					%>
					<form name="fcontact" action="<%=request.getContextPath()%>/home/send-contact" method="post" id="fcontact"
						novalidate="novalidate">

						<div class="FieldRow">
							<label>Họ và tên:<span class="RSM_form_star_color">(*)</span></label>
							<input type="text" value="" class="" maxlength="50"
								name="name" id="HO_VA_TEN">
						</div>

						<div class="FieldRow">
							<label>Email:<span class="RSM_form_star_color">(*)</span></label>
							<input type="text" value="" class="" maxlength="50" name="email"
								id="EMAIL">
						</div>

						<div class="FieldRow">
							<label>Điện thoại:</label> <input type="text" value="" class=""
								maxlength="50" name="phone" id="PHONE">
						</div>

						<div class="FieldRow">
							<label>Website:</label> <input type="text" value="" class=""
								maxlength="50" name="website" id="WEBSITE">
						</div>

						<div class="FieldRow">
							<label>Nội dung:<span class="RSM_form_star_color">(*)</span></label>
							<textarea class="ckeditor" style="width: 100%; height: 140px;"
								name="content" id="CONTENT"></textarea>
						</div>


						<div class="FieldRow" style="margin-top: 24px;">
							<input class="button_submit" type="submit" id="submit"
								name="submit" value="Gửi liên hệ"> <input class="button_submit"
								type="reset" id="submit" name="submit" value="Nhập lại">
						</div>

					</form>
				</div>


			</div>
		</div>
	</div>

</div>
<div class="clr"></div>
</div>
</div>
<%@include file="/templates/public/inc/footer.jsp" %>   