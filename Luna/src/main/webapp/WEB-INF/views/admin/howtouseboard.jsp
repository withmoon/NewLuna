<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<title>게시판 목록</title>

</head>
<%@include file="../admin/footer.jsp" %>
   <center>
      <h3>이용가이드</h3>
   </center>
   <br></br>
   <div class="container">
      <div class="row">
      <form action=".ado" method="post">
         <table class="table table-striped"
            style="text-align: center; border: 1px solid #dddddd">
            <tbody>
            
             <tr>
              <td><a href="howtouseview.ado">회원가입방법</a></td>
             </tr>

			  <tr>
              <td><a href="howtouseview.ado">예약방법</a></td>
             </tr>
             
              <tr>
              <td><a href="howtouseview.ado">방법</a></td>
             </tr>
             
             
              <tr>
              <td><a href="howtouseview.ado">방법론</a></td>
             </tr>             
            </tbody>
         </table>
         </form>
      </div>
   </div>





   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
   
   
</body>
</html>