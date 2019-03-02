<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script>
<script 
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<style type="text/css">
#ex {
	background-color: lightgreen;
	height: 30px;
}

#ex ul {
	padding-top: 3px;
	list-style: circle;
}

#ex ul li {
	display: inline;
	padding-left: 20px;
}

#exb {
	float: center;
}

#t {
	height: 100%;
	border-color: gray;
}

#t {
	margin-top: 20px;
	width: 100%;
	border-bottom-color: black;
}

#t tr td {
	text-align: center;
}

#ttr1 {
	background-color: lightgreen;
}
</style>

<!-- jQuery CDN --->
<script>
  function cancelPay() {
    jQuery.ajax({
      "url": "http://www.myservice.com/payments/cancel",
      "type": "POST",
      "contentType": "application/json",
      "data": JSON.stringify({
        "merchant_uid": "mid_" + new Date().getTime(), // 주문번호
        "cancel_request_amount": 2000, // 환불금액
        "reason": "테스트 결제 환불", // 환불사유
        "refund_holder": "홍길동", // [가상계좌 환불시 필수입력] 환불 가상계좌 예금주
        "refund_bank": "88", // [가상계좌 환불시 필수입력] 환불 가상계좌 은행코드(ex. KG이니시스의 경우 신한은행은 88번)
        "refund_account": "56211105948400" // [가상계좌 환불시 필수입력] 환불 가상계좌 번호
      }),
      "dataType": "json"
    });
    alert("환불성공");
  }
</script>
<title>지점장 관리화면</title>
</head>
<body>
	<!-- 상단바 -->
	<nav id="TopNav"> 
		<!-- 상단 탭 -->
		<div id="TopMenu1">
			<!-- 좌측상단 로고 -->
			<div id="letflogo">
				<a href="manager.mdo"><img class="logo"
					src="<c:url value="/resources/manager/images/mainlogo2.png"/>" /></a>
			</div>
			<jsp:include page="/WEB-INF/views/manager/form/TopMenu1.jsp"></jsp:include>
		</div>
		<%-- <div id="TopMenu2">
					<jsp:include page="form/TopMenu2.jsp" />
				</div> --%>
	</nav>

	<!-- 배경 -->
	<div id="border">
		<!-- 왼측1 사이드 -->
		<div id="left1div">
			<div id="search">
				<jsp:include page="/WEB-INF/views/manager/form/search.jsp" />
			</div>
			<aside id="left1">
				<jsp:include page="/WEB-INF/views/manager/form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>환불 현황</header>
			</div>
			<div>
				<div id="ex">
					<ul>
						<li><input type="text" class="text"
							placeholder="ID or 연락처를 입력하세요"></li>
						<li id="exb"><input type="button" value="조회"></li>
					</ul>
				</div>

				<!-- db데이터 -->
				<table id="t">
					<tr id="ttr1">
						<th>No.</th>
						<th>ID</th>
						<th>방이름</th>
						<th>룸번호</th>
						<th>예약일</th>
						<th>승인</th>
					</tr>
					<c:forEach var="list" items="${list }">
						<tr>
							<c:if test="${list.status eq -2 || list.status eq -1}">
							<td>${list.seq }</td>			
							<td>${list.imp_uid}</td>	
							<td>${list.branchname }</td>
							<td>${list.roomnum }</td>
							<td><fmt:formatDate value="${list.paid_at }" pattern="yyyy.MM.dd"/></td>
							<c:if test="${list.status==-2}">
								<td><button onclick="cancelPay()">환불하기</button></td>
							</c:if>
							<c:if test="${list.status==-1}">
								<td>환불완료</td>
							</c:if>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</div>
		</section>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>