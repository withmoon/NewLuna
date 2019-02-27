function replyOnOff(num) {
	if($(".reply2").css("display") == "none"){
		$(".reply2").show();
		
		$.ajax({
			type:"GET",
			url:"nReplyList.udo",
			data: {num:num,"nreList":"nreL"},
			success : function(data) {
				$('.replyList').children().remove();
				if(data==0) {
					var nreply='';
					nreply += '<div class="rbox"><p>댓글이 없어요... 남겨주시면 힘이 됩니다...</p></div>';
						
					$('.replyList').append(nreply);
				} else {
					for(var i=0; i<data.length; i++) {
						var replyer = data[i].replyer;
						var regdate = new Date(data[i].regdate);
						var regdateFormat = regdate.toISOString().slice(2,10);
						var replytext = data[i].replytext;	
						var nreply='';
						nreply += '<div class="rbox">작성자 : '+replyer+'</br>작성날짜 : '+regdateFormat+'<br/>'+replytext+
									'<span><button>수정</button> <button>삭제</button></span></div>';
						
						$('.replyList').append(nreply);
					}
				}
			}
		});
	} else{
		$(".reply2").hide();
	}
}

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