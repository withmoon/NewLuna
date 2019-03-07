<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/admin/event/css/event.css"/>"/>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="<c:url value="/resources/admin/event/js/event.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
<title>이벤트 페이지</title>
</head>
<%@include file="../admin/footer.jsp" %>
   </nav>
   <div align="center">
   <h1>EVENT</h1>

   </div>
   
   <br></br>
   
   <!-- 진행(종료) 이벤트버튼 -->
<section>
<div class="event-container">
	<ul class="eventTap">
		<li onclick="noticeNow()">진행중인이벤트</li>
		<li onclick="noticeFinsh()">종료된이벤트</li>
	</ul>
</div>
</section>
  
<div class="event-container">
<span id="eNow" class="title">진행중인 이벤트</span>
<a href="eventwrite.ado" id="btn" class="btn btn-primary pull-right">글쓰기</a>
<br>
<div class="row">
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
	</tr>
</thead>
<tbody id="eNow-tbody"></tbody>
</table>
<!-- 페이지목록 -->
<ul id="pageT"></ul>
</div>

<span id="eFinsh" class="title">종료된 이벤트</span><br>
<div class="row">
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
	</tr>
</thead>
<tbody id="eEnd-tbody"></tbody>
</table>
<!-- 페이지목록 -->
<ul id="pageT2"></ul>
</div>
</div>



        
        
        
        <span class="title">2월 27일 이벤트 당첨자 발표</span>
        
        
         <ul class="event-ul">
            <div class='emptyEvent'>위 게시판을 통해 확인하세요.</div>
              </ul>
           

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>

</body>
</html>