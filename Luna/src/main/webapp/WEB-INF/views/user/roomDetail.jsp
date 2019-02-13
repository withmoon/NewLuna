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

<script src="<c:url value="https://developers.kakao.com/sdk/js/kakao.min.js"/>"></script>

<script type="text/javascript" src="<c:url value="/resources/user/roomDetail/js/kakaoPop.js"/>"></script>
<script src="<c:url value="/resources/user/roomDetail/js/textAuto.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/user/roomDetail/js/rdjsgroup.js"/>"></script>
</head>
<body style="overflow-x:hidden">
<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<!-- 상단로고 -->

<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>

<div class="roomExp">

<img id="roomExpImg" src="<c:url value="/resources/user/roomDetail/images/cafe.jpg"/>">
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
<label id="bex1">강남점</label><br/><br/>
<label id="bex2">도로명 도로명 도로명 </label><br/><br/>
<label id="bex3">010-1121-1131</label><br/><br/>
<label id="bex4">카페 겸비, 조용한 시설</label>
</div>
</div>

<!-- 카카오 링크 -->
<a id="kakao-link-btn" title="카카오링크로 공유하기" href="javascript:sendLink()">
<img style="width:50%;" src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"/>
</a>

<script type='text/javascript' src="<c:url value="/resources/user/roomDetail/js/kakaolink.js"/>"></script>

<!-- 찜 안찜 -->
<img title="찜하기" id="keep" src="<c:url value="/resources/user/roomDetail/images/notChoiceList.png"/>" onclick="changeChoiceImg(this)"/>

<div id="showSchedule">
<p>선택하신 날짜 : <b><label>0월 0일</label> </b>의 스케줄입니다.</p><br/>
<table id="schdule">
<tr>
<th>오전</th>
<td style="background-color:#b5a495;">00:00</td>
<td style="background-color:#b5a495;">00:30</td>
<td style="background-color:#b5a495;">01:00</td>
<td style="background-color:#b5a495;">01:30</td>
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
<td style="background-color:#b5a495;">11:30</td>
</tr>
<tr>
<th>오후</th>
<td style="background-color:#b5a495;">12:00</td>
<td style="background-color:#b5a495;">12:30</td>
<td style="background-color:#b5a495;">13:00</td>
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

<!-- 오른쪽 달력 바 -->
<div class="right1">
<input type="date"><br/>
<button class="look">스케줄 보기</button>	
</div>

<!-- 오른쪽 예약 바 -->
<div class="right2">
	<!-- 로그인 페이지 들어가야 함 -->	
<c:if test="${member.id eq null}">
예약은 <a href="#">로그인</a> 필수<br/>
입니다.<br/><br/>
</c:if>
가격: 40000 원
<button class="rsbtn" onclick="kakapop()">예약&amp;결제</button>
</div>

<!-- 스프링 효과 -->

<img class="springEf" src="<c:url value="/resources/user/roomDetail/images/spring.png"/>"/>
<img style="right:9%" class="springEf2" src="<c:url value="/resources/user/roomDetail/images/spring.png"/>"/>

<section class="content">

<!-- 방소개 시작 -->
<section class="f_roomExplain">
<b style="text-decoration:underline;">방소개</b><br/>
<script>
var str=$('#etx1').val();
str=str.replaceAll("<br/>","\r\n");
$('#etx1').val(str);
</script>
<textarea class="etx1" id="etx1" style="overflow-y:hidden" cols="115" disabled="disabled">
${roomInfo.roomExplain}
</textarea>
<br/>
<!-- 방 사진 -->
<b style="text-decoration:underline;">방사진</b><br/>

<img src="<c:url value="/resources/user/roomDetail/images/cafe.jpg"/>">
<img src="<c:url value="/resources/user/roomDetail/images/cafecube.png"/>">
<img src="<c:url value="/resources/user/roomDetail/images/jonggakRoom.JPG"/>">
</section>
<br/>
<!-- 주의사항 시작 -->
<section>
<b style="color:gray; font-size:1.2vw;">※주의사항</b><br/>
<textarea class="etx2" style="color:gray; overflow-y:hidden" cols="115" disabled="disabled">
주의사항
주의사항
주의사항
주의사항
주의사항
</textarea>
</section>

<!-- 위치설명 시작 -->
<section>
<b style="text-decoration:underline;">오시는 길</b><br/>
<textarea class="etx3" style="overflow-y:hidden" cols="115" disabled="disabled">
왕십리역 2번출구 에서 직진후
바로 보이는 골목으로 들어오시면 
1층에 떡볶이집이 있는 빌딩 4층입니다^^
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
<div class="rbox">
작성자 : 선비냥이<br/>
작성날짜 : 2019-01-01<br/><br/>
흠.. <a href="#">수정</a>&emsp;<a href="#">삭제</a><br/>
</div>

<div class="rbox">
작성자 : 냥냥펀치님<br/>
작성날짜 : 2019-01-01<br/><br/>
아래 작성자 넌 뭐냥 왜 고냥이 말밖에 못하냥 어디서 순고양이가 인간세계에와서 어울리냥<br/>
</div>

<div class="rbox">
작성자 : 고냥이님<br/>
작성날짜 : 2019-01-01<br/><br/>
냥냥냥 냥냥~~냥냥 0ㅁ0 냥냥냥~~~~~~<br/>
</div>

<div class="rbox">
작성자 : 프로리뷰어님<br/>
작성날짜 : 2019-01-01<br/><br/>
공기정화기 덕분에 숨통도 잘 트이고 조명조절이 가능해서 오늘 프레젠테이션하는데 있어 너무나도 편리했습니다.<br/>
</div>

<div class="rbox">
작성자 : 난강사다<br/>
작성날짜 : 2019-01-01<br/><br/>
강의하는데 있어 아주 편리했습니다. 가격도 무인시스템으로 예약받아서 그런지 일반 적인 곳에 비해 싸서 좋네요<br/>
</div>
<br/>
<div class="pnum">[이전] <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> [다음]</div>
<br/>
<input type="text" size="120"><button>후기 올리기</button>
</section>


<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>