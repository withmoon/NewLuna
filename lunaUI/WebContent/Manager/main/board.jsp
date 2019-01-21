<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
header {
	border-bottom: 1px solid blue;
	width: auto;
	text-align: left;
	padding-left: 10px;
	padding-top: 30px;
	font-size: 20pt;
}
#board {
	margin-left: 20%;
	margin-top: 5%;
}

table, th, td {
	border: 1px solid black;
	border-spacing: 0px;
	border-collapse: collapse;
}

th {
	padding: 10px 5px;
	text-align: center;
	
}

td {
	text-align: center;
	padding: 5px 10px;
}

#boardsearch {
	margin-top: 10px;
	margin-left: 20% 


</style>
<link type="text/css" rel="stylesheet" href="../css/manager1.css">
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/mjs.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="back">
		<!-- 배경 -->
		<div id="border">
			<!-- 틀 -->
			<!-- 상단바 -->
			<nav id="TopNav">
				<!-- 좌측상단 로고 -->
				<div id="letflogo">
					<img class="logo" src="../images/mainlogo2.png">
				</div>

				<!-- 상단 탭 -->
				<div id="TopMenu1"> 
					<jsp:include page="form/TopMenu1.jsp"></jsp:include>
				</div>
				<div id="TopMenu2">
					<jsp:include page="form/TopMenu2.jsp" />
				</div>

			</nav>

			<!-- 중앙 -->
			<div id="center">
				<!-- 왼측1 사이드 -->
				<aside id="left1">
					<jsp:include page="form/left1_menu.jsp"></jsp:include>
				</aside>
				<!-- 왼측2 사이드 -->
				<aside id="left2">
					<div id="letf2div">
						<jsp:include page="form/search.jsp" />
					</div>
					<div id="submenu">
						<jsp:include page="form/submenu.jsp" />
					</div>
				</aside>
				<!-- 중앙세션 -->
				<section id="msec">
					<div id=header>
						<header>문의 게시판</header>
					</div>

					<div id="board">
						<table>
							<tr class="tr1">
								<th>번호</th>
								<th class="th">제목</th>
								<th class="th">작성자</th>
								<th class="th">조회수</th>
								<th class="th">작성일</th>
							</tr>
							<!-- db에서 읽어들어와야하는 부분 -->
							<!-- 예시로 데이터 작업 -->
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
							<tr>
								<td>1</td>
								<td>제목제목제목제목제목</td>
								<td>김김김</td>
								<td>5</td>
								<td>19/01/01</td>
							</tr>
						</table>

						<div id="boardsearch">
							<label for="boardsearch">검색 :</label> &nbsp; <input id="search"
								name="boardsearch" type="text">&nbsp;
							<button type="button">찾기</button>
						</div>
					</div>

				</section>
			</div>


			<div>
				<footer id="footer">
					<jsp:include page="form/footer.jsp"></jsp:include>
				</footer>
			</div>
		</div>

	</div>


</body>
</html>