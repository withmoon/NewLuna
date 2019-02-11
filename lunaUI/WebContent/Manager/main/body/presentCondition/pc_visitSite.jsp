<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#ex {
	background-color: orange;
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
	background-color: orange;
}
</style>

<meta charset="UTF-8">
<title>방문현황</title>
</head>
<body>
	<h2>방문현황</h2>
	<hr>
	<div>
		<div id="ex">
			<ul>
				<li>
				<select name="select">
						<option>선택하세요</option>
						<option value="visit">매장방문</option>
						<option value="site">사이트방문</option>
				</select>
				</li>
				<li id="exb"><input type="button" value="조회"></li>
			</ul>
		</div>

		<!-- 사이트방문 선택 후 조회 했을 경우 table 영역 변경 -->
		<!-- db데이터 -->		
		<table id="t">
			<tr id="ttr1"> 
				<th>사이트방문</th>
				<th>방문횟수</th>
				<th>ID</th>
				<th>AGE</th>
				<th>게시물</th>
			</tr>
			<tr>
				<td>1위</td>
				<td>70</td>
				<td>GD</td>
				<td>20대</td>
				<td>10</td>
			</tr>
			<tr>
				<td>2위</td>
				<td>60</td>
				<td>TOP</td>
				<td>20대</td>
				<td>9</td>
			</tr>
			<tr>
				<td>3위</td>
				<td>50</td>
				<td>TAEYANG</td>
				<td>20대</td>
				<td>8</td>
			</tr>
		</table><br/>
		<h2>사이트 방문은 매월 1일 초기화됩니다.</h2>
	</div>
</body>
</html>