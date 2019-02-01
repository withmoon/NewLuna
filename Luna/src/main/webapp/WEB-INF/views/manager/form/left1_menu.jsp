<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/manager/js/left1.js"/>"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 문의게시판 , 이벤트게시판 둘다 같은 board.jsp에서  스크립트 이용해서 DB에서 각자 데이터 가져와 사용할 생각 -->
<!-- 이상태 링크가 아닌 main 화면에 각자 넣고 그 jsp화면을 연동할 생각  *현재는 테스트로 링크를 넣어둠 -->
<!-- ajax 는 로그인 부분만 사용하고 나머지는 세션/링크를 통해 넘어갈것 -->
<body>
	<div id="letf1m">
		<ul>
			<li class="menu"><a id="a" href="#"><img src="<c:url value="/resources/manager/images/menu02.png"/>"/>게시판관리</a>
				<ul class="hide">
					<li><a href="board.mdo">문의 게시판<br/>(고객의 소리, 자주묻는질문)</a></li>
					<li>이벤트 게시판</li>
					<li>공지사항</li>
					<li>자유게시판</li>
					<li>메뉴3</li>
				</ul>
			</li>

			<li class="menu"><a href="#"><img src="<c:url value="/resources/manager/images/menu02.png"/>" alt="매출통계" >매출통계</a>
				<ul class="hide">
					<li><a href="sales_reserve.mdo">월 매출</a></li>
					<li><a href="sales_market.mdo">Market 매출</a></li>
					<li>메뉴3</li>
				</ul>
			</li>
			<li class="menu"><a href="#"><img src="<c:url value="/resources/manager/images/menu01.png"/>" alt="예약시간대통계" />예약시간대통계</a>
				<ul class="hide">
					<li><a href="MgAge.mdo">연령별</a></li>
					<li><a href="MgSeason.mdo">분기별</a></li>
					<li>메뉴3</li>
				</ul>
			</li>
			<li class="menu"><a href="#"><img src="<c:url value="/resources/manager/images/menu03.png"/>" alt="방 생성/수정/삭제" />방 생성/수정/삭제</a>
				<ul class="hide">
					<li><a href="MgRoom.mdo">방관리</a></li>
				</ul>
			</li>
				<li class="menu"><a href="#"><img src="<c:url value="/resources/manager/images/menu02.png"/>" alt="현황보기" />현황보기</a>
				<ul class="hide">
					<li><a href="MgSales.mdo">매출현황</a></li>
					<li><a href="MgReserve.mdo">예약현황</a></li>
					<li><a href="MgVisit.mdo">방문현황</a></li>
					<li><a href="MgRefund.mdo">환불현황</a></li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>