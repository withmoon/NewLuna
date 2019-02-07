<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디카페 달빛</title>
<link href="<c:url value="/resources/user/event/css/event.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
</head>
<body>
<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<!-- 상단로고 -->
<a href="<c:url value="/nolog/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">이벤트</div>

<!-- 이벤트목록 -->
<section class="list_tab">
<table>
<tr>
<th>번호</th>
<th>제목</th>
<th>날짜</th>
</tr>
<tr>
<td>1</td>
<td><a href="showForm.jsp">☆5월 이벤트☆</a></td>
<td>2019-01-01</td>
</tr>

<tr>
<td>2</td>
<td><a href="showForm.jsp">☆4월 이벤트☆</a></td>
<td>2019-01-01</td>
</tr>
<tr>
<td>3</td>
<td><a href="showForm.jsp">☆3월 이벤트☆</a></td>
<td>2019-01-01</td>
</tr>
<tr>
<td>4</td>
<td><a href="showForm.jsp">☆2월 이벤트☆</a></td>
<td>2019-01-01</td>
</tr>
<tr>
<td>5</td>
<td><a href="showForm.jsp">☆1월 이벤트☆</a></td>
<td>2019-01-01</td>
</tr>
</table>
</section>
<div class="pnum"><a href="#">[이전]</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">[다음]</a></div>

<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>