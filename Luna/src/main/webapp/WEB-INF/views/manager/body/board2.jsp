<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
header {
	border-bottom: 1px solid blue;
	width: auto;
	text-align: left;
	padding-left: 10px;
	padding-top: 30px;
	font-size: 20pt;
}

#searchtable {
	width: 35%;
	min-width: 450px;
}

#boardtable {
	width: 35%;
	min-width: 450px;
}

#searchtd {
	text-align: right;
}

a
#write {
	float: left;
	padding: 2px 1px;
}

#board {
	margin-left: 20%;
	margin-top: 5%;
	width: auto;
}

#boardtable, th, td {
	border: 1px solid black;
	border-spacing: 0px;
	border-collapse: collapse;
}

#boardtable tr td {
	text-align: center;
	padding: 5px 10px;
}

#boardtable tr th {
	padding: 10px 5px;
	text-align: center;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="board">
		<form>
			<table id="searchtable">
				<tr>
					<td id="searchtd"><label id="write" onclick="#">글쓰기</label> <select
						name="searchbaord">
							<option value="TITLE">제목</option>
							<option value="WITER">작성자</option>
					</select> <input name="searchboard" type="text"> <input id="search"
						type="button" value="검색"></td>
				</tr>
			</table>
		</form>

		<table id="boardtable">
			<tr id="th1">
				<th>번호</th>
				<th class="th">제목</th>
				<th class="th">작성자</th>
				<th class="th">조회수</th>
				<th class="th">작성일</th>
			</tr>
			<!-- db에서 읽어들어와야하는 부분 -->
			<!-- 예시로 데이터 작업 -->
			<tr id="tr2">
				<td>1</td>
				<td>제목제목제목제목제목</td>
				<td>김김김</td>
				<td>5</td>
				<td>19/01/01</td>
			</tr>
			<tr>
				<td>1</td>
				<td>제목제목제목제목제목</td>
				<td>김김김</td>
				<td>5</td>
				<td>19/01/01</td>
			</tr>
			<tr>
				<td>1</td>
				<td>제목제목제목제목제목</td>
				<td>김김김</td>
				<td>5</td>
				<td>19/01/01</td>
			</tr>
			<tr>
				<td>1</td>
				<td>제목제목제목제목제목</td>
				<td>김김김</td>
				<td>5</td>
				<td>19/01/01</td>
			</tr>
		</table>
	</div>
</body>
</html>