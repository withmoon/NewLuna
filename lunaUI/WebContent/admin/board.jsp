<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>게시판 사이트</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="navbar-brand">
	        <img src="달빛.png" width="100" height="100">
			</div>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="administrator.jsp">홈</a></li>
				<li><a href="sales.jsp">판매현황</a></li>
				<li><a href="approve.html">관리자승인</a></li>
				<li><a href="board.jsp">문의게시판</a></li>
				<li><a href="member.html">회원관리</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">메뉴<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="login.jsp">로그아웃</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<center>
	<h3>게시판</h3>
	</center>
<br></br>
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
				<tr>
				<th style="background-color:#eeeeee; text-align:center;">번호</th>
				<th style="background-color:#eeeeee; text-align:center;">제목</th>
				<th style="background-color:#eeeeee; text-align:center;">작성자</th>
				<th style="background-color:#eeeeee; text-align:center;">작성일</th>
				</tr>
				</thead>
				<tbody>
				<tr>
				<td>1</td>
				<td>hi</td>
				<td>신영</td>
				<td>2019/1/27</td>
				</tr>
				</tbody>
				</table>
				<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
				</div>
				</div>





				<script
					src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
				<script src="js/bootstrap.min.js"></script>
</body>
</html>