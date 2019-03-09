<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세보기</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/admin/eventview/css/eventview.css"/>"></link>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/admin/eventview/js/eventview.js"/>"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">
<%@include file="../admin/footer.jsp" %><br><br><br>

<div class="container">
<table class="table table-bordered">
<tbody>
	<tr>
		<th>제목:</th>
		<td id="tt">${ebv.title } <input type="hidden" name="seq" value="${ebv.seq}" /></td>
		<%-- <input type="text"  placeholder="title" name="title"
                      value="${seq.title}" class="form-control" /> --%>
	</tr>
	<tr>
		<th>날짜</th>
		<td><fmt:formatDate value="${ebv.startdate }" pattern="yy-MM-dd" /> ~ <fmt:formatDate value="${ebv.enddate }" pattern="yy-MM-dd" /></td>
	</tr>
	<tr>
		<th>내용:</th>
		<td>
			${ebv.content } <p>
			<img src="<c:url value="/resources/eventimg/${ebv.seq }/${ebv.files}"/>">	
		<%-- <textarea cols="10" rows="16" placeholder="content " name="content" class="form-control">${seq.content}</textarea> --%>
		</td>
	</tr>
	<tr class="button"><td colspan="2">
		<input type="button" onclick="window.open('event.ado','_self');" value="글 목록"/>
		<input type="button" id="upbt${ ebv.seq}" onclick="upbt()" value="수정"/> 
		<input type="button" value="삭제" onclick="javascript:location.href='deleteevent.ado?seq=${seq.seq}'" />
	</td></tr>
</tbody>
</table>
</div>
</body>
</html>               
                <%-- <tr>
                  <th>이벤트시작일:</th>
                  <td><input type="date"  placeholder="startdate" name="startdate"
                     value="${seq.startdate}" class="form-control" /></td>
               </tr>
                <tr>
                  <th>이벤트종료일:</th>
                  <td><input type="date"  placeholder="enddate" name="enddate"
                  value="${seq.enddate}"
                     class="form-control" /></td>
               </tr> --%>
               
                <%-- <tr>
                  <th>이미지업로드:</th>
                  <td><input type="text"  placeholder="image" name="image"
                  value="${seq.image}"
                     class="form-control" /></td>
               </tr>
                <tr>
                  <th>파일업로드:</th>
                  <td><input type="text"  placeholder="files" name="files"
                  value="${seq.files}"
                     class="form-control" /></td>
               </tr> --%>