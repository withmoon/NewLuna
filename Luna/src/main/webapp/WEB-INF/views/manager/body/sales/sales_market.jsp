<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#ex {
	background-color: yellow;
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
	float: right;
	margin-right: 5%;
}

#t {
	height: 100%;
	border-color: gray;
}

#t{
	margin-top:20px;
	width: 100%;
	border-bottom-color: black;	
}

#t tr td{
	text-align: center;
}

#ttr1 {
	background-color: yellow;
}

/*
table {
  border-collapse: separate;
  border-spacing: 0 10px;
}*/
</style>
<meta charset="UTF-8">
<title>Market 매출</title>
</head>
<body>
	<h2>카운터</h2>
	<hr>
	<div>
		<div id="ex">
			<ul>
				<li>검색창 : <select name="select">
						<option value="name">이름</option>
						<option value="tel">전화번호</option>
				</select>
				</li>
				<li>날짜 : <input type="date">
				</li>
				<li id="exb"><input type="button" value="검색"></li>
			</ul>
		</div>

		<!-- db데이터 -->
		<table id="t">
			<tr id="ttr1"> 
				<th>MARKET</th>
				<th colspan="3">음식판매</th>
				<th>합계</th>
			</tr>
			<tr>
				<td>음료</td>
				<td>식혜</td>
				<td>바나나쉐이크</td>
				<td>딸기스무디</td>
				<td>21000</td>
			</tr>
			<tr>
				<td>커피</td>
				<td>카라멜마끼아또</td>
				<td>카푸치노</td>
				<td>아메리카노</td>
				<td>24000</td>
			</tr>
			<tr>
				<td>빵</td>
				<td>초코범벅</td>
				<td>찐빵</td>
				<td>카스테라</td>
				<td>23000</td>
			</tr>
			<tr>
				
			</tr>
		</table>
	</div>
</body>
</html>