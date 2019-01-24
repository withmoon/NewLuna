<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"  content="width=device-width, initial-scale=1.0"/>
<title>스터디카페 달빛_근처 지점 찾기</title>
<link rel="stylesheet" href="<c:url value="/resources/public/css/topmenu.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/user/found/css/FoundBranch.css"/>"/>
</head>
<body style="overflow-x:hidden;">
<nav>
<ul class="topUl">
<li><a href="../event/event.jsp">이벤트</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li style="text-decoration: underline;color:#836e5b;"><a href="#">지점 찾기</a></li>
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
<a href="#" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/Logo/MainLogo.png"/>"/></a>
<div class="top">근처 지점 찾아보기</div>

<!-- 검색어 입력 -->
<section class="searchArea">
<form onsubmit="searchPlaces(); return false;">
<input id="keyword" type="text" placeholder="서울" value="서울" size="30"/>
<button type="submit">찾기</button>
</form>
</section>

<!-- 지도 및 검색결과 틀 -->
<section id="mapSec">
<!-- 지도 div -->
<div id="map" style="width:60%;height:100%;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=da37e5836c002230d358ce5af57a57ca&libraries=services"></script>
<script type="text/javascript" src="<c:url value="/resources/user/found/js/founding.js"/>"></script>


<!-- 결과값 전송받을 div -->
<div id="mapResult" style="padding:5px;z-index:1;overflow-y:scroll;">
<div id="menu_wrap" class="bg_white">
<hr>
<ul id="placesList"></ul>
<div id="pagination"></div>
</div>
</div>
</section>


<footer>
<section class="sec" style="width:100%; height:1%; border-top:1px solid darkgray; margin:0 1% 1% 0;"></section>
&nbsp;Shining in the dark 
&emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;
&emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
㈜2조시스템즈/사업자등록번호 : 112 01 12321 /대표이사 대표다/서울 성동구 왕십리동 빌드빌딩 4층<br/> 
&nbsp;<b>MoonLight</b> StudyCafe
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
©2019. 2JOSYSTEMS Corp.
</footer>

 
</body>
</html>