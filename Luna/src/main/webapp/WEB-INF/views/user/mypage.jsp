<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Pragma" content="no-cache"/>

<meta charset="UTF-8">
<title>MyPage</title>
<link href="<c:url value="/resources/user/mypage/css/mypage.css"/>" type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/public/css/topmenu.css"/>" type="text/css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet"> <!-- 외부폰트 -->
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/resources/user/mypage/js/inputChk.js"/>"></script>
<script src="<c:url value="/resources/user/mypage/js/mypage.js"/>"></script>
</head>
<body style="overflow-x:hidden">

	<!-- 로그인 -->
	<header>
		<%@ include file="../public/topmenu.jsp" %>
	</header>
	
	<!-- 상단로고 -->
	<a href="<c:url value="/home.udo"/>" title="홈으로 이동"><img class="logo" src="<c:url value="/resources/public/logo/mainlogo.png"/>"/></a>
	<div class="top">MyPage</div>

		<!-- 회원정보 -->
		<div class="myinformation">
			<img class="infoline1" src="<c:url value="/resources/user/mypage/images/line.png"/>">
			<br/><b>${member.name}님 환영합니다.</b><br/>
			&emsp;전화번호&ensp;${member.phone} <br>
			&emsp;이메일 &ensp;${member.email}
			<button class="update" onclick="showUpdateForm()">정보수정</button>
			<img class="deer" onclick="goToNotice()" onmouseenter="this.src='<c:url value="/resources/user/mypage/images/bboo.gif"/>'" onmouseleave="this.src='<c:url value="/resources/user/mypage/images/not.png"/>'"  src="<c:url value="/resources/user/mypage/images/not.png"/>">
			
			<img class="infoline2" src="<c:url value="/resources/user/mypage/images/line.png"/>">
		</div>
		
		<!-- 내가찜한방 -->
		<div class="favorites1">
		<label>❣ 내가 찜한 방 ❣</label><a href="#" id="display1" onclick="displayBoard(1)">찜리스트 보이기</a>
			<div class="favorlist">
			<div>
				<img src="<c:url value="/resources/rooms/pome.jpg"/>"><br/><a href="#">방이름</a>
			</div>
			<div>
			<img src="<c:url value="/resources/rooms/samo.jpg"/>"><br/><a href="#">방이름</a></div>
			<div>
			<img src="<c:url value="/resources/rooms/samo.jpg"/>"><br/><a href="#">방이름</a></div>
			<div>
			<img src="<c:url value="/resources/rooms/pome.jpg"/>"><br/><a href="#">방이름</a></div>
			<p>페이징</p>
			</div>
		</div>
		
		
		<!-- 예약 현황 보기-->
		<div class="reservation">
			<label class="reservlabel">※ 예약현황 ※</label><a href="#" id="display2" onclick="displayBoard(2)">현황 보이기</a>
			<div class="rslist">
				<!-- 방없을시 -->
				<c:if test="${fn:length(reserInfo) eq 0}">
				<div class="noroom">
					<img src="<c:url value="/resources/user/mypage/images/noroom.png"/>"><label>예약하신 룸이 없습니다.</label>
				</div>
				</c:if>
				<!-- 방 있으면 -->
				<!-- 최근내역중  -->
				<c:if test="${fn:length(reserInfo) ne 0}">
					<div id="latelyReservList">
					<b>최근 예약 내역</b>
					<table>
						<thead>
							<tr>
								<th>예약하신 날짜</th>
								<th>지점명</th>
								<th>예약하신 룸 이름</th>
								<th>지점 전화번호</th>
								<th>지점주소</th>
								<th>예약 시간</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${reserInfo.get(0).getReservdate()}</td>
								<td>${reserInfo.get(0).getBranchName()}</td>
								<td>${reserInfo.get(0).getRoomName()}</td>
								<td>02.2222.2222</td>
								<td>${reserInfo.get(0).getBranchAddr1()}</td>
								<td>${reserInfo.get(0).getStarttime()}~${reserInfo.get(0).getEndtime()}</td>
								<td>
								<button class="update">취소/환불</button>
								<button class="update" onclick="window.open('${reserInfo.get(0).getReceipt_url()}','window_name','width=500,height=750,location=no,status=no')">영수증</button>
								</td>
							</tr>
							
							<tr>
								<td>${reserInfo.get(0).getReservdate()}</td>
								<td>${reserInfo.get(0).getBranchName()}</td>
								<td>${reserInfo.get(0).getRoomName()}</td>
								<td>02.2222.2222</td>
								<td>${reserInfo.get(0).getBranchAddr1()}</td>
								<td>${reserInfo.get(0).getStarttime()}~${reserInfo.get(0).getEndtime()}</td>
								<td>
								<a class="update">환불요청중</a>
								<button class="update" onclick="window.open('${reserInfo.get(0).getReceipt_url()}','window_name','width=500,height=750,location=no,status=no')">영수증</button>
								</td>
							</tr>
							
							<tr>
								<td>${reserInfo.get(0).getReservdate()}</td>
								<td>${reserInfo.get(0).getBranchName()}</td>
								<td>${reserInfo.get(0).getRoomName()}</td>
								<td>02.2222.2222</td>
								<td>${reserInfo.get(0).getBranchAddr1()}</td>
								<td>${reserInfo.get(0).getStarttime()}~${reserInfo.get(0).getEndtime()}</td>
								<td>
								<label class="update">환불완료</label>
								<button class="update" onclick="window.open('${reserInfo.get(0).getReceipt_url()}','window_name','width=500,height=750,location=no,status=no')">영수증</button>
								</td>
							</tr>
						</tbody>
					</table>
					<ul class="pagcls">
						<li>페</li>
						<li>이</li>
						<li>징</li>
						<li>처</li>
						<li>리</li>
					</ul>
					
				</div>
				
				<label class="lastSearch"><b>지난 예약 조회</b></label>
				<div class="line2">
					<input type="date" id="stdate">&emsp;~&emsp;<input type="date" id="endate">
					&emsp;<button class="update">적용</button>
				</div>
				
				<div id="lastReservList">
				<table>
					<thead>
						<tr>
							<th>지점</th>
							<th>룸</th>
							<th>날짜</th>
							<th>시간</th>
							<th>예약</th>
							<th>비고</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${fn:length(reserInfo) ne 0}">
					<c:if test="${reserInfo.get(1).getBranchName() ne null}">
					<c:forEach  var="reserInfo" items="${reserInfo}">
					<tr>
						<td>${reserInfo.branchName}</td>
						<td><a href="javascript:window.location.href='roomDetail.udo?roomnum=${reserInfo.roomNum}'">${reserInfo.roomName}</a></td>
						<td>${reserInfo.reservdate}</td>
						<td>${reserInfo.starttime}~${reserInfo.endtime}</td>
						<td>예약 완료</td>
						<td>
						<button class="update" onclick="openReview(${reserInfo.roomNum})">리뷰쓰기</button>
						<button class="update" onclick="window.open('${reserInfo.receipt_url}','window_name','width=500,height=750,location=no,status=no')">영수증</button>
						</td>
					</tr>
					</c:forEach>
					</c:if>
					</c:if>
				</tbody>
				</table>
				<ul class="pagcls">
						<li>페</li>
						<li>이</li>
						<li>징</li>
						<li>처</li>
						<li>리</li>
					</ul>
				</div>
				</c:if>
			</div>
		</div>

		<!-- 알림 -->
		<div class="allnon">
		<p class="notification1">☏ 알림 ☏</p>
		<table class="notification2">
			<tbody>
				<tr>
					<td>1</td>
					<td>관리자</td>
					<td>서울지점 예약이 취소되었습니다.</td>
					<td>01.05 11:50</td>
				</tr>
				<tr>
					<td>2</td>
					<td>관리자</td>
					<td>서울지점 환불처리 완료</td>
					<td>12.21 08:00</td>
				</tr>
				<tr>
					<td>3</td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td>4</td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td>5</td>
					<td><br></td>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
				<td colspan="4">
					<ul class="pagcls">
						<li>페</li>
						<li>이</li>
						<li>징</li>
						<li>처</li>
						<li>리</li>
					</ul>
				</td>
				</tr>
			</tbody>
		</table>
		</div>
	
	<!-- 정보수정 div -->
		<div id="upInfo" class="upInfo">
			<form id="update" name="update" action="" method="post">
			<table>
				<tr><td>
					<label>ID</label><br/>
					<input type="text" name="id" id="id" size="30" value="${member.id}" disabled="disabled">
				</td></tr>
				<tr><td>
					<label>PassWord</label><br/>
					<c:if test="${fn:substring(member.id, 0, 2) ne 'k#'}">
					<input type="password" name="pw" id="pw" size="30" value="${member.pw}">
					</c:if>
					<c:if test="${fn:substring(member.id, 0, 2) eq 'k#'}">
					<input type="password" name="pw" id="pw" size="30" disabled="disabled">
					</c:if>
				</td></tr>
				<tr><td>
					<label>Confirm PassWord</label><br/>
					<c:if test="${fn:substring(member.id, 0, 2) ne 'k#'}">
					<input type="password" name="repw" id="repw" size="30">
					</c:if>
					<c:if test="${fn:substring(member.id, 0, 2) eq 'k#'}">
					<input type="password" name="repw" id="repw" size="30" disabled="disabled">
					</c:if>		
				</td></tr>
				<tr><td>
					<label>Name</label><br/>
					<input type="text" name="name" id="name" size="30" value="${member.name}" required="required">
				</td></tr>
				<tr><td>
					<label>Tel [ / '-' 포함 입력 ]</label><br/>
					<input type="text" name="phone" id="phone" size="30" value="${member.phone}" required="required">	
				</td></tr>
				<tr><td>
					<label>birthday [ / 6자리 입력 ex)820215 ]</label><br/>
					<input type="text" name="birth" id="birth" size="30" value="${member.birth}" required="required" disabled="disabled">			
				</td></tr>
				<tr><td>
					<label>Email</label><br/>
					<input type="email" name="email" id="email" size="30" value="${member.email}" required="required">
				</td></tr>
				<tr><td align="center"><br/>
					<button onclick="inputCheck()">수정 완료</button>&emsp;&emsp;<input type="button" onclick="hideUpdateForm()" value="취소">
				</td></tr>
			</table>
		</form>
		</div>
		
		<div class="review">
			<img id="star1" class="star" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star2" class="star" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star3" class="star" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star4" class="star" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star5" class="star" src="<c:url value="/resources/util/unstar.png"/>"/><label>별점 :<b id="starcount">0</b>점</label>
			<img onclick="closeReview()" src="<c:url value="/resources/util/xicon.png"/>"/><br/><br/>
			<input type="text" size="100" placeholder="최대 100자">&nbsp;<button>후기 올리기</button>
		</div>
	
	<!-- footer -->
	<footer>
		<%@ include file="../public/footer.jsp" %>
	</footer>
</body>
</html>