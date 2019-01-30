<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달빛 관리자페이지</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/administrator.css"/>" />
<style>
.type1 {
   padding: 0px;
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
.vv2 {
   position: fixed;
   top: 180px;
   right: 0px;
   width: 980px;
   height: 200px;
}
</style>
<body>
   <h1 id="bold">달빛</h1>
   <p id="bod">'공부하기 좋은 탁트인 창가'</p>
   <nav>
      <ul>
        <li><a href="administrator.ado">홈</a></li>
            <li><a href="sales.ado">판매현황</a></li>
            <li><a href="approve.ado">지점장승인</a></li>
            <li><a href="board.ado">자주묻는질문</a></li>
            <li><a href="gongji.ado">공지사항</a></li>
             <li><a href="event.ado">이벤트</a></li>
            <li><a href="member.ado">회원관리</a></li>
      </ul>
   </nav>

   <div>
      <table align="center">
         <tr>
            <td><img class="vv" src="<c:url value="/resources/admin/달빛.png"/>"></td>
         </tr>
      </table>


      <footer id="bottom">
         서울특별시 종로구 종각동 856-92<br>Copyright (c) 2018 달빛스터디카페
      </footer>
</body>
</html>