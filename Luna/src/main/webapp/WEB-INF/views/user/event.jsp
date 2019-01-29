<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디카페 달빛</title>
<link href="<c:url value="/resources/user/event/css/event.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
</head>
<body>
<!-- 상단 메뉴 -->
<nav>
<ul class="topUl">
<li><a href="<c:url value="event.udo"/>" style="text-decoration: underline;">이벤트</a></li>
<li>&emsp;&nbsp;&nbsp;</li>

<li><a href="<c:url value="foundbranch.udo"/>">지점 찾기</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="<c:url value="login.do"/>">로그인&nbsp;/&nbsp;회원가입</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="<c:url value="inform.udo"/>">고객 센터</a></li>
<!-- 
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="<c:url value="myPage.udo"/>">마이페이지</a></li>
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">로그아웃</a></li> -->
</ul>
</nav>

<!-- 상단로고 -->
<a href="<c:url value="home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
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

<!-- footer -->
<footer>
<section class="sec" style="width:100%; height:1%; border-top:1px solid darkgray; margin:0 1% 1% 0;"></section>
&nbsp;Shining in the dark 
&emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;
&emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
㈜2조시스템즈/사업자등록번호 : 112 01 12321 /대표이사 대표다/서울 성동구 왕십리동 빌드빌딩 4층<br/> 
<Strong>MoonLight</Strong> StudyCafe
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
©2019. 2JOSYSTEMS Corp.
</footer>
</body>
</html>