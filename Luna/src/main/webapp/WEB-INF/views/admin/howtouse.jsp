<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet"
   href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
</head>
<%@include file="../admin/footer.jsp" %>
   <br>
   <br>
   <br>
   <div class="container">
   <h4>사용방법</h4>
      <form name="form" action=".ado" method="POST">
         <table class="table table-bordered">
            <tbody>
               <tr>
                  <th>파일:</th>
                  <td><input type="file" name="file" placeholder="file" id="file"
                     value="file" class="form-control" ></td><td><input type="button" name="add" id="add" value="추가"/>
                  </td>
               </tr>
              
              	<tr><td>
               <td colspan="2"><input type="submit" id="update" value="수정" class="btn btn-primary pull-right" /> </td>
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