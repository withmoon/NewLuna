<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script" rel="stylesheet"> <!-- 외부폰트 -->
<link rel="stylesheet" type="text/css" href="css/Home.css">
<link rel="stylesheet" href="../../Public/TopMenu.css"/>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<!-- <script type="text/javascript">
	$(function() {
		$('option').onmosueover(function(){
			$(this).css("background-color","#836e5b");
			$(this).css("font-color","#836e5b");
		});
		 $('option').onmouseout(function(){
			$(this).removeClass('over');
		});
	});
</script> -->
</head>
<body>
	<!-- 로그인 -->
	<header>
		
	</header>
	
	<section>
	<!-- 배너 -->
	<div>
		<div id="b_icon">
			<img class="icon1" alt="전체지점수" src="images/전체지점수.png"
				onmouseout="this.src='images/전체지점수.png'"
				onmouseover="this.src='images/전체지점수2.png'">
			<img class="icon2" alt="전월이용고객님" src="images/전월이용고객님.png"
				onmouseout="this.src='images/전월이용고객님.png'"
				onmouseover="this.src='images/전월이용고객님2.png'">
			<img class="icon3" alt="고객님누적이용횟수" src="images/고객님누적이용횟수.png"
				onmouseout="this.src='images/고객님누적이용횟수.png'"
				onmouseover="this.src='images/고객님누적이용횟수2.png'">
		</div>
		<div align="center"  id="banner">
			<img alt="studyhome" src="images/studyhome.jpg" >
		</div>
	</div>

	<!-- 선택창 -->
	<div align="center">
	<select>
		<option value="서울">서울</option>
		<option value="부산">부산</option>
		<option value="대구">대구</option>
		<option value="인천">인천</option>
		<option value="광주">광주</option>
		<option value="대전">대전</option>
		<option value="울산">울산</option>
		<option value="경기">경기</option>
		<option value="강원">강원</option>
		<option value="세종">세종</option>
		<option value="충청남도">충청남도</option>
		<option value="충청북도">충청북도</option>
		<option value="전라남도">전라남도</option>
		<option value="전라북도">전라북도</option>
		<option value="경상남도">경상남도</option>
		<option value="경상북도">경상북도</option>
		<option value="제주">제주</option>
	</select>

	<select>
		<option value="서울지점">서울지점</option>
		<option value="경기지점">경기지점</option>
		<option value="대구지점">대구지점</option>
	</select>
	
	<button class="look">찾기</button>
	</div>&nbsp;
	
	<!-- 인기순/조회수/new -->
	<div align="center">
		<p><img alt="" src="images/line.png">	인기순	<img alt="" src="images/line.png"></p>
		<table border="0">
			<tr>
				<td><img alt="" src="images/room1.png" width="400" height="250"></td>
				<td><img alt="" src="images/room2.png" width="400" height="250"></td>
				<td><img alt="" src="images/room3.png" width="400" height="250"></td>
			</tr>
			<tr>
				<td><img alt="" src="images/room1.png" width="400" height="250"></td>
				<td><img alt="" src="images/room2.png" width="400" height="250"></td>
				<td><img alt="" src="images/room3.png" width="400" height="250"></td>
			</tr>
		</table>
		<p><img alt="" src="images/line.png">	조회순	<img alt="" src="images/line.png"></p>
		<table border="0">
			<tr>
				<td><img alt="" src="images/room1.png" width="400" height="250"></td>
				<td><img alt="" src="images/room2.png" width="400" height="250"></td>
				<td><img alt="" src="images/room3.png" width="400" height="250"></td>
			</tr>
		</table>
	</div>
	</section>
</body>
</html>