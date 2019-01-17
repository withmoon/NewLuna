$(document).ready(function(){
	$(".page2").hide();
	$(".page3").hide();
	$(".page4").hide();
	$(".page5").hide();
	
	var count=0;
	/*
	$(".page1").delay(2000).fadeOut(3000);
	$(".page2").delay(2000).fadeIn(2000);
	$(".page2").delay(6000).fadeOut(3000);
	$(".page3").delay(6000).fadeIn(2000);
	$(".page3").delay(10000).fadeOut(3000);
	$(".page4").delay(10000).fadeIn(2000);
	$(".page4").delay(14000).fadeOut(3000);
	$(".page5").delay(14000).fadeIn(2000);
	*/
	if(count==0){
	$(".page1").delay(2000).fadeOut(3000);
	$(".page2").delay(2000).fadeIn(2000);
	count++;
	}else if(count==1){
	$(".page2").delay(6000).fadeOut(3000);
	$(".page3").delay(6000).fadeIn(2000);
	count++;
	}else if(count==2){
	$(".page3").delay(10000).fadeOut(3000);
	$(".page4").delay(10000).fadeIn(2000);
	count++;
	}else if(count==3){
	$(".page4").delay(14000).fadeOut(3000);
	$(".page5").delay(14000).fadeIn(2000);
	count=0;
	}
});