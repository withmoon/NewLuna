<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="calendar">
<head>
<link rel="stylesheet" type="text/css" href="../css/calendar.css">
<link type="text/css" rel="stylesheet" href="../css/refund.css">
<link type="text/css" rel="stylesheet" href="../css/manager1.css">

<script src="../jquery/moment.min.js"></script>
<script src="../jquery/angular.min.js"></script>
<script src="../js/calendar.js"></script>
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/mjs.js"></script>
<title>지점장 관리화면</title>
<script type="text/javascript">
	moment.locale('kr', {
		months : "1월_2월_3월_4월_5월_6월_7월_8월_9월_10월_11월_12월".split("_"),
		monthsShort : "1월_2월_3월_4월_5월_6월_7월_8월_9월_10월_11월_12월".split("_"),
		weekdays : "일요일_월요일_화요일_수요일_목요일_금요일_토요일".split("_"),
		weekdaysShort : "일._월._화._수._목._금_토.".split("_"),
		weekdaysMin : "일._월._화._수._목._금_토.".split("_"),
		ordinal : function(number) {
			return number + '일'
		}
	});
</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="back">
		<!-- 배경 -->
		<div id="border">
			<!-- 틀 -->
			<!-- 상단바 -->
			<nav id="TopNav">
				<!-- 좌측상단 로고 -->
				<div id="letflogo">
					<img class="logo" src="../images/mainlogo2.png">
				</div>

				<!-- 상단 탭 -->
				<div id="TopMenu1">
					<jsp:include page="form/TopMenu1.jsp"></jsp:include>
				</div>
				<div id="TopMenu2">
					<jsp:include page="form/TopMenu2.jsp" />
				</div>

			</nav>

			<!-- 중앙 -->
			<div id="center">
				<!-- 왼측1 사이드 -->
				<aside id="left1">
					<jsp:include page="form/left1_menu.jsp"></jsp:include>
				</aside>
				<!-- 왼측2 사이드 -->
				<aside id="left2">
					<div id="letf2div">
						<jsp:include page="form/search.jsp" />
					</div>
					<div id="submenu">
						<jsp:include page="form/submenu.jsp" />
					</div>
				</aside>
				<!-- 중앙세션 -->
				<section id="msec">
					<!-- 환불처리  -->
					<!-- 방 예약 현황을 가져오고  -->
					<!-- 검색창으로 고객을 검색해서 -->
					<!-- 예약취소 / 환불 버튼 클릭으로  기능 수행 -->

					<div id=header>
						<header>환불처리 현황</header>
					</div>
<!-- 구글 캘린더  미사용  -->
<!-- <iframe src="https://calendar.google.com/calendar/embed?height=600&amp;wkst=1&amp;bgcolor=%23FFFFFF&amp;src=9rn25thj37k6lkhutaivlhcmcc%40group.calendar.google.com&amp;color=%23711616&amp;ctz=Asia%2FSeoul" style="border-width:0" width="800" height="600" frameborder="0" scrolling="no"></iframe> -->

					<div id="calendar">
						<div ng-controller="calendarWidget">
							<calendar selected="day"></calendar>
							<span id="cday">선택된 날짜 : <strong>{{day.format('dddd, MMMM Do YYYY')}}</strong>
							</span>
						</div>
					</div>

					<hr>

					<div id="rcenter">
						<table>
							<tr class="tr1">
								<th>방 번호</th>
								<th class="th">신청자</th>
								<th class="th">예약인원</th>
								<th class="th">희망이용시간</th>
								<th class="th">신청일/시간</th>
								<th class="th">환불/취소</th>
							</tr>
							<!-- db에서 읽어들어와야하는 부분 -->
							<!-- 예시로 데이터 작업 -->
							<tr>
								<td>1</td>
								<td>홍</td>
								<td>6명</td>
								<td>15:30</td>
								<td>15일</td>
								<td><button type="button">환불</button></td>
							</tr>
							<tr>
								<td>2</td>
								<td>길</td>
								<td>3명</td>
								<td>10:00</td>
								<td>12일</td>
								<td><button type="button">환불</button></td>
							</tr>
							<tr>
								<td>3</td>
								<td>동</td>
								<td>2명</td>
								<td>17:00</td>
								<td>18일</td>
								<td><button type="button">환불</button></td>
							</tr>
							<tr>

							</tr>
						</table>

						<div id="namesearch">
							<label for="namesearch">검색 :</label> <br /> <input id="search"
								name="namesearch" type="text">&nbsp;
							<button type="button">찾기</button>
							<label>어떤방식으로 화면이 늘어났을때 만들건지 테스트 중</label><br/>
							<label>스크롤바를 만들지 웹을 늘릴지</label>
						</div>
					</div>
				</section>
			</div>


			<div>
				<footer id="footer">
					<jsp:include page="form/footer.jsp"></jsp:include>
				</footer>
			</div>
		</div>

	</div>
</body>
</html>