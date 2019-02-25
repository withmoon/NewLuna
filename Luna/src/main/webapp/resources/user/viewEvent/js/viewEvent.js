/*댓글목록보기*/


$(function() {
	$('.listReply').hide();
	
	$('.reply').click(function() {
		if($('.listReply').css("display") == 'none') {
			$('.listReply').show();
		} else {
			$('.listReply').hide();
		}
		
		$.ajax({
			type:"GET",
			url:"eReplyList.udo",
			data:{"eReplyL":"eReL"},
			success:function(data) {
				for(var i=0; i<data.length; i++) {
					$('.rbox').children().remove();
					
					var replyer = data[i].replyer;
					var regdate = date[i].regdate;
					var regdateFormat = regdate.toISOString().slice(2,10);
					var replytext = data[i].regdate;
					
					var ereply='작성자 : '+replyer+'</br>작성날짜 : '+regdateFormat+'<br/>'+replytext+'</br>';
					
					$('.rbox').append(ereply);
				}
			}
		});
	});
});

/*댓글입력 버튼*/
$('#btnReply').click(function() {
	$.ajax({
		type:"GET",
		url:"eReplyInsert.udo",
		data:{"eReplyI":"eReI"},
		success:function(data) {
			var erplyL='<textarea rows="3" cols="70" id="replyArea" placeholder="댓글을 작성해주세요"></textarea>';
			
			$('#replytext').append(erplyL);
			
			alert("댓글이 등록되었습니다.");
		}
	});
});


/*창닫기*/
function windowClose() {
	window.close();
}