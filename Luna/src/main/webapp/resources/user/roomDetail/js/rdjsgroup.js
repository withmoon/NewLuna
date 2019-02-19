$('document').ready(function($) {
	showSd(3);
});
//날짜에 따른 스케줄
function showSd(num){
	$("#schdule tr td").css({"text-decoration":"","color":""});
	
	var seldate=$("#reservDate").val(); 
	
	$.ajax({      
		type:"GET",  
		url:"getSchedule.udo",    
		data:{roomnum:num, seldate:seldate},     
		success:function(data){
			var sch=data.reservstate;
			//console.log("sch="+sch);
			if(sch==undefined){
				$("#startdate").text("");
				$("#startdate").text(seldate);
				$("#scroomname").text("");
				$("#scroomname").text(" "+$(".roomname"+num).text()+"방");
				
				$(".showSchedule").display="";
				$(".showSchedule").show();
				return;
			}else{
				var splitsch=sch.split(",");
				var spschresult="";
			
				var time="";
				for ( var i in splitsch ) {
					time=(splitsch[i]=='00:00'?"#am1":splitsch[i]=='00:30'?"#am2":
					  splitsch[i]=='01:00'?"#am3":splitsch[i]=='01:30'?"#am4":
					  splitsch[i]=='02:00'?"#am5":splitsch[i]=='02:30'?"#am6":
					  splitsch[i]=='03:00'?"#am7":splitsch[i]=='03:30'?"#am8":
					  splitsch[i]=='04:00'?"#am9":splitsch[i]=='04:30'?"#am10":
					  splitsch[i]=='05:00'?"#am11":splitsch[i]=='05:30'?"#am12":
					  splitsch[i]=='06:00'?"#am13":splitsch[i]=='06:30'?"#am14":
					  splitsch[i]=='07:00'?"#am15":splitsch[i]=='07:30'?"#am16":
					  splitsch[i]=='08:00'?"#am17":splitsch[i]=='08:30'?"#am18":
					  splitsch[i]=='09:00'?"#am19":splitsch[i]=='09:30'?"#am20":
					  splitsch[i]=='10:00'?"#am21":splitsch[i]=='10:30'?"#am22":
					  splitsch[i]=='11:00'?"#am23":splitsch[i]=='11:30'?"#am24":
					  //pm
					  splitsch[i]=='12:00'?"#pm1":splitsch[i]=='12:30'?"#pm2":
					  splitsch[i]=='13:00'?"#pm3":splitsch[i]=='13:30'?"#pm4":
					  splitsch[i]=='14:00'?"#pm5":splitsch[i]=='14:30'?"#pm6":
					  splitsch[i]=='15:00'?"#pm7":splitsch[i]=='15:30'?"#pm8":
					  splitsch[i]=='16:00'?"#pm9":splitsch[i]=='16:30'?"#pm10":
					  splitsch[i]=='17:00'?"#pm11":splitsch[i]=='17:30'?"#pm12":
					  splitsch[i]=='18:00'?"#pm13":splitsch[i]=='18:30'?"#pm14":
					  splitsch[i]=='19:00'?"#pm15":splitsch[i]=='19:30'?"#pm16":
					  splitsch[i]=='20:00'?"#pm17":splitsch[i]=='20:30'?"#pm18":
					  splitsch[i]=='21:00'?"#pm19":splitsch[i]=='21:30'?"#pm20":
					  splitsch[i]=='22:00'?"#pm21":splitsch[i]=='22:30'?"#pm22":
					  splitsch[i]=='23:00'?"#pm23":splitsch[i]=='23:30'?"#pm24":""
				);
				$(time).css({"text-decoration":"line-through double","color":"gray"});
				}
			}
			$("#startdate").text("");
			$("#startdate").text(seldate);
			$(".showSchedule").display="";
			$(".showSchedule").show();
			
		}
	});
}

//찜 , 안찜
function changeChoiceImg(img){
	var image=$("#keep").attr('src');
	if(image.match("notChoiceList.png")){
		$("#keep").attr('src','resources/user/roomDetail/images/choice.png');
	}else{
		$("#keep").attr('src','resources/user/roomDetail/images/notChoiceList.png');
	}
}
//스케줄 예약 예정
$(function(){
$("#schdule tr td").click(function(){
	var txt = $(this).text();
	alert(txt);
});
});

function writeReview(){
	
}