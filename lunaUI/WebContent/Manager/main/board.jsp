<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../js/date.js"></script>
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/mjs.js"></script>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="../css/manager2.css">
<style type="text/css">
header {
	border-bottom: 1px solid blue;
	width: auto;
	text-align: left;
	padding-left: 10px;
	padding-top: 30px;
	font-size: 20pt;
}

#searchtable {
	width: 100%;
	min-width: 450px;
}

#boardtable {
	width: 100%;
	min-width: 450px;
}

#searchtd {
	text-align: right;
}

#write {
	float: left;
	padding: 2px 1px;
}

#board {
	margin-left: 5%;
	margin-top: 5%;
	width: 90%;
}

#boardtable, th, td {
	border: 1px solid black;
	border-spacing: 0px;
	border-collapse: collapse;
}

#boardtable tr td {
	text-align: center;
	padding: 5px 10px;
}

#boardtable tr th {
	padding: 10px 5px;
	text-align: center;
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
				<header>문의 게시판</header>
			</div>


			<div id="board">
				<form>
					<table id="searchtable">
						<tr>
							<td id="searchtd"><label id="write" onclick="#">글쓰기</label>
								<select name="searchbaord">
									<option value="TITLE">제목</option>
									<option value="WITER">작성자</option>
							</select> <input name="searchboard" type="text"> <input
								id="search" type="button" value="검색"></td>
						</tr>
					</table>
				</form>

				<table id="boardtable">
					<tr id="th1">
						<th>번호</th>
						<th class="th">제목</th>
						<th class="th">작성자</th>
						<th class="th">조회수</th>
						<th class="th">작성일</th>
					</tr>
					<!-- db에서 읽어들어와야하는 부분 -->
					<!-- 예시로 데이터 작업 -->
					<tr id="tr2">
						<td>1</td>
						<td>제목제목제목제목제목</td>
						<td>김김김</td>
						<td>5</td>
						<td>19/01/01</td>
					</tr>
					<tr>
						<td>1</td>
						<td>제목제목제목제목제목</td>
						<td>김김김</td>
						<td>5</td>
						<td>19/01/01</td>
					</tr>
					<tr>
						<td>1</td>
						<td>제목제목제목제목제목</td>
						<td>김김김</td>
						<td>5</td>
						<td>19/01/01</td>
					</tr>
					<tr>
						<td>1</td>
						<td>제목제목제목제목제목</td>
						<td>김김김</td>
						<td>5</td>
						<td>19/01/01</td>
					</tr>
				</table>
			</div>
		</section>
	</div>
	<footer>
		<jsp:include page="form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>