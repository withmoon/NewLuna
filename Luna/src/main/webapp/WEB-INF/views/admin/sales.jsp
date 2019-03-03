<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<!-- Resources -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/sales.css"/>" />
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
 <script src="<c:url value="/resources/admin/js/sales.js"/>"></script>


<title>승인 페이지</title>
</head>
<body style="overflow-y:hidden;overflow-x:hidden;">
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
            <li><a href="info.ado">지점장정보/승인</a></li>
            <li><a href="board.ado">문의게시판</a></li>
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
                   <li class="active"><a href="adminmail.ado">공지알림</a></li>
               </ul></li>
         </ul>
      </div>
   </nav>
   
<table>
   <tr>
   <td>
   
    <!--  
   <aside id="left">
   <h4><strong>카테고리</strong></h4>
   <form action="search" method="post">
   <table>
  <tr>
 
  <td><input type="text" id="search" placeholder="검색어 입력"></td>
  <td><button id="img-button" type="submit" onclick="#"></button></td></tr>
    </table>
   </form>
   <ul id="u_left">
   <li><a target="page1" href="administrator.ado">홈으로 가기</a></li>
   <li><a target="page1" href="sales.ado">매출현황</a></li>
   <li><a target="page1" href="administrator.ado">지점장승인</a></li>
   <li><a target="page1" href="board.ado">자주묻는질문</a></li>
   <li><a target="page1" href="gongji.ado">공지사항</a></li>
   <li><a target="page1" href="event.ado">이벤트</a></li>
   <li><a target="page1" href="member.ado">회원관리</a></li>
   </ul>
   </aside>
   </td>
   -->
</td>
</tr>
</table>
 <h3>달빛 총 매출현황</h3> <div class="searchArea"><input id="paid_at_start" type="date"/>&emsp;-&emsp;<input id="paid_at_end" type="date"/>&emsp; <button onclick="getTermSales()">검색</button></div>
<div id="chartdiv"> </div>

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
</body>
</html>