<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>스터디카페 달빛</title>
<link href="<c:url value="/resources/user/roomDetail/css/roomDetail.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
<!-- 카카오링크 developer -->
<script src="<c:url value="https://developers.kakao.com/sdk/js/kakao.min.js"/>"></script>
<!-- 카카오 결제창 띄움 -->
<script type="text/javascript" src="<c:url value="/resources/user/roomDetail/js/kakaoPop.js"/>"></script>
<!-- textArea  조절 js -->
<script src="<c:url value="/resources/user/roomDetail/js/textAuto.js"/>"></script>
<!-- roomDetail 고유 js -->
<script type="text/javascript" src="<c:url value="/resources/user/roomDetail/js/rdjsgroup.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/public/js/getSchedule.js"/>"></script>
</head>
<body style="overflow-x:hidden">
  
  
  <form id="theForm" action="" method="POST">
  		<input type="hidden" id="status" name="status" value="${roomPay.status}"/>
  		<input type="hidden" id="branchName" name="branchName" value="${roomInfo.branchName}"/>
  		<input type="hidden" id="roomNum" name="roomNum" value="${roomInfo.roomNum}"/>
  		<input type="hidden" id="roomName" name="roomName" value="${roomInfo.roomName}"/>
		<input type="hidden" id="reserveTime" name="reserveTime" value="${roomPay.reserveTime}"/>
        <input type="hidden" id="imp_uid" name="imp_uid" value="${roomPay.imp_uid}"/>
        <input type="hidden" id="merchant_uid" name="merchant_uid" value="${roomPay.merchant_uid}"/>
        <input type="hidden" id="payAmount" name="payAmount" value="${roomPay.payAmount}"/>
        <input type="hidden" id="paid_ats" name="paid_ats" value="${roomPay.paid_ats}"/>
        <input type="hidden" id="receipt_url" name="receipt_url" value="${roomPay.receipt_url}"/> 
        <input type="hidden" id="pg_provider" name="pg_provider" value="${roomPay.pg_provider}"/>
        <input type="hidden" id="pg_tid" name="pg_tid" value="${roomPay.pg_tid}"/> 
        <input type="hidden" id="reservdate" name="reservdate" value="${roomPay.reservdate}"/> 
  </form>
  
<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<!-- 상단로고 -->

<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>

<div class="roomExp">
<img id="roomExpImg" src="<c:url value="/resources/rooms/${roomImgList.get(0).getFname()}"/>">
<div id="roomExplain">
<b>방소개</b><br/><br/>
<label id="ex1">${roomInfo.roomEx1}</label><br/><br/>
<label id="ex2">${roomInfo.roomEx2}</label><br/><br/>
<label id="ex3">${roomInfo.roomEx3}</label><br/><br/>
<label id="ex4">${roomInfo.roomEx4}</label>
</div>
<div class="rsec"></div>
<div id="branchExplain">
<b>지점소개</b><br/><br/>
<label id="bex1">${roomInfo.branchName}</label><br/><br/>
<label id="bex2">${roomInfo.branchAddr1}</label><br/><br/>
<label id="bex3">010-1121-1131</label><br/><br/>
<label id="bex4">카페 겸비, 조용한 시설</label>
</div>
</div>
<input type="hidden" id="rname" value="${roomInfo.roomName}"/>
<!-- 카카오 링크 -->
<a id="kakao-link-btn" title="카카오링크로 공유하기" href="javascript:sendLink()">
<img style="width:50%;" src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"/>

</a>

<script type='text/javascript' src="<c:url value="/resources/user/roomDetail/js/kakaolink.js"/>"></script>

<!-- 찜 안찜 -->
<img title="찜하기" id="keep" src="<c:url value="/resources/user/roomDetail/images/notChoiceList.png"/>" onclick="changeChoiceImg(this)"/>

<!-- 스케줄 구간 -->
<div id="showSchedule">
<p>선택하신 날짜 : <b><label id="startdat">${sel_date}</label></b>의 스케줄입니다.</p><br/>
<table id="schdule">
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

<!-- 오른쪽 달력 바 -->
<div class="right1">
<input type="date" id="reservDate" value="${sel_date}"><br/>
<button class="look" onclick='showSd(${roomInfo.roomNum})'>스케줄 보기</button>	
</div>

<!-- 오른쪽 예약 바 -->
<div class="right2">
	<!-- 로그인 페이지 들어가야 함 -->	
<c:if test="${member.id eq null}">
예약은 <a href="login.do">로그인</a> 필수<br/>
입니다.<br/><br/>
</c:if>
<input type="hidden" id="payPrice" value="${roomInfo.roomprice}"/>
<label class="payArea">☆가격☆<br/>(30분당: ${roomInfo.roomprice})원</label><br/><br/>
<label>기본예약 시간은 <br/><b>2시간</b>입니다♡</label>
<c:if test="${member.id ne null}">
<a onclick="kakapop()"><img class="rsbtn" src="<c:url value="/resources/user/roomDetail/images/payment_icon_yellow_medium.png"/>;"></a>
</c:if>
</div>

<!-- 스프링 효과 -->

<img class="springEf" src="<c:url value="/resources/user/roomDetail/images/spring.png"/>"/>
<img style="right:9%" class="springEf2" src="<c:url value="/resources/user/roomDetail/images/spring.png"/>"/>

<section class="content">

<!-- 방소개 시작 -->
<section class="f_roomExplain">
<b style="text-decoration:underline;">방소개</b><br/>

<textarea class="etx1" id="etx1" style="overflow-y:hidden" cols="115" disabled="disabled">
${roomInfo.roomExplain}
</textarea>
<br/>
<!-- 방 사진 -->
<b style="text-decoration:underline;">방사진</b><br/>
<img src="<c:url value="/resources/rooms/${roomImgList.get(1).getFname()}"/>">
<img src="<c:url value="/resources/rooms/${roomImgList.get(2).getFname()}"/>">
<img src="<c:url value="/resources/rooms/${roomImgList.get(3).getFname()}"/>">
<img src="<c:url value="/resources/rooms/${roomImgList.get(4).getFname()}"/>">
</section>
<br/>
<!-- 주의사항 시작 -->
<section>
<b style="color:gray; font-size:1.2vw;">※주의사항</b><br/>
<textarea class="etx2" style="color:gray; overflow-y:hidden" cols="115" disabled="disabled">
${roomInfo.roomWarn}
</textarea>
</section>

<!-- 위치설명 시작 -->
<section>
<b style="text-decoration:underline;">오시는 길</b><br/>
<textarea class="etx3" style="overflow-y:hidden" cols="115" disabled="disabled">
${roomInfo.comeRoute}
</textarea>
</section>

<!-- 다음 지도 시작 -->
<section>
<div id="map" style="width:100%; height:300px" ></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=da37e5836c002230d358ce5af57a57ca&libraries=services"></script>
<script type="text/javascript" src="<c:url value="/resources/user/roomDetail/js/branchLocate.js"/>"></script>
</section>
</section>

<!-- 리뷰 시작 -->
<section class="review">
<img src="<c:url value="/resources/user/roomDetail/images/star.png"/>"><b>한줄후기</b><img src="<c:url value="/resources/user/roomDetail/images/star.png"/>">
<br/>여러분의 <a href="#" onclick="rivDown('pnum')">한줄후기</a> 를 들려주세요<br/><br/>
<section id="rboxsec">
</section>
<br/>
<div class="pnum">[이전] <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> [다음]</div>
<br/>
</section>

<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>