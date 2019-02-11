<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세보기</title>
<link href="<c:url value="/resources/user/viewEvent/css/viewEvent.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/user/viewEvent/js/viewEvent.js"/>"></script>
</head>
<body>
<header>
<img class="line1" src="<c:url value="/resources/user/viewEvent/images/line1.png"/>">
<p><b>${ebv.title }</b>
<span class="date">
	<fmt:formatDate value="${ebv.startDate }"></fmt:formatDate> ~ <fmt:formatDate value="${ebv.endDate }"></fmt:formatDate>
</span></p>
<img class="line2" src="<c:url value="/resources/user/viewEvent/images/line2.png"/>">
</header>
<section>
<div>${ebv.content }</div>
<img class="line1" src="<c:url value="/resources/user/viewEvent/images/line1.png"/>"><p>
<button type="button" onclick="windowClose()">닫기</button>
</section>
</body>
</html>