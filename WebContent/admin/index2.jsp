<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Tiêu đề</title>
	<script src="<%=request.getContextPath()%>/templates/libraries/jquery-2.1.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/templates/libraries/ckeditor/ckeditor.js"></script>	
<script>
	function Search()
	{ 
		var a=$("#id").find(":selected").val()
		alert(a);
	}
</script>
</head>

<body>
<form name="the_form" action="" method="post">
	<div class="option">

				<p>
					<label>Chi tiết</label>
					<textarea id="chitiet"  name="chitiet" value="" rows="7" cols="90" class="input-long "></textarea>
				</p>
				<fieldset>
					<input class="submit-green" name="add" type="submit" value="Add"  onclick="getD()" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập lại" />
				</fieldset>
	</div>
	
</form>
<script type="text/javascript">
		function getD(){
		var	textarea=window.document.the_form.chitiet.value;
			alert(textarea);
		}
</script> 
</body>
</html>