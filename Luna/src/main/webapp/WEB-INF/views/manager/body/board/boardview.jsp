<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script> 
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<style type="text/css">
#writer {
	margin-right: 20%;
}

table, th, td {
	border: 1px solid black;
	border-spacing: 0px;
	border-collapse: collapse;
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
				<a href="manager.mdo"><img class="logo" src="<c:url value="/resources/manager/images/mainlogo2.png"/>"/></a>
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
		
		<h2>글 상세보기</h2>
	<form name="form" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text"  value="${view.title}"/></td>
			</tr>
			<tr>
				<!-- 값얻어와서 로그인한 아이디로 작성 변경불가능하게 -->
				<td>작성자</td>
				<td><input id="writer" type="text"  value="${view.writer}"/>
				<!-- 등록일date얻어와서 작성 -->
				등록일<input type="date"   value="${view.regdate}"/></td>
				
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="15" cols="60" >${view.content}</textarea></td>
			</tr>
		</table>
			<input type="submit" value="수정">
			<input type="button" value="취소">
	</form>
		</section>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>