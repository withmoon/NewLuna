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
				<header>방 생성</header>
			</div>
			<div>
			
			<form id="form1" method="post"  action="mgRoom.mdo?">
				<div id="ex">
					<ul>
						<li>
							검색창 : <select name="searchOption">
								<option value="all"  <c:out value="${list.searchOption=='all' ? 'selected' : '' }" />>전체</option>
								<option value="roomName"  <c:out value="${list.searchOption=='roomName' ? 'selected' : '' }" />>방/지점 이름</option>
								<option value="roomnum"  <c:out value="${list.searchOption=='roomnum' ? 'selected' : '' }" />>방 번호</option>
							</select>
						</li>
						<li>검색 : <input type="text" name="keyword">
						</li>
						<li id="exb"><input type="button" value="방생성" 	onclick="location.href='RoomUpload.mdo'"></li>
						<li id="exb"><input type="submit" value="검색"></li>
					</ul>
				</div>
			</form>

				<!-- db데이터 -->
				<table id="t">
					<tr id="ttr1">
						<th>ROOM.NO</th>
						<th>지점명</th>
						<th>방이름</th>
						<th>주소</th>
						<th>가격</th>
					</tr>
					<c:forEach items="${map.list}" var="list">
						<tr>
							<td>${list.roomnum}</td>
							<td><a href="mgRoomView.mdo?roomnum=${list.roomnum}">${list.branchName}</a></td>
							<td>${list.roomName }  </td>
							<td>${list.roomLocate}</td>
							<td>${list.roomPrice}</td>
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