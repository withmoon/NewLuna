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
            
           <li><a href="admin.ado">판매현황</a></li>
            <li><a href="approve.ado">지점장승인</a></li>
            <li><a href="board.ado">자주묻는질문</a></li>
            <li><a href="gongji.ado">공지사항</a></li>
            <li><a href="inquire.ado">문의게시판</a></li>
            <li><a href="event.ado">이벤트</a></li>
             <li><a href="reportboard.ado">보고게시판</a></li>
              <li><a href="howtouseboard.ado">이용가이드</a></li>
            <li><a href="member.ado">회원관리</a></li>
         
         </ul>

         <ul class="nav navbar-nav navbar-right">
            <li class="dropdown"><a href="#" class="dropdown-toggle"
               data-toggle="dropdown" role="button" aria-haspopup="true"
               aria-expanded="false">메뉴<span class="caret"></span></a>
               <ul class="dropdown-menu">
                 <li class="active"><a href="login.jsp">로그아웃</a></li>
                <li class="active"><a href="login.jsp">사용자모드</a></li>
               </ul></li>
         </ul>
      </div>
   </nav>
   <br><br><br>

   <div class="container">
   <form id="form1" name="form1" action="insert1.ado" method="post" >
      <table class="table table-bordered">
         <thead>
         <caption>글쓰기</caption>
         </thead>
         <tbody>
             
               <tr>
                  <th>제목:</th>
                  <td><input type="text"  placeholder="title" name="title"
                     class="form-control" /></td>
               </tr>
               
               <tr>
                  <th>내용:</th>
                  <td><textarea cols="10" rows="16" placeholder="content " name="content"
                        class="form-control"></textarea></td>
               </tr>
               <tr>
                  <th>작성자:</th>
                  <td><input type="text" placeholder="writer" name="writer"
                     class="form-control" /></td>
               </tr>
                <tr>
                  <th>이벤트시작일:</th>
                  <td><input type="date"  placeholder="startdate" name="startdate"
                     class="form-control" /></td>
               </tr>
                <tr>
                  <th>이벤트종료일:</th>
                  <td><input type="date"  placeholder="enddate" name="enddate"
                     class="form-control" /></td>
               </tr>
                <tr>
                  <th>이미지업로드:</th>
                  <td> <input type="file" name="image" id="image" 
                     class="form-control"  /></td>
                     <div id="holder"></div>
               </tr>

               
 <script>
var upload = document.getElementsByTagName('input')[0],
holder = document.getElementById('holder'),
    state = document.getElementById('image');

if (typeof window.FileReader === 'undefined') {
  state.className = 'fail';
} else {
  state.className = 'success';
  state.innerHTML = 'File API & FileReader available';
}
 
upload.onchange = function (e) {
  e.preventDefault();

  var file = upload.files[0],
      reader = new FileReader();
  reader.onload = function (event) {
    var img = new Image();
    img.src = event.target.result;
    // note: no onload required since we've got the dataurl...I think! :)
    if (img.width > 560) { // holder width
      img.width = 560;
    }
    holder.innerHTML = '';
    holder.appendChild(img);
  };
  reader.readAsDataURL(file);

  return false;
};

</script>
                <tr>
                  <th>파일업로드:</th>
                  <td><input type="file"  placeholder="files" name="files"
                     class="form-control" /></td>
               </tr>
                
               
               
               
                <tr>
                  <td colspan="2"><input type="submit" id="btnSave" value="등록" class="pull-right" /> 
                  <input type="button" value="글 목록"
                     class="pull-right" onclick="javascript:location.href='event.ado'" />

                     
                  </td>
               </tr>
               
            
            </form>
         </tbody>
      </table>
   </div>

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
   <jsp:include page="../admin/footer.jsp"></jsp:include>
</body>
</html>