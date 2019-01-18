<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"  content="width=device-width, initial-scale=1.0"/>
<link rel="stylesheet"  href="css/MainPage.css"/>
<title>스터디카페 달빛</title>
<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/Main.js"></script>
</head>
<body style="overflow-x:hidden; overflow-y:hidden">
<!-- 메인에서 변경되는 이미지 -->
<section>
<img id="PartOfMain_left" class="page1" src="images/Page1.png"/>
<img id="PartOfMain_left" class="page2" src="images/Page2.png"/>
<img id="PartOfMain_left" class="page3" src="images/Page3.png"/>
<img id="PartOfMain_left" class="page4" src="images/Page4-1.png"/>
<img id="PartOfMain_left" class="page5" src="images/Page5.png"/>
<!-- 시 있는 곳 -->
<img id="PartOfMain_right" src="images/PartOfMain_right.gif"/>
</section>

<!-- 슬라이드 변경바  시간 날때 넣을거
<section id="slidebar">
		<a href="#"><img id="ns_main1" src="images/mainBar_nonSelect.png"/></a>
		<a href="#"><img id="ns_main2" src="images/mainBar_nonSelect.png"/></a>
		<a href="#"><img id="ns_main3" src="images/mainBar_nonSelect.png"/></a>
		<a href="#"><img id="ns_main4" src="images/mainBar_nonSelect.png"/></a>
		<a href="#"><img id="ns_main5" src="images/mainBar_nonSelect.png"/></a>
		 
</section>
-->

<!-- 이동 경로 -->
<section id="sec">
	<ul>
		<li><a href="../Home/home.jsp">&nbsp;홈으로&nbsp;</a></li>
		<li><a href="#">&nbsp;바로 예약&nbsp;</a></li>
		<li><a href="#">&nbsp;주변 지점 찾기&nbsp;</a></li>
	</ul>
	</section>
<!-- 이벤트  로그인/회원가입 -->
<nav> 
<jsp:include page="../TopMenu.jsp"/>
</nav>

</body>
</html>