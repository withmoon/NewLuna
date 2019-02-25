$(function() {
	$(".reply2").hide();
	
	$('.replyOnOff').click(function() {
		if($(".reply2").css("display") == "none"){
			$(".reply2").show();
		}else{
			$(".reply2").hide();
		}
	});
});
