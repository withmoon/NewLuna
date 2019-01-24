<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달빛 스터디카페</title>
<link rel="stylesheet" href="css/inform.css"/>
<link rel="stylesheet" href="../../Public/TopMenu.css"/>
</head>
<body>

<nav>
<ul class="topUl">
<li><a href="../event/event.jsp">이벤트</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="../Found/FoundBranch.jsp">지점 찾기</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="#">로그인&nbsp;/&nbsp;회원가입</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="#" style="text-decoration: underline;">고객 센터</a></li>
<!-- 
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">마이페이지</a></li>
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">로그아웃</a></li> -->
</ul>
</nav>
<!-- 상단로고 -->
<a href="../Home/Home.jsp" title="홈으로 이동"><img class="logo" src="../../Public/Logo/MainLogo.png"/></a>
<div class="top">고객센터</div>
<!-- 고/공/자 이미지 -->
<section class="menu">
<img onmouseenter="this.src='images/공지in.png'" onmouseleave="this.src='images/공지.png'"  src="images/공지.png"/>
<img onmouseenter="this.src='images/자주묻는질문in.png'" onmouseleave="this.src='images/자주묻는질문.png'" src="images/자주묻는질문.png"/>
<img onmouseenter="this.src='images/고객in.png'" onmouseleave="this.src='images/고객.png'" src="images/고객.png"/>
</section>
<!-- 
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
<!-- 이것들은 다 예시일뿐임..(페이지 사이즈 조절용) 
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
 -->
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
<td colspan="4"><img src="images/보내기.png">&nbsp;<a href="#">보내기</a></td>
</tr>


</table>
</section>

<footer>
<jsp:include page="../../Public/footer.jsp"/><br/><br/><br/><br/><br/>
</footer>
</body>
</html>