<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#ex {
	background-color: lightblue;
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

#t{
	margin-top:20px;
	width: 100%;
	border-bottom-color: black;	
}

#t tr td{
	text-align: center;
}

#ttr1 {
	background-color: lightblue;
}
</style>
<meta charset="UTF-8">
<title>매출현황</title>
</head>
<body>
	<h2>매출현황</h2>
	<hr>
	<div>
		<div id="ex">
			<ul>
				<li>
					<input type="text" class="text" placeholder="DATE를 입력하세요.">
				</li>
				<li id="exb"><input type="button" value="조회"></li>
			</ul>
		</div>

		<!-- db데이터 -->
		<table id="t">
			<tr id="ttr1"> 
				<th>DATE</th>
				<th>인원</th>
				<th>예약건수</th>
				<th>TOTAL</th>
				<th>MARKET</th>
				<th>TOTAL</th>
				<th>총매출</th>
			</tr>
			<tr>
				<td rowspan="4">19/01/01</td>
				<td>1인</td>
				<td>30</td>
				<td>300000</td>
				<td>음료</td>
				<td rowspan="4">400000</td>
				<td rowspan="4">3400000</td>
			</tr>
			<tr>
				<td>2인</td>
				<td>30</td>
				<td>600000</td>
				<td>커피</td>
			</tr>
			<tr>
				<td>3인</td>
				<td>30</td>
				<td>900000</td>
				<td>빵</td>
			</tr>
			<tr>
				<td>4인 이상</td>
				<td>30</td>
				<td>1200000</td>
				<td>X</td>
			</tr>
			<tr>
				<td rowspan="4">19/01/02</td>
				<td>1인</td>
				<td>30</td>
				<td>300000</td>
				<td>음료</td>
				<td rowspan="4">400000</td>
				<td rowspan="4">3400000</td>
			</tr>
			<tr>
				<td>2인</td>
				<td>30</td>
				<td>600000</td>
				<td>커피</td>
			</tr>
			<tr>
				<td>3인</td>
				<td>30</td>
				<td>900000</td>
				<td>빵</td>
			</tr>
			<tr>
				<td>4인 이상</td>
				<td>30</td>
				<td>1200000</td>
				<td>X</td>
			</tr>
			<tr>
				<td rowspan="4">19/01/03</td>
				<td>1인</td>
				<td>30</td>
				<td>300000</td>
				<td>음료</td>
				<td rowspan="4">400000</td>
				<td rowspan="4">3400000</td>
			</tr>
			<tr>
				<td>2인</td>
				<td>30</td>
				<td>600000</td>
				<td>커피</td>
			</tr>
			<tr>
				<td>3인</td>
				<td>30</td>
				<td>900000</td>
				<td>빵</td>
			</tr>
			<tr>
				<td>4인 이상</td>
				<td>30</td>
				<td>1200000</td>
				<td>X</td>
			</tr>
		</table>
	</div>
</body>
</html>