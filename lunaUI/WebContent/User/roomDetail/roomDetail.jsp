<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>스터디카페 달빛</title>
<link rel="stylesheet" href="css/roomDetail.css"/>
<link rel="stylesheet" href="../../Public/TopMenu.css"/>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
<nav>
<ul class="topUl">
<li><a href="#">이벤트</a></li>
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">지점 찾기</a></li>
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">로그인&nbsp;/&nbsp;회원가입</a></li>
<!-- 
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">마이페이지</a></li>
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">로그아웃</a></li> -->
</ul>
</nav>

<!-- 상단로고 -->
<a href="../Home/home.jsp" title="홈으로 이동"><img class="logo" src="../../Public/Logo/MainLogo.png"/></a>

<div class="roomExp">
<img id="roomExpImg" src="sampleImg/더빅스터디카페단체.jpg">
<div id="roomExplain">
<b>방소개</b><br/><br/>
<label id="ex1">30인</label><br/><br/>
<label id="ex2">빔프로젝터 구비</label><br/><br/>
<label id="ex3">큐브형 룸</label><br/><br/>
<label id="ex4">쾌적한환경과 조절가능한 조명</label>
</div>
<div class="sec"></div>
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
<script type='text/javascript' src="js/kakaolink.js"></script>

<!-- 찜 안찜 -->
<img title="찜하기" id="keep" src="images/안찜.png" onclick="this.src='images/찜.png'"/>

<div id="showSchedule">
<p>선택하신 날짜 : <b><label>0월 0일</label> </b>의 스케줄입니다.</p><br/>
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

<!-- 오른쪽 달려 바 -->
<div class="right1">
<input type="date"><br/><br/>
<button class="look">스케줄 보기</button>	
</div>

<!-- 오른쪽 예약 바 -->
<div class="right2">
	<!-- 로그인 페이지 들어가야 함 -->	
예약은 <a href="#">로그인</a> 필수<br/>
입니다.<br/><br/>
[입장시간]<br/>
<select>
	<option value="a00">00</option>
	<option value="a01">01</option>
	<option value="a01">02</option>
	<option value="a03">03</option>
	<option value="a04">04</option>
	<option value="a05">05</option>
	<option value="a06">06</option>
	<option value="a07">07</option>
	<option value="a08">08</option>
	<option value="a09">09</option>
	<option value="a10">10</option>
	<option value="a11">11</option>
	<option value="p12">12</option>
	<option value="p13">13</option>
	<option value="p14">14</option>
	<option value="p15">15</option>
	<option value="p16">16</option>
	<option value="p17">17</option>
	<option value="p18">18</option>
	<option value="p19">19</option>
	<option value="p20">20</option>
	<option value="p21">21</option>
	<option value="p22">22</option>
	<option value="p23">23</option>
</select>
<select>
	<option value="m00">00</option>
	<option value="m30">30</option>
</select>
<br/><br/>
[이용시간]<br/>
<select>
	<option value="tl_2">02</option>
	<option value="tl_3">03</option>
	<option value="tl_4">04</option>
	<option value="tl_5">05</option>
	<option value="tl_6">06</option>
	<option value="tl_7">07</option>
	<option value="tl_8">08</option>
	<option value="tl_9">09</option>
	<option value="tl_10">10</option>
</select>

</div>

<!-- 스프링 효과 -->
<img class="springEf" src="images/동글2.png"/>
<img style="right:18%" class="springEf" src="images/동글2.png"/>

<!-- 주의사항 시작 -->

<!-- 방소개 시작 -->

<!--  -->

<!-- 위치설명 시작 -->

<!-- 다음 지도 시작 -->

<!-- 리뷰 시작 -->

<footer>
<jsp:include page="../../Public/footer.jsp"/><br/><br/><br/><br/><br/>
</footer>
</body>
</html>