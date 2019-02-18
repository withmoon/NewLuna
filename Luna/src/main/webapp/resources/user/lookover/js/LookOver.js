function showSd(){
	$(".showSchedule").display="";
	$(".showSchedule").show();
}
function hideSd(){
	$(".showSchedule").hide();
}

/* 주소 select 시/군/도 */
$('document').ready(function() {
	var sido=$("option:selected",$(this));
	var area0=$("#sido_select>option").map(function() { return $(this).val(); });

	// 시/도 선택 박스 초기화
	$("select[name^=sido]").each(function() {
		$selsido = $(this);
		var sel_gugun=$("#sel_gugun").val();
		if(sel_gugun==''){
			$selsido.next().append("<option value='' selected='selected'>시/구/군 선택</option>");
		}else{
			$.ajax({      
				 type:"GET",  
				 url:"getSidoGugun.udo",    
				  data:sido,      
				  success:function(data){  
			    	 for(var i=0; i<data.length; i++){
			    		 if(data[i].trim()==sel_gugun.trim()){
			    			 $selsido.next().append("<option value='"+sel_gugun+"' selected='selected'>"+sel_gugun+"</option>");
			    		 }else{
			    			 $selsido.next().append("<option value='"+data[i]+"'>"+data[i]+"</option>");
			    		 }
			    		 
			    	 }
			     }
			});   
		}
	});

	// 시/도 선택시 구/군 설정
	$("select[name^=sido]").change(function() {
		var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의
																					// 구군
																					// Array
		var $gugun = $(this).next(); // 선택영역 군구 객체
		$("option",$gugun).remove(); // 구군 초기화
		
		var sido=$("option:selected",$(this));
		
		$.ajax({      
			 type:"GET",  
			 url:"getSidoGugun.udo",    
		     data:sido,      
		     success:function(data){   
		    	 for(var i=0; i<data.length; i++){
		    		 $gugun.append("<option value='"+data[i]+"'>"+data[i]+"</option>");
		    	 }
		     }
		});   
	});

});

//날짜 입력후 ajax로 데이터 처리
function findCanReservRoom(){
	var sido=$("#sido_select option:selected").val();
	var gugun=$("#gugun_select option:selected").val();
	var seldate=$("#reservDate").val(); 

	var localdate=new Date();
	var month = (localdate.getMonth() + 101).toString().substring(1);
	var day = (localdate.getDate() + 100).toString().substring(1);
	var year = localdate.getFullYear();
	
	
	
	var thisdate=year+month+day;
	var selsplit=seldate.split("-");
	var selspdate="";
	
	for ( var i in selsplit ) {
        selspdate+=selsplit[i];
     }
	
	
	if(selspdate<thisdate){
		alert("날짜를 확인해주세요^^");
	}else{
		var strDom="";
		$.ajax({      
			type:"GET",  
			url:"getCanReservRoom.udo",    
			data:{sido:sido, gugun:gugun, seldate:seldate},     
			success:function(data){  
				$(".showView").remove();
				for(var i=0; i<data.length; i++){
					strDom+='<div class="showView">';
					strDom+='<a href="#" onmouseenter="showSd()" onmouseleave="hideSd()">';
					strDom+='<img src="resources/rooms/'+data[i].fname+'"/></a><br/>';
					strDom+='<a href="#">'+data[i].roomName+'</a><br/>';
					strDom+='<label>('+data[i].branchName+')</label><br/>';
					strDom+='<label>'+data[i].roomEx1+'</label><br/>';
					strDom+='<label>'+data[i].roomEx2+'</label><br/>';
					strDom+='<label>'+data[i].roomEx3+'</label></div>';
					var sch=splitSchedule(data[i],seldate);
				}
				$('.showRoom').append(strDom,sch);
			}
		});
	}
}

function splitSchedule(obj,seldate){
	var schdiv="";
	
	var sch=obj.reservstate;
	
	var splitsch=sch.split(",");
	
	for ( var i in selsplit ) {
        selspdate+=splitsch[i];
    }
	
	schdiv+='<div class="showSchedule">';
	schdiv+='<p style="color:white">방을 예약하시려면 이미지를 클릭해주세요^^</p>';
	schdiv+='<p>선택하신 날짜 : <b><label>'+seldate+'&nbsp;&nbsp;&nbsp;</label>'+obj.roomName+'방</b>의 스케줄입니다.</p><br/>';
	
	
	/*
	
	
	
	<table>
	<tr>
	<th>오전</th>
	<td>00:00</td>
	<td>00:30</td>
	<td>01:00</td>
	<td>01:30</td>
	<td>02:00</td>
	<td>02:30</td>
	<td>03:00</td>
	<td>03:30</td>
	<td>04:00</td>
	<td>04:30</td>
	<td>05:00</td>
	<td>05:30</td>
	<td>06:00</td>
	<td>06:30</td>
	<td>07:00</td>
	<td>07:30</td>
	<td>08:00</td>
	<td>08:30</td>
	<td>09:00</td>
	<td>09:30</td>
	<td>10:00</td>
	<td>10:30</td>
	<td>11:00</td>
	<td>11:30</td>
	</tr>
	<tr>
	<th>오후</th>
	<td>12:00</td>
	<td>12:30</td>
	<td>13:00</td>
	<td>13:30</td>
	<td>14:00</td>
	<td>14:30</td>
	<td>15:00</td>
	<td>15:30</td>
	<td>16:00</td>
	<td>16:30</td>
	<td>17:00</td>
	<td>17:30</td>
	<td>18:00</td>
	<td>18:30</td>
	<td>19:00</td>
	<td>19:30</td>
	<td>20:00</td>
	<td>20:30</td>
	<td>21:00</td>
	<td>21:30</td>
	<td>22:00</td>
	<td>22:30</td>
	<td>23:00</td>
	<td>23:30</td>
	</tr>
	</table>
	</div>
	*/
	return sch;
}