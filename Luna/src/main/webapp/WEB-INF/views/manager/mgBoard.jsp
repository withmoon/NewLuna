<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script> 
<script type="text/javascript" src="<c:url value="/resources/manager/js/board.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/manager/js/manager2.js"/>"></script>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/board.css"/>"></link>
<script type="text/javascript">
	function list(page) {
		location.href = "mgBoard.mdo?curPage="+page+"&searchOption=${map.searchOption}"+"&keywrod=${map.keyword}";
	}
</script>
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
				<form name="form1" method="post" action="mgBoard.mdo?">
					<table id="searchtable">
						<tr>
							<td id="searchtd"><a id="write" onclick=" insertboard()" href="#">글쓰기</a>
								<select name="searchOption">
									<option value="TITLE"  <c:out  value="${map.searchOption == 'title' ? 'selected' : '' }" />>제목</option>
									<option value="WRITER"  <c:out value="${map.searchOption == 'writer'?'selected' : '' }"/> >작성자</option>
							</select> 
							<input name="keyword"  value="${map.keyword }"> 
							<input	 type="submit" value="검색">
							</td>
						</tr>
					</table>
				</form>

				<!-- 레코드의 갯수를 출력 -->
				${map.count }개의 게시물이 있습니다.
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
					<c:forEach var="list" items="${map.list }">
						<tr>
							<td>${list.num }</td>			
							<td><a href="mgBoardview.mdo?num=${list.num}&curPage=${map.boardPager.curPage}&searchOption=${map.searchOption}&keyword=${map.keyword}" >${list.title}</a></td>	
							<td>${list.writer }</td>
							<td>${list.ref }</td>
							<td><fmt:formatDate value="${list.regdate}" pattern="yyyy.MM.dd"/></td>
							
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5">
							<c:if test="${map.boardPager.curBlock>1}"> <!-- 처음페이지로 이동 : 현재페이직 1보다크면 -->
								<a href="javascript:list('1')">[처음]</a>
							</c:if>
						<!-- 이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
							<c:if test="${map.boardPager.curBlock > 1}">
								<a href="javascript:list('${map.boardPager.prevPage}')">[이전]</a>
							</c:if>
							
						<!-- **하나의 블럭 시작페이지부터 끝페이지까지 반복문 실행 -->
				<c:forEach var="num" begin="${map.boardPager.blockBegin}" end="${map.boardPager.blockEnd}">
					<!-- 현재페이지이면 하이퍼링크 제거 -->
					<c:choose>
						<c:when test="${num == map.boardPager.curPage}">
							<span style="color: red">${num}</span>&nbsp;
						</c:when>
						<c:otherwise>
							<a href="javascript:list('${num}')">${num}</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
							
							<!-- 다음페이지 블록으로 이동 -->
							<c:if test="${map.boardPager.curBlock <= map.boardPager.totBlock}">
								<a href="javascript:list('${map.boardPager.nextPage}')">[다음]</a>
							</c:if>
							<!-- 끝페이지로 이동 -->
							<c:if test="${map.boardPager.curBlock <= map.boardPager.totPage}">
								<a href="javascript:list(' ${map.boardPager.totPage}')">[끝]</a>
							</c:if>
						</td>
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