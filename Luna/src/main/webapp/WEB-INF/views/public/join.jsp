<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign</title>
<link href="<c:url value="/resources/public/css/join.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower"rel="stylesheet"><!-- 외부폰트 -->
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="<c:url value="/resources/public/js/join.js"/>"></script>
</head>
<body>
	<a href="../Home/Home.jsp" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
	<div class="top">회원가입</div>

	<form name="kform" action="join.do" method="post">
		<input type="hidden" name="kid" value="${kid}"/>
		<input type="hidden" name="knic" value="${knic}"/>
	</form>

	<!-- 회원가입 버튼 -->
	<section>
	<c:if test="${kid ne null }">
	<img class="kawai" src="<c:url value="/resources/public/images/kakaoregis.gif"/>"/>
	<p class="kawai2">♡사이트 이용을 위해 추가정보를 입력해주세욧♡</p>
	</c:if>
	<c:if test="${kid eq null}">
		<div class="user">
			<div class="inside" onclick="isMem()">
				<span>회원가입</span>
				<div class="tie-wrap">
					<div class="tie"></div>
				</div>
			</div>
			<div class="button">
				<div class="front">
					<span>일반회원</span>
				</div>
				<div class="back"></div>
			</div>
		</div>
		
		<div class="manager" onclick="isbranch()">
			<div class="inside">
				<span>회원가입</span>
				<div class="tie-wrap">
					<div class="tie"></div>
				</div>
			</div>
			<div class="button">
				<div class="front">
					<span>지점장</span>
				</div>
				<div class="back"></div>
			</div>
			
		</div>
		</c:if>
		
		<!-- 회원가입 폼 -->
		<div class="join">
			<img src="<c:url value="/resources/public/images/line.png"/>"/>
			
			<!-- 일반회원가입 -->
			<c:if test="${br eq 'off'}">
			<table align="center">
				<c:if test="${kid eq null}"><!-- 카카오 로그인이 아닐시 출력 -->
				<tr><td>
					<input type="text" name="id" size="40">
					<label>ID</label>
					<button>중복확인</button>
				</td></tr>
				<tr><td>
					<input type="password" name="pw" size="50">
					<label>PassWord</label>
				</td></tr>
				<tr><td>
					<input type="password" name="repw" size="50">
					<label>Confirm PassWord</label>
				</td></tr>
				</c:if><!-- 카카오 로그인시 여기까지 비출력 -->
				
				<tr><td>
					<input type="text" name="name" size="50" value="${knic}">
					<label>Name</label>
				</td></tr>
				<tr><td>
					<input type="tel" name="tel" size="50">
					<label>Tel</label>
				</td></tr>
				<tr><td>
					<input type="text" name="address2" size="50">
					<label>birthday</label>
				</td></tr>
				<tr><td>
					<input type="email" name="email" size="50">
					<label>Email</label>
				</td></tr>
			</table>
			</c:if>
			
			<c:if test="${br eq 'on'}">
			<table align="center">
				<tr><td>
					<input type="text" name="id" size="40">
					<label>ID</label>
					<button>중복확인</button>
				</td></tr>
				<tr><td>
					<input type="password" name="pw" size="50">
					<label>PassWorld</label>
				</td></tr>
				<tr><td>
					<input type="password" name="repw" size="50">
					<label>Confirm PassWorld</label>
				</td></tr>
				<tr><td>
					<input type="text" name="name" size="50">
					<label>Name</label>
				</td></tr>
				<tr><td>
					<input type="text" name="position" size="50">
					<label>Position</label>
				</td></tr>
				<tr><td>
					<input type="email" name="email" size="50">
					<label>Email</label>
				</td></tr>
				<tr><td>
					<input type="text" name="branch" size="50">
					<label>Branch</label>
				</td></tr>
				<tr><td>
					<input type="text" name="address1" size="40">
					<label>Address1</label>
					<button>찾기</button>
				</td></tr>
				<tr><td>
					<input type="text" name="address2" size="50">
					<label>Address2</label>
				</td></tr>
				<tr><td>
					<input type="tel" name="tel" size="50">
					<label>Tel</label>
				</td></tr>
			</table>
			</c:if>
			<div align="center"><button>회원가입완료</button></div>
			<img src="<c:url value="/resources/public/images/line.png"/>"/>
		</div>
	</section>
</body>
</html>