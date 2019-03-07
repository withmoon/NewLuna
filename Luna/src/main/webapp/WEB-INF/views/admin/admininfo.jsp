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



<%@include file="../admin/footer.jsp" %>
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
  
   </body>
</html>