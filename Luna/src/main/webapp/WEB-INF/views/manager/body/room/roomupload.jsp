<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<link type="text/css" rel="stylesheet"  href="<c:url value="/resources/manager/css/manager2.css"/>"/>
<link type="text/css" rel="stylesheet"  href="<c:url value="/resources/manager/css/roomupload.css"/>"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>방 생성</h2>
	<hr>
	<form>
		<div id="roominsert">
			<!-- 이미지 / 방소개영역 -->
			<div id="image">
				<img id="img"><br />이미지 영역
				<div>
					<input type="file">
				</div>
			</div>

			<div id="room">
				<p>방소개글	<p>
					소개1 : <input type="text"><br />
					소개2 : <input type="text"><br />
					소개3 : <input type="text"><br /> 
					소개4 : <input type="text"><br /> 
			</div>
		</div>

		<div id="form2">
			<div id="file">
			방 이미지1 : <input type="file"><br />
			방 이미지2 : <input type="file"><br />	
			방 이미지3 : <input type="file"><br />
			방 이미지4 : <input type="file">
			</div>

			<div id="roomtext">
				<p>방소개
				<p>
					<textarea rows="10" cols="40"></textarea>
				<p>주의 사항
				<p>
					<textarea rows="10" cols="40"></textarea>
			</div>

		</div>
			<input type="submit" value="등록">
			<input type="reset" value="초기화">
			<input type="button" value="취소">
	</form>



</body>
</html>