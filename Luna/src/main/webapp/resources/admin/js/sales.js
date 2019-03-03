var paid_at_start="";
var paid_at_end="";

$(function(){
	/*
	// Themes begin
	am4core.useTheme(am4themes_animated);
	// Themes end

	var chart = am4core.create("chartdiv", am4charts.XYChart);
	
	//데이터 삽입 시작
	var data = [];
	var value = 0;
	for(let i = 0; i <300; i++){
	  let date = new Date('2019-03-01 11:12');
	  console.log(date);
	  value -= Math.round((Math.random() < 0.5 ? 1 : -1) * Math.random() * 10);
	  data.push({date:date, value: value});
	}

	//date==날짜   value==날짜에 해당하는 값
	
	
	chart.data = data;

	// Create axes
	var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
	dateAxis.renderer.minGridDistance = 60;

	var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

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
	*/
	getTermSales(); //나중에 마지노선 변경 만들예정
});
function getTermSales(){
	paid_at_start=$("#paid_at_start").val();
	paid_at_end=$("#paid_at_end").val();
	$.ajax({      
		type:"GET",  
		url:"getTermSales.do",    
		data:{paid_at_start:paid_at_start, paid_at_end:paid_at_end},     
		success:function(res){
			// Themes begin
			am4core.useTheme(am4themes_animated);
			// Themes end

			var chart = am4core.create("chartdiv", am4charts.XYChart);
			
			//데이터 삽입 시작
			var data = [];
			var value = 0;
			console.log(res.length+" ㅏㅇㅇ "+res[0].paid_at+" df "+res[0].payAmount);
			for(var i = 0; i <res.length; i++){
			  var date = new Date(res[i].paid_at);
			  value=res[i].payAmount;
			  data.push({date:date, value: value});
			}

			//date==날짜   value==날짜에 해당하는 값
			
			
			chart.data = data;

			// Create axes
			var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
			dateAxis.renderer.minGridDistance = 60;

			var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

			// Create series
			var series = chart.series.push(new am4charts.LineSeries());
			series.dataFields.valueY = "value";
			series.dataFields.dateX = "date";
			series.tooltipText = "{value}"

			series.tooltip.pointerOrientation = "vertical";
			
			var range = valueAxis.createSeriesRange(series);
			range.value = 0;
			range.endValue = res[0].baseline;
			range.contents.stroke = am4core.color("#FF0000");
			range.contents.fill = range.contents.stroke;

			chart.cursor = new am4charts.XYCursor();
			chart.cursor.snapToSeries = series;
			chart.cursor.xAxis = dateAxis;

			//chart.scrollbarY = new am4core.Scrollbar();
			chart.scrollbarX = new am4core.Scrollbar();
			
		}
	});
}