<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	background-color: lightblue;
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
	background-color: lightblue;
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
				<header>판매 현황</header>
			</div>
			
			<div>
		<div id="ex">
			<ul>
				<li><input type="text" class="text" placeholder="DATE를 입력하세요.">
				</li>
				<li id="exb"><input type="button" value="조회"></li>
				<li><a href="excelDownload.mdo">엑셀 내려받기</a></li>
			</ul>
		</div>

		<!-- db데이터 -->
		<table id="t">
			<tr id="ttr1">
				<th>DATE</th>
				<th>인원</th>
				<th>예약건수</th>
				<th>TOTAL</th>
				<th>MARKET</th>
				<th>TOTAL</th>
				<th>총매출</th>
			</tr>
			<c:forEach var="sales" items="${list}">
				<tr>
					<th><fmt:formatDate value="${sales.date}" pattern="yyyy-MM-dd"/> </th>
					<th>${sales.inone}</th>
					<th>${sales.su}</th>
					<th>${sales.sales1}</th>
					<th>${sales.market}</th>
					<th>${sales.sales2}</th>
					<th>${sales.total}</th>
				</tr>
			</c:forEach>
		</table>
	</div>

			
		</section>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>