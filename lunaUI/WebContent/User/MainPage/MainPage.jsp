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

<section>
<img id="PartOfMain_left" class="page1" src="images/Page1.png"/>
<img id="PartOfMain_left" class="page2" src="images/Page2.png"/>
<img id="PartOfMain_left" class="page3" src="images/Page3.png"/>
<img id="PartOfMain_right" src="images/PartOfMain_right.gif"/>
		
	<section id="sec">
	<ul>
		<li><a href="#">&nbsp;홈으로&nbsp;</a></li>
		<li><a href="#">&nbsp;바로 예약&nbsp;</a></li>
		<li><a href="#">&nbsp;주변 지점 찾기&nbsp;</a></li>	
	</ul>
	</section>
	
</section>

<nav> 
<jsp:include page="TopMenu.jsp"/>
</nav>

</body>
</html>