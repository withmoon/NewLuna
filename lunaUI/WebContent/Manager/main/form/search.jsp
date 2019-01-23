<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
}


#img-button {
	margin-bottom:0%;
	width: 30px;
	height: 30px;
	background: url("../images/search2.PNG");
	background-repeat: no-repeat;
	cursor: pointer;
	border: none;
}

#sch {
	margin-top:3px;
	margin-left:3px;
	width: 75%;
	height:25px;
	outline: none;
	border: 0px;
	float: left;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="search" method="post">
			<input type="text" id="sch" name="search" placeholder="검색어 입력">
			<button id="img-button" type="submit" onclick="#"></button>
		</form>
</body>
</html>