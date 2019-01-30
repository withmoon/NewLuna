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
				<th>매장방문</th>
				<th>방문횟수</th>
				<th>ID</th>
				<th>AGE</th>
				<th>선호인원</th>
			</tr>
			<tr>
				<td>1위</td>
				<td>20</td>
				<td>GD</td>
				<td>20대</td>
				<td>3인</td>
			</tr>
			<tr>
				<td>2위</td>
				<td>19</td>
				<td>TOP</td>
				<td>20대</td>
				<td>3인</td>
			</tr>
			<tr>
				<td>3위</td>
				<td>18</td>
				<td>TAEYANG</td>
				<td>20대</td>
				<td>2인</td>
			</tr>
		</table>
		
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
		</table>
	</div>
</body>
</html>