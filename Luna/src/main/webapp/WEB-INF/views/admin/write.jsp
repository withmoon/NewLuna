<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet"
   href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
</head>

<%@include file="../admin/footer.jsp" %>
   <br>
   <br>
   <br>

   <div class="container">
   <form id="form1" name="form1" action="insert.ado" method="post">
      <table class="table table-bordered">
         <h4>글쓰기</h4>
         <tbody>
               <tr>
                  <th>제목:</th>
                  <td><input type="text" placeholder="subject" id="subject" name="subject"
                     class="form-control" /></td>
               </tr>

               <tr>
                  <th>내용:</th>
                  <td><textarea cols="10" placeholder="content " id="content" name="content"
                        class="form-control"></textarea></td>
               </tr>
               <tr>
               
                  <th>작성일:</th>
                  <td><input type="date" placeholder="date" id="regdate" name="regdate"
                     class="form-control" /></td>
               </tr>
               <tr>
                  <td colspan="2"><input type="submit" id="btnSave" value="등록" class="pull-right" /> 
                  <input type="button" value="글 목록"
                     class="pull-right" onclick="javascript:location.href='board.ado'" />
                  </td>
               </tr>
            
         </tbody>
      </table>
      </form>
   </div>

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
  
</body>
</html>