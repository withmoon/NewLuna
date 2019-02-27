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
				<li><a href="info.ado">지점장정보/승인</a></li>
				<li><a href="inquireList.ado">문의게시판</a></li>
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
		<form id="form1" name="form1" action="${pageContext.request.contextPath}/inquireinsert.ado" method="post">
			<table class="table table-bordered">
				<h4>답변쓰기</h4>
				<tbody>
				<tr>
				<th>이메일:</th>
				 <td><input type="text" name="tomail" size="120" style="width:100%" placeholder="상대의 이메일" class="form-control" value="${seq.email}"/></td>
				</tr>
				<tr>
				<th>제목:</th>
				 <td><input type="text" name="title" size="120" style="width:100%" placeholder="제목" class="form-control"/></td>
				</tr>
					<tr>
						<th>답변:</th>
						<td><textarea cols="10" rows="4" placeholder="reply" id="reply"
								name="reply" class="form-control">${seq.reply}</textarea>
					   <input type="hidden" name="seq" value="${seq.seq}" /></td>
					 </tr>
					<tr>
						<td colspan="2"><input type="submit" id="btnSave" value="등록"
							class="btn btn-primary pull-right" /> <input type="button"
							value="글 목록" class="btn btn-primary pull-right"
							onclick="javascript:location.href='inquireList.ado'" /></td>
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