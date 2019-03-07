<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link href="<c:url value="/resources/admin/member/css/member.css"/>" type="text/css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/admin/report/css/report.css"/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/admin/report/css/board.css"/>"></link>
<script src="<c:url value="/resources/admin/report/report.js"/>"></script>
<script src="<c:url value="/resources/admin/report/reportreply.js"/>"></script>

</head>


<nav class="navbar navbar-default">
      <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed"
            data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
            aria-expanded="false">
            <span class="icon-bar"></span> <span class="icon-bar"></span> <span
               class="icon-bar"></span>
         </button>
         <div class="navbar-brand">
         <img src="<c:url value="/resources/admin/달빛.png"/>" width="100" height="100">
         </div>
         
      </div>
      <div class="collapse navbar-collapse"
         id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
          
           <li><a href="admin.ado">판매현황</a></li>
            <li><a href="approve.ado">지점장승인</a></li>
            <li><a href="board.ado">자주묻는질문</a></li>
            <li><a href="gongji.ado">공지사항</a></li>
            <li><a href="inquire.ado">문의게시판</a></li>
            <li><a href="event.ado">이벤트</a></li>
             <li><a href="reportboard.ado">보고게시판</a></li>
              <li><a href="howtouseboard.ado">이용가이드</a></li>
            <li><a href="member.ado">회원관리</a></li>
            <li><a href="admininfo.ado">관리자정보</a></li>
           
         </ul>
      <ul class="nav navbar-nav navbar-right">
            <li class="dropdown"><a href="#" class="dropdown-toggle"
               data-toggle="dropdown" role="button" aria-haspopup="true"
               aria-expanded="false">메뉴<span class="caret"></span></a>
               <ul class="dropdown-menu">
                 <li class="active"><a href="login.jsp">로그아웃</a></li>
                <li class="active"><a href="login.jsp">사용자모드</a></li>
       
               </ul></li>
         </ul>
      </div>
   </nav>
   
   
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
								<select name="searchOption" id="searchOption">
									<option value="title">제목</option>
									<option value="content">내용</option>
								</select> 
							<input name="text" id="keyword"/> 
							<input type="button" value="검색" onclick="searchReport()">
							</td>
						</tr>
					</table>
				</form>
		<button style="margin:1%; padding:3px" onclick="deleteReport()" class="btn btn-primary pull-right"> 삭제 </button>
				<br/>
				
				
				<table id="boardtable">
				<thead>
					<tr id="th1">
						<th>번호</th>
						<th class="th">지점</th>
						<th class="th">이름</th>
						<th class="th">제목</th>
						<th class="th">작성일</th>
						<th class="th">비고</th>	
					</tr>
					</thead>
					<tbody>
					</tbody>
					<tfoot>
					<tr style="border:0">
						<td  colspan="6" align="center"><ul id="pnum"></ul></td><!-- 나중에 css에서 커서 처리 --> 
					</tr>
					</tfoot>
				</table>
				</div>
			<!-- 보고쓰기 -->
			<div class="board" hidden="true">
			<form id="ajaxform" action="insertReport.do" onsubmit="changeContent()" method="post" enctype="multipart/form-data">
				<table style="background-color:lightgray; border-collapse:collapse">
				<tr>
				<td  colspan="2"  id="reportTt">제목</td>
				<td><input id="title" name="title" type="text" size="88"/></td>
				</tr>
				<tr>
				<td  colspan="2">첨부파일</td><!-- <a href="path_to_file" download="proposed_file_name">Download</a>  파일 첨부--> 
				<td  id="ftd"><input type="file"  name="ffname"  id="ffname"/></td>
				</tr>
				<tr>
				<td align="center" colspan="3">내용</td>
				</tr>
				<tr>
				<td  colspan="3" id="ctts"><textarea cols="97" id="ctt" rows="20"></textarea><input type="hidden" id="content" name="content" value=""/></td>
				</tr>
			</table>
			</form>
		</div>
		<button hidden="true" id="showlistBtn" onclick="getReportlist(1)">목록 보기</button><br/><br/>
		<!-- 댓글 -->
		<div class="reply" hidden="true">
			<table style="background-color:beige; border-collapse:collapse">
				<tr><th colspan="2">댓글 올리기</th></tr>
				<tr><td><textarea id="replytx" cols="92" rows="5" ></textarea></td><td><button id="inRpBtn" style="height:80px" onclick="insertReportReply()">올리기</button></td></tr>
			</table>
			<table style="background-color:beige; border-collapse:collapse" id="replylist">
				<thead><tr><th>댓글</th></tr></thead>
					<tbody>
				</tbody>
			</table>
		</div>
		
		</section>
   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
   </body>
</html>
