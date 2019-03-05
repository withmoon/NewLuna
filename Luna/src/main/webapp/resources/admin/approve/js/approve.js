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
	    		 app += '<td>'+data.approveList[i].email+'</td>';
	    		 app += '<td>'+data.approveList[i].branchName+'</td>';
	    		 app += '<td>'+data.approveList[i].branchAddr1+'</td>';
	    		 app += '<td><a href="approval.ado?id='+data.approveList[i].id+'">승인</a>&emsp;<a href="approvedelete.ado?id='+data.approveList[i].id+'">거절</a></td>';
	    		 app += '</tr>';
	    	 }
	    	 
	    	 $("#approve_table").append(app)
	    	 
	    	 blockPage("approvePaging",apage,data.approvePage.BLOCK_SCALE,data.approvePage.totPage,"approveP","approveList");
	     }
	});
}