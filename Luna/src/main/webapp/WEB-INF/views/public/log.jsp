<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Log</title>
<link href="../css/log.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<div id="layer_fixed">
	<center>
	<h1>Moon Light</h1>
	<br>
	<form method="post" action="#">
		<table width="300">
			<tr id="tr">
				<td align="right" width="100"><b>ID : &nbsp;&nbsp;<b></td>
				<td width="200">
					<img src="../image/coffee2.jpg" width="30px" height="30px">
					<input class="text" type="text" name="id" size="20">
				</td>
			</tr>
			<tr>
				<td align="right" width="100"><b>PW : &nbsp;&nbsp;<b></td>
				<td width="200">
					<img src="../image/coffee2.jpg" width="30px" height="30px">
					<input class="text" type="password" name="pass" size="20"/>
				</td>
			</tr>			
		</table>
		<br>
	</form>
	<br>
		<input class="button" type="button" value="로그인">
		&nbsp;&nbsp;&nbsp;&nbsp;	
		<input class="button" type="button" value="회원가입">
		<a href="sign.jsp">
	</center>
	</div>
</body>
</html>