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
function list(page) {
	location.href = "mgRefund.mdo?curPage="+page+"&searchOption=${map.searchOption}"+"&keywrod=${map.keyword}";
}

 
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
					<form name="form1" method="post" action="mgRefund.mdo?">
						<table id="searchtable">
							<tr>
								<td id="searchtd">
									<!-- 레코드의 갯수를 출력 -->
									<select name="searchOption">
										<option value="roomnum"  <c:out  value="${map.searchOption == 'roomnum' ? 'selected' : '' }" />>번호</option>
										<option value="IMP_UID"  <c:out value="${map.searchOption == 'IMP_UID'?'selected' : '' }"/> >아이디</option>
								</select> 
								<input name="keyword"  value="${map.keyword }"> 
								<input	 type="submit" value="검색">
								</td>
							</tr>
						</table>
					</form>
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
					<c:forEach var="list" items="${map.list }">
						<tr>
							<c:if test="${list.status eq -2 || list.status eq -1}">
							<td>${list.rownum }</td>			
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
							 <tr>
		            <td colspan="5">
		                <!-- 처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력-->
		                <c:if test="${map.boardPager.curBlock > 1}">
		                    <a href="javascript:list('1')">[처음]</a>
		                </c:if>
		                
		                <!-- 이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
		                <c:if test="${map.boardPager.curBlock > 1}">
		                    <a href="javascript:list('${map.boardPager.prevPage}')">[이전]</a>
		                </c:if>
		                
		                <!-- **하나의 블럭 시작페이지부터 끝페이지까지 반복문 실행 -->
		                <c:forEach var="num" begin="${map.boardPager.blockBegin}" end="${map.boardPager.blockEnd}">
		                    <!-- 현재페이지이면 하이퍼링크 제거 -->
		                    <c:choose>
		                        <c:when test="${num == map.boardPager.curPage}">
		                            <span style="color: red">${num}</span>&nbsp;
		                        </c:when>
		                        <c:otherwise>
		                            <a href="javascript:list('${num}')">${num}</a>&nbsp;
		                        </c:otherwise>
		                    </c:choose>
		                </c:forEach>
		                
		                <!-- 다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
		                <c:if test="${map.boardPager.curBlock <= map.boardPager.totBlock}">
		                    <a href="javascript:list('${map.boardPager.nextPage}')">[다음]</a>
		                </c:if>
		                
		                <!-- 끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
		                <c:if test="${map.boardPager.curPage <= map.boardPager.totPage}">
		                    <a href="javascript:list('${map.boardPager.totPage}')">[끝]</a>
		                </c:if>
		            </td>
		        </tr>
				</table>
			</div>
		</section>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>