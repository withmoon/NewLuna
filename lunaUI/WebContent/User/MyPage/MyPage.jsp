<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script"
	rel="stylesheet">
<!-- 외부폰트 -->
<link rel="stylesheet" type="text/css" href="css/MyPage.css">
</head>
<body>

	<div class="mypage">

		<hr>
		MyPage
		<hr>
		<hr>
		테스트님<br> 전화번호 : <br> 이메일 :
		<hr>
	</div>
	<div class="aside">
		<button class="aside">
			<img alt="" src="images/love.png"> <br>내가 찜한 방
		</button>
	</div>

<section class="bottom">
	<div >
		<input type="date">
		
			당일<input type="radio" name="schedule" value="today" checked>
			일주일<input type="radio" name="schedule" value="week">
			한달<input type="radio" name="schedule" value="month">
			3개월<input type="radio" name="schedule" value="3months">
		
		<button class="look">적용</button>
	</div>&nbsp;
	<div >
		<img alt="" src="images/room1.png">
	</div>
</section>

</body>
</html>