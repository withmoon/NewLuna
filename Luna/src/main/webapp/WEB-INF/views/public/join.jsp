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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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
					<input type="text" name="id" id="id" size="40">
					<label>ID</label>
					<button onclick="idCheck()">중복확인</button>
				</td></tr>
				<tr><td>
					<input type="password" name="pw" id="pw" size="50" required="required">
					<label>PassWord</label>
				</td></tr>
				<tr><td>
					<input type="password" name="repw" id="repw" size="50" required="required">
					<label>Confirm PassWord</label>
				</td></tr>
				</c:if><!-- 카카오 로그인시 여기까지 비출력 -->
				
				<tr><td>
					<input type="text" name="name" id="name" size="50" value="${knic}">
					<label>Name</label>
				</td></tr>
				<tr><td>
					<input type="tel" name="tel" id="tel" size="50" placeholder="">
					<label>Tel</label>
				</td></tr>
				<tr><td>
					<input type="text" name="birth" id="birth" size="50">
					<label>birthday</label>
				</td></tr>
				<tr><td>
					<input type="email" name="email" id="email" size="50">
					<label>Email</label>
				</td></tr>
			</table>
			</c:if>
			
			<c:if test="${br eq 'on'}">
			<table align="center">
				<tr><td>
					<input type="text" name="id" id="id" size="40">
					<label>ID</label>
					<button>중복확인</button>
				</td></tr>
				<tr><td>
					<input type="password" name="pw" id="pw" size="50">
					<label>PassWorld</label>
				</td></tr>
				<tr><td>
					<input type="password" name="repw" id="repw" size="50">
					<label>Confirm PassWorld</label>
				</td></tr>
				<tr><td>
					<input type="text" name="name" id="name" size="50">
					<label>Name</label>
				</td></tr>
				<tr><td>
					<input type="text" name="position" id="position" size="50">
					<label>Position</label>
				</td></tr>
				<tr><td>
					<input type="email" name="email" id="email" size="50">
					<label>Email</label>
				</td></tr>
				<!-- 다음 우편 시작 -->
				<tr><td>
				<input type="text" id="sample2_postcode" size="50"> <input type="button" onclick="sample2_execDaumPostcode()" value="우편번호 찾기">
				<label>우편번호</label>
				</td></tr>
				<tr><td>
				<input type="text" id="sample2_address" size="50"><br>
				<label>Address</label>
				</td></tr>
				<tr><td>
				<input type="text" id="sample2_detailAddress" size="50"> <input type="text" id="sample2_extraAddress" placeholder="참고항목">
				<label>detail_Address2</label>
				</td></tr>	
				<!-- 여기서 끝 -->
				<tr><td>
					<input type="text" name="branch" id="branch" size="50">
					<label>BranchName</label>
				</td></tr>
				<tr><td>
					<input type="tel" name="tel" id="tel" size="50">
					<label>Tel</label>
				</td></tr>
			</table>
			
			<!-- 다음 우편번호 iframe 을 위한 div -->
			<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
			<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
			<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
			</div>
			<script src="<c:url value="/resources/public/js/getaddress.js"/>"></script>
			<!-- 여기서 다음 우편 참고 끝 -->
			
			</c:if>
			<div align="center"><button onclick="inputCheck()">회원가입완료</button></div>
			<img src="<c:url value="/resources/public/images/line.png"/>"/>
		</div>
	</section>
</body>
</html>