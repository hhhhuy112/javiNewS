<%@page import="bean.SplitPages"%>
<%@page import="bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">


	<div class="module">
		 <h2><span>Phân trang</span></h2>
		<% String msg=request.getParameter("msg"); 
			if(msg!=null){
				out.println("<p style='color:red'>"+msg+"</p>");
			}
		%>			
		 <div class="module-body">
			<form id="form" action="<%=request.getContextPath() %>/admin/split-pages" method="post">
			<div class="option">
			<% SplitPages splitPages=(SplitPages)request.getAttribute("splitpages");%>
			<label>Phân trang admin</label>
				<select id="searchcat"  name="admin" class="input-short" ;>
					<option value="1" <%if(splitPages.getNumAdmin()==1){%>selected<%}%> >1</option>
					<option value="2" <%if(splitPages.getNumAdmin()==2){%>selected<%}%> >2</option>
					<option value="3" <%if(splitPages.getNumAdmin()==3){%>selected<%}%> >3</option>
					<option value="4" <%if(splitPages.getNumAdmin()==4){%>selected<%}%> >4</option>
					<option value="5" <%if(splitPages.getNumAdmin()==5){%>selected<%}%> >5</option>
					<option value="6" <%if(splitPages.getNumAdmin()==6){%>selected<%}%> >6</option>
					<option value="7" <%if(splitPages.getNumAdmin()==7){%>selected<%}%> >7</option>
					<option value="8" <%if(splitPages.getNumAdmin()==8){%>selected<%}%> >8</option>
					<option value="9" <%if(splitPages.getNumAdmin()==9){%>selected<%}%> >9</option>
					<option value="10" <%if(splitPages.getNumAdmin()==10){%>selected<%}%> >10</option>
					
				</select>
			</div>
			<label>Phân trang public</label>
				<select id="searchcat"  name="public" class="input-short" >
					<option value="1" <%if(splitPages.getNumPublic()==1){%>selected<%}%> >1</option>
					<option value="2" <%if(splitPages.getNumPublic()==2){%>selected<%}%> >2</option>
					<option value="3" <%if(splitPages.getNumPublic()==3){%>selected<%}%> >3</option>
					<option value="4" <%if(splitPages.getNumPublic()==4){%>selected<%}%> >4</option>
					<option value="5" <%if(splitPages.getNumPublic()==5){%>selected<%}%> >5</option>
					<option value="6" <%if(splitPages.getNumPublic()==6){%>selected<%}%> >6</option>
					<option value="7" <%if(splitPages.getNumPublic()==7){%>selected<%}%> >7</option>
					<option value="8" <%if(splitPages.getNumPublic()==8){%>selected<%}%> >8</option>
					<option value="9" <%if(splitPages.getNumPublic()==9){%>selected<%}%> >9</option>
					<option value="10" <%if(splitPages.getNumPublic()==10){%>selected<%}%> >10</option>
					
				</select>
			</div>
			<div>
				<input type="submit" name="set" value="Set">
			</div>
			</form>
		 </div> <!-- End .module-body -->
		
	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->

<%@include file="/templates/admin/inc/footer.jsp" %> 