<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Log</title>
<link href="<c:url value="/resources/public/css/login.css"/>" type="text/css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/public/css/topmenu.css"/>"/>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>

<body style="background-image: url('<c:url value="/resources/public/images/galaxy.gif"/>');">
<nav>
<ul class="topUl">
<li><a href="main.do">메인으로 돌아가기</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="#">이벤트</a></li>
<li>&emsp;&nbsp;&nbsp;</li>
<li><a href="foundbranch.udo">지점 찾기</a></li>
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
<a href="#" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
<div class="top">로그인</div>

	<div>
	
	<label class="ilabel"><b>ID : &nbsp;&nbsp;</b></label> 
	<input type="text" name="id" size="20">
	<label class="plabel"><b>PW: &nbsp;&nbsp;</b></label> 
	<input type="password" name="pass" size="20"/><br/>
	
	<button class="loginBtn" style="background-image: url('<c:url value="/resources/public/images/litgal.PNG"/>');">접속</button>
	&emsp;
	<%--<button class="joinBtn">가입하기</button> --%>
	
	<a id="kakao-login-btn"></a>
	<a href="http://developers.kakao.com/logout"></a>
	<script type='text/javascript'>
  	//<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('da37e5836c002230d358ce5af57a57ca');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        alert(JSON.stringify(authObj));
      },
      fail: function(err) {
         alert(JSON.stringify(err));
      }
    });
  	//]]>
	</script>

	</div>
	
	
</body>
</html>