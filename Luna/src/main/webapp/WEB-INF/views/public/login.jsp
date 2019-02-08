<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Log</title>
<link href="<c:url value="/resources/public/css/login.css"/>" type="text/css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
</head>

<body style="background-image: url('<c:url value="/resources/public/images/galaxy.gif"/>');">
<nav>
<ul class="topUl">
<li><a href="main.do" >메인으로 돌아가기</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="../inform/inform.jsp">고객 센터</a></li>
</ul>
</nav>

<!-- 상단로고 -->
<a href="join.do?br=off" title="회원가입"><img class="regis" src="<c:url value="/resources/public/images/regis.gif"/>"/></a>
<p class="registt">← ← 회원가입은 토끼를 클릭해주세요</p>
<a href="main.do" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">로그인</div>

	<div>
	<form name="logForm" id="logForm" action="login/loginCheck.do" method="post">
	
	<label class="ilabel"><b>ID : &nbsp;&nbsp;</b></label> 
	<input type="text" name="id" id="id" size="20" required="required">
	<label class="plabel"><b>PW: &nbsp;&nbsp;</b></label> 
	<input type="password" name="pw" id="pw" size="20" required="required"/><br/>
	<button type="submit" class="loginBtn" style="background-image: url('<c:url value="/resources/public/images/litgal.PNG"/>');">접속</button>
	&emsp;
	</form>
	
	<a id="kakao-login-btn"></a>
	<a href="http://developers.kakao.com/logout"></a>
	<script src="<c:url value="/resources/public/js/login.js"/>"></script>
	</div>
	
	<form name="kform" action="join.do?br=off" method="post">
		<input type="hidden" name="kid" value="1"/>
		<input type="hidden" name="knic" value="2"/>
	</form>
	
</body>
</html>