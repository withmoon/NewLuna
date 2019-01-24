<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디카페 달빛</title>
<link rel="stylesheet" href="../../Public/TopMenu.css"/>
<link rel="stylesheet" href="css/event.css"/>
</head>
<body>
<nav>
<ul class="topUl">
<li><a href="#" style="text-decoration: underline;">이벤트</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="../Found/FoundBranch.jsp">지점 찾기</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="#">로그인&nbsp;/&nbsp;회원가입</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="../inform/inform.jsp">고객 센터</a></li>
<!-- 
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">마이페이지</a></li>
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">로그아웃</a></li> -->
</ul>
</nav>

<!-- 상단로고 -->
<a href="../Home/Home.jsp" title="홈으로 이동"><img class="logo" src="../../Public/Logo/MainLogo.png"/></a>
<div class="top">이벤트</div>
<section class="list_tab">
<table>
<tr>
<th>번호</th>
<th>제목</th>
<th>날짜</th>
</tr>
<tr>
<td>1</td>
<td><a href="showForm.jsp">☆5월 이벤트☆</a></td>
<td>2019-01-01</td>
</tr>

<tr>
<td>2</td>
<td><a href="showForm.jsp">☆4월 이벤트☆</a></td>
<td>2019-01-01</td>
</tr>
<tr>
<td>3</td>
<td><a href="showForm.jsp">☆3월 이벤트☆</a></td>
<td>2019-01-01</td>
</tr>
<tr>
<td>4</td>
<td><a href="showForm.jsp">☆2월 이벤트☆</a></td>
<td>2019-01-01</td>
</tr>
<tr>
<td>5</td>
<td><a href="showForm.jsp">☆1월 이벤트☆</a></td>
<td>2019-01-01</td>
</tr>
</table>
</section>
<div class="pnum"><a href="#">[이전]</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">[다음]</a></div>

<footer>
<jsp:include page="../../Public/footer.jsp"/><br/><br/><br/><br/><br/>
</footer>
</body>
</html>