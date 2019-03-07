<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link href="<c:url value="/resources/admin/inquire/css/inquire.css"/>" type="text/css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/admin/inquire/js/inquire.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
<title>게시판 목록</title>
</head>
<%@include file="../admin/footer.jsp" %>
   
   <div align="center">
      <h3>문의게시판</h3>
   </div>
   <br></br>
   <div class="container">
      <div class="row">
         <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
            <thead>
               <tr>
                  <th>번호</th>
                  <th>아이디</th>
                  <th>제목</th>
                  <th>지점</th>
                  <th>작성일자</th>
                  <th>비교</th>
               </tr>
            </thead>
            
            <tbody id="inquire_table"></tbody>
         </table>
         <ul id="inquirePaging"></ul>
         <a href="gongjiwrite.ado" class="btn btn-primary pull-right">글쓰기</a>
      </div>
   </div>





   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
   
   
</body>
</html>