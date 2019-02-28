<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<title>Insert title here</title>
</head>
<body>
	<header>
		<ul class="memberUl">
			<c:if test="${member.id eq null}">
				<li><a href="<c:url value="/login.do"/>"><img src="<c:url value="/resources/public/images/login.gif"/>"/></a></li>
			</c:if>

			<c:if test="${member.id ne null}">
				<li><a class="lgoutli" href="<c:url value='/logout.do'/>"><img src="<c:url value="/resources/public/images/LogOut.gif"/>"/></a></li>
				<li><a href="<c:url value="/mypage.udo"/>"><img src="<c:url value="/resources/public/images/mypage.gif"/>"/></a></li>
			</c:if>
		</ul>
		<ul class="topUl">
			<li onclick="location.href='<c:url value="/foundbranch.udo"/>'">근처 장소 찾기</li>
			<li onclick="location.href='<c:url value="/lookover.udo"/>'">공간 둘러보기</li>
			<li onclick="location.href='<c:url value="/event.udo"/>'">이벤트</li>
			<li onclick="location.href='<c:url value="/inform.udo"/>'">고객 센터</li>

		</ul>
	</header>
</body>
</html>