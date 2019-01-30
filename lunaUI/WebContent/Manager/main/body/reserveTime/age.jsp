<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
header {
	border-bottom: 1px solid blue;
	width: auto;
	text-align: left;
	padding-left: 10px;
	padding-top: 30px;
	font-size: 20pt;
}
</style>
<!-- 구글 차트 스크립트 -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(drawVisualization);

	function drawVisualization() {
		/* 데이터를 DB에서 연동해 받아온 값에 대한 차트 데이터 구성하기 */
		var data = google.visualization.arrayToDataTable([
				[ '   월     ', ' 1인  ', ' 2인 ', ' 4인 ', '6인', '15인', '성인수' ],
				[ '2004/05', 165, 938, 522, 998, 450, 614.6 ],
				[ '2005/06', 135, 1120, 599, 1268, 288, 682 ],
				[ '2006/07', 157, 1167, 587, 807, 397, 623 ],
				[ '2007/08', 139, 1110, 615, 968, 215, 609.4 ],
				[ '2008/09', 136, 691, 629, 1026, 366, 569.6 ] ]);

		var options = {
			/* 이름 , 세로명 , 가로명 ,기본타입 '바'차트 ,5번째를 라인차트로 */
			title : '기간별 차트표',
			vAxis : {
				title : '이용수'
			},
			hAxis : {
				title : '월'
			},
			seriesType : 'bars', /* 이걸 변경해서 차트형식 변경가능 */
			series : {
				5 : {
					type : 'line'
				}
			}
		/* 5번째 차트를 라인형으로 변경 */
		};

		var chart = new google.visualization.ComboChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>


<title>예약 시간대</title>
</head>
<body>

	<!-- 시간대별 예약 확인 테이블 -->
	<h2>연령대</h2>
	<table width="80%" border="1">
		<tr>
			<td>연령/예약</td>
			<td>TIME</td>
			<td>인실</td>
			<td>예약수치</td>
		</tr>
		<tr>
			<td rowspan="16">10대</td>
			<td rowspan="4">AM 8:00-9:00</td>
			<td>1인</td>
			<td>15%</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>35%</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>25%</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>25%</td>
		</tr>
		<tr>
			<td rowspan="4">AM 9:00-10:00</td>
			<td>1인</td>
			<td>15%</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>35%</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>25%</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>25%</td>
		</tr>
		<tr>
			<td rowspan="4">AM 10:00-11:00</td>
			<td>1인</td>
			<td>15%</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>35%</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>25%</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>25%</td>
		</tr>
		<tr>
			<td rowspan="4">AM 11:00-12:00</td>
			<td>1인</td>
			<td>15%</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>35%</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>25%</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>25%</td>
		</tr>
	</table>
	
	<div id=header>
		<header>연령별 예약 시간 통계</header>
	</div>

	<div id="chart_div" style="width: 900px; height: 500px;"></div>
</body>
</html>