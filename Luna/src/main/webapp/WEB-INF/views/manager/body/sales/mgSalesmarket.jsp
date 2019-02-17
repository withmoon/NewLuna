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
	background-color: yellow;
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
	float: right;
	margin-right: 5%;
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
	background-color: yellow;
}

/*
table {
  border-collapse: separate;
  border-spacing: 0 10px;
}*/
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
				<header>문의 게시판</header>
			</div>
			<div>
				<div id="ex">
					<ul>
						<li>검색창 : <select name="select">
								<option value="name">이름</option>
								<option value="tel">전화번호</option>
						</select>
						</li>
						<li>날짜 : <input type="date">
						</li>
						<li id="exb"><input type="button" value="검색"></li>
					</ul>
				</div>

				<!-- db데이터 -->
				<table id="t">
					<tr id="ttr1">
						<th>MARKET</th>
						<th colspan="3">음식판매</th>
						<th>합계</th>
					</tr>
					<tr>
						<td>음료</td>
						<td>식혜</td>
						<td>바나나쉐이크</td>
						<td>딸기스무디</td>
						<td>21000</td>
					</tr>
					<tr>
						<td>커피</td>
						<td>카라멜마끼아또</td>
						<td>카푸치노</td>
						<td>아메리카노</td>
						<td>24000</td>
					</tr>
					<tr>
						<td>빵</td>
						<td>초코범벅</td>
						<td>찐빵</td>
						<td>카스테라</td>
						<td>23000</td>
					</tr>
					<tr>

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