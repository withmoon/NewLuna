<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/left1.js"></script>

<!--왜 안먹지?????????????????
<script>
	$(document).ready(function(){
		
		//[환불현황] 버튼을 누르면 pc_refund.jsp 페이지가 실행된다
		$("button").click(function(){
			$("#result").load("presentCondition/pc_refund.jsp");
		});
	});
</script>-->
<meta charset="UTF-8">
<title>매니저 좌측 메뉴</title>
</head>
<!-- 문의게시판 , 이벤트게시판 둘다 같은 board.jsp에서  스크립트 이용해서 DB에서 각자 데이터 가져와 사용할 생각 -->
<!-- 이상태 링크가 아닌 main 화면에 각자 넣고 그 jsp화면을 연동할 생각  *현재는 테스트로 링크를 넣어둠 -->
<!-- ajax 는 로그인 부분만 사용하고 나머지는 세션/링크를 통해 넘어갈것 -->
<body>
	<div id="letf1m">
		<ul>
			<li class="menu"><a id="a" href="#"><img src="../images/menu02.png" alt="게시판관리" />게시판관리</a>
				<ul class="hide">
					<li>자유 게시판</li>
					<li>문의 게시판(고객의 소리.자주묻는질문)</li>
					<li>이벤트 게시판</li>
					<li>공지사항</li>
				</ul>
			</li>

			<li class="menu"><a href="#"><img src="../images/menu02.png" alt="매출통계" />매출통계</a>
				<ul class="hide">
					<li><a href="body/sales/sales_reserve.jsp">월 매출</a></li>
					<li><a href="body/sales/sales_market.jsp">Market 매출</a></li>
				</ul>
			</li>
			<li class="menu"><a href="#"><img src="../images/menu01.png" alt="예약시간대통계" />예약시간대통계</a>
				<ul class="hide">
					<li><a href="body/reserveTime/age.jsp">연령별</a></li>
					<li><a href="body/reserveTime/season.jsp">분기별</a></li>
				</ul>
			</li>
			<li class="menu"><a href="#"><img src="../images/menu03.png" alt="방 생성/수정/삭제" />방 생성/수정/삭제</a>
				<ul class="hide">
					<li>방등록</li>
					<li>방수정</li>
					<li>방삭제</li>
				</ul>
			</li>
				<li class="menu"><a href="#"><img src="../images/menu02.png" alt="현황보기" />현황보기</a>
				<ul class="hide">
					<li><a href="body/presentCondition/pc_sales.jsp">매출현황</a></li>
					<li><a href="body/presentCondition/pc_reserve.jsp">예약현황</a></li>
					<li><a href="body/presentCondition/pc_visit.jsp">방문현황</a></li>
					<li><button>환불현황</button></li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>