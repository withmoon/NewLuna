<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달빛 스터디카페</title>
<link href="<c:url value="/resources/user/inform/css/inform.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
</head>
<body>

<!-- 상단 메뉴 -->
<nav>
<%@ include file="../public/topmenu.jsp" %>
</nav>

<!-- 상단로고 -->
<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">고객센터</div>
<!-- 고/공/자 이미지 -->
<section class="menu">
<a href="inform.udo?cmd=''"><img onmouseenter="this.src='<c:url value="/resources/user/inform/images/announcein.png"/>'" onmouseleave="this.src='<c:url value="/resources/user/inform/images/announce.png"/>'"  src="<c:url value='/resources/user/inform/images/announce.png'/>"/></a>
<a href="inform.udo?cmd=quest"><img onmouseenter="this.src='<c:url value="/resources/user/inform/images/questionin.png"/>'" onmouseleave="this.src='<c:url value="/resources/user/inform/images/question.png"/>'" src="<c:url value='/resources/user/inform/images/question.png'/>"/></a>
<a href="inform.udo?cmd=gokso"><img onmouseenter="this.src='<c:url value="/resources/user/inform/images/userin.png"/>'" onmouseleave="this.src='<c:url value="/resources/user/inform/images/user.png"/>'" src="<c:url value='/resources/user/inform/images/user.png'/>"/></a>
</section>

<!-- 공지 +자주묻는 질문 -->
<c:if test="${cmd ne 'gokso'}">
<section class="list_tab">
<table>
<tr>
<th>번호</th>
<th>제목</th>
<th>날짜</th>
</tr>
<tr>
<td>1</td>
<td><a href="showForm.jsp">오늘의 공지입니다아</a></td>
<td>2019-01-01</td>
</tr>
<!-- 이것들은 다 예시일뿐임..(페이지 사이즈 조절용) -->
<tr>
<td>2</td>
<td><a href="showForm.jsp">오늘의 공지입니다아</a></td>
<td>2019-01-01</td>
</tr>
<tr>
<td>3</td>
<td><a href="showForm.jsp">오늘의 공지입니다아</a></td>
<td>2019-01-01</td>
</tr>
<tr>
<td>4</td>
<td><a href="showForm.jsp">오늘의 공지입니다아</a></td>
<td>2019-01-01</td>
</tr>
<tr>
<td>5</td>
<td><a href="showForm.jsp">오늘의 공지입니다아</a></td>
<td>2019-01-01</td>
</tr>
</table>
</section>
<div class="pnum"><a href="#">[이전]</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">[다음]</a></div>
</c:if>



<!-- 고객의 소리 구간-->
<c:if test="${cmd eq 'gokso'}">
<section class="list_tab2">
<table>
<tr>
<th>이름</th>
<td><input type="text" size="30" name="name" placeholder="이름"></td>
<th>이메일</th>
<td><input type="email" size="30" name="email" placeholder="email@email.com"></td>
</tr>
<tr>
<th>전화번호</th>
<td><input type="text" size="30" name="number" placeholder="-포함 입력"></td>
<th>문의지점</th>
<td>
<select>
<option value="br0">전체
<option value="br1">지점1
<option value="br2">지점2
<option value="br3">지점3
<option value="br4">지점4
<option value="br5">지점5
</select>
</td>
</tr>
<tr>
<th>내용</th>
<td colspan="3"><textarea cols="120" rows="10"></textarea></td>
</tr>
<tr>
<th>파일업로드</th>
<td colspan="3"><input type="file" name="uploadFile"/></td>
</tr>
<tr>
<td colspan="4"><img src="<c:url value="/resources/user/inform/images/send.png"/>">&nbsp;<a href="#">보내기</a></td>
</tr>
</table>
</section>
</c:if>
</body>

<!-- footer -->
<footer>
<%@ include file="../public/footer.jsp" %>
</footer>
</html>