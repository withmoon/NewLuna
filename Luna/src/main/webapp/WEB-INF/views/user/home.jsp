<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="<c:url value="/resources/user/home/css/home.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/user/home/js/home.js"/>"></script>
</head>
<body>
	<!-- 상단메뉴 -->
	<header>
		<%@ include file="../public/topmenu.jsp" %>
	</header>
	
	<!-- 상단로고 -->
	<a href="<c:url value="/nolog/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
	<div class="top">HOME</div>

	
	<section>
	<!-- 배너 -->
	<div>
		<div onmouseover="view1(true)" onmouseout="view1(false)">
    		<img class="whole" alt="전체지점수" src="<c:url value="/resources/user/home/images/whole.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/whole.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/whole2.png"/>'">
		</div>
		<div id="whole2">
    		<b>전국 380개의 지점수</b><br> <!-- 지점명이 있고 상태가 0인 지점 갯수 넣어주기 -->
        	MoimCenter : 22센터    StudyCenter: 349센터    WorkCenter: 9센터
        </div>
        <div onmouseover="view2(true)" onmouseout="view2(false)">
    		<img class="previous" alt="전월이용고객님" src="<c:url value="/resources/user/home/images/previous.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/previous.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/previous2.png"/>'">
		</div>
		<div id="previous2">
    		<b>22,712명 고객님들 감사합니다~</b><br> <!-- 지점명이 없는 유저들의 명수 넣어주기 -->
        	MoimCenter : 1,934명   StudyCenter: 20,098명    WorkCenter: 680명
        </div>
        <div onmouseover="view3(true)" onmouseout="view3(false)">
    		<img class="accumulate" alt="고객님이용횟수" src="<c:url value="/resources/user/home/images/accumulate.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/accumulate.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/accumulate2.png"/>'">
		</div>
		<div id="accumulate2">
    		<b>22,712명 고객님들이 증명합니다</b><br> <!-- 전일/ 전월 예약 명수 넣기 -->
        	전일 예약수 : 1,934명  전월예약 수 : 20,098명
        </div>
		<div align="center"  id="banner">
			<img alt="studyhome" src="<c:url value="/resources/user/home/images/studyhome.png"/>" >
		</div>
	</div>

	<!-- 선택창 -->
	<!-- 시/도 -->
	<div align="center">
	<select name="sido"></select>
	<!-- 시/군/구 -->
	<select name="gugun"></select>
	
	<button class="btn_find">찾기</button><p>
	<table class="find">
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
					<td><a href="<c:url value="/lookover.udo"/>">서울시 동대문구 장안동</a></td>
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
	</div>&nbsp;
	
	<!-- 인기순/조회수/new -->
	<div align="center">
		<p><img alt="" src="<c:url value="/resources/user/home/images/line.png"/>">	인기순	<img alt="" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
		<table border="0">
			<tr>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room1.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room2.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room3.png"/>" width="400" height="250"></td>
			</tr>
			<tr>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room1.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room2.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room3.png"/>" width="400" height="250"></td>
			</tr>
		</table>
		<p><img alt="" src="<c:url value="/resources/user/home/images/line.png"/>">	조회순	<img alt="" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
		<table border="0">
			<tr>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room1.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room2.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room3.png"/>" width="400" height="250"></td>
			</tr>
		</table>
	<p><img alt="" src="<c:url value="/resources/user/home/images/line.png"/>">   리뷰   <img alt="" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
   </div>
   </section>
   
   <!-- review -->
   <section class="review">
      <img src="<c:url value="/resources/user/home/images/star.png"/>"><b>한줄후기</b><img src="<c:url value="/resources/user/home/images/star.png"/>">
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
      </div><br/>
      <div class="pnum">[이전] <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> [다음]</div><br/>
      
   </section>
  	<!-- footer -->
	<footer>
		<%@ include file="../public/footer.jsp" %>
	</footer>
</body>
</html>