<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Sign</title>
<link href="<c:url value="/resources/public/css/join.css"/>" type="text/css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script language="javascript" src="script.js"></script>
</head>
<body>
	<h1 align="center">☆ 회원가입</h1>
	
	<!-- 회원가입 버튼 -->
	<section>
		<div class="user">
			<div class="inside">
				<span>회원가입</span>
				<div class="tie-wrap">
					<div class="tie"></div>
				</div>
			</div>
			<div class="button">
				<div class="front">
					<span>일반회원</span>
				</div>
				<div class="back"></div>
			</div>
		</div>
		<div class="manager">
			<div class="inside">
				<span>회원가입</span>
				<div class="tie-wrap">
					<div class="tie"></div>
				</div>
			</div>
			<div class="button">
				<div class="front">
					<span>지점장</span>
				</div>
				<div class="back"></div>
			</div>
		</div>
	</section>
	
	
	<!-- <div id="layer_fixed">
	<div align="center">
	<h1>회원가입 중입니다!</h1>
	<br/>
	<form method="post" action="#">
		<table width="400">
			<tr>
				<td align="right" width="100"><b>ID : &nbsp;&nbsp;</b></td>
				<td width="200">
					<img src="../image/book2.png" width="25px" height="25px">
					<input class="text" type="text" name="id" size="22"/>
					<input type="button" value="중복확인" onClick="idCheck(this.form.id.value)"/>
				</td>
			</tr>
			<tr>
				<td align="right" width="100"><b>PW : &nbsp;&nbsp;</b></td>
				<td width="200">
					<img src="../image/book2.png" width="25px" height="25px">
					<input class="text" type="password" name="pass" size="22"/>
				</td>
			</tr>
			<tr>
				<td align="right"><b>TEL : &nbsp;&nbsp;</b></td>
				<td>
				 	<img src="../image/book2.png" width="25px" height="25px">
				 	<input class="text" type="text" name="phone1" size="2"/> -
				 	<input class="text" type="text" name="phone2" size="2"/> -
				 	<input class="text" type="text" name="phone3" size="2"/>
				</td>
			</tr>
			<tr>
				<td align="right" width="100"><b>BIRTH : &nbsp;&nbsp;</b></td>
				<td width="200">
					<img src="../image/book2.png" width="25px" height="25px">
					<input class="text" type="text" name="id" size="22"/>
				</td>
			</tr>
		</table>
		<br>
	</form>
	&nbsp; &nbsp; &nbsp; &nbsp;	
	<input class="button" type="button" value="회원가입">
	</div>
	</div> -->
	
</body>
</html>