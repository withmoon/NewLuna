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

	function mail_0(num,email) {
	   	alert("클릭");
	   	var url = "mailForm.mdo?num="+num+"&email="+email;
		window.open(url,"mailForm.mdo","width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
	} 
	
	function mail_1(num,emailtitle,emailcontent,email) {
	   	alert("클릭");
	   	var url = "mailView.mdo?num="+num+"&emailtitle="+emailtitle+"&emailcontent="+emailcontent+"&email="+email;
		window.open(url,"mailForm.mdo","width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
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
			<div id="search">
				<jsp:include page="../../form/search.jsp" />
			</div>
			<aside id="left1">
				<jsp:include page="../../form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>보고 게시판</header>
			</div>


			<div id="board">
				<form name="form1" method="post" action="mgBoard.mdo?">
					<table id="searchtable">
						<tr>
							<td id="searchtd"><!-- <a id="write" onclick=" insertboard()" href="#">글쓰기</a> -->
								<!-- 레코드의 갯수를 출력 -->
								<div id="write"></div>
								<select name="searchOption">
									<option value="TITLE" id="searchOption">제목</option>
									<option value="id" id="keyword" >내용</option>
							</select> 
							<input name="text" id="keyword"/> 
							<input type="button" value="검색" onclick="searchReport()">
							</td>
						</tr>
					</table>
				</form>
				<button style="margin:1%; padding:3px" onclick="writeReport()">보고 올리기</button>
				<br/>
				
				
				<table id="boardtable">
					<tr id="th1">
						<th>번호</th>
						<th class="th">제목</th>
						<th class="th">작성자</th>
						<th class="th">작성일</th>
						<th class="th">답장여부</th>						
					</tr>
					<tbody>
					</tbody>
				</table>
				</div>
			<!-- 보고쓰기 -->
			<div class="board" hidden="true">
			<form id="ajaxform" action="insertReport.do" onsubmit="changeContent()" method="post" enctype="multipart/form-data">
				<input type="hidden" value="1" id="seq" name="seq"/>
				<table style="background-color:lightgray; border-collapse:collapse">
				<tr>
				<td  colspan="2"  id="reportTt">제목</td>
				<td><input id="title" name="title" type="text" size="88"/></td>
				</tr>
				<tr>
				<td  colspan="2" id="ftd">첨부파일</td><!-- <a href="path_to_file" download="proposed_file_name">Download</a>  파일 첨부--> 
				<td><input type="file"  name="ffname"  id="ffname"/></td>
				</tr>
				<tr>
				<td align="center" colspan="3">내용</td>
				</tr>
				<tr>
				<td  colspan="3"><textarea cols="97" id="ctt" rows="20"></textarea><input type="hidden" id="content" name="content" value=""/></td>
				</tr>
				<tr>
				<td  colspan="3" align="center" class="sendReportBtn"><input style="margin:1%; padding:3px" type="submit" value="올리기"/><input type="button" style="margin:1%; padding:3px" onclick="nosend()" value="취소"></td>
				</tr>
			</table>
			</form>
		</div>
		<!-- 댓글 -->
		<div class="reply" hidden="true">
			<table style="background-color:beige; border-collapse:collapse">
				<tr><th>달린 댓글</th></tr>
				<tbody>
					<tr>
						<td style="width:710px; height:auto; align:top; border-bottom:1px solid gray;">
							<b>[관리자]</b> 쓴날짜<br/>
							&emsp;>알겠다<br/>
							</td>
					</tr>
					<tr>
						<td style="width:710px; height:auto; align:top; border-bottom:1px solid gray;">
							<b>[관리자]</b> 쓴날짜<br/>
							&emsp;>알겠다<br/>
							&emsp;>알겠다
							</td>
					</tr>
					<tr>
						<td style="width:710px; height:auto; align:top; border-bottom:1px solid gray;">
							[나] 쓴날짜<br/>
							&emsp;몰겠다<br/>
							&emsp;몰겠다
							</td>
					</tr>
				</tbody>
			</table>
			<table style="background-color:beige; border-collapse:collapse">
				<tr><th colspan="2">댓글 올리기</th></tr>
				<tr><td><textarea cols="90" rows="5" ></textarea></td><td><button style="height:80px">올리기</button></td></tr>
			</table>
		</div>
		</section>
		</div>

	<footer>
		<jsp:include page="../../form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>