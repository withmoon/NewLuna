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
<script src="<c:url value="/resources/admin/member/js/member.js"/>"></script>
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
          
           <li><a href="sales.ado">판매현황</a></li>
            <li><a href="approve.ado">지점장승인</a></li>
            <li><a href="board.ado">자주묻는질문</a></li>
            <li><a href="gongji.ado">공지사항</a></li>
            <li><a href="inquire.ado">문의게시판</a></li>
            <li><a href="event.ado">이벤트</a></li>
            <li><a href="member.ado">회원관리</a></li>
            <li><a href="info.ado">지점장 정보</a></li>
           
         </ul>

         <ul class="nav navbar-nav navbar-right">
            <li class="dropdown"><a href="#" class="dropdown-toggle"
               data-toggle="dropdown" role="button" aria-haspopup="true"
               aria-expanded="false">메뉴<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li class="active"><a href="login.jsp">로그아웃</a></li>
                 <li class="active"><a href="adminmail.ado">공지알림</a></li>
               </ul></li>
         </ul>
      </div>
   </nav>
   <div align="center">
      <h3>회원관리게시판</h3>
   </div>
   <br></br>
<div class="container">
<b style="position:relative; left:103px;">[선택된 아이디]</b>
<div class="cendmBtn"></div><button class="sendmBtn" onclick="sendEmailToMembers()"> 메일 보내기 </button>
<div class="row">

<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
<thead>
	<tr>
		<th><input type="checkbox" id="allSeq" onclick="checkAll()"/></th>
		<th>이름</th>
		<th>아이디</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>회원상태</th>
	</tr>
</thead>
<tbody id="member_table"></tbody>
</table>

<ul id="memberPaging"></ul>
</div>
</div>
<div hidden="true" class="explur">
<form name="memform" action="sendemail.ado" method="POST" onsubmit="sendEmail()" enctype="multipart/form-data">
<table>
	<thead>
		<tr>
			<th>제명 사유</th>
		</tr>
	</thead>
	
	<tr class="emailcontents" hidden="true">
	<td>
		<input id="extitle" name="title" type="text" size="80" placeholder="제목을 입력해주세요"/>
		<input hidden="true" name="id" id="ids" value=""/><input hidden="true" id="ems" name="email" value=""/>
	</td>
	</tr>
	<tr class="emailcontents" hidden="true">
	<td>
		<input id="filename" name="filename" type="file"/>
	</td>
	</tr>
	<tr>
	<td>
		<textarea id="excontent" name="content" cols="80" rows="5" placeholder="사유를 입력해주세요."></textarea>
	</td>
	</tr>
	<tr align="center" style="background-color:#eeeeee;">
	<td>
		<input type="submit" id="sendToUser" value="보내기"/>&emsp;<input type="button" onclick="cancleExplur()" value="취소">
	</td>
	</tr>
</table>
</form>

</div>

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
   </body>
</html>