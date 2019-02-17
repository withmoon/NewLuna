<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<style type="text/css">
#ex {
	background-color: lightgreen;
	height: 30px;
}

#ex ul {
	padding-top: 3px;
	list-style: circle;
}

#ex ul li {
	display: inline;
	padding-left: 20px;
}

#exb {
	float: center;
}

#t {
	height: 100%;
	border-color: gray;
}

#t {
	margin-top: 20px;
	width: 100%;
	border-bottom-color: black;
}

#t tr td {
	text-align: center;
}

#ttr1 {
	background-color: lightgreen;
}
</style>
<title>지점장 관리화면</title>
</head>
<body>
	<!-- 상단바 -->
	<nav id="TopNav">
		<!-- 상단 탭 -->
		<div id="TopMenu1">
			<!-- 좌측상단 로고 -->
			<div id="letflogo">
				<a href="manager.mdo"><img class="logo"
					src="<c:url value="/resources/manager/images/mainlogo2.png"/>" /></a>
			</div>
			<jsp:include page="/WEB-INF/views/manager/form/TopMenu1.jsp"></jsp:include>
		</div>
		<%-- <div id="TopMenu2">
					<jsp:include page="form/TopMenu2.jsp" />
				</div> --%>
	</nav>

	<!-- 배경 -->
	<div id="border">
		<!-- 왼측1 사이드 -->
		<div id="left1div">
			<div id="search">
				<jsp:include page="/WEB-INF/views/manager/form/search.jsp" />
			</div>
			<aside id="left1">
				<jsp:include page="/WEB-INF/views/manager/form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>환불 현황</header>
			</div>
			<div>
				<div id="ex">
					<ul>
						<li><input type="text" class="text"
							placeholder="ID or 연락처를 입력하세요"></li>
						<li id="exb"><input type="button" value="조회"></li>
					</ul>
				</div>

				<!-- db데이터 -->
				<table id="t">
					<tr id="ttr1">
						<th>No.</th>
						<th>ID</th>
						<th>AGE</th>
						<th>결제일</th>
						<th>인원</th>
						<th>예약일</th>
						<th>승인</th>
					</tr>
					<tr>
						<td>1</td>
						<td>GD</td>
						<td>20대</td>
						<td>19/01/01</td>
						<td>3인</td>
						<td>19/01/07 AM 9:00-10:00</td>
						<td>환불완료</td>
					</tr>
					<tr>
						<td>2</td>
						<td>TOP</td>
						<td>20대</td>
						<td>19/01/02</td>
						<td>3인</td>
						<td>19/01/07 AM 9:00-10:00</td>
						<td>처리중</td>
					</tr>
					<tr>
						<td>3</td>
						<td>TAEYANG</td>
						<td>20대</td>
						<td>19/01/03</td>
						<td>2인</td>
						<td>19/01/07 AM 9:00-10:00</td>
						<td>처리중</td>
					</tr>
					<tr>
						<td>4</td>
						<td>J</td>
						<td>20대</td>
						<td>19/01/03</td>
						<td>1인</td>
						<td>19/01/07 AM 9:00-10:00</td>
						<td>환불신청</td>
						<td><button type="button">환불</button></td>
					</tr>
					<tr>
						<td>5</td>
						<td>X</td>
						<td>20대</td>
						<td>19/01/03</td>
						<td>1인</td>
						<td>19/01/07 AM 9:00-10:00</td>
						<td>환불신청</td>
						<td><button type="button">환불</button></td>
					</tr>
				</table>
			</div>
		</section>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>