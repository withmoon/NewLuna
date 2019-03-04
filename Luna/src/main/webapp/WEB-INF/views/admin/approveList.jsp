<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet"
	href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<title>승인페이지</title>


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
				
				<li><a href="sales.ado">판매현황</a></li>
            <li><a href="approve.ado">지점장승인</a></li>
            <li><a href="board.ado">자주묻는질문</a></li>
            <li><a href="gongji.ado">공지사항</a></li>
            <li><a href="inquire.ado">문의게시판</a></li>
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
						 <li class="active"><a href="adminmail.ado">공지알림</a></li>
						<li><a href="approve.ado">지점장승인</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<center>
		<h3>지점장 승인</h3>
	</center>
	<br></br>
	<div class="container">
		<div class="row">
			<form action="approveList.ado" method="get">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th style="background-color: #eeeeee; text-align: center;">id</th>
							<th style="background-color: #eeeeee; text-align: center;">name</th>
							<th style="background-color: #eeeeee; text-align: center;">phone</th>
							<th style="background-color: #eeeeee; text-align: center;">birth</th>
							<th style="background-color: #eeeeee; text-align: center;">email</th>
							<th style="background-color: #eeeeee; text-align: center;">branchName</th>
							<th style="background-color: #eeeeee; text-align: center;">zipcode</th>
							<th style="background-color: #eeeeee; text-align: center;">branchAddr1</th>
							<th style="background-color: #eeeeee; text-align: center;">branchAddr2</th>
							<th style="background-color: #eeeeee; text-align: center;">승인</th>
							<th style="background-color: #eeeeee; text-align: center;">거절</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${map.list}">
							<tr>
								<td>${row.id}</td>
								<td>${row.name}</td>
								<td>${row.phone}</td>
								<td>${row.birth}</td>
								<td>${row.email}</td>
								<td>${row.branchName}</td>
								<td>${row.zipcode}</td>
								<td>${row.branchAddr1}</td>
								<td>${row.branchAddr2}</td>
								<td><input type="button" value="승인"
									class="btn btn-primary pull-right"
									onclick="javascript:location.href='approval.ado?id=${row.id}'" />
									<input type="hidden" name="id" value="${row.id}" />
								<td><input type="button" value="거절" class="btn btn-primary pull-right" onclick="javascript:location.href='approvedelete.ado?id=${row.id}'"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>





	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>

</body>
</html>