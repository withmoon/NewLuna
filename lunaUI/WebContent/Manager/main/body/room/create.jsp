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
	background-color: lightblue;
}
</style>
<meta charset="UTF-8">
<title>방 생성</title>
</head>
<body>
	<h2>방 생성</h2>
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
				<li id="exb"><input type="button" value="방생성"></li>
				<li id="exb"><input type="button" value="검색"></li>
			</ul>
		</div>

		<!-- db데이터 -->
		<table id="t">
			<tr id="ttr1"> 
				<th>ROOM.NO</th>
				<th>지점명</th>
				<th>등록일</th>
				<th>인원</th>
				<th>주소</th>
			</tr>
			<tr>
				<td>1</td>
				<td>도곡점</td>
				<td>19/01/01</td>
				<td>3인실</td>
				<td>경기도 고양시</td>
			</tr>
			<tr>
				<td>2</td>
				<td>상왕점</td>
				<td>19/01/02</td>
				<td>3인실</td>
				<td>경기도 안양시</td>
			</tr>
			<tr>
				<td>3</td>
				<td>체인점</td>
				<td>19/01/03</td>
				<td>2인실</td>
				<td>경기도 삼성시</td>
			</tr>
		</table>
	</div>
</body>
</html>