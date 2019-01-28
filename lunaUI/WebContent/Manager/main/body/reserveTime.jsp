<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>예약 시간대</title>
</head>
<body>
	
	<!-- 나이대별 예약 확인 테이블 -->
	<h2>AGE</h2>
	<table width="80%" border="1">
		<tr>
			<td>연령대/예약</td>
			<td>예약</td>
			<td>금액</td>
			<td>건수</td>
			<td>비율</td>
			<td>합계</td>
		</tr>
		<tr>
			<td rowspan="4">10대</td>
			<td>1인</td>
			<td>15%</td>
			<td>남성:여성</td>
			<td>1:3</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>15%</td>
			<td>20(예약)</td>
			<td>3</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>2</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>0</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">20대</td>
			<td>1인</td>
			<td>18000</td>
			<td>50</td>
			<td>3</td>
			<td>900000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>50</td>
			<td>3</td>
			<td>900000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>18000</td>
			<td>50</td>
			<td>3</td>
			<td>900000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>18000</td>
			<td>50</td>
			<td>1</td>
			<td>900000</td>
		</tr>
		<tr>
			<td rowspan="4">30대</td>
			<td>1인</td>
			<td>18000</td>
			<td>20</td>
			<td>2</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>2</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td rowspan="4">40대</td>
			<td>1인</td>
			<td>18000</td>
			<td>10</td>
			<td>1</td>
			<td>180000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>10</td>
			<td>1</td>
			<td>180000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>18000</td>
			<td>10</td>
			<td>1</td>
			<td>180000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>18000</td>
			<td>10</td>
			<td>1</td>
			<td>180000</td>
		</tr>
		<tr>
			<td rowspan="4">50대</td>
			<td>1인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>27000</td>
			<td>10</td>
			<td>2</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>27000</td>
			<td>10</td>
			<td>0</td>
			<td>270000</td>
		</tr>
		<tr>
			<td rowspan="4">60대</td>
			<td>1인</td>
			<td>36000</td>
			<td>10</td>
			<td>0</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>36000</td>
			<td>10</td>
			<td>0</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>36000</td>
			<td>10</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>10</td>
			<td>1</td>
			<td>360000</td>
		</tr>
	</table>
	<br>
	
	<!-- 시간대별 예약 확인 테이블 -->
	<h2>TIME</h2>
	<table width="80%" border="1">
		<tr>
			<td>시간대/매출</td>
			<td>인실</td>
			<td>금액</td>
			<td>건수</td>
			<td>환불</td>
			<td>합계</td>
		</tr>
		<tr>
			<td rowspan="4">AM 8:00 - 9:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20(매장방문)</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20(예약)</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">AM 9:00 - 10:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">AM 10:00 - 11:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">AM 11:00 - 12:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">PM 12:00 - 1:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">PM 1:00 - 2:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">PM 2:00 - 3:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">PM 3:00 - 4:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">PM 4:00 - 5:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">PM 5:00 - 6:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">PM 6:00 - 7:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">PM 7:00 - 8:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">PM 8:00 - 9:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
		<tr>
			<td rowspan="4">PM 9:00 - 10:00</td>
			<td>1인</td>
			<td>10000</td>
			<td>20</td>
			<td>1</td>
			<td>200000</td>
		</tr>
		<tr>
			<td>2인</td>
			<td>18000</td>
			<td>20</td>
			<td>1</td>
			<td>360000</td>
		</tr>
		<tr>
			<td>3인</td>
			<td>27000</td>
			<td>10</td>
			<td>1</td>
			<td>270000</td>
		</tr>
		<tr>
			<td>4인</td>
			<td>36000</td>
			<td>20</td>
			<td>1</td>
			<td>720000</td>
		</tr>
	</table>
</body>
</html>