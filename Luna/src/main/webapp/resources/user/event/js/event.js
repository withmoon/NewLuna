/*진행 이벤트*/
$(function() {
	$('.eventNow1').click(function() {
		$('.eventFinsh2').hide();
		$('.eventNow2').show();
	});
});

/*종료 이벤트*/
$(function() {
	$('.eventFinsh2').hide();
	$('.eventFinsh1').click(function() {
		$('.eventNow2').hide();
		$('.eventFinsh2').show();
	});
});