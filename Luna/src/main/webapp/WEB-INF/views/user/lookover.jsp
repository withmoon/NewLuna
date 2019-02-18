<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디카페 달빛</title>
<%-- --%><link rel="stylesheet" href="<c:url value="/resources/user/lookover/css/LookOver.css"/>"/>
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
<c:if test="${sel_sido eq '시/도 선택'}">
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
<a href="roomDetail.udo?roomnum=${roomList.roomNum}"><img src="<c:url value="/resources/rooms/${roomList.fname}"/>"/></a><br/>
<a href="#">${roomList.roomName}</a><br/>
<label>(${roomList.branchName})</label><br/>
<label>${roomList.roomEx1}</label><br/>
<label>${roomList.roomEx2}</label><br/> 
<label>${roomList.roomEx3}</label>
</div>
</c:forEach>

</div>

<!-- 스케줄 구간 -->
<div class="showSchedule">
<p style="color:white">방을 예약하시려면 이미지를 클릭해주세요^^</p>
<p>선택하신 날짜 : <b><label>0월 0일 00</label>방</b>의 스케줄입니다.</p><br/>
<table>
<tr>
<th>오전</th>
<td id="am1">00:00</td>
<td id="am2">00:30</td>
<td id="am3">01:00</td>
<td id="am4">01:30</td>
<td id="am5">02:00</td>
<td id="am6">02:30</td>
<td id="am7">03:00</td>
<td id="am8">03:30</td>
<td id="am9">04:00</td>
<td id="am10">04:30</td>
<td id="am11">05:00</td>
<td id="am12">05:30</td>
<td id="am13">06:00</td>
<td id="am14">06:30</td>
<td id="am15">07:00</td>
<td id="am16">07:30</td>
<td id="am17">08:00</td>
<td id="am18">08:30</td>
<td id="am19">09:00</td>
<td id="am20">09:30</td>
<td id="am21">10:00</td>
<td id="am22">10:30</td>
<td id="am23">11:00</td>
<td id="am24">11:30</td>
</tr>
<tr>
<th>오후</th>
<td id="pm1">12:00</td>
<td id="pm2">12:30</td>
<td id="pm3">13:00</td>
<td id="pm4">13:30</td>
<td id="pm5">14:00</td>
<td id="pm6">14:30</td>
<td id="pm7">15:00</td>
<td id="pm8">15:30</td>
<td id="pm9">16:00</td>
<td id="pm10">16:30</td>
<td id="pm11">17:00</td>
<td id="pm12">17:30</td>
<td id="pm13">18:00</td>
<td id="pm14">18:30</td>
<td id="pm15">19:00</td>
<td id="pm16">19:30</td>
<td id="pm17">20:00</td>
<td id="pm18">20:30</td>
<td id="pm19">21:00</td>
<td id="pm20">21:30</td>
<td id="pm21">22:00</td>
<td id="pm22">22:30</td>
<td id="pm23">23:00</td>
<td id="pm24">23:30</td>
</tr>
</table>
</div>

<footer>
<%@ include file="../public/footer.jsp" %>
</footer>

</body>
</html>