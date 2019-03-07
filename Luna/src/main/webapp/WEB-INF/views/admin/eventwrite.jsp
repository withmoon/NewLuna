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

</body>
</html>