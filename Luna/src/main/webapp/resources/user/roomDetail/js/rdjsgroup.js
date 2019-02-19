var rnum=getParameterByName('roomnum'); //방번호 가져오기

var reservtime="";
var count=0;

$('document').ready(function($) {
	showSd(rnum);
	writeReview(rnum);
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
					var time=getSelTime(splitsch[i]);
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

	var sel_time=getSelTime(txt);
	var backcolor = $(sel_time).css("background-color");
	var color=$(sel_time).css("color");
	
	if(color=='rgb(128, 128, 128)'){
		color='';
		return;
	}
	
	if(backcolor=='rgb(255, 255, 0)'){
		$(sel_time).css("background-color","white");
		var sptime=reservtime.split(txt+",");
		reservtime=sptime[0]+sptime[1];
		count--;
	}else{
		$(sel_time).css("background-color","yellow");
		if(reservtime==undefined){ reservtime=txt+",";} 
		else{reservtime+=txt+",";}
		count++;
	}
	var roomprice=$("#payPrice").val();
	var realprice=roomprice*count;
	$(".payArea").text("☆가격☆ ￦"+realprice);
	$("#payAmount").val(realprice);
	$("#reserveTime").val(reservtime);
	
});
});


function getSelTime(txt){
	var sel_time=(txt=='00:00'?"#am1":txt=='00:30'?"#am2":
	txt=='01:00'?"#am3":txt=='01:30'?"#am4":
	txt=='02:00'?"#am5":txt=='02:30'?"#am6":
	txt=='03:00'?"#am7":txt=='03:30'?"#am8":
	txt=='04:00'?"#am9":txt=='04:30'?"#am10":
	txt=='05:00'?"#am11":txt=='05:30'?"#am12":
	txt=='06:00'?"#am13":txt=='06:30'?"#am14":
	txt=='07:00'?"#am15":txt=='07:30'?"#am16":
	txt=='08:00'?"#am17":txt=='08:30'?"#am18":
	txt=='09:00'?"#am19":txt=='09:30'?"#am20":
	txt=='10:00'?"#am21":txt=='10:30'?"#am22":
	txt=='11:00'?"#am23":txt=='11:30'?"#am24":
	//pm
	txt=='12:00'?"#pm1":txt=='12:30'?"#pm2":
	txt=='13:00'?"#pm3":txt=='13:30'?"#pm4":
	txt=='14:00'?"#pm5":txt=='14:30'?"#pm6":
	txt=='15:00'?"#pm7":txt=='15:30'?"#pm8":
	txt=='16:00'?"#pm9":txt=='16:30'?"#pm10":
	txt=='17:00'?"#pm11":txt=='17:30'?"#pm12":
	txt=='18:00'?"#pm13":txt=='18:30'?"#pm14":
	txt=='19:00'?"#pm15":txt=='19:30'?"#pm16":
	txt=='20:00'?"#pm17":txt=='20:30'?"#pm18":
	txt=='21:00'?"#pm19":txt=='21:30'?"#pm20":
	txt=='22:00'?"#pm21":txt=='22:30'?"#pm22":
	txt=='23:00'?"#pm23":txt=='23:30'?"#pm24":"");
 return sel_time;
}

function writeReview(){
	$.ajax({      
		type:"GET",  
		url:"getRoomAllReview.udo",    
		data:{roomnum:rnum},     
		success:function(data){
			$(".rbox").remove();
			var strDom="";
			for(var i=0; i<data.length; i++){
				strDom+='<div class="rbox">';
				strDom+='작성자 : '+data[i].name+'<br/>';
				strDom+='작성날짜 : '+data[i].writedate+'<br/><br/>';
				strDom+=data[i].reviewContent+'<br/>';
				strDom+='</div>'
			}
			$('#rboxsec').append(strDom);
		}
	});
}

//url가져온는 function
function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    return results[2];
}