<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디카페 달빛</title>
<link rel="stylesheet" href="css/LookOver.css"/>
<link rel="stylesheet" href="../../Public/TopMenu.css"/>
<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/LookOver.js"></script>
</head>
<body style="overflow-x:hidden;">
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
<div class="top">방 찾기</div>

<!-- 지점 지정 -->
<section class="searchArea">
<p>날짜 적용후 이미지에 마우스를 올리시면 자세한 스케줄 확인이 가능합니다^^</p>
<select id="branchSido">
		<option value="서울">서울</option>
		<option value="부산">부산</option>
		<option value="대구">대구</option>
		<option value="인천">인천</option>
		<option value="광주">광주</option>
		<option value="대전">대전</option>
		<option value="울산">울산</option>
		<option value="경기">경기</option>
		<option value="강원">강원</option>
		<option value="세종">세종</option>
		<option value="충청남도">충청남도</option>
		<option value="충청북도">충청북도</option>
		<option value="전라남도">전라남도</option>
		<option value="전라북도">전라북도</option>
		<option value="경상남도">경상남도</option>
		<option value="경상북도">경상북도</option>
		<option value="제주">제주</option>
</select>

<select id="branchBranch">
		<option value="서울지점">서울지점</option>
		<option value="경기지점">경기지점</option>
		<option value="대구지점">대구지점</option>
</select>
<input type="date">
<button class="look">적용</button>	
</section>

<!-- 검색결과 보여주는 곳 -->
<div class="showRoom" style="overflow-y:scroll;">
<div class="showView">
<a href="#" onmouseenter="showSd()" onmouseleave="hideSd()"><img src="sampleImg/더빅스터디카페8콘.jpg"></a><br/>
<a href="#">첫번째이미지</a><br/>
<label>설명1</label><br/>
<label>설명2설명2</label><br/>
<label>설명3설명3설명3</label>
</div>

<div class="showView">
<a href="#" onmouseenter="showSd()" onmouseleave="hideSd()"><img src="sampleImg/더빅스터디카페단체.jpg"></a><br/>
<a href="#">두번째이미지</a><br/>
<label>설명1</label><br/>
<label>설명2설명2설명2설명2</label><br/>
<label>설명3설명3설명3</label>
</div>
<div class="showView">
<a href="#"><img src="sampleImg/위넌스터디카페.jpg"></a><br/>
<a href="#">세번째이미지</a><br/>
<label>설명1</label><br/>
<label>설명2설명2설명2설명2</label><br/>
<label>설명3설명3설명3설명3설명3</label>
</div>
<div class="showView">
<a href="#"><img src="sampleImg/더빅스터디카페단체2_1.png"></a><br/>
<a href="#">네번째이미지</a><br/>
<label>설명1</label><br/>
<label>설명2설명2설명2설명2</label><br/>
<label>설명3설명3설명3설명3설명3</label>
</div>

<div class="showView">
<a href="#"><img src="sampleImg/홀릭스터디카페본점.jpg"></a><br/>
<a href="#">다섯번째이미지</a><br/>
<label>설명1</label><br/>
<label>설명2설명2설명2설명2</label><br/>
<label>설명3설명3설명3설명3설명3</label>
</div>

</div>

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
<jsp:include page="../../Public/footer.jsp"/><br/><br/><br/><br/><br/>
</footer>
</body>
</html>