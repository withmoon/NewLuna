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
					var time=getSelTime(getTimeTxt(splitsch[i]));
					//var time=getSelTime(splitsch[i]);
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

	var sel_time=getSelTime(getTimeTxt(txt));
	var backcolor = $(sel_time).css("background-color");
	var color=$(sel_time).css("color");
	
	if(color=='rgb(128, 128, 128)'){
		color='';
		return;
	}
	
	if(backcolor=='rgb(255, 255, 0)'){
		$(sel_time).css("background-color","white");
		var sptime=reservtime.split(getTimeTxt(txt)+",");
		reservtime=sptime[0]+sptime[1];
		count--;
	}else{
		$(sel_time).css("background-color","yellow");
		if(reservtime==undefined||reservtime==''){ reservtime=getTimeTxt(txt)+",";} 
		else{reservtime+=getTimeTxt(txt)+",";}
		count++;
	}
	var roomprice=$("#payPrice").val();
	var realprice=roomprice*count;
	$(".payArea").text("☆가격☆ ￦"+realprice);
	$("#payAmount").val(realprice);
	$("#reserveTime").val(reservtime);
	
	console.log(reservtime+" count 치사량=>"+count);
	
});
});

function getTimeTxt(txt){
	var resert=(txt=='00:00'?"0000":txt=='00:30'?"0030":
	txt=='01:00'?"0100":txt=='01:30'?"0130":
	txt=='02:00'?"0200":txt=='02:30'?"0230":
	txt=='03:00'?"0300":txt=='03:30'?"0330":
	txt=='04:00'?"0400":txt=='04:30'?"0430":
	txt=='05:00'?"0500":txt=='05:30'?"0530":
	txt=='06:00'?"0600":txt=='06:30'?"0630":
	txt=='07:00'?"0700":txt=='07:30'?"0730":
	txt=='08:00'?"0800":txt=='08:30'?"0830":
	txt=='09:00'?"0900":txt=='09:30'?"0930":
	txt=='10:00'?"1000":txt=='10:30'?"1030":
	txt=='11:00'?"1100":txt=='11:30'?"1130":
	//pm
	txt=='12:00'?"1200":txt=='12:30'?"1230":
	txt=='13:00'?"1300":txt=='13:30'?"1330":
	txt=='14:00'?"1400":txt=='14:30'?"1430":
	txt=='15:00'?"1500":txt=='15:30'?"1530":
	txt=='16:00'?"1600":txt=='16:30'?"1630":
	txt=='17:00'?"1700":txt=='17:30'?"1730":
	txt=='18:00'?"1800":txt=='18:30'?"1830":
	txt=='19:00'?"1900":txt=='19:30'?"1930":
	txt=='20:00'?"2000":txt=='20:30'?"2030":
	txt=='21:00'?"2100":txt=='21:30'?"2130":
	txt=='22:00'?"2200":txt=='22:30'?"2230":
	txt=='23:00'?"2300":txt=='23:30'?"2330":txt);
 return resert;
}

function getSelTime(txt){
	var sel_time=(txt=='0000'?"#am1":txt=='0030'?"#am2":
	txt=='0100'?"#am3":txt=='0130'?"#am4":
	txt=='0200'?"#am5":txt=='0230'?"#am6":
	txt=='0300'?"#am7":txt=='0330'?"#am8":
	txt=='0400'?"#am9":txt=='0430'?"#am10":
	txt=='0500'?"#am11":txt=='0530'?"#am12":
	txt=='0600'?"#am13":txt=='0630'?"#am14":
	txt=='0700'?"#am15":txt=='0730'?"#am16":
	txt=='0800'?"#am17":txt=='0830'?"#am18":
	txt=='0900'?"#am19":txt=='0930'?"#am20":
	txt=='1000'?"#am21":txt=='1030'?"#am22":
	txt=='1100'?"#am23":txt=='1130'?"#am24":
	//pm
	txt=='1200'?"#pm1":txt=='1230'?"#pm2":
	txt=='1300'?"#pm3":txt=='1330'?"#pm4":
	txt=='1400'?"#pm5":txt=='1430'?"#pm6":
	txt=='1500'?"#pm7":txt=='1530'?"#pm8":
	txt=='1600'?"#pm9":txt=='1630'?"#pm10":
	txt=='1700'?"#pm11":txt=='1730'?"#pm12":
	txt=='1800'?"#pm13":txt=='1830'?"#pm14":
	txt=='1900'?"#pm15":txt=='1930'?"#pm16":
	txt=='2000'?"#pm17":txt=='2030'?"#pm18":
	txt=='2100'?"#pm19":txt=='2130'?"#pm20":
	txt=='2200'?"#pm21":txt=='2230'?"#pm22":
	txt=='2300'?"#pm23":txt=='2330'?"#pm24":txt);
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