<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"  content="width=device-width, initial-scale=1.0"/>
<link rel="stylesheet"  href="css/MainPage.css"/>
<title>스터디카페 달빛</title>
<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/Main.js">
</script>
</head>
<body style="overflow-x:hidden; overflow-y:hidden">

<section id="page4">
<div class="p4_2">
설명 들어갈 곳
</div>
<div class="p4_1">
<img id="p4_im1" src="images/랭스터디카페.jpg"/><!-- 프린터기 -->
<img id="p4_im2"  src="images/스터디엔카페놑북.jpeg"/><!-- 노트북 -->
<img id="p4_im3"  src="images/스터디엔카페장치.jpeg"/><!-- 비번장치 -->
<img id="p4_im4"  src="images/포텐스터디카페안산중앙점.JPG"/><!-- 안마의자 -->
<img id="p4_im5" src="images/이제마스터디카페.jpg"/><!-- 카페 -->
<img id="p4_im6" src="images/르하임인천논현점.jpg"/><!-- 캐비넷 -->
</div>
</section>

 <section id="page3">
 <img id="p3_1" src="images/page3_1.png"/>
 <img id="p3_2" src="images/page3_2.png"/>
 <img id="p3_3" src="images/page3_3.png"/>
 </section>

<section id="page2">
<img id="p2_1" class="page2_1" src="images/finalMain2-3-1.png"/>
<img id="p2_2" class="page2_1" src="images/finalMain2-3-2.png"/>
<jsp:include page="MoveBar.jsp"/>
</section>

<section id="page1">
<img src="images/finalMain1.gif"/>
<section id="sec">
<ul><br/><br/>
<li><a href="#">&nbsp;둘러보기&nbsp;</a></li>
<li><a href="#">&nbsp;바로 예약&nbsp;</a></li>
<li><a href="#">&nbsp;지점으로 찾아보기&nbsp;</a></li>
</ul>
</section>
</section>

<nav> 
<jsp:include page="TopMenu.jsp"/>
</nav>

</body>
</html>