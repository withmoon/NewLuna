$(function() {
	inquireList(1);
});

//문의계시판
function inquireList(inpage) {
	$.ajax({     
		 type:"GET",  
		 url:"inquireList.ado",    
	     data:{curPage:inpage},      
	     success:function(data){
	    	 $("#inquire_table").children().remove();
	    	 var inqui = '';
	    	 
	    	 //alert(data.inquireList.length);
	    	 for(var i=0; i<data.inquireList.length; i++){
	    		 
	    		 var regdate = new Date(data.inquireList[i].regdate);
	    		 var regdateFormat = regdate.toISOString().slice(2,10);
	    		 
	    		 inqui += '<tr>';
	    		 inqui += '<td>'+data.inquireList[i].seq+'</td>';
	    		 inqui += '<td>'+data.inquireList[i].id+'</td>';
	    		 inqui += '<td>'+data.inquireList[i].title+'</td>';
	    		 inqui += '<td>'+data.inquireList[i].branchname+'</td>';
	    		 inqui += '<td>'+regdateFormat+'</td>';
	    		 inqui += '<td><a href="inquirewrite.ado?seq='+data.inquireList[i].seq+'">답변</a>&emsp;<a href="inquiredelete.ado?seq='+data.inquireList[i].seq+'">삭제</a></td>';
	    		 inqui += '</tr>';
	    	 }
	    	 
	    	 $("#inquire_table").append(inqui)
	    	 
	    	 blockPage("inquirePaging",inpage,data.inquirePage.BLOCK_SCALE,data.inquirePage.totPage,"inquireP","inquireList");
	     }
	});
}