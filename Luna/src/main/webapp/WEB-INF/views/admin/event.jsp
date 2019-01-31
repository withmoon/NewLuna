<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/event.css"/>" />
<title>이벤트 페이지</title>
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
            <li><a href="member.ado">지점장 정보</a></li>
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
   <table>
   <tr>
   <td>
      <h1>EVENT</h1>
      </tr></td>
      </table>
   </center>
   <br></br>
  
    <div class="event-container">

        <ul class="top-navigate">
            <li>이벤트</li>
        </ul>
        <ul class="eventTap">
            <li><a href="event.ado">전체이벤트</a></li>
            <li><a href="event.ado">진행중인이벤트</a></li>
            <li><a href="event.ado">종료된이벤트</a></li>
        </ul>
        <span class="title">진행중인 이벤트</span>
        <ul class="event-ul">
            <div class='emptyEvent'>진행중인 이벤트가 없습니다.</div>
        </ul>
        <span class="title">종료된 이벤트</span>
        
        <li class="eventbox">
            <a href="event.ado" class='eventimg' style="background:url('/storage/event/75251273_event_6195.png');"></a>
            <ul>
                <li><a href="event.ado" >잇츠 달빛 타임! 이벤트 당첨자 발표</a></li>
                <li><a href="event.ado" >중고교재 70%할인 이벤트</a></li>
            </ul>





   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
</body>
</html>