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
   <div align="center">
      <h3>회원관리게시판</h3>
   </div>
   <br></br>
<div class="container">
<div class="row">
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
<thead>
	<tr>
		<th>체크박스</th>
		<th>아이디</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>날짜</th>
		<th>삭제</th>
	</tr>
</thead>
<tbody id="">
<td><input type="checkbox" name="check"/></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td><input type="button" value="삭제"></td>

</tbody>
</table>
<ul id="memberPaging"></ul>
</div>
</div>

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
   <jsp:include page="../admin/footer.jsp"></jsp:include>
   </body>
</html>