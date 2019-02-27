<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세보기</title>
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet"
   href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
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
            <img src="<c:url value="/resources/admin/달빛.png"/>" width="100"
               height="100">
         </div>
      </div>
      <div class="collapse navbar-collapse"
         id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
          
            <li><a href="sales.ado">판매현황</a></li>
            <li><a href="info.ado">지점장승인</a></li>
            <li><a href="board.ado">자주묻는질문</a></li>
            <li><a href="gongji.ado">공지사항</a></li>
            <li><a href="admininquiry.ado">문의게시판</a></li>
            <li><a href="event.ado">이벤트</a></li>
            <li><a href="member.ado">회원관리</a></li>
         
         </ul>

         <ul class="nav navbar-nav navbar-right">
            <li class="dropdown"><a href="#" class="dropdown-toggle"
               data-toggle="dropdown" role="button" aria-haspopup="true"
               aria-expanded="false">메뉴<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li class="active"><a href="login.jsp">로그아웃</a></li>
                 <li class="active"><a href="adminmail.ado">공지알림</a></li>
               </ul></li>
         </ul>
      </div>
   </nav>
   <br>
   <br>
   <br>
   <div class="container">
   <form name="form2" action="updateevent.ado" method="post">
      <table class="table table-bordered">
       
         <tbody>
 
               <tr>
                  <th>제목:</th>
                  <td><input type="text"  placeholder="title" name="title"
                      value="${seq.title}" class="form-control" />
                     <input type="hidden" name="seq" value="${seq.seq}" /></td>
               </tr>
               
               <tr>
                  <th>내용:</th>
                  <td><textarea cols="10" rows="16" placeholder="content " name="content"
                        class="form-control">${seq.content}</textarea></td>
               </tr>
               
                <tr>
                  <th>이벤트시작일:</th>
                  <td><input type="date"  placeholder="startdate" name="startdate"
                     value="${seq.startdate}" class="form-control" /></td>
               </tr>
                <tr>
                  <th>이벤트종료일:</th>
                  <td><input type="date"  placeholder="enddate" name="enddate"
                  value="${seq.enddate}"
                     class="form-control" /></td>
               </tr>
                <tr>
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
               </tr>
                
                <tr>
               <td colspan="2"><input type="submit" id="update" value="수정" class="btn btn-primary pull-right" /> 
                <input type="button" value="삭제"
                     class="btn btn-primary pull-right" onclick="javascript:location.href='deleteevent.ado?seq=${seq.seq}'" /></td>
               </tr>
               
            
            </form>
         </tbody>
      </table>
   </div>


   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
</body>
</html>