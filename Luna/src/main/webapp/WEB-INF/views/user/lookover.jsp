<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디카페 달빛</title>
<link rel="stylesheet" href="<c:url value="/resources/user/lookover/css/LookOver.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/public/css/topmenu.css"/>"/>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/user/lookover/js/LookOver.js"/>"></script>
</head>
<body style="overflow-x:hidden;">
<!-- 상단 기본 바 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<!-- 상단로고 -->
<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">방 찾기</div>

<!-- 지점 지정 -->
<section class="searchArea">
<p>날짜 적용후 이미지에 마우스를 올리시면 자세한 스케줄 확인이 가능합니다^^</p>

<select name="sido" id="sido_select">
<c:if test="${sel_sido eq ''}">
<option selected="selected" disabled="disabled" hidden="true">시/도 선택</option>
</c:if>
	<c:forEach  var="sidoList" items="${sido}">
		<c:if test="${sidoList eq sel_sido}">
			<option value="${sidoList}" selected="selected">${sidoList}</option>
		</c:if>
		<c:if test="${sidoList ne sel_sido}">
			<option value="${sidoList}">${sidoList}</option>
		</c:if>
	</c:forEach>
</select>

<!-- 시/군/구 -->
<select name="gugun" id="gugun_select"></select>

<input id="reservDate" type="date">
<button class="look" onclick="findCanReservRoom()">적용</button>

<input type="hidden" id="sel_gugun" value="${sel_gugun}"/>	
</section>

<!-- 검색결과 보여주는 곳 -->
<div class="showRoom" style="overflow-y:scroll;">

<c:forEach var="roomList" items="${roomList}">
<div class="showView">
<a href="#" onmouseenter="showSd()" onmouseleave="hideSd()"><img src="<c:url value="/resources/rooms/${roomList.fname}"/>"/></a><br/>
<a href="#">${roomList.roomName}</a><br/>
<label>(${roomList.branchName})</label><br/>
<label>${roomList.roomEx1}</label><br/>
<label>${roomList.roomEx2}</label><br/> 
<label>${roomList.roomEx3}</label>
</div>
</c:forEach>

</div>

<!-- 스케줄 구간 -->
<div id="showSchedule">
<p style="color:white">방을 예약하시려면 이미지를 클릭해주세요^^</p>
<p>선택하신 날짜 : <b><label>0월 0일 00</label>방</b>의 스케줄입니다.</p><br/>
<table>
<tr>
<th>오전</th>
<td>00:00</td>
<td>00:30</td>
<td>01:00</td>
<td>01:30</td>
<td>02:00</td>
<td>02:30</td>
<td>03:00</td>
<td>03:30</td>
<td>04:00</td>
<td>04:30</td>
<td>05:00</td>
<td>05:30</td>
<td>06:00</td>
<td>06:30</td>
<td>07:00</td>
<td>07:30</td>
<td>08:00</td>
<td>08:30</td>
<td>09:00</td>
<td>09:30</td>
<td>10:00</td>
<td>10:30</td>
<td>11:00</td>
<td>11:30</td>
</tr>
<tr>
<th>오후</th>
<td>12:00</td>
<td>12:30</td>
<td>13:00</td>
<td>13:30</td>
<td>14:00</td>
<td>14:30</td>
<td>15:00</td>
<td>15:30</td>
<td>16:00</td>
<td>16:30</td>
<td>17:00</td>
<td>17:30</td>
<td>18:00</td>
<td>18:30</td>
<td>19:00</td>
<td>19:30</td>
<td>20:00</td>
<td>20:30</td>
<td>21:00</td>
<td>21:30</td>
<td>22:00</td>
<td>22:30</td>
<td>23:00</td>
<td>23:30</td>
</tr>
</table>
</div>

<footer>
<%@ include file="../public/footer.jsp" %>
</footer>

</body>
</html>