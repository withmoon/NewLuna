<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link rel="stylesheet" type="text/css" href="css/MyPage.css">
<link rel="stylesheet" href="../../Public/TopMenu.css"/>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"></script>
</head>
<body>
	<!-- 로그인 -->
	<header>
		<ul class="topUl">
			<li><a href="#">이벤트</a></li>
			<li>&emsp; &ensp;</li>
			<li><a href="#">지점 찾기</a></li>
			<li>&emsp; &ensp;</li>
			<li><a href="#">로그인&nbsp;/&nbsp;회원가입</a></li>
		</ul>
	</header>
	
	<!-- 상단로고 -->
	<a href="../Home/Home.jsp" title="홈으로 이동"><img class="logo" src="../../Public/Logo/MainLogo.png"/></a>
	<div class="top">MyPage</div>

	<section>
		<!-- 회원정보 -->
		<div class="myinformation">
			<img alt="" src="images/line.png">
			<p>- 테스트님 -</p>
			&emsp;전화번호&ensp;010-1111-1111 <br>
			&emsp;이메일 &ensp;email@email.com
			<button class="update">정보수정</button>
			<button class="room">
				<img alt="" src="images/love.png"> <br>내가 찜한 방
			</button>
			<img alt="" src="images/line.png">
		</div>
		
		<!-- 일정 -->
		<div class="line2"><img alt="" src="images/line2.png"></div>
		<div class="schedule">
			<br>
			<input type="date" class="calendal"> <!-- 달력 -->
			당일<input type="radio" name="schedule" value="today" checked>
			일주일<input type="radio" name="schedule" value="week">
			한달<input type="radio" name="schedule" value="month">
			3개월<input type="radio" name="schedule" value="3months"> <!-- 일정 -->
			<button class="update">적용</button>
			<br>
		</div>
		
		<!-- 예약 현황 -->
		<div class="noroom"><img alt="" src="images/noroom.png"></div>
		<div class="reservation">
			<p>현재 서울 지점 예약되었습니다.</p>
			&emsp;전화번호&ensp;02.2222.2222 <br>
			&emsp;주소 &ensp;서울시 동대문구 장안동 <br>
			&emsp;룸 &ensp;스터디 1룸<br>
			&emsp;시간 &ensp; 2018.01.02 pm7:00~pm8:30
			<button class="update">취소/환불</button>
			<button class="update">리뷰</button>
		</div>
		<div>
			<table>
				<tr>
					<th>지점</th>
					<th>룸</th>
					<th>시간</th>
					<th>예약</th>
				</tr>
				<tr>
					<th>서울지점</th>
					<th>스터디 1룸</th>
					<th>pm7:00~pm8:30</th>
					<th>예약 완료</th>
				</tr>
				<tr>
					<th>서울지점</th>
					<th>스터디 2룸</th>
					<th>pm7:00~pm8:30</th>
					<th>예약 미완료</th>
				</tr>
				<tr>
					<th><br></th>
					<th><br></th>
					<th><br></th>
					<th><br></th>
				</tr>
				<tr>
					<th><br></th>
					<th><br></th>
					<th><br></th>
					<th><br></th>
				</tr>
				<tr>
					<th><br></th>
					<th><br></th>
					<th><br></th>
					<th><br></th>
				</tr>
			</table>
		</div>
	</section>
<!-- 
		

<section class="bottom">
	<div >
		<input type="date">
		
			당일<input type="radio" name="schedule" value="today" checked>
			일주일<input type="radio" name="schedule" value="week">
			한달<input type="radio" name="schedule" value="month">
			3개월<input type="radio" name="schedule" value="3months">
		
		<button class="look">적용</button>
	</div>&nbsp;
	<div >
		<img alt="" src="images/room1.png">
	</div>
</section> -->

</body>
</html>