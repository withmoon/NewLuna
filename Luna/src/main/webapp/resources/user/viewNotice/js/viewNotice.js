var num = getParameterByName('num');

$(function() {
	 $(".reply2").hide();
	nReplyList(1);
	
	 $('.replyOnOff').click(function() {
		 if($(".reply2").css("display") == "none"){
			 $(".reply2").show();
				
			 nReplyList(1);
		 } else{
			 $(".reply2").hide();
		 }
	 });
});

function writeCommand(num){
	var content=$("#replytext").val();
	
	$.ajax({
		type:"POST",
		url:"nReplyInsert.udo",
		data: {bnum:num,content:content},
		success : function(data) {
			replyOnOff(num);
			$('#replytext').val("");
			alert("등록");
		}
	});
}

function nReplyList(nrpage) {
	$.ajax({
		type:"GET",
		url:"nReplyList.udo",
		data: {num:num,curPage:nrpage},
		success : function(data) {
			$('.replyList').children().remove();
			var nreply='';
			if(data.nReplyList.length==0) {
				nreply += '<div class="rbox"><p>댓글이 없어요... 남겨주시면 힘이 됩니다...</p></div>';
				$('.replyList').append(nreply);
				return;
			}
			if(data.nReplyList.length!=0) {
				for(var i=0; i<data.nReplyList.length; i++) {
					var regdate = new Date(data.nReplyList[i].regdate);
					var regdateFormat = regdate.toISOString().slice(2,10);
					nreply += '<div class="rbox">작성자 : '+data.nReplyList[i].replyer+'</br>작성날짜 : '+regdateFormat+'<br/>'+data.nReplyList[i].replytext;	
					if(data.userid == data.nReplyList[i].replyer) {
						nreply += '<span><button>수정</button> <button>삭제</button></span>';
					}
					
					nreply += '</div>';
				}
				$('.replyList').append(nreply);
				console.log(data.nReplyPage.BLOCK_SCALE+ " " +nrpage+" " +data.nReplyPage.totPage);
				blockPage("replyPaging",nrpage,data.nReplyPage.BLOCK_SCALE,data.nReplyPage.totPage,"reli","nReplyList");
			}
		}
	});
}

function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}