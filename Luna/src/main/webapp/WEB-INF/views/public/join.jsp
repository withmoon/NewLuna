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
		<form class="join" name="join" action="home.udo" method="post">
			<img src="<c:url value="/resources/public/images/line.png"/>"/>
			<input type="hidden" name="kid" value="${kid}"/>
			<input type="hidden" name="knic" value="${knic}"/>
			
			<!-- 일반회원가입 -->
			<table align="center">
				<c:if test="${kid eq null}"><!-- 카카오 로그인이 아닐시 출력 -->
				<tr><td>
					<input type="text" name="id" id="id" size="40" value="${member.id}">
					<label>ID</label>
					<button onclick="idCheck()">중복확인</button>
				</td></tr>
				<tr><td>
					<input type="password" name="pw" id="pw" size="50" value="${member.pw}" required="required" >
					<label>PassWord</label>
				</td></tr>
				<tr><td>
					<input type="password" name="repw" id="repw" size="50" required="required">
					<label>Confirm PassWord</label>
				</td></tr>
				</c:if><!-- 카카오 로그인시 여기까지 비출력 -->
				<!-- 여기서 부터 그냥 회원 -->
				<tr><td>
					<c:if test="${kid eq null}">
					<input type="text" name="name" id="name" size="50" value="${member.name}">
					</c:if>
					<c:if test="${kid ne null}">
					<input type="text" name="name" id="name" size="50" value="${knic}">
					</c:if>
					<label>Name</label>
				</td></tr>
				<tr><td>
					<input type="text" name="phone" id="phone" size="50" value="${member.phone}" placeholder="'-' 포함 입력">
					<label>Tel</label>
				</td></tr>
				<tr><td>
					<input type="text" name="birth" id="birth" size="50" value="${member.birth}" placeholder="6자리 입력 ex)820215">
					<label>birthday</label>
				</td></tr>
				<tr><td>
					<input type="email" name="email" id="email" size="50" value="${member.email}">
					<label>Email</label>
				</td></tr>
				<!-- 여기까지 그냥 회원 -->
				
				<!-- 여기서부터 지점장 회원 -->
				<c:if test="${br eq 'on'}">
				<input type="hidden" name="position" value="지점장"/>
				<!-- 다음 우편 시작 -->
				<tr><td>
				<input type="text" id="sample2_postcode" size="35" value="${member.zipcode}"> <input type="button" onclick="sample2_execDaumPostcode()" value="우편번호 찾기">
				<label>우편번호</label>
				</td></tr>
				<tr><td>
				<input type="text" id="sample2_address" size="50" value="${member.branchAddr1}"><br>
				<label>Address</label>
				</td></tr>
				<tr><td>
				<input type="text" id="sample2_detailAddress" size="50" value="${member.branchAddr2}"> <input type="text" id="sample2_extraAddress" placeholder="참고항목" value="${member.branchAddr3}">
				<label>detail_Address2</label>
				</td></tr>	
				<!-- 여기서 끝 -->
				<tr><td>
					<input type="text" name="branch" id="branch" size="50" value="${member.branchName}">
					<label>BranchName</label>
				</td></tr>
			
			<!-- 다음 우편번호 iframe 을 위한 div -->
			<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
			<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
			<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
			</div>
			<script src="<c:url value="/resources/public/js/getaddress.js"/>"></script>
			<!-- 여기서 다음 우편 참고 끝 -->
			</c:if>
			</table>
			
			
			<div align="center"><button onclick="inputCheck()">회원가입완료</button></div>
			<img src="<c:url value="/resources/public/images/line.png"/>"/>
		</form>
	</section>
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