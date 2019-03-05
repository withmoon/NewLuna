var filterVal10 = 'blur(10px)';
var filterVal0 = 'blur(0px)';
var emails='';
var ids='';
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
	    	 
	    	 for(var i=0; i<data.memberList.length; i++){
	    		 mem += '<tr>';
	    		 mem += '<td><input type="checkbox" name="checkRow" class="chkbox" id="chkseq'+i+'" value="'+data.memberList[i].id+';'+data.memberList[i].email+'" onclick="attachUserInfo(&#039'+data.memberList[i].id+'&#039,&#039'+data.memberList[i].email+'&#039,'+i+')"/></td>';
	    		 mem += '<td>'+data.memberList[i].name+'</td>';
	    		 mem += '<td>'+data.memberList[i].id+'</td>';
	    		 mem += '<td>'+data.memberList[i].phone+'</td>';
	    		 mem += '<td>'+data.memberList[i].email+'</td>';
	    		 if(data.memberList[i].brStatus==0){
	    			 mem += '<td><input type="button" onclick="editContentExpulmember(&#039'+data.memberList[i].id+'&#039,&#039'+data.memberList[i].email+'&#039)" value="제명"></td>';
	    		 }
	    		 if(data.memberList[i].brStatus==-2){
	    			 mem+='<td><input type="button" onclick="cancleExplurUser(&#039'+data.memberList[i].id+'&#039,&#039'+data.memberList[i].email+'&#039)" value="제명취소" /></td>';
	    		 }
	    		 mem += '</tr>';
	    	 }
	    	 
	    	 $("#member_table").append(mem)
	    	 
	    	 blockPage("memberPaging",mpage,data.memberPage.BLOCK_SCALE,data.memberPage.totPage,"memberP","memberList");
	     }
	});
}
//제명 하겠다 내용을 띄워달라
function editContentExpulmember(id,email){
	$(".explur").show();
	$(".emailcontents").hide();
	$(".emailcontents").hide();
	if(confirm(id+"님의 계저을 제명 처리하시겠습니까?")){
	$('body > *:not(.explur) ').css('filter',filterVal10);
	$(".explur").show();
	$("#sendToUser").attr("onclick","expulmember('"+id+"','"+email+"')");
	}
}
//제명 취소
function cancleExplur(){
	$('body > *:not(.explur) ').css('filter',filterVal0);
	$(".explur").hide();
}
//제명 처리
function expulmember(id,email,title){
	var content=$("#excontent").val();

	$.ajax({     
		 type:"GET",  
		 url:"expulmember.ado",    
	     data:{id:id,email:email,content:content,title:title},
	     success:function(){
	    	 alert(id+"님이 제명되었습니다.");
	    	 memberList(1);
	    	 cancleExplur();
	     }
	});
} 
//제명 처리
function cancleExplurUser(id,email){
	$.ajax({     
		 type:"GET",  
		 url:"expulmember.ado",    
	     data:{id:id,email:email},
	     success:function(){
	    	 alert(id+"님의 제명이 취소되었습니다.");
	    	 memberList(1);
	     }
	});
}


//체크박스 누를시
function attachUserInfo(id,email,i){
	 $(".cendmBtn").children().remove();
	 if( $("#chkseq"+i).is(':checked') ){
		 emails+=email+";";
		 ids+=id+";";
		 $(".cendmBtn").append("<p>"+ids+"</p>");
		 return;
	 }else{
		 var emsp=emails.split(email+";");
		 var idsp=ids.split(id+";");
		 ids=idsp[0]+""+idsp[1];
		 emails=emsp[0]+""+emsp[1];
		 $(".cendmBtn").append("<p>"+ids+"</p>");
		 return; 
	 }
}

//선택박스 모두 체크
function checkAll(){
	 if( $("#allSeq").is(':checked') ){
		 $("input[name=checkRow]").prop("checked", true);
		 ids='';
	     for(i=0; i <$("input[name=checkRow]").prop("checked", true).length; i++) {
	    	 var idsplit=$("#chkseq"+i).val().split(";");
	    	 ids+=idsplit[0]+";";
	    	 emails=idsplit[1]+";";
	  	 }
	     $(".cendmBtn").children().remove();
	     $(".cendmBtn").append("<p>"+ids+"</p>");
	     return;
	 }else{
		  $(".cendmBtn").children().remove();
		  ids='';
		  emails='';
	     $("input[name=checkRow]").prop("checked", false);
	 }
}
//메일보내기 클릭
function sendEmailToMembers(){
	$('body > *:not(.explur) ').css('filter',filterVal10);
	$(".explur").show();
	$(".emailcontents").show();
}
//내용작성 후 메일 보내기
function sendEmail(){
	$("#ids").val(ids);
	$("#ems").val(emails);
}
