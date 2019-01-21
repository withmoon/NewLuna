<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

#topmenubar{
	color: white;
	float: left;
	margin-left: 3%;
	margin-top: 27px;
	background-color: #A8998C;
}
#topmenubar ul li{
	list-style-type: none;
	float: left;
	font-size: 20px;
}
.topM{
	padding-left: 50px;
	padding-right : 50px;
	border-left: 1px solid black;
	border-right: 1px solid black;
	height: auto;
	text-align: center;
}
#topmenubar li ul{
	background-color: rgba(168,153,140,0.7);
	display: none;
	height: auto;
	padding: 0px;
	margin: 0px;
	margin-left:-50px;
	padding-top :5px;
	position:absolute;
	z-index:200;
	color: black;
}
#topMul1{
	width: 257px;
}
#topMul2{
	width: 207px; 
}
#topmenubar li:hover ul{ 
	display: block;
}
a:link{
	color: black;
	text-decoration: none;
}
a:visited{
 	text-decoration: none;
 	color: black;
 	}
a:hover{
	
}
#topmenubar ul ul li{
	float: none;
	list-style-type: none;
}
	
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<div id="topmenubar">
			<ul>
				<li class="topM">방 추가/삭제/수정
					<ul id="topMul1">
						<li><a href="#">방 추가</a></li>
						<li><a href="#">방 삭제</a></li>
						<li><a href="#">방 수정</a></li>
					</ul>
				</li>
				<li class="topM">게시판 관리
					<ul id="topMul2">
						<li><a href="board.jsp">문의 게시판</a></li>
						<li><a href="#">이벤트 게시판</a></li>
					</ul>
				</li>
				<li><a href="#"></a>
				</li>
				<li><a href=""></a>
				</li>
				<li><a href=""></a>
				</li>
				<li><a href=""></a>
				</li>
			</ul>
		</div>

</body>
</html>