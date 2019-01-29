<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

#chartdiv {
  width: 1650px;
  height: 600px;
  font-size: 20px;
}

.amcharts-export-menu-top-right {
  top: 10px;
  right: 0;
}

</style>

<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>



<meta charset="UTF-8">
<title>달빛 관리자페이지</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/sales.css"/>" />
<body>
   <h1 id="bold">달빛</h1>
   <p id="bod">'공부하기 좋은 탁트인 창가'</p>
   
   <nav>
      <ul>
         <li><a href="administrator.html">홈</a></li>
         <li><a href="sales.jsp">매출현황</a></li>
         <li><a href="administrator.html">지점장승인</a></li>
         <li><a href="board.html">문의게시판</a></li>
         <li><a href="member.html">회원관리</a></li>
      </ul>
   </nav>
   
   
   <table>
   <tr>
   <td>
   
   
   <aside id="left">
   <h4>카테고리</h4>
   <ul id="u_left">
   <li><a target="page1" href="administrator.html">홈으로 가기</a></li>
   <li><a target="page1" href="sales.jsp">매출현황</a></li>
   <li><a target="page1" href="administrator.html">지점장승인</a></li>
   <li><a target="page1" href="board.html">문의게시판</a></li>
   <li><a target="page1" href="member.html">회원관리 게시판</a></li>
   </ul>
   </aside>
   </td>
   
   <td id="chart">
   <div align="center">
      <h3>매출현황</h3>
   </div>


<div id="chartdiv"></div>
   

   <table align="center">
      <td>왕십리점 총매출</td>
   </table>

</td>
</tr>
</table>
   <footer id="bottom">
      서울특별시 종로구 종각동 856-92<br>Copyright (c) 2018 달빛스터디카페
   </footer>
</head>

<script>
// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end



// Create chart instance
var chart = am4core.create("chartdiv", am4charts.XYChart);
chart.scrollbarX = new am4core.Scrollbar();

// Add data
chart.data = [{
  "country": "1",
  "visits": 1000
}, {
  "country": "2",
  "visits": 800
}, {
  "country": "3",
  "visits": 1200
}, {
  "country": "4",
  "visits": 1250
}, {
  "country": "5",
  "visits": 1400
}, {
  "country": "6",
  "visits": 1500
}, {
  "country": "7",
  "visits": 1440
}, {
  "country": "8",
  "visits": 1600
}, {
  "country": "9",
  "visits": 1500
}, {
  "country": "10",
  "visits": 1800
}, {
  "country": "11",
  "visits": 2000
}, {
  "country": "12",
  "visits": 2500
}];

// Create axes
var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
categoryAxis.dataFields.category = "country";
categoryAxis.renderer.grid.template.location = 0;
categoryAxis.renderer.minGridDistance = 30;
categoryAxis.renderer.labels.template.horizontalCenter = "right";
categoryAxis.renderer.labels.template.verticalCenter = "middle";
categoryAxis.renderer.labels.template.rotation = 270;
categoryAxis.tooltip.disabled = true;
categoryAxis.renderer.minHeight = 110;

var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
valueAxis.renderer.minWidth = 50;

// Create series
var series = chart.series.push(new am4charts.ColumnSeries());
series.sequencedInterpolation = true;
series.dataFields.valueY = "visits";
series.dataFields.categoryX = "country";
series.tooltipText = "[{categoryX}: bold]{valueY}[/]";
series.columns.template.strokeWidth = 0;

series.tooltip.pointerOrientation = "vertical";

series.columns.template.column.cornerRadiusTopLeft = 10;
series.columns.template.column.cornerRadiusTopRight = 10;
series.columns.template.column.fillOpacity = 0.8;

// on hover, make corner radiuses bigger
let hoverState = series.columns.template.column.states.create("hover");
hoverState.properties.cornerRadiusTopLeft = 0;
hoverState.properties.cornerRadiusTopRight = 0;
hoverState.properties.fillOpacity = 1;

series.columns.template.adapter.add("fill", (fill, target)=>{
  return chart.colors.getIndex(target.dataItem.index);
})

// Cursor
chart.cursor = new am4charts.XYCursor();
</script>


</body>
</html>