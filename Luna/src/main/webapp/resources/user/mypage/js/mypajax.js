var cancleSt=0;
var imp_uid="";
var id="";
var filterVal10 = 'blur(10px)';
var filterVal0 = 'blur(0px)';
//환불 요청 ajax 
function cancleReserve(id,imp,st){
	
	console.log(imp+" " +st);
	imp_uid=imp;
	id=id;
	$('body > *:not(.ccReserDiv) ').css('filter',filterVal10);
	$(".ccReserDiv").display="";
	$(".ccReserDiv").show();
	
}
//환불하시겠습니까?
function goCancle(){
	gogoCC(status,imp_uid);
	$('body > *:not(.ccReserDiv) ').css('filter',filterVal0);
}

function noCancle(){
	$(".ccReserDiv").hide();
	$('body > *:not(.ccReserDiv) ').css('filter',filterVal0);
}
function gogoCC(){
	$.ajax({      
		type:"POST",  
		url:"cancleReserve.udo",    
		data:{imp_uid:imp_uid,id:id},     
		success:function(data){
			$("#"+imp_uid).children().remove();
			var stdom="<label>환불요청중</label>";
			$("#"+imp_uid).append(stdom);
			noCancle();
			alert("환불이 완료되었습니다");
		}
	});

}