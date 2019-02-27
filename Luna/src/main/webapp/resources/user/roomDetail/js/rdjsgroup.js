var rnum=getParameterByName('roomnum'); //방번호 가져오기

var reservtime="";
var count=0;
var userid='';
$('document').ready(function($) {
	showSd(rnum);
	showReview(1);
	userid = '@Request.RequestContext.HttpContext.Session["member"]';
});
//날짜에 따른 스케줄
function showSd(num){
	$("#schdule tr td").css({"text-decoration":"","color":""});
	
	var seldate=$("#reservDate").val(); 
	
	$("#reservdate").val(seldate); 
	
	$.ajax({      
		type:"GET",  
		url:"getSchedule.udo",    
		data:{roomnum:num, seldate:seldate},     
		success:function(data){
			var sch=data.reservstate;
			//console.log("sch="+sch);
			if(sch==undefined){
				$("#startdat").text("");
				$("#startdat").text(seldate);
				$("#scroomname").text("");
				$("#scroomname").text(" "+$(".roomname"+num).text()+"방");
				
				$(".showSchedule").display="";
				$(".showSchedule").show();
				return;
			}else{
				alert("적용되었습니다.");
				var splitsch=sch.split(",");
				var spschresult="";
			
				var time="";
				for ( var i in splitsch ) {
					var time=getSelTime(getTimeTxt(splitsch[i]));
					//var time=getSelTime(splitsch[i]);
				$(time).css({"text-decoration":"line-through double","color":"gray"});
				}
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

	
	//아이디는 세션에서
	console.log(ronum);
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
			console.log("성공");
		}
	});
}
//스케줄 예약 예정

//클릭이벤트 일어날때 선택폭 한정하기 클릭부터 클릭까지
//셀데이터가 두개일시 다른 function 실행
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
	
});
});
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