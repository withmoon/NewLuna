<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#ex {
	background-color: lightpink;
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
	background-color: lightpink;
}

/*
table {
  border-collapse: separate;
  border-spacing: 0 10px;
}*/
</style>
<meta charset="UTF-8">
<title>월 매출</title>
</head>
<body>
	<h2>월 매출</h2>
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
				<th>MONTH</th>
				<th>인실</th>
				<th>금액</th>
				<th>건수</th>
				<th>환불</th>
				<th>합계</th>
			</tr>
			<tr>
				<td rowspan="4">1월</td>
				<td>1인</td>
				<td>10000</td>
				<td>20</td>
				<td>1</td>
				<td>190000</td>
			</tr>
			<tr>
				<td>2인</td>
				<td>18000</td>
				<td>20</td>
				<td>1</td>
				<td>360000</td>
			</tr>
			<tr>
				<td>3인</td>
				<td>27000</td>
				<td>10</td>
				<td>1</td>
				<td>270000</td>
			</tr>
			<tr>
				<td>4인 이상</td>
				<td>36000</td>
				<td>20</td>
				<td>1</td>
				<td>720000</td>
			</tr>
			<tr>
				<td rowspan="4">2월</td>
				<td>1인</td>
				<td>10000</td>
				<td>20</td>
				<td>1</td>
				<td>190000</td>
			</tr>
			<tr>
				<td>2인</td>
				<td>18000</td>
				<td>20</td>
				<td>1</td>
				<td>360000</td>
			</tr>
			<tr>
				<td>3인</td>
				<td>27000</td>
				<td>10</td>
				<td>1</td>
				<td>270000</td>
			</tr>
			<tr>
				<td>4인 이상</td>
				<td>36000</td>
				<td>20</td>
				<td>1</td>
				<td>720000</td>
			</tr>
		</table>
	</div>
</body>
</html>