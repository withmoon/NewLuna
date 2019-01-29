<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link href="<c:url value="/resources/user/mypage/css/mypage.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"></script>
</head>
<body>
	<!-- 로그인 -->
	<header>
		<nav>
			<ul class="topUl">
			<li><a href="<c:url value="event.udo"/>">이벤트</a></li>
			<li>&emsp;&nbsp;&nbsp;</li>
			<li><a href="<c:url value="foundbranch.udo"/>">지점 찾기</a></li>
			<li>&emsp;&nbsp;&nbsp;</li>
			<li><a href="<c:url value="inform.udo"/>">고객 센터</a></li> 
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li><a href="<c:url value="myPage.udo"/>" style="text-decoration: underline;">마이페이지</a></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li><a href="#">로그아웃</a></li>
			</ul>
		</nav>
	</header>
	
	<!-- 상단로고 -->
	<a href="<c:url value="home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
	<div class="top">MyPage</div>

	<section>
		<!-- 회원정보 -->
		<div class="myinformation">
			<img alt="" src="<c:url value="/resources/user/mypage/images/line.png"/>">
			<p>- 테스트님 -</p>
			&emsp;전화번호&ensp;010-1111-1111 <br>
			&emsp;이메일 &ensp;email@email.com
			<button class="update">정보수정</button>
			<div class="deer"><img alt="" src="<c:url value="/resources/user/mypage/images/deer.png"/>"></div>
			<img alt="" src="<c:url value="/resources/user/mypage/images/line.png"/>">
		</div>
		
		<!-- 즐겨찾기 -->
		<p class="favorites1">- 내가 찜한 방 -</p>
		<table class="favorites2">
			<thead>
				<tr>
					<th scope="cols">지점</th>
					<th scope="cols">룸</th>
					<th scope="cols">장소</th>
					<th scope="cols">전화번호</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>서울지점</td>
					<td>스터디 1룸</td>
					<td>서울시 동대문구 장안동</td>
					<td>02.2222.2222</td>
				</tr>
				<tr>
					<td>서울지점</td>
					<td>VIP실</td>
					<td>서울시 강남구 압구정동</td>
					<td>02-3511-2889</td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
			</tbody>
		</table>
		
		<!-- 일정 -->
		<p class="reservation1">- 예약현황 -</p>
		<div class="line2"><img alt="" src="<c:url value="/resources/user/mypage/images/line2.png"/>"></div>
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
		
		<div class="noroom"><img alt="" src="<c:url value="/resources/user/mypage/images/noroom.png"/>"></div>
		<div class="reservation2">
			<p>현재 서울 지점 예약되었습니다.</p>
			&emsp;전화번호&ensp;02.2222.2222 <br>
			&emsp;주소 &ensp;서울시 동대문구 장안동 <br>
			&emsp;룸 &ensp;스터디 1룸<br>
			&emsp;날짜 &ensp; 2019.01.02<br>
			&emsp;시간 &ensp; pm7:00~pm8:30
			<button class="update">취소/환불</button>
			<button class="update">리뷰</button>
		</div>
		<table class="availability">
			<thead>
				<tr>
					<th scope="cols">지점</th>
					<th scope="cols">룸</th>
					<th scope="cols">날짜</th>
					<th scope="cols">시간</th>
					<th scope="cols">예약</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>서울지점</td>
					<td>스터디 1룸</td>
					<td>2019.01.02</td>
					<td>pm7:00~pm8:30</td>
					<td>예약 완료</td>
				</tr>
				<tr>
					<td>서울지점</td>
					<td>스터디 2룸</td>
					<td>2019.01.02</td>
					<td>pm7:00~pm8:30</td>
					<td>예약 미완료</td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
			</tbody>
		</table>
		
		<!-- 알림 -->
		<p class="notification1">- 알림 -</p>
		<table class="notification2">
			<tbody>
				<tr>
					<td><img alt="" src="<c:url value="/resources/user/mypage/images/message1.png"/>"></td>
					<td>관리자</td>
					<td>서울지점 예약이 취소되었습니다.</td>
					<td>01.05 11:50</td>
				</tr>
				<tr>
					<td><img alt="" src="<c:url value="/resources/user/mypage/images/message2.png"/>"></td>
					<td>관리자</td>
					<td>서울지점 환불처리 완료</td>
					<td>12.21 08:00</td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
			</tbody>
		</table>
	</section>
	
	<!-- footer -->
	<footer>
		<section class="sec" style="width:100%; height:1%; border-top:1px solid darkgray; margin:0 1% 1% 0;"></section>
		&nbsp;Shining in the dark 
		&emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;
		&emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		㈜2조시스템즈/사업자등록번호 : 112 01 12321 /대표이사 대표다/서울 성동구 왕십리동 빌드빌딩 4층<br/> 
		<Strong>MoonLight</Strong> StudyCafe
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		©2019. 2JOSYSTEMS Corp.
	</footer>
</body>
</html>