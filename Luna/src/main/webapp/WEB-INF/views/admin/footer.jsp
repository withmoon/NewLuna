<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.button{
   margin: auto;
   width: 50%;
   align:right;
}

div.button input{
   padding: 5px;
   font-size: 14px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="button">
		<form action="moveUserMode.ado" method="post">
			<input type="submit" value="사용자 화면으로 이동">
		</form>
	</div>
</body>
</html>