$(document).ready(function(){
	$(".page2").hide();
	$(".page3").hide();
	
	$(".page1").delay(2000).fadeOut(3000);
	$(".page2").delay(2000).fadeIn(2000);
	
	$(".page2").delay(6000).fadeOut(3000);
	$(".page3").delay(6000).fadeIn(2000);
	
});