<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">

<style>
   .type1 {
      padding :0px;
      padding-top: 250px;
      padding-left: 620px;
      }
   /*
   .vv{
   position: fixed;
   top:180px;
   left:0px;
   width: 940px;
   height: 200px;
   }
   */
   .vv2{
   position: fixed;
   top:180px;
   right:0px;
   width: 980px;
   height: 200px;
   }
</style>
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
            <li><a href="administrator.ado">홈</a></li>
            <li><a href="sales.ado">판매현황</a></li>
            <li><a href="approve.ado">지점장승인</a></li>
            <li><a href="board.ado">자주묻는질문</a></li>
            <li><a href="gongji.ado">공지사항</a></li>
             <li><a href="event.ado">이벤트</a></li>
            <li><a href="member.ado">회원관리</a></li>
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
   <h3>지점장정보 게시판입니다</h3>
   </center>
<br></br>
   <div class="container">
      <div class="row">
         <table class="table table-striped"
            style="text-align: center; border: 1px solid #dddddd">
            <thead>
            <tr>
            <th style="background-color:#eeeeee; text-align:center;">번호</th>
            <th style="background-color:#eeeeee; text-align:center;">이름</th>
            <th style="background-color:#eeeeee; text-align:center;">아이디</th>
            <th style="background-color:#eeeeee; text-align:center;">관리</th>
            </tr>
            </thead>
            <tbody>
            <tr>
            <td>1</td>
            <td>박은별</td>
            <td>은별스타</td>
            <td><input type="button" value="삭제"></td>
            </tr>
            </tbody>
            </table>
            </div>
   
   
            <script
               src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
           <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
</body>

</html>