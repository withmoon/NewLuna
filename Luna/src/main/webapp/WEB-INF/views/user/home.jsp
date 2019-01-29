<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="<c:url value="/resources/user/home/css/home.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/user/home/js/home.js"/>"></script>
</head>
<body>
	<!-- 상단메뉴 -->
	<header>
		<ul class="topUl">
			<li><a href="<c:url value="event.udo"/>">이벤트</a></li>
			<li>&emsp;&nbsp;&nbsp;</li>

			<li><a href="<c:url value="foundbranch.udo"/>">지점 찾기</a></li>
			<li>&emsp;&nbsp;&nbsp;</li>
			<li><a href="<c:url value="login.do"/>">로그인&nbsp;/&nbsp;회원가입</a></li>
			<li>&emsp;&nbsp;&nbsp;</li>
			<li><a href="<c:url value="inform.udo"/>">고객 센터</a></li>
			<!-- 
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li><a href="<c:url value="myPage.udo"/>">마이페이지</a></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li><a href="#">로그아웃</a></li> -->
		</ul>
	</header>
	
	<!-- 상단로고 -->
	<a href="<c:url value="home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
	<div class="top">HOME</div>

	
	<section>
	<!-- 배너 -->
	<div>
		<div onmouseover="view1(true)" onmouseout="view1(false)">
    		<img class="whole" alt="전체지점수" src="<c:url value="/resources/user/home/images/whole.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/whole.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/whole2.png"/>'">
		</div>
		<div id="whole2">
    		<b>전국 380개의 지점수</b><br>
        	MoimCenter : 22센터    StudyCenter: 349센터    WorkCenter: 9센터
        </div>
        <div onmouseover="view2(true)" onmouseout="view2(false)">
    		<img class="previous" alt="전체지점수" src="<c:url value="/resources/user/home/images/previous.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/previous.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/previous2.png"/>'">
		</div>
		<div id="previous2">
    		<b>22,712명 고객님들 감사합니다~</b><br>
        	MoimCenter : 1,934명   StudyCenter: 20,098명    WorkCenter: 680명
        </div>
        <div onmouseover="view3(true)" onmouseout="view3(false)">
    		<img class="accumulate" alt="전체지점수" src="<c:url value="/resources/user/home/images/accumulate.png"/>"
				onmouseout="this.src='<c:url value="/resources/user/home/images/accumulate.png"/>'"
				onmouseover="this.src='<c:url value="/resources/user/home/images/accumulate2.png"/>'">
		</div>
		<div id="accumulate2">
    		<b>22,712명 고객님들이 증명합니다</b><br>
        	MoimCenter : 1,934명   StudyCenter: 20,098명    WorkCenter: 680명
        </div>
		<div align="center"  id="banner">
			<img alt="studyhome" src="<c:url value="/resources/user/home/images/studyhome.png"/>" >
		</div>
	</div>

	<!-- 선택창 -->
	<div align="center">
	<select>
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

	<select>
		<option value="서울지점">서울지점</option>
		<option value="경기지점">경기지점</option>
		<option value="대구지점">대구지점</option>
	</select>
	
	<button>찾기</button>
	</div>&nbsp;
	
	<!-- 인기순/조회수/new -->
	<div align="center">
		<p><img alt="" src="<c:url value="/resources/user/home/images/line.png"/>">	인기순	<img alt="" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
		<table border="0">
			<tr>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room1.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room2.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room3.png"/>" width="400" height="250"></td>
			</tr>
			<tr>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room1.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room2.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room3.png"/>" width="400" height="250"></td>
			</tr>
		</table>
		<p><img alt="" src="<c:url value="/resources/user/home/images/line.png"/>">	조회순	<img alt="" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
		<table border="0">
			<tr>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room1.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room2.png"/>" width="400" height="250"></td>
				<td><img alt="" src="<c:url value="/resources/user/home/images/room3.png"/>" width="400" height="250"></td>
			</tr>
		</table>
	<p><img alt="" src="<c:url value="/resources/user/home/images/line.png"/>">   리뷰   <img alt="" src="<c:url value="/resources/user/home/images/line.png"/>"></p>
   </div>
   </section>
   
   <!-- review -->
   <section class="review">
      <img src="<c:url value="/resources/user/home/images/star.png"/>"><b>한줄후기</b><img src="<c:url value="/resources/user/home/images/star.png"/>">
      <br/>여러분의 <a href="#" onclick="rivDown('pnum')">한줄후기</a> 를 들려주세요<br/><br/>
      <div class="rbox">
         작성자 : 선비냥이<br/>
         작성날짜 : 2019-01-01<br/><br/>
         흠.. <a href="#">수정</a>&emsp;<a href="#">삭제</a><br/>
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
      </div><br/>
      <div class="pnum">[이전] <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> [다음]</div><br/>
      
   </section>
  	<!-- footer -->
	<footer>
	<section class="sec" style="width:100%; height:1%; border-top:1px solid darkgray; margin:0 1% 1% 0;"></section>
	&nbsp;Shining in the dark 
	&emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;
	&emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 
	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	㈜2조시스템즈/사업자등록번호 : 112 01 12321 /대표이사 대표다/서울 성동구 왕십리동 빌드빌딩 4층<br/> 
	<Strong>MoonLight</Strong> StudyCafe
	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;
	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	©2019. 2JOSYSTEMS Corp.
	</footer>
</body>
</html>