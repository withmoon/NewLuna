var filterVal10 = 'blur(10px)';
var filterVal0 = 'blur(0px)';

$(function() {
	approveList(1);
});

//승인계시판
function approveList(apage) {
	$.ajax({     
		 type:"GET",  
		 url:"approveList.ado",    
	     data:{curPage:apage},      
	     success:function(data){
	    	 $("#approve_table").children().remove();
	    	 var app = '';
	    	 for(var i=0; i<data.approveList.length; i++){
	    		 
	    		 app += '<tr>';
	    		 app += '<td>'+data.approveList[i].id+'</td>';
	    		 app += '<td>'+data.approveList[i].name+'</td>';
	    		 app += '<td>'+data.approveList[i].phone+'</td>';
	    		 app += '<td  onclick="sendEmailToMembers(&#039'+data.approveList[i].email+'&#039)">'+data.approveList[i].email+'</td>';
	    		 app += '<td>'+data.approveList[i].branchName+'</td>';
	    		 app += '<td>'+data.approveList[i].branchAddr1+'</td>';
	    		 app += '<td><a href="javascript:sendpproveEmail(&#039'+data.approveList[i].id+'&#039,&#039'+data.approveList[i].email+'&#039)">승인</a>&emsp;<a href="approvedelete.ado?id='+data.approveList[i].id+'&type=approve">거절</a></td>';
	    		 app += '</tr>';
	    		 console.log(data.approveList[i].id);
	    	 }
	    	 
	    	 $("#approve_table").append(app)
	    	 blockPage("approvePaging",apage,data.approvePage.BLOCK_SCALE,data.approvePage.totPage,"approveP","approveList");
	     }
	});
}
//제명 취소
function cancleExplur(){
	$('body > *:not(.explur) ').css('filter',filterVal0);
	$(".explur").hide();
}
function sendpproveEmail(id,email){
	$("#id").val(id);
	$("#ems").val(email);
	$("#type").val("approve");
	$("#jspname").val("approve");
	$("#extitle").val("[달빛 관리자] 등록하신 지점이 승인되었습니다.");
	$("#excontent").val("http://localhost:8080/luna/manager.mdo");
	$("#appform").submit();
}

//메일보내기 클릭
function sendEmailToMembers(email){
	$("#ems").val(email);
	$("#jspname").val("approve");
	$('body > *:not(.explur) ').css('filter',filterVal10);
	$(".explur").show();
	$(".emailcontents").show();
}