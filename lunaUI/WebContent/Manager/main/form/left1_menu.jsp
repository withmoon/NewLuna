<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	   <!-- 문의게시판 , 이벤트게시판 둘다 같은 board.jsp에서  스크립트 이용해서 DB에서 각자 데이터 가져와 사용할 생각 -->
	   <!-- 이상태 링크가 아닌 main 화면에 각자 넣고 그 jsp화면을 연동할 생각  *현재는 테스트로 링크를 넣어둠 -->
	   <!-- ajax 는 로그인 부분만 사용하고 나머지는 세션/링크를 통해 넘어갈것 -->
<body>
	<ul>
		<li><button id="hanbool" onclick="location.href='refund.jsp'">환불처리</button></li>
		<li><button id="test" onclick="location.href='manager.jsp'">예약시간대통계</button></li>
		<li><button onclick="location.href='#'">매출통계</button></li>
		<li><button onclick="location.href='board.jsp'">문의게시판</button></li>
		<li><button onclick="location.href='#'">방생성</button></li>
		<li><button onclick="location.href='#'">방수정</button></li>
		<li><button onclick="location.href='#'">방삭제</button></li>
		<li><button onclick="location.href='#'">예약현황</button></li>
		<li><button onclick="location.href='board.jsp'">이벤트게시판</button></li>
	</ul>
</body>
</html>