<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"  content="width=device-width, initial-scale=1.0"/>
<title>스터디카페 달빛_근처 지점 찾기</title>
<link rel="stylesheet" href="../../Public/TopMenu.css"/>
<link rel="stylesheet" href="css/FoundBranch.css"/>
</head>
<body style="overflow-x:hidden;">
<nav>
<ul class="topUl">
<li><a href="#">이벤트</a></li>
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">로그인&nbsp;/&nbsp;회원가입</a></li>
<!-- 
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">마이페이지</a></li>
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li><a href="#">로그아웃</a></li> -->
</ul>
</nav>
<a href="../Home/home.jsp"><img class="logo" src="../../Public/Logo/MainLogo.png"/></a>
<div class="top">근처 지점 찾아보기</div>

<!-- 검색어 입력 -->
<section class="searchArea">
<input id="streetName" type="text" placeholder="도로명을 입력해주세요" size="30"/>
<button>찾기</button>
</section>

<!-- 지도 및 검색결과 틀 -->
<section id="mapSec">
<!-- 지도 div -->
<div id="map" style="width:60%;height:100%;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=da37e5836c002230d358ce5af57a57ca&libraries=services"></script>
<script type="text/javascript" src="js/FoundBranch.js"></script>

<div class="resultMsg">"달빛 스터디카페" 에대한 검색결과 <b id="searchResultCount">8</b>건이 있습니다</div>
<!-- 결과값 전송받을 div -->
<div id="mapResult" style="padding:5px;z-index:1;">
<a>
<b>여기에 장소명</b><br/>
도로명도로명도로명<br/>
지번지번지번지번지번지번지번지번지번지번<br/>
번호-번호-번호<br/>
</a>
<div class="sep"></div>
<a>
<b>여기에 장소명</b><br/>
도로명도로명도로명<br/>
지번지번지번지번지번지번<br/>
번호-번호-번호<br/>
</a>
<div class="sep"></div>
<a>
<b>여기에 장소명</b><br/>
도로명도로명도로명<br/>
지번지번지번지번지번지번지번지번<br/>
번호-번호-번호<br/>
</a>
<div class="sep"></div>
</div>
</section>

<footer>
<jsp:include page="../../Public/footer.jsp"/><br/><br/><br/><br/><br/>
</footer>
</body>
</html>