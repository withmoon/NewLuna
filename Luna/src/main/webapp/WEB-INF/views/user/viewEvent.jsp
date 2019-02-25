<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세보기</title>
<link href="<c:url value="/resources/user/viewEvent/css/viewEvent.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/user/viewEvent/js/viewEvent.js"/>"></script>
</head>
<body>
<header>
<img class="line1" src="<c:url value="/resources/user/viewEvent/images/line1.png"/>">
<p><b>${ebv.title }</b>
<span class="date">
	<fmt:formatDate value="${ebv.startdate }" pattern="yy-MM-dd" /> ~ <fmt:formatDate value="${ebv.enddate }" pattern="yy-MM-dd" />
</span></p>
<img class="line2" src="<c:url value="/resources/user/viewEvent/images/line2.png"/>">
</header>
<section>
<div class="content">
	${ebv.content } <p>
	${ebv.image }
</div>
<img class="line1" src="<c:url value="/resources/user/viewEvent/images/line1.png"/>"><p>
<div class="review">
	<img src="<c:url value="/resources/user/viewEvent/images/star.png"/>">
		<b class="reply">댓글 보기/닫기</b>
	<img src="<c:url value="/resources/user/viewEvent/images/star.png"/>">
	<div class="listReply">
		<div class="rbox">
			댓글이 없습니다.
		</div>
    	<!-- <div class="rbox">
       		  작성자 : 선비냥이<br/>
     		  작성날짜 : 2019-01-01<br/><br/>
     		  흠.. <br/>
    	</div>

    	<div class="rbox">
       		  작성자 : 냥냥펀치님<br/>
       		  작성날짜 : 2019-01-01<br/><br/>
       		  아래 작성자 넌 뭐냥 왜 고냥이 말밖에 못하냥 어디서 순고양이가 인간세계에와서 어울리냥<br/>
    	</div>

    	<div class="rbox">
       		  작성자 : 고냥이님<br/>
       		  작성날짜 : 2019-01-01<br/><br/>
       		  냥냥냥 냥냥~~냥냥 0ㅁ0 냥냥냥~~~~~~<br/>
    	</div>

    	<div class="rbox">
       		  작성자 : 프로리뷰어님<br/>
       		  작성날짜 : 2019-01-01<br/><br/>
       		  공기정화기 덕분에 숨통도 잘 트이고 조명조절이 가능해서 오늘 프레젠테이션하는데 있어 너무나도 편리했습니다.<br/>
    	</div>

    	<div class="rbox">
       		  작성자 : 난강사다<br/>
       		  작성날짜 : 2019-01-01<br/><br/>
       		  강의하는데 있어 아주 편리했습니다. 가격도 무인시스템으로 예약받아서 그런지 일반 적인 곳에 비해 싸서 좋네요<br/>
    	</div><br/> -->
    	</br><c:if test="${member.id != null }"><div class="rbox">
    		<div id="replytext"></div>
    		<!-- <textarea rows="3" cols="70" id="replytext" placeholder="댓글을 작성해주세요"></textarea> --> 
    		<button type="button" id="btnReply">올리기</button>
    	</div></c:if>
    	
    	<div class="pnum">[이전] <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> [다음]</div><br/>
    </div> 
</div>
<button class="close" type="button" onclick="windowClose()">닫기</button>
</section>
</body>
</html>