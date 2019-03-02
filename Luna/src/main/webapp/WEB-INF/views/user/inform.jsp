<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width" />
<title>달빛 스터디카페</title>
<link href="<c:url value="/resources/user/inform/css/inform.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/user/inform/js/inform.js"/>"></script>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">


<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<!-- 상단로고 -->
<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">고객센터</div>
<!-- 고/공/자 이미지 -->
<section class="menu">
<a class="informNotice">
	<img onmouseenter="this.src='<c:url value="/resources/user/inform/images/announcein.png"/>'" onmouseleave="this.src='<c:url value="/resources/user/inform/images/announce.png"/>'"  src="<c:url value='/resources/user/inform/images/announce.png'/>"/>
</a> <!-- 공지사항 -->
<a class="informQnA">
	<img onmouseenter="this.src='<c:url value="/resources/user/inform/images/questionin.png"/>'" onmouseleave="this.src='<c:url value="/resources/user/inform/images/question.png"/>'" src="<c:url value='/resources/user/inform/images/question.png'/>"/>
</a> <!-- 자주묻는질문 -->
<a class="informUser">
	<img onmouseenter="this.src='<c:url value="/resources/user/inform/images/userin.png"/>'" onmouseleave="this.src='<c:url value="/resources/user/inform/images/user.png"/>'" src="<c:url value='/resources/user/inform/images/user.png'/>"/>
</a> <!-- 고객의 소리 -->
</section>

<!-- 공지 +자주묻는 질문 -->
<section class="list_tab">
<table class="inform_list">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>날짜</th>
	</tr>
</thead>
<tbody id="inform_table">
<c:forEach items="${noticeList }" var="notice">
	<tr>
		<td>${notice.num }</td>
		<td><a onclick="window.open('viewNotice.udo?num=${notice.num}','_self');">
			${notice.title }</a></td>
		<td><fmt:formatDate value="${notice.regdate }" pattern="yy-MM-dd"/></td>
	</tr>
</c:forEach>
</tbody>
</table>
<!-- 페이지 처리 -->
<table class="tbl paginated" id="tbl">
<tbody id="inform_page">
	<tr>
		<td>
			 <!-- 처음페이지로 이동 : 현재페이지 블럭이 1보다크면 -->
			<c:if test="${boardPager.curBlock > 1}">
				<a href="javascript:noticeList('1')">[처음]</a>
			</c:if>
			<!-- 이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
			<c:if test="${boardPager.curBlock > 1}">
				<a href="javascript:noticeList('${boardPager.prevPage}')">[이전]</a>
			</c:if>
			<!-- 페이지 블럭 처음부터 마지막 블럭까지 1씩 증가하는 페이지 출력 -->
			<c:forEach var="num" begin="${boardPager.blockBegin}" end="${boardPager.blockEnd}">
				<!-- 현재페이지이면 하이퍼링크 제거 -->
				<c:choose>
					<c:when test="${num == boardPager.curPage}">${num}&nbsp;</c:when>
					<c:otherwise>
						<a href="javascript:noticeList('${num}')">${num}</a>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 다음페이지 블록으로 이동 -->
			<c:if test="${boardPager.curBlock <= boardPager.totBlock}">
				<a href="javascript:noticeList('${boardPager.nextPage}')">[다음]</a>
			</c:if>
			<!-- 끝페이지로 이동 -->
			<c:if test="${boardPager.curBlock <= boardPager.totPage}">
				<a href="javascript:noticeList(' ${boardPager.totPage}')">[끝]</a>
			</c:if>
		</td>
	</tr>
</tbody>
</table>
</section>


<!-- 고객의 소리 구간-->
<section class="list_tab2">
<div class="inform_user">
	<div><label>문의지점</label><b></b>
		<%-- <input type="hidden" id="email" name="email" value="${emailList.email}"> --%>
		<!-- <div id="email"></div> -->
		<!-- 시/도 -->
		<select name="sido" id="sido_select">
			<option selected="selected" disabled="disabled" hidden="true">시/도 선택</option>
		<c:forEach  var="sidoList" items="${sido}">
			<option value="${sidoList}">${sidoList}</option>
		</c:forEach>
		</select>&emsp;
		<!-- 시/군/구 -->
		<select name="gugun"></select>&emsp;
		<!-- 문의지점 -->
		<select id="branch" name="branch"></select>
	</div>
	<div><label>제목</label>
		<input type="text" id="title" name="title" placeholder="제목을 입력해주세요"/>
	</div>
	<div><label>내용</label>
		<textarea cols="120" id="content" rows="10" placeholder="내용을 입력해주세요"></textarea>
	</div>
	<!-- 첨부파일 등록영역 -->
	<!-- <div class="fileDrop"></div> -->
	<!-- 첨부팡리의 목록 출력영역 -->
	<!-- <div id="uploadedList"></div>
	<div><label>파일업로드</label>&emsp;&emsp;&emsp;&emsp;
		<input type="file" name="uploadFile"/>
	</div> -->
	<div class="informbox2">
		<img src="<c:url value="/resources/user/inform/images/send.png"/>">&nbsp;<button onclick='userCommand()'>보내기</button>
	</div>
</div> 
</section>

<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</body>
</html>