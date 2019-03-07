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
         <table class="table table-bordered">
            <tbody>
               	<tr>
                  <th>이미지</th>
                  <td>
                    <img src="<c:url value="/resources/admin/달빛.png"/>" width="100"
               			height="100">
                 </td>
                 </tr>
               <tr>
               <td colspan="2"><a href="howtouse.ado" class="btn btn-primary pull-right">수정</a></td>
               </tr>
            </tbody>
         </table>
   </div>


   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
   
</body>
</html>