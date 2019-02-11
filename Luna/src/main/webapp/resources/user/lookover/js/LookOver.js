function showSd(){
	$("#showSchedule").display="";
	$("#showSchedule").show();
}
function hideSd(){
	$("#showSchedule").hide();
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

function findCanReservRoom(){
	var sido=$("#sido_select option:selected").val();
	var gugun=$("#gugun_select option:selected").val();
	var seldate=$("#reservDate").val(); 

	var localdate=new Date();
	var month = (localdate.getMonth() + 101).toString().substring(1);
	var day = (localdate.getDate() + 100).toString().substring(1);
	var year = localdate.getFullYear();
	
	
	
	var thisdate=year+month+day;
	/*
	
	if()
	$.ajax({      
		 type:"GET",  
		 url:"getCanReservRoom.udo",    
	     data:{sido:sido, gugun:gugun, seldate:seldate},     
	     success:function(data){  
	    	 alert("갔다았습니당 ㅎ");
	     }
	});
	*/  
}
