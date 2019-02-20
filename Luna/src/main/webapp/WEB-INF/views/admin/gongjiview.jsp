<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet"
	href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
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
				<img src="<c:url value="/resources/admin/달빛.png"/>" width="100"
					height="100">
			</div>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="administrator.ado">홈</a></li>
				<li><a href="sales.ado">판매현황</a></li>
				<li><a href="info.ado">지점장정보/승인</a></li>
				<li><a href="board.ado">자주묻는질문</a></li>
				<li><a href="gongji.ado">공지사항</a></li>
				<li><a href="event.ado">이벤트</a></li>
				<li><a href="member.ado">회원관리</a></li>
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
	<br>
	<br>
	<br>
	<div class="container">
		<h4>글상세</h4>
		<form name="form2" action="gongjiupdate.ado" method="POST">
			<table class="table table-bordered">
				<tbody>

					<tr>
						<th>작성자:</th>
						<td><input type="text" placeholder="subject" id="writer"
							name="writer" class="form-control" /></td>
					</tr>
					<tr>
						<th>제목:</th>
						<td><input type="text" name="title" placeholder="title"
							id="title" value="${num.title}" class="form-control" /> <input
							type="hidden" name="num" value="${num.num}" /></td>
					</tr>

					<tr>
						<th>내용:</th>
						<td><textarea cols="5" placeholder="content " id="content"
								name="content" class="form-control" rows="20">${num.content}</textarea></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit" id="update" value="수정"
							class="btn btn-primary pull-right" /> <input type="button"
							value="삭제" class="btn btn-primary pull-right"
							onclick="javascript:location.href='gongjidelete.ado?num=${num.num}'" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
</body>
</html>