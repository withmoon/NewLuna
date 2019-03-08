<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"></c:url>"></script>
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/material.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
	
<meta charset="UTF-8">  
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/manager/css/manager2.css"/>"></link>
<style type="text/css">
header {
	border-bottom: 1px solid blue;
	width: auto;
	text-align: left;
	padding-left: 10px;
	padding-top: 30px;
	font-size: 20pt;
}
#chartdiv {
  width: 100%;
  height: 500px;
}
</style>

<!-- Chart code -->
<script>
var paid_at_start="";
var paid_at_end="";

$(function(){
	getTermSales();
});
	

	
function getTermSales(){
	
	paid_at_start=$("#paid_at_start").val();
	paid_at_end=$("#paid_at_end").val();
		$.ajax({
			type : "POST",
			url : "mgTime2.mdo",
			data : {paid_at_start:paid_at_start, paid_at_end:paid_at_end},
			success : function(vo) {
				alert(vo);
			}
			
			
		});
		
		$.ajax({
			  
			 type : "POST", 
			 url: "mgchart.mdo", 
			 data:{paid_at_start:paid_at_start, paid_at_end:paid_at_end},     
			success:function(A){
		        
				// Themes begin
				am4core.useTheme(am4themes_material);
				am4core.useTheme(am4themes_animated);
				// Themes end
				var chart = am4core.create("chartdiv", am4charts.XYChart);
				
				//데이터 배열
				//데이터값?
				//데이터 삽입 시작
				var data = [];
				var value = 0;
			
				for(var i = 0; i <A.length; i++){
				  var date = new Date(A[i].reservdate);
				  value=A[i].su;
				  data.push({date:date, value: value});
				}
				
				//차트에 데이터
				chart.data = data;
				
				//축 생성
				// Create axes
				var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
				dateAxis.renderer.minGridDistance = 60;
				
				var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
				
				
				// 시리즈 만들기??
				// Create series
				var series = chart.series.push(new am4charts.LineSeries());
				series.dataFields.valueY = "value";
				series.dataFields.dateX = "date";
				series.tooltipText = "{value}"
				
				series.tooltip.pointerOrientation = "vertical";
				
				chart.cursor = new am4charts.XYCursor();
				chart.cursor.snapToSeries = series;
				chart.cursor.xAxis = dateAxis;
				
				//chart.scrollbarY = new am4core.Scrollbar();
				chart.scrollbarX = new am4core.Scrollbar();
								}
					});
		
}
					</script>


<title>지점장 관리화면</title>
</head>
<body>
	<!-- 상단바 -->
	<nav id="TopNav">
		<!-- 상단 탭 -->
		<div id="TopMenu1">
			<!-- 좌측상단 로고 -->
			<div id="letflogo">
				<a href="manager.mdo"><img class="logo"
					src="<c:url value="/resources/manager/images/mainlogo2.png"/>" /></a>
			</div>
			<jsp:include page="/WEB-INF/views/manager/form/TopMenu1.jsp"></jsp:include>
		</div>
		<%-- <div id="TopMenu2">
					<jsp:include page="form/TopMenu2.jsp" />
				</div> --%>
	</nav>

	<!-- 배경 -->
	<div id="border">
		<!-- 왼측1 사이드 -->
		<div id="left1div">
			<div id="search">
				<jsp:include page="/WEB-INF/views/manager/form/search.jsp" />
			</div>
			<aside id="left1">
				<jsp:include page="/WEB-INF/views/manager/form/left1_menu.jsp"></jsp:include>
			</aside>
		</div>
		<!-- 중앙세션 -->
		<section id="msec">
			<div id=header>
				<header>기간 통계</header>
			</div>
			
			 <div class="searchArea">
			 <input id="paid_at_start"  type="date"/><br/>
			 <input id="paid_at_end" type="date"/>&emsp; 
			 <button onclick="getTermSales()">검색</button>
			 </div>
			<table width="100%" border="1">
				<tr>
					<td>기간</td>
					<td>TIME</td>
					<td>예약횟수 &nbsp; ${vo.asum }회</td>
					<td>퍼센트</td>
				</tr>
				<tr>
					<td rowspan="12">???일</td>
					<td rowspan="1">AM 8:00-9:59</td>
					<td>${vo.a08 + vo.a09}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a08+vo.a09)) }" pattern="#.##"/>%</td>
					
				</tr>
				<tr>
					<td>AM 10:00-11:59</td>
					<td>${vo.a10 + vo.a11}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a10 + vo.a11)) }" pattern="#.##"/>%</td>
				</tr>
				<tr>
					<td>PM 12:00-13:59</td>
					<td>${vo.a12 + vo.a13}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a12 + vo.a13)) }" pattern="#.##"/>%</td>
				</tr>
				<tr>
					<td>PM 14:00-15:59</td>
					<td>${vo.a14 + vo.a15}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a14 + vo.a15)) }" pattern="#.##"/>%</td>
				</tr>
				<tr>
					<td>PM 16:00-17:59</td>
					<td>${vo.a16 + vo.a17}</td>
					<td><fmt:formatNumber value="${100/(vo.asum / (vo.a16 + vo.a17)) }" pattern="#.##"/>%</td>
				</tr>
				<tr>
					<td>PM 18:00-19:59</td>
					<td>${vo.a18 + vo.a19}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a18 + vo.a19)) }" pattern="#.##"/>%</td>
				</tr>
				<tr>
					<td>PM 20:00-21:59</td>
					<td>${vo.a20 + vo.a21}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a20 + vo.a21)) }" pattern="#.##"/>%</td>
				</tr>
				<tr>
					<td>PM 22:00-23:59</td>
					<td>${vo.a22 + vo.a23}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a22 + vo.a23)) }" pattern="#.##"/>%</td>
				</tr>
				<tr>
					<td>PM 24:00-01:59</td>
					<td>${vo.a00 + vo.a01}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a00 + vo.a01)) }" pattern="#.##"/>%</td>
				</tr>
				<tr>
					<td>AM 02:00-03:59</td>
					<td>${vo.a02 + vo.a03}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a02 + vo.a03)) }" pattern="#.##"/>%</td>
				</tr>
				<tr>
					<td>AM 04:00-05:59</td>
					<td>${vo.a04 + vo.a05}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a04 + vo.a05)) }" pattern="#.##"/>%</td>
				</tr>
				<tr>
					<td>AM 06:00-07:59</td>
					<td>${vo.a06 + vo.a07}</td>
					<td><fmt:formatNumber value="${100/(vo.asum/(vo.a06 + vo.a07)) }" pattern="#.##"/>%</td>
				</tr>
			</table>

			<div id=header>
				<header>시간별 예약 통계</header>
			</div>
			
			<!-- HTML -->
			<div id="chartdiv"></div>

			

		</section>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/manager/form/footer.jsp"></jsp:include>
	</footer>
</body>

</html>