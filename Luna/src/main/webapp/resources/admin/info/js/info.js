$(function() {
	infoList(1);
});

//지점장 목록
function infoList(ipage) {
	$.ajax({     
		 type:"GET",  
		 url:"infoList.ado",    
	     data:{curPage:ipage},      
	     success:function(data){
	    	 $("#info_table").children().remove();
	    	 var inf = '';
	    	 
	    	 for(var i=0; i<data.infoList.length; i++){
	    		 inf += '<tr>';
	    		 inf += '<td>'+data.infoList[i].id+'</td>';
	    		 inf += '<td>'+data.infoList[i].name+'</td>';
	    		 inf += '<td>'+data.infoList[i].phone+'</td>';
	    		 inf += '<td>'+data.infoList[i].email+'</td>';
	    		 inf += '<td>'+data.infoList[i].branchName+'</td>';
	    		 inf += '<td>'+data.infoList[i].branchAddr1+'</td>';
	    		 inf += '<td><a href="approvedelete.ado?id='+data.infoList[i].id+'">삭제</a>';
	    		 inf += '</tr>';
	    	 }
	    	 
	    	 $("#info_table").append(inf)
	    	 
	    	 blockPage("infoPaging",ipage,data.infoPage.BLOCK_SCALE,data.infoPage.totPage,"infoP","infoList");
	     }
	});
}