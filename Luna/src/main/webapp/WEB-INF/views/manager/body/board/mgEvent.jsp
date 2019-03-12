<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/manager/js/manager2.js"/>"></script>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="<c:url value="/resources/user/event/js/event.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/manager/css/board.css"/>"></link>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script type="text/javascript">
	function list(page) { 
		location.href = "mgGong.mdo?curPage="+page+"&searchOption=${map.searchOption}"+"&keywrod=${map.keyword}";
	}
</script>
<style type="text/css">
th{
 border:none;
}
td{
	border:none;
}
/* c:forEach > tr:last-child */
#last{
border-top: 1px solid black;
background-color: #a0a0a0;
}
#last a{
 text-decoration:none;
 color: white;
}


/*진행(종료) 이벤트 버튼*/
.event-container {
   position: relative;
   min-width: 15%px;
   margin: auto auto;
   
}


.eventTap {
   display: flex;
   width: 80%;
   height: 45px;
   box-sizing: border-box;
   list-style: none;
   position: relative;
   left:6%;
}
.eventNow{
 border-radius: 40px;
}
.eventFinsh{
margin-left:5%;
 border-radius: 40px;
}
.eventNow2{
	width: 550px;
	margin: auto auto;
	margin-top: 5%;
	text-align: center;
}

.eventTap li {
   display: flex-block;
   width: 100%;
   border: 1px solid #e9e9eb;
   box-sizing: border-box;
   text-align: center;
   padding:1.5%;
}

.eventTap li {
   background-color: #fff;
}

.eventTap li:hover, .eventTap li.active
   {
   background-color: #c0c0c0;
}

.eventTap li:hover a, .eventTap li.active a
   {
   color: #fff;
}

/*진행(종료) 이벤트 버튼 여기까지*/

.event-container .eventTap a {
   font-size: 10px;
   line-height: 40px;
   color: #333;
   text-decoration: none;
}

/*이벤트 게시판*/
table th {
    background-color: #eeeeee;
    text-align: center;
    font-size: 10px;
}
table tr td{
	font-size: 15px;
}


.row {
    width:80%;
    position: relative;
    left: 10%;
}

.btn-primary {
    position: relative;
    left:-12%;
    top:35px;
}

/*페이지*/
/*진행이벤트 페이지*/
#pageT {
    list-style: none;
	width: 100%;
	font-size: 1.5vw;
	position:relative;
	left:45%;
}

#pageT li {float:left; 
    list-style:none; 
    margin:1px;
}
/*종료이벤트 페이지*/
#pageT2 {
    list-style: none;
	width: 100%;
	font-size: 1.5vw;
	position:relative;
	left:45%;
}

#pageT2 li {float:left; 
    list-style:none; 
    margin:1px;
}

/* .title {
   list-style: none; display : inline-block;
   width: 80%;
   font-size: 2vw;
   font-weight: 500;
   line-height: 45px;
   line-width : 50px;
   margin: 35px 0px 0px 0px;
   color: #333;
   border-bottom: 1px solid #333;
   display: inline-block;
   position: relative;
   left: 8.5%;
}
 */
/* .emptyEvent {
   position: relative;
   width: 100%;
   margin: 20px 0px;
   border: 2px dashed #e9e9eb;
   font-size: 14px;
   color: #999;
   line-height: 100px;
   text-align: center;
}
 */
/* 

.event-ul {
   list-style: none; display : flex;
   flex-wrap: wrap;
   -webkit-flex-wrap: wrap;
   width: 100%;
   margin: 0px;
   padding: 0px;
   box-sizing: border-box;
   display: flex;
}

.event-ul li.eventbox {
   display: flex-inline;
   position: relative;
   width: 253px;
   margin: 15px 20px 0px 0px;
   box-sizing: border-box;
}

.event-ul li.eventbox:nth-child(4n) {
   margin-right: 0px;
}

.event-ul li.eventbox.eventimg {
   display: inline-block;
   position: relative;
   width: 253px;
   height: 253px;
   background-repeat: no-repeat !important;
   background-position: center center !important;
   background-size: contain !important;
   box-sizing: border-box;
   border: 1px solid #e9e9eb;
   font-size: 0px;
   line-height: 0px;
}

.event-ul li.eventbox ul {
   margin: 17px 0px 5px 0px;
}

.event-ul li.eventbox ul li {
   text-align: center;
   padding: 5px 0px;
}

.event-ul li.eventbox ul:hover a {
   border-bottom: 1px solid #737373;
}

.event-ul li.eventbox ul li:nth-child(1), .event-ul li.eventbox ul li:nth-child(1) a
   {
   font-size: 13px;
   line-height: 13px;
   color: #333;
   text-decoration: none;
}

.event-ul li.eventbox ul li:nth-child(2), .event-ul li.eventbox ul li:nth-child(2) a
   {
   font-size: 13px;
   line-height: 13px;
   color: #737373;
   text-decoration: none;
} */
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
				<a href="manager.mdo"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
			</div>
			<jsp:include page="../../form/TopMenu1.jsp"></jsp:include>
		</div>
		<%-- <div id="TopMenu2">
					<jsp:include page="form/TopMenu2.jsp" />
				</div> --%>
	</nav>

	<!-- 배경 -->
	<div id="border">
		<!-- 왼측1 사이드 -->
		<div id="left1div">
			
			<aside id="left1">
				<jsp:include page="../../form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>이벤트 게시판</header>
			</div>


			<div id="board">
				<%-- <form name="form1" method="post" action="noticeList.mdo?">
					<table id="searchtable">
						<tr>
							<td id="searchtd"><!-- <a id="write" onclick=" insertboard()" href="#">글쓰기</a> -->
								<!-- 레코드의 갯수를 출력 -->
								<div id="write">${map.count}개의 게시물이 있습니다.</div>
								<select name="searchOption">
									<option value="TITLE"  <c:out  value="${map.searchOption == 'title' ? 'selected' : '' }" />>제목</option>
									<option value="id"  <c:out value="${map.searchOption == 'id'?'selected' : '' }"/> >작성자</option>
							</select> 
							<input name="keyword"  value="${map.keyword }"> 
							<input	 type="submit" value="검색">
							</td>
						</tr>
					</table>
				</form> 
	
				<br/>--%>
				<!-- 이벤트목록 -->
<section>
<div class="event-container">
	<ul class="eventTap">
		<li class="eventNow">진행중인이벤트</li>
		<li class="eventFinsh">종료된이벤트</li>
	</ul>
</div>
</section>

<section class="list_tab">
<!-- 이벤트 목록 -->
<table class="eventNow2">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
	</tr>
</thead>
	<tbody id="my-tbody"></tbody>
</table>
<!-- 페이지목록 -->
<ul id="pageT"></ul>
</section>
				
				<%-- <table id="boardtable">
					<tr id="th1">
						<th>번호</th>
						<th class="th">제목</th>
						<th class="th">내용</th>
						<th class="th">날짜</th>
					</tr>
					<!-- db에서 읽어들어와야하는 부분 -->
					<!-- 예시로 데이터 작업 -->
					<c:forEach var="list" items="${list }">
						 <tr>
							<td>${list.num }</td>			
							<td><a href="mgBoardview.mdo?seq=${list.seq}&curPage=${map.boardPager.curPage}&searchOption=${map.searchOption}&keyword=${map.keyword}" >
								${list.title}
							</td>	
							<td>${list.content }</td>
							<td><fmt:formatDate value="${list.regdate }" pattern="yyyy.MM.dd a hh:mm:ss"/></td>
						</tr>  
					</c:forEach> --%>
			<%--		 <tr>
       		  <td colspan="5" id="last">
                <!-- 처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력-->
                <c:if test="${map.boardPager.curBlock > 1}">
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
                
                <!-- 다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.boardPager.curBlock <= map.boardPager.totBlock}">
                    <a href="javascript:list('${map.boardPager.nextPage}')">[다음]</a>
                </c:if>
                
                <!-- 끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.boardPager.curPage <= map.boardPager.totPage}">
                    <a href="javascript:list('${map.boardPager.totPage}')">[끝]</a>
                </c:if>
            </td>
        </tr>
				</table> --%>
			</div>
		</section>
	</div>
	<footer>
		<jsp:include page="../../form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>