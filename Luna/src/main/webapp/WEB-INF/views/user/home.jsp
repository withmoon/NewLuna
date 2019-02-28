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
	
	
	<!-- 상단로고 -->
	<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
	<div class="top">HOME</div>
	
	<section>
	
	<!-- 상단메뉴 -->
	<nav>
		<%@ include file="../public/topmenu.jsp" %>
	</nav>
	
	<!-- 배너 -->
	<div>
		<div align="center"  class="banner">
			<img id="banner" src="<c:url value="/resources/user/home/images/studyhome.png"/>" >
		</div>
		
		<div onmouseover="view1(true)" onmouseout="view1(false)">
    		<img class="whole" alt="전체지점수" src="<c:url value="/resources/user/home/images/whole.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/whole.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/whole2.png"/>'">
		</div>
		<div id="whole2">
    		<b>☆전국 ${allBranchCount}개의 스터디카페 달빛☆</b><br> <!-- 지점명이 있고 상태가 0인 지점 갯수 넣어주기 -->
        	
        </div>
        <div onmouseover="view2(true)" onmouseout="view2(false)">
    		<img class="previous" alt="전월이용고객님" src="<c:url value="/resources/user/home/images/previous.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/previous.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/previous2.png"/>'">
		</div>
		<div id="previous2">
    		<b>${allMemberCount}명 고객님들 감사합니다~</b><br> <!-- 예약 테이블에서 작년 예약수 count(*)해서 넣기 -->
        	작년 예약수 : ${preYearReserveCount}명 올해 예약수 : ${thisYearReserveCount}명  
        </div>
        <div onmouseover="view3(true)" onmouseout="view3(false)">
    		<img class="accumulate" alt="고객님이용횟수" src="<c:url value="/resources/user/home/images/accumulate.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/accumulate.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/accumulate2.png"/>'">
		</div>
		<div id="accumulate2">
    		<b>${allMemberCount}명 고객님들이 증명합니다</b><br> <!-- 전일 : 현재날짜에서 하루 빠진 날의 예약 수 count(*)  전월 : 현재날짜에서 한달빼고 나온 월의 예약수 count-->
        	전일 예약수 : ${preDayReserveCount}명  전월예약 수 : ${preMonthReserveCount}명
        </div>
	</div>
	
	<!-- 선택창 -->
	<!-- 시/도 -->
	<div align="center" class="slctDiv">
	<label>♡시/도와 시/구/군을 선택후 찾기를 눌러주세요♡</label><br/>
	<select name="sido" id="sido_select">
	<option selected="selected" disabled="disabled" hidden="true">시/도 선택</option>
		<c:forEach  var="sidoList" items="${sido}">
			<option value="${sidoList}">${sidoList}</option>
		</c:forEach>
	</select>
	<!-- 시/군/구 -->
	<select name="gugun" id="gugun_select"></select>
	<button class="btn_find" onclick="findRoom()">찾기</button>
	</div>
	<!-- 여기까지 선택창 -->
	
	<!-- 인기순/조회수/new -->
	<div class="roomTable" align="center">
		<p class="fmroom"><img class="line" src="<c:url value="/resources/user/home/images/line.png"/>">&emsp;♡달빛 인기 공간♡&emsp;<img class="line" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
		<table>
			<tr>
				<td>
				<div class="slider">
				<figure>
					<img src="<c:url value="/resources/user/home/images/room1.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room3.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
				</figure>
				</div>
				</td>
				<td>
				<div class="slider">
				<figure>
					<img src="<c:url value="/resources/user/home/images/room1.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room3.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
				</figure>
				</div>
				</td>
				<td>
				<div class="slider">
				<figure>
					<img src="<c:url value="/resources/user/home/images/room1.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room3.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
				</figure>
				</div>
				</td>
			</tr>
			<tr>
			<td><a>평점<br/>브랜치 명<br/>룸이름</a></td>
			<td><a>평점<br/>브랜치 명<br/>룸이름</a></td>
			<td><a>평점<br/>브랜치 명<br/>룸이름</a></td>
			</tr>
		</table>
		<p class="lkroom"><img class="line" src="<c:url value="/resources/user/home/images/line.png"/>">&emsp;☆예약 많은 공간☆&emsp;<img class="line" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
		<table>
			<tr>
				<td>
				<div class="slider">
				<figure>
					<img src="<c:url value="/resources/user/home/images/room1.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room3.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
				</figure>
				</div>
				</td>
				<td>
				<div class="slider">
				<figure>
				
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room3.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
						<img src="<c:url value="/resources/user/home/images/room1.png"/>" alt="">
				</figure>
				</div>
				</td>
				<td>
				<div class="slider">
				<figure>
					
					<img src="<c:url value="/resources/user/home/images/room3.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room1.png"/>" alt="">
					<img src="<c:url value="/resources/user/home/images/room2.png"/>" alt="">
				</figure>
				</div>
				</td>
			</tr>
			<tr>
			<td><a>조회수<br/>브랜치 명<br/>룸이름</a></td>
			<td><a>조회수<br/>브랜치 명<br/>룸이름</a></td>
			<td><a>조회수<br/>브랜치 명<br/>룸이름</a></td>
			</tr>
		</table>
		<p class="fmroom"><img class="line" src="<c:url value="/resources/user/home/images/line.png"/>">&emsp;♡달빛 신규 공간♡&emsp;<img class="line" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
		<table>
			<tr>
				<td><img class="roomImage" src="<c:url value="/resources/user/home/images/room1.png"/>"></td>
				<td><img class="roomImage" src="<c:url value="/resources/user/home/images/room2.png"/>"></td>
				<td><img class="roomImage" src="<c:url value="/resources/user/home/images/room3.png"/>"></td>
			</tr>
			<tr>
			<td><a>주소<br/>브랜치 명<br/>전화번호</a></td>
			<td><a>주소<br/>브랜치 명<br/>전화번호</a></td>
			<td><a>주소<br/>브랜치 명<br/>전화번호</a></td>
			</tr>
		</table>
	<p><img class="rline" src="<c:url value="/resources/user/home/images/line.png"/>">&emsp;✌달빛 최근 리뷰✌&emsp;<img class="rline" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
</div>
	<div class="review">
      <table>
      	<tr>
      	<td rowspan="5"><img class="rvroomImg" src="<c:url value="/resources/user/home/images/room1.png"/>"></td>

      	<td  class="starImg" > <img src="<c:url value="/resources/user/home/images/star.png"/>"><img src="<c:url value="/resources/user/home/images/star.png"/>"><img src="<c:url value="/resources/user/home/images/star.png"/>"></td>

      	<td rowspan="6"><img class="rvroomImg" src="<c:url value="/resources/user/home/images/room1.png"/>"></td>

      	<td  class="starImg" > <img src="<c:url value="/resources/user/home/images/star.png"/>"><img src="<c:url value="/resources/user/home/images/star.png"/>"><img src="<c:url value="/resources/user/home/images/star.png"/>"></td>
      
		</tr>
		<tr>
      	<td>지점명</td>
      	<td>지점명</td>
      	</tr>
      	<tr>
      	<td>룸이름</td>
      	<td>룸이름</td>
      	<tr>
      	<td>사용자이름</td>
      	<td>사용자이름</td>
      	</tr>
      	<tr>
      	<td>사용자 후기</td>
      	<td>사용자 후기</td>
		</tr>	
      </table>
      </div>
   </section>

  	<!-- footer -->
	<footer>
		<%@ include file="../public/footer.jsp" %>
	</footer>
	
</body>
</html>