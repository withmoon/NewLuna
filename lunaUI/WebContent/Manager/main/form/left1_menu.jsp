<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/left1.js"></script>
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
					<li><button id="btn9">월 매출</button></li>
					<li><button id="btn8">Market 매출</button></li>
				</ul>
			</li>
			
			<li class="menu"><a href="#"><img src="../images/menu01.png" alt="예약시간대통계" />예약시간대통계</a>
				<ul class="hide">
					<li><button id="btn7">연령별</button></li>
					<li><button id="btn6">분기별</button></li>
				</ul>
			</li>
			
			<li class="menu"><a href="#"><img src="../images/menu03.png" alt="방 생성/수정/삭제" />방 생성/수정/삭제</a>
				<ul class="hide">
					<li><button id="btn5">방등록/수정/삭제</button></li>
				</ul>
			</li>
			
			<li class="menu"><a href="#"><img src="../images/menu02.png" alt="현황보기" />현황보기</a>
				<ul class="hide">
					<li><button id="btn4">매출현황</button></li>
					<li><button id="btn3">예약현황</button></li>
					<li><button id="btn2">방문현황</button></li>
					<li><button id="btn1">환불현황</button></li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>