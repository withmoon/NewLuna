<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/mjs.js"></script>
<script type="text/javascript" src="../js/date.js"></script>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="../css/manager2.css">

<title>지점장 관리화면</title>
</head>
<body>
	<!-- 상단바 -->
	<nav id="TopNav">
		<!-- 상단 탭 -->
		<div id="TopMenu1">
			<!-- 좌측상단 로고 -->
			<div id="letflogo">
				<img class="logo" src="../images/mainlogo2.png">
			</div>
			<jsp:include page="form/TopMenu1.jsp"></jsp:include>
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
				<jsp:include page="form/search.jsp" />
			</div>
			<aside id="left1">
				<jsp:include page="form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>관리자 초기 페이지</header>

				<div id="today">
					<div id="tmember">
						<div id="day">
							today
							<p id="date"></p>
						</div>
						<div id="su1">방문수</div>
						<div id="su2">예약수</div>
						<div id="su3">????</div>

						<div id="tsu">
							<ul>
								<li>회원 <label>몇명el태그</label></li>
								<li>예약<label>몇명el태그</label></li>
								<li>회원가입<label>몇명el태그</label></li>
								<li>방문 <label>몇명el태그</label></li>
							</ul>
						</div>
					</div>
				</div>

				<h3 id="h3">접속 통계</h3>
				<div id="statistics">
					<div id="chartdiv"></div>
				</div>

			</div>
			<!-- <div id="chart_div"></div> -->
		</section>
		<aside id="right">
			<div id="rtd">
				<div class="rdiv">최신소식</div>
				<ul id="rul">
					<li>asasdasd</li>
					<li>asdasda</li>
					<li>asfsaf</li>
					<li>asdsadas</li>
					<li>asdasdasd</li>
				</ul>
			</div>
			
			<div id="re">
				<div class="rdiv">최신댓글</div>
				<ul id="rul">
					<li>asasdasd</li>
					<li>asdasda</li>
					<li>asfsaf</li>
					<li>asdsadas</li>
					<li>asdasdasd</li>
				</ul>
			</div>
			
		</aside>
	</div>
	<footer>
		<jsp:include page="form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>