<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<link rel="stylesheet" type="text/css" href="css/jquery.selectlist.css">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="js/jquery.selectlist.js"></script>
<script type="text/javascript">
	$(function() {
		$('select').selectlist({
			zIndex : 10,
			width : 300,
			height : 40
		});
	})
</script>
</head>
<body>
<article id="studyhome">
		<section>
			<img src="images/studyhome.jpg" alt="studyhome">
		</section>
	</article>

	<select id="sido" name="sido">
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
	<select id="branch" name="branch">
		<option value="서울지점">서울지점</option>
		<option value="경기지점">경기지점</option>
		<option value="대구지점">대구지점</option>
	</select>
</body>
</html>