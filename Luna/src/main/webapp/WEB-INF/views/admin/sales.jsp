<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<style>

#chartdiv {
  width: 1200px;
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
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin/sales.css"/>" />


<title>승인 페이지</title>
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
            <img src="<c:url value="/resources/admin/달빛.png"/>" width="100" height="100">
         </div>
      </div>
      <div class="collapse navbar-collapse"
         id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
           
            <li><a href="sales.ado">판매현황</a></li>
            <li><a href="info.ado">지점장정보/승인</a></li>
            <li><a href="board.ado">문의게시판</a></li>
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
                   <li class="active"><a href="adminmail.ado">공지알림</a></li>
               </ul></li>
         </ul>
      </div>
   </nav>
   
<table>
   <tr>
   <td>
   
   
   <aside id="left">
   <h4><strong>카테고리</strong></h4>
   <form action="search" method="post">
   <table>
  <tr>
  <td><input type="text" id="search" placeholder="검색어 입력"></td>
  <td><button id="img-button" type="submit" onclick="#"></button></td></tr>
    </table>
   </form>
   <ul id="u_left">
   <li><a target="page1" href="administrator.ado">홈으로 가기</a></li>
   <li><a target="page1" href="sales.ado">매출현황</a></li>
   <li><a target="page1" href="administrator.ado">지점장승인</a></li>
   <li><a target="page1" href="board.ado">자주묻는질문</a></li>
   <li><a target="page1" href="gongji.ado">공지사항</a></li>
   <li><a target="page1" href="event.ado">이벤트</a></li>
   <li><a target="page1" href="member.ado">회원관리</a></li>
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

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
</body>
</html>