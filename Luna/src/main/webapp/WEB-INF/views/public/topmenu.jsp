<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
	<header>
		<ul class="topUl">
			<li><a href="<c:url value="/event.udo"/>">이벤트</a></li>
			<li>&emsp;&nbsp;&nbsp;</li>
			<li><a href="<c:url value="/foundbranch.udo"/>">지점 찾기</a></li>

			<c:if test="${member.id eq null}">
				<li>&emsp;&nbsp;&nbsp;</li>
				<li><a href="<c:url value="/login.do"/>">로그인&nbsp;/&nbsp;회원가입</a></li>
			</c:if>

			<c:if test="${member.id ne null}">
				<li>&emsp;&nbsp;&nbsp;</li>
				<li><a href="<c:url value="/mypage.udo"/>">마이페이지</a></li>
				<li>&emsp;&nbsp;&nbsp;</li>
				<li><a href="<c:url value='/logout.do'/>">로그아웃</a></li>
			</c:if>

			<li>&emsp;&nbsp;&nbsp;</li>
			<li><a href="<c:url value="/inform.udo"/>">고객 센터</a></li>

		</ul>
	</header>
</body>
</html>