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
			tentin: {
				required: true,
			},
			mota: {
				required: true,
			},
			
			chitiet: {
				required: true,
			},
		},
		messages: {
			tentin: {
				required: "Vui lòng nhập vào tên tin",
			},
			mota: {
				required: "Vui lòng nhập vào Mô Tả",
			},
			
			chitiet: {
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
		 <h2><span>Sửa tin tức</span></h2>
			
		 <div class="module-body">
			<form id="form" name="the_form" action="<%=request.getContextPath() %>/admin/edit-news" enctype="multipart/form-data" method="post">
				<input id="mota1" type="hidden"  name="mota1" value="" />
				<input id="chitiet1" type="hidden"  name="chitiet1" value="" />
				<% News news=(News)request.getAttribute("news"); 
					if(news!=null){
				%>	
				<p>
					<input type="hidden"  name="idtintuc" value="<%=news.getIdNews()%>" />
				</p>
				<p>
					<label>Tên tin</label>
					<input type="text" name="tentin" value="<%=news.getTitle()%>" class="input-medium" />
				</p>
				<p>
					<label>Danh mục tin</label>
					<select  name="danhmuc" class="input-short">
						<%
							ArrayList<Category> listCat  = (ArrayList<Category>)request.getAttribute("listCat");
							if(listCat!=null){
								for(Category cat:listCat){
								%>
								<option value="<%=cat.getIdCat()%>"<%if(news.getIdCat()==cat.getIdCat()){ out.print("selected");}%>><%=cat.getNameCat()%></option>
								<%
								}
							}
						%>
						
						
					</select>
				</p>
				<p>
					
				</p>
				<p>
					
					<label>Hình ảnh</label>
					<img style="height:30px;width:30px;" src="<%=request.getContextPath() %>/files/<%=news.getPicture()%>" class="hoa" /></td>
					<input type="hidden"  name="picture" value="<%=news.getPicture()%>" />
					<input type="file"  name="hinhanh" value="" />
					<%
					String msg1 = request.getParameter("msg1");
					if(msg1!=null){
						out.print("<p style='color:red'>"+msg1+"</p>");
					}
					%>	
				</p>
				<p>
					<label>Mô tả</label>
					<textarea name="mota"  rows="7" cols="90" class="input-medium"><%=news.getDescription()%></textarea>
				</p>
				<p>
					<label>Chi tiết</label>
					<textarea  name="chitiet" rows="7" cols="90" class="input-long ckeditor"><%=news.getDetail()%></textarea>
				</p>
				<%} %>
			
				<fieldset>
					<input class="submit-green" name="edit" type="submit" value="Edit" onclick="getD()"/> 
					<input class="submit-gray" name="reset" type="reset" value="reset" />
				</fieldset>
				
				
			</form>
		 </div> <!-- End .module-body -->
		<script type="text/javascript">
		function getD(){
			var chitiet1 = CKEDITOR.instances.chitiet.getData();
			$('#chitiet1').val(chitiet1);
			var	mota1=window.document.the_form.mota.value;
			$('#mota1').val(mota1);
			    
		}
	</script> 
		
	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 