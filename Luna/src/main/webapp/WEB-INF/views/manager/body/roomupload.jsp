<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#roominsert {
	width: 60%;
	border-bottom: 1px solid black;
	height: 300px;
	border-right: 1px solid black;
}

#image {
	float: left;
}

#img {
	border: 1px solid black;
	width: 300px;
	height: 200px;
}

#room {
	margin-left: 360px;
	float: none;
}

#form2 {
	width: 60%;
	
}

#file {
	float: left;
	
}

#roomtext {
	margin-left: 350px;
	float: none;
	border-right: 1px solid black;
}

.bt { 
	height: 25px;
	width: 60px;
	margin-left: 10px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>방 생성</h2>
	<hr>
	<form>
		<div id="roominsert">
			<!-- 이미지 / 방소개영역 -->
			<div id="image">
				<img id="img"><br />이미지 영역
				<div>
					<input type="file">
				</div>
			</div>

			<div id="room">
				<p>방소개글
				<p>
					<input type="text"><input class="bt" type="button"
						value="추가"><br /> <input type="text"><br /> <input
						type="text"><br /> <input type="text"><br /> <input
						type="text"><br /> <label>추가 버튼?</label>
			</div>
		</div>

		<div id="form2">
			<div id="file">
				<input type="file"><input class="bt" type="button"
					value="추가">
			</div>

			<div id="roomtext">
				<p>방소개
				<p>
					<textarea rows="10" cols="40"></textarea>
				<p>주의 사항
				<p>
					<textarea rows="10" cols="40"></textarea>
			</div>

		</div>
			<input type="submit" value="등록">
			<input type="reset" value="초기화">
			<input type="button" value="취소">
	</form>



</body>
</html>