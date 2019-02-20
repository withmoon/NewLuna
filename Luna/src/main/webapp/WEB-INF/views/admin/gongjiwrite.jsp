<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
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
				<li><a href="approve.ado">지점장승인</a></li>
				<li><a href="board.ado">자주묻는질문</a></li>
				<li><a href="gongji.ado">공지사항</a></li>
				<li><a href="event.ado">이벤트</a></li>
				<li><a href="member.ado">회원관리</a></li>
				<li><a href="info.ado">지점장 정보</a></li>
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
		<form id="form1" name="form1" action="noticeinsert.ado">
			<table class="table table-bordered">
				<h4>글쓰기</h4>
				<tbody>

					<tr>
						<th>작성자:</th>
						<td><input type="text" placeholder="subject" id="writer"
							name="writer" class="form-control" /></td>
					</tr>

					<tr>
						<th>제목:</th>
						<td><input type="text" placeholder="subject" id="title"
							name="title" class="form-control" /></td>
					</tr>

					<tr>
						<th>내용:</th>
						<td><textarea cols="10" placeholder="content " id="content"
								name="content" class="form-control"></textarea></td>
					</tr>
					<tr>
						<th>작성일:</th>
						<td><input type="date" placeholder="date" id="regdate"
							name="regdate" class="form-control" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" id="btnSave" value="등록"
							class="pull-right" /> <input type="button" value="글 목록"
							class="pull-right"
							onclick="javascript:location.href='gongjiboardList.ado'" /></td>
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