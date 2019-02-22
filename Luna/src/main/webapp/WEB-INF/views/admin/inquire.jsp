<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<title>승인 페이지</title>
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
            <img src="<c:url value="/resources/admin/달빛.png"/>" width="100" height="100">
         </div>
      </div>
      <div class="collapse navbar-collapse"
         id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
            <li><a href="administrator.ado">홈</a></li>
            <li><a href="sales.ado">판매현황</a></li>
            <li><a href="approve.ado">지점장승인</a></li>
            <li><a href="board.ado">자주묻는질문</a></li>
            <li><a href="gongji.ado">공지사항</a></li>
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
               </ul></li>
         </ul>
      </div>
   </nav>
   <center>
      <h3>공지사항</h3>
   </center>
   <br></br>
   <div class="container">
      <div class="row">
         <table class="table table-striped"
            style="text-align: center; border: 1px solid #dddddd">
            <thead>
            <tr>
            <th style="background-color:#eeeeee; text-align:center;">seq</th>
            <th style="background-color:#eeeeee; text-align:center;">id</th>
            <th style="background-color:#eeeeee; text-align:center;">branchname</th>
            <th style="background-color:#eeeeee; text-align:center;">content</th>
            <th style="background-color:#eeeeee; text-align:center;">fileupload</th>
            <th style="background-color:#eeeeee; text-align:center;">response</th>
            </tr>
            </thead>
            <tbody>
            <tr>
            <td>1</td>
            <td>id</td>
            <td>본점</td>
            <td>내용</td>
            <td>파일업로드</td>
            <td>답변</td>
            </tr>
            </tbody>
            </table>
      
   </div>





   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
</body>
</html>