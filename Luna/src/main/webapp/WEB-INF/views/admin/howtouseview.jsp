<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet"
   href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
</head>
<body>
   <nav class="navbar navbar-default">
      <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed"
            data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
            aria-expanded="false">
            <span class="icon-bar"></span> <span class="icon-bar"></span> <span
               class="icon-bar"></span>
         </button>
         <div class="navbar-brand">
            <img src="<c:url value="/resources/admin/달빛.png"/>" width="100"
               height="100">
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
   <br>
   <br>
   <br>
   <div class="container">
   <h4>사용방법</h4>
         <table class="table table-bordered">
            <tbody>
               	<tr>
                  <th>이미지</th>
                  <td>
                    <img src="<c:url value="/resources/admin/달빛.png"/>" width="100"
               			height="100">
                 </td>
                 </tr>
               <tr>
               <td colspan="2"><a href="howtouse.ado" class="btn btn-primary pull-right">수정</a></td>
               </tr>
            </tbody>
         </table>
   </div>


   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
   <jsp:include page="../admin/footer.jsp"></jsp:include>
</body>
</html>