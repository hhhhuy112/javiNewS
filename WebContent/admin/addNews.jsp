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
		 <h2><span>Thêm tin tức</span></h2>
			
		 <div class="module-body">
			<form id="form" name="the_form" action="<%=request.getContextPath() %>/admin/add-news" enctype="multipart/form-data" method="post">
				<input id="chitiet1" type="hidden"  name="chitiet1" value="2" />
				<input id="mota1" type="hidden"  name="mota1" value="1" />
				<% News news2=(News)request.getAttribute("news2"); 
					if(news2!=null){
				%>
				<p>
					<label>Tên tin</label>
					<input type="text" name="tentin" value="<%=news2.getTitle()%>" class="input-medium" />
				</p>
				<p>
					<label>Danh mục tin</label>
					<select  name="danhmuc" class="input-short">
						<%
							ArrayList<Category> listCat  = (ArrayList<Category>)request.getAttribute("listCat");
							if(listCat!=null){
								for(Category cat:listCat){
								%>
								<option value="<%=cat.getIdCat()%>" <%if(news2.getIdCat()==cat.getIdCat()){ out.println("selected");}%>><%=cat.getNameCat()%></option>
								<%
								}
							}
						%>
						
						
					</select>
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
				<p>
					<label>Mô tả</label>
					<textarea name="mota" value="<%=news2.getDescription()%>" rows="7" cols="90" class="input-medium"><%=news2.getDescription()%></textarea>
				</p>
				<p>
					<label>Chi tiết</label>
					<textarea   name="chitiet" value="<%=news2.getDescription()%>" rows="7" cols="90" class="input-long ckeditor"><%=news2.getDetail()%></textarea>
				</p>
				<%}else{ %>
					<p>
					<label>Tên tin</label>
					<input type="text" name="tentin" value="" class="input-medium" />
				</p>
				<p>
					<label>Danh mục tin</label>
					<select  name="danhmuc" class="input-short">
						<%
							ArrayList<Category> listCat  = (ArrayList<Category>)request.getAttribute("listCat");
							if(listCat!=null){
								for(Category cat:listCat){
								%>
								<option value="<%=cat.getIdCat()%>"><%=cat.getNameCat()%></option>
								<%
								}
							}
						%>
						
						
					</select>
				</p>
				<p>
					<label>Hình ảnh</label>
					<input type="file"  name="hinhanh" value="" />
				</p>
				<p>
					<label>Mô tả</label>
					<textarea name="mota" value="" rows="7" cols="90" class="input-medium"></textarea>
				</p>
				<p>
					<label>Chi tiết</label>
					<textarea   name="chitiet" value="" rows="7" cols="90" class="input-long ckeditor"></textarea>
					
				</p>
				<%}%>
				<input id="chitiet1" type="hidden"  name="chitiet1" value="2" />
				<input id="mota1" type="hidden"  name="mota1" value="1" />
				<fieldset>
					<input class="submit-green" name="add" type="submit" value="Add"  onclick="getD()" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập lại" />
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