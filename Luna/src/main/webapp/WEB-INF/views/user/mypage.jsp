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
<script src="<c:url value="/resources/user/mypage/js/mypajax.js"/>"></script>

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
			<img class="deer" onclick="goToNotice()" onmouseenter="this.src='<c:url value="/resources/user/mypage/images/bboo.gif"/>'" onmouseleave="this.src='<c:url value="/resources/user/mypage/images/not.png"/>'"  src="<c:url value="/resources/user/mypage/images/not.png"/>">
			<img class="deer2" onclick="goToQandA()" src="<c:url value="/resources/user/mypage/images/que.png"/>" onmouseenter="this.src='<c:url value="/resources/user/mypage/images/queg.gif"/>'" onmouseleave="this.src='<c:url value="/resources/user/mypage/images/que.png"/>'">
			<br/><b>${member.name}님 환영합니다.</b><br/>
			&emsp;전화번호&ensp;${member.phone} <br>
			&emsp;이메일 &ensp;${member.email}
			<button class="update" onclick="showUpdateForm()">정보수정</button>
			
			
			
			<img class="infoline2" src="<c:url value="/resources/user/mypage/images/line.png"/>">
		</div>
		
		<!-- 내가찜한방 keeplist-->
		<div class="favorites1">
		<label>❣ 내가 찜한 방 ❣</label><a href="#" id="display1" onclick="displayBoard(1)">찜리스트 보이기</a>
			<div class="favorlist">
				<div id="nonroom" hidden="true"><!-- 방 없을때만 나옴 -->
					ㅜ찜한방이 아직 없습니다ㅜ
				</div>
			<table id="fvTable"></table>
			<ul id="fvPaging"></ul>
			</div>
		</div>
		
		
		<!-- 예약 현황 보기-->
		<div class="reservation">
			<label class="reservlabel">※ 예약현황 ※</label><a href="#" id="display2" onclick="displayBoard(2)">현황 보이기</a>
			<div class="rslist">
				<!-- 방없을시 -->
				<c:if test="${fn:length(latelyreserInfo) eq 0}">
				<div class="noroom">
					<img src="<c:url value="/resources/user/mypage/images/noroom.png"/>"><label>예약하신 룸이 없습니다.</label>
				</div>
				</c:if>

				<!-- 최근내역중  -->	
				<div id="latelyReservList">
					<b>최근 예약 내역</b><ul id="ltPaging" class="pagcls"></ul>
					<table id="lateTable">
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
						<c:if test="${fn:length(latelyreserInfo) eq 0}">
							<tr><td colspan="7">최근 예약된 방이 없습니다.</td></tr>
						</c:if>
						<c:if test="${fn:length(latelyreserInfo) ne 0}">
							<c:forEach  var="latelyreserInfo" items="${latelyreserInfo}" begin="1" end="${fn:length(lastreserInfo)}" step="1" varStatus="status">
								<tr hidden="true" id="ltd${status.index}" >
									<td>${latelyreserInfo.reservdate}</td>
									<td>${latelyreserInfo.branchName}</td>
									<td>${latelyreserInfo.roomName}</td>
									<td>02.2222.2222</td>
									<td>${latelyreserInfo.branchAddr1}</td>
									<td>${latelyreserInfo.starttime}~${reserInfo.endtime}</td>
									<td id="${latelyreserInfo.imp_uid}">
									<c:if test="${latelyreserInfo.status eq 1}">
										<button class="cancle" onclick='cancleReserve("${member.id}","${latelyreserInfo.imp_uid}",${latelyreserInfo.status})'>취소/환불</button>
										<button class="showRecipe" onclick="window.open('${latelyreserInfo.receipt_url}','window_name','width=500,height=750,location=no,status=no')">영수증</button>
									</c:if>
									<c:if test="${latelyreserInfo.status eq -2}">
										<label>환불요청중</label>
									</c:if>
									<c:if test="${latelyreserInfo.status eq -1}">
										<<label>환불완료</label>
									</c:if>
									</td>
								</tr>
							</c:forEach>
						</c:if>
						</tbody>
					</table>
				</div>
				
				<label class="lastSearch"><b>지난 예약 조회</b></label>
				<div class="line2">
					<input type="date" id="stdate">&emsp;~&emsp;<input type="date" id="endate">
					&emsp;<button class="update">적용</button>
				</div>
				
				<div id="lastReservList">
				<table id="lastTable">
					<thead>
						<tr>
							<th>날짜</th>
							<th>시간</th>
							<th>지점</th>
							<th>룸</th>
							<th>비고</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${fn:length(lastreserInfo) eq 0}">
						<tr><td colspan="7">6개월간 예약된 방이 없습니다.</td></tr>
					</c:if>
					<c:if test="${fn:length(lastreserInfo) ne 0}">
						<c:forEach  var="lastreserInfo" items="${lastreserInfo}" begin="1" end="${fn:length(lastreserInfo)}" step="1" varStatus="status">
						<tr hidden="true" id="ld${status.index}">
							<td>${lastreserInfo.reservdate}</td>
							<td>${lastreserInfo.starttime}~${lastreserInfo.endtime}</td>
							<td>${lastreserInfo.branchName}</td>
							<td><a href="javascript:window.location.href='roomDetail.udo?roomnum=${lastreserInfo.roomNum}'">${lastreserInfo.roomName}</a></td>
							<td>
							<button class="reviewBtn${lastreserInfo.imp_uid}" onclick="openReview(${lastreserInfo.roomNum})">리뷰쓰기</button>
							<button onclick="window.open('${lastreserInfo.receipt_url}','window_name','width=500,height=750,location=no,status=no')">영수증</button>
							</td>
						</tr>
						</c:forEach>
					</c:if>
				</tbody>
				</table>
				<ul id="lastPaging" class="lppagcls"></ul>
				</div>
			</div>
		</div>

		<!-- 알림 -->
		<div class="allnon">
		<p class="notification1">☏ 알림 ☏</p> <ul class="pagcls"><li>페</li><li>이</li><li>징</li><li>처</li><li>리</li></ul>
		<table class="notification2">
			<tbody>
			<c:if test="${fn:length(alamlist) eq 0}">
				<tr><td colspan="4">알림이 없습니다.</td></tr>
			</c:if>
			<c:if test="${fn:length(alamlist) ne 0}">
				<c:forEach  var="alamlist" items="${alamlist}">
					<tr> 
						<!-- 읽은거는 color처리 -->
						<c:if test="${alamlist.readst eq 1}">
							<td style="color:gray">${alamlist.fromwho}</td>
							<td style="color:gray">${alamlist.content}</td>
							<td style="color:gray">${alamlist.almdate}</td>
						</c:if>
						<!-- 안 읽은거 colorX -->
						<c:if test="${alamlist.readst eq 0}">
							<td class="conf${alamlist.seq}">${alamlist.fromwho}</td>
							<td class="conf${alamlist.seq}">${alamlist.content}</td>
							<td class="conf${alamlist.seq}">${alamlist.almdate}</td>
						</c:if>
						
						<td>
							<c:if test="${alamlist.readst eq 0 and alamlist.numforwhat ne -1}">
								<button id="conf${alamlist.seq}" onclick="confirmCancle(${alamlist.seq})">확인완료</button>
							</c:if>
							<c:if test="${alamlist.numforwhat eq -1}">
								<button onclick="openElse(${alamlist.seq},'${alamlist.content}','${alamlist.fromwhat}')">내용보기</button>
							</c:if>
						</td>						
					</tr>
				</c:forEach>
			</c:if>
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
		<!-- 리뷰 받는 div -->
		<div class="review">
			<img id="star1" class="star" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star2" class="star" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star3" class="star" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star4" class="star" src="<c:url value="/resources/util/unstar.png"/>"/>
			<img id="star5" class="star" src="<c:url value="/resources/util/unstar.png"/>"/><label>별점 :<b id="starcount">0</b>점</label>
			<img onclick="closeReview()" src="<c:url value="/resources/util/xicon.png"/>"/><br/><br/>
			<input type="text" size="100" placeholder="최대 100자">&nbsp;<button onclick="writeReview()">후기 올리기</button>
		</div>
		
		<!-- 환불요청 div -->
		<div class="ccReserDiv">
			정말로 환불하시겠습니까?<br/><br/>
			<button onclick="goCancle()">예</button> <button onclick="noCancle()">아니요</button>
		</div>
		
		<!-- 알림 else 내용  -->
		<div id="showElse" class="showElse">
			<table>
				<tr>
					<td>제목</td>
					<td><input id="elsett" type="text" size="30" disabled="disabled"/></td>
				</tr>
				<tr align="center">
					<td colspan="2">내용</td>
				</tr>
				<tr>
				<td colspan="2"><textarea id="elsect" cols="43" rows="14" disabled="disabled"></textarea></td>
				</tr>
				<tr align="center">
					<td id="elsebtn" colspan="2"><button onclick="closeElse()">닫기</button></td>
				</tr>
			</table>
		</div>
	<script src="<c:url value="/resources/user/mypage/js/pageajax.js"/>"></script>
	<!-- footer -->
	<footer>
		<%@ include file="../public/footer.jsp" %>
	</footer>
</body>
</html>