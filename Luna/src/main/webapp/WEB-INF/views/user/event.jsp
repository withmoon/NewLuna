<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디카페 달빛</title>
<link href="<c:url value="/resources/user/event/css/event.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="<c:url value="/resources/user/event/js/event.js"/>"></script>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
</head>
<body>
<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<!-- 상단로고 -->
<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">이벤트</div>

<!-- 이벤트목록 -->
<section>
<div class="event-container">
	<ul class="eventTap">
		<li class="eventNow">진행중인이벤트</li>
		<li class="eventFinsh">종료된이벤트</li>
	</ul>
</div>
</section>

<section class="list_tab">
<!-- 진행 이벤트 목록 -->
<table class="eventNow2">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
	</tr>
	<tbody id="my-tbody">
	<c:forEach items="${eventList }" var="event">
		<tr>
		<td>${event.seq }</td>
		<td><a onclick="window.open('viewEvent.udo?seq=${event.seq}','window_name','width=700,height=720,location=no,status=no,scrollbars=yes');">
			${event.title }</a></td>
		<td>${event.writer }</td>
		<td><fmt:formatDate value="${event.startdate }" pattern="yy-MM-dd" /> ~ <fmt:formatDate value="${event.enddate }" pattern="yy-MM-dd" /></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</section>
<div class="pnum"><a href="#">[이전]</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">[다음]</a></div>

<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>