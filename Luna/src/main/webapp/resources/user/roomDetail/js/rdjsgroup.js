var rnum=getParameterByName('roomnum'); //방번호 가져오기
var reservtime="";
var count=0;
var userid='';
var seldate='';
var incount=0;
$('document').ready(function($) {
	incount=1;
	showSd(rnum);
	showReview(1);
	userid = '@Request.RequestContext.HttpContext.Session["member"]';
});
//날짜에 따른 스케줄
function showSd(num){
	$("#daumschdule").hide();
	$("#schdule tr td").css({"text-decoration":"","color":""});
	
	seldate=$("#reservDate").val(); 
	
	$("#reservdate").val(seldate); 
	
	$.ajax({      
		type:"GET",  
		url:"getSchedule.udo",    
		data:{roomnum:num, seldate:seldate},     
		success:function(data){
			var sch=data.reservstate;
			if(sch==undefined){
				schClickReset();
				if(incount>=2){
					alert("적용되었습니다.");
				}
				$("#startdat").text("");
				$("#startdat").text(seldate);
				$("#scroomname").text("");
				$("#scroomname").text(" "+$(".roomname"+num).text()+"방");
				
				$(".showSchedule").display="";
				$(".showSchedule").show();
				incount++;
				return;
			}else{
				schClickReset();
				if(incount>=2){
					alert("적용되었습니다.");
				}
				var splitsch=sch.split(",");
				var spschresult="";
			
				var time="";
				for ( var i in splitsch ) {
					var time=getSelTime(getTimeTxt(splitsch[i]));
				$(time).css({"text-decoration":"line-through double","color":"gray"});
				}
				incount++;
			}
			$("#startdat").text("");
			$("#startdat").text(seldate);
			$(".showSchedule").display="";
			$(".showSchedule").show();
			
		}
	});
}

//찜 , 안찜
var kst=0;
function changeChoiceImg(img){
	var image=$("#keep").attr('src');
	var ronum=$("#roomNum").val();

	if(image.match("notChoiceList.png")){
		kst=1;
		$("#keep").attr('src','resources/user/roomDetail/images/choice.png');
	}else{
		kst=0;
		$("#keep").attr('src','resources/user/roomDetail/images/notChoiceList.png');
	}
	$.ajax({      
		type:"GET",  
		url:"changekeeproom.udo",    
		data:{roomnum:ronum,kst:kst},     
		success:function(data){
			
		}
	});
}

//클릭이벤트 일어날때 선택폭 한정하기 클릭부터 클릭까지
var sclickct=0;
var stid=0;
var edid=0;
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
	//시작시간 선택
	var sttime='';
	if(sclickct==0){
		sclickct=1;
		sttime=sel_time;
		stid=getSelTime(getTimeTxt(txt));
		stid=stid.replace(/[^0-9]/g,'');
		console.log("시작아이디 숫자 "+stid);
		$(sel_time).css("background-color","pink");
		if(reservtime==undefined||reservtime==''){ reservtime=getTimeTxt(txt)+",";} 
		else{reservtime+=getTimeTxt(txt)+",";}
		count=1;
		var roomprice=$("#payPrice").val();
		var realprice=roomprice*count;
		$(".payArea").text("☆가격☆ ￦"+realprice);
		$("#payAmount").val(realprice);
		$("#reserveTime").val(reservtime);
		console.log(reservtime);
		return;
	}
	//끝나는 시간 선택
	var endtime='';
	if(sclickct==1){
		sclickct=2;
		end=sel_time;
		edid=getSelTime(getTimeTxt(txt));
		edid=edid.replace(/[^0-9]/g,'');
		console.log("끝아이디 숫자 "+edid);
		if(edid-stid<3){
			alert("시작시간과 끝시간을 확인해주세요^^ 저희 달빛은 2시간 기본 예약입니다^^");
			schClickReset();
			return;
		}else{
			$(sel_time).css("background-color","skyblue");
			
			console.log(reservtime);
			var roomprice=$("#payPrice").val();
			var realprice=roomprice*count;
			$(".payArea").text("☆가격☆ ￦"+realprice);
			$("#payAmount").val(realprice);
			$("#reserveTime").val(reservtime);
		}
	}
});
//다음스케줄
$("#daumschdule tr td").click(function(){
	if(sclickct==0){
		console.log("안돼 이사람아");
		return;
	}
	if(sclickct>=1){
		console.log("ㅇㅋ 선택");
		return;
	}
});
});
var daumCt=0;
var daumReservtime='';

//새벽손님 스케줄 가져오기
function daumschclick(num){
	daumCt=1;
	$("#daumschdule tr td").css("background-color","white");
	var daumdate=$("#reservDate").val();
	var ddate=daumdate.split("-");
	var nyan=ddate[0];
	var war=ddate[1];
	var il=ddate[2];
	var ilplus=1;
	il*=ilplus+1;
	daumdate = new Date(nyan, war-1, il);
	
	var month = (daumdate.getMonth() + 101).toString().substring(1);
	var day = (daumdate.getDate() + 100).toString().substring(1);
	var year = daumdate.getFullYear();
	
	daumdate=year+"-" +month+"-"+day;
	
	console.log("다음데이트 "+daumdate);
	$.ajax({      
		type:"GET",  
		url:"getSchedule.udo",    
		data:{roomnum:num, seldate:daumdate},     
		success:function(data){
			var sch=data.reservstate;
			if(sch==undefined){
				$("#daumschdule").show();
				return;
			}else{
				var splitsch=sch.split(",");
				var spschresult="";
			
				var time="";
				for ( var i in splitsch ) {
					var time=getdaumSelTime(getTimeTxt(splitsch[i]));
				$(time).css({"text-decoration":"line-through double","color":"gray"});
				}
				incount++;
				$("#daumschdule").show();
			}
		}
	});
	
}
//선택초기화
function schClickReset(){
	sclickct=0;
	reservtime="";
	daumReservtime="";
	$("#schdule tr td").css("background-color","white");
	$("#daumschdule tr td").css("background-color","white");
	$(".payArea").text("☆가격☆ ￦ 원");
}
function daumschReset(){
	sclickct=1;
	daumCt=0;
	daumReservtime="";
	$("#daumschdule tr td").css("background-color","white");
	$(".payArea").text("☆가격☆ ￦ 원");
	$("#daumschdule").hide();
}
/*
 * 	var rvlast=reservtime.substr(reservtime.length-5,4);
		console.log(rvlast);
 */
//리뷰가져오기
function showReview(rvcurpage){
	$.ajax({      
		type:"GET",  
		url:"getRoomAllReview.udo",    
		data:{curpage:rvcurpage ,roomnum:rnum},     
		success:function(data){
			$(".rbox").remove();
			var rvtDom='';
			var strDom="";
			
			if(data.length==0){
				strDom+='<div class="rbox">';
				strDom+='여러분의 한줄후기를 들려주세요</div>';
			}else{
				rvtDom+='<b style="font-size:2vw">      총점 '+data.rvscore+' 점</b>';
				$("#rvtitle").append(rvtDom);
				
				for(var i=0; i<data.rvlist.length; i++){
					strDom+='<div class="rbox">';
					strDom+='작성자 : '+data.rvlist[i].name+'<br/>';
					strDom+='작성날짜 : '+data.rvlist[i].writedate+'<br/><br/>';
					strDom+=data.rvlist[i].reviewContent+'<br/>';
					strDom+='</div>'
				}
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