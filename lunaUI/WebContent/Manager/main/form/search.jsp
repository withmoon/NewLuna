<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	
*{
 padding: 0px; margin: 0px;
}

#img-button{
	margin-top : -50px;
	padding-top: 20px;
	width: 30px;
 	height: 30px;
	display: inline-block;
	background: url("../images/search2.PNG");
	background-repeat: no-repeat;
	cursor: pointer;
	border: none;
}

#sch{
	width: auto;
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="search" method="post">
			<label for="search">검색 : </label> <br/> 
			<input type="text" id="sch" name="search"> 
				<button id="img-button" type="submit" onclick="#"></button>
		</form>
	</div>
</body>
</html>