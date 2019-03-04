$(function() {
	memberList(1);
});

//회원정보
function memberList(mpage) {
	$.ajax({     
		 type:"GET",  
		 url:"aMemberList.ado",    
	     data:{curPage:mpage},      
	     success:function(data){
	    	 $("#member_table").children().remove();
	    	 var mem = '';
	    	 
	    	 alert(data.memberList.length);
	    	 
	    	 for(var i=0; i<data.memberList.length; i++){
	    		 mem += '<tr>';
	    		 mem += '<td>'+data.memberList[i].name+'</td>';
	    		 mem += '<td>'+data.memberList[i].id+'</td>';
	    		 mem += '<td>'+data.memberList[i].phone+'</td>';
	    		 mem += '<td>'+data.memberList[i].email+'</td>';
	    		 mem += '<td><a href="remove.ado?id='+data.memberList[i].name+'">제명</a></td>';
	    		 mem += '</tr>';
	    	 }
	    	 
	    	 $("#member_table").append(mem)
	    	 
	    	 blockPage("memberPaging",mpage,data.memberPage.BLOCK_SCALE,data.memberPage.totPage,"memberP","memberList");
	     }
	});
}