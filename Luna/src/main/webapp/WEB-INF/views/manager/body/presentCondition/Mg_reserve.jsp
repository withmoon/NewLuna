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
<title>예약현황</title>
</head>
<body>
	<h2>예약현황</h2>
	<hr>
	<div>
		<div id="ex">
			<ul>
				<li>
					<input type="text" class="text" placeholder="ID or 연락처를 입력하세요">
				</li>
				<li id="exb"><input type="button" value="조회"></li>
			</ul>
		</div>

		<!-- db데이터 -->
		<table id="t">
			<tr id="ttr1"> 
				<th>예약No.</th>
				<th>ID</th>
				<th>AGE</th>
				<th>결제일</th>
				<th>인원</th>
				<th>예약일</th>
				<th>승인</th>
			</tr>
			<tr>
				<td>1</td>
				<td>GD</td>
				<td>20대</td>
				<td>19/01/01</td>
				<td>3인</td>
				<td>19/01/07 AM 9:00-10:00</td>
				<td>예약완료</td>
			</tr>
			<tr>
				<td>2</td>
				<td>TOP</td>
				<td>20대</td>
				<td>19/01/02</td>
				<td>3인</td>
				<td>19/01/07 AM 9:00-10:00</td>
				<td>대기중</td>
			</tr>
			<tr>
				<td>3</td>
				<td>TAEYANG</td>
				<td>20대</td>
				<td>19/01/03</td>
				<td>2인</td>
				<td>19/01/07 AM 9:00-10:00</td>
				<td>대기중</td>
			</tr>
		</table>
	</div>
</body>
</html>