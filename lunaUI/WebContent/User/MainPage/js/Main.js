$(document).ready(function(){
	$('#sec').display = "";  
    $('#sec').fadeIn(3000);
    $("#p2_2").hide();
    var count=2;
   
    //소개
	  $("#goExplain").click(function(){
		  $("#page1").fadeOut(2000);
		  $("#page2").fadeIn(2000);
		  $("#p2_1").animate({top: "+=20%"},1500);
		  $("#p2_2").show();
		  $(".bar").show();
		  $(".bar").animate({left:"+=4%"},1500);
		  $("#goPre").hide();
		  $("#p2_2").animate({bottom:"+=20%"},1500); 
	  });
	 
	  //화살표 전으로
	  $("#goPre").click(function(){
		  count--;
		
		});
	  //이쪽 세팅은 animate이돼 연산이 아닌 값으로 넣으줘야함
	  //그래야 나중에 중간에 홈페이지로 갈시 미연의 방지 가능
	  //메인페이지로 가기
	  $("#goPage1").click(function(){
		  if(count==2){
			  $("#page1").fadeIn(1500);
			  $("#p2_1").animate({top: "-20%"},1500);
			  $("#p2_2").animate({bottom:"-20%"},1500);
			  $("#page2").fadeOut(1500);
			  $(".bar").animate({left:"44%"},1500);
		  }else if(count==3){
			  $("#page1").fadeIn(1500);
			  $(".bar").hide();
			  $("#page2").hide();
			  $("#p2_1").css({top: "-20%",left: "0"});
			  $("#p2_2").css({bottom:"-20%",left:"100%"});
			  
			  $("#page3").fadeOut(1000);
			  $("#p3_2").delay(1000).css({width:"33%"});
			  $("#p3_1").delay(1000).css({left:"-33%"});
			  $("#p3_3").delay(1000).css({right:"-33%"});
		  }else if(count==4){
			  $("#page1").css({right:"-=100%"});
			  $("#page1").show();
			  $("#page4").animate({left:"-=100%"},1000);
			  $("#page1").animate({left:"0"},1000);
			  $("#page4").hide(2000);
			  $("#page4").css({left:"0"});
		  }
		  count=2;
	});
	  
	 //다음화살표
	$("#goNext").click(function(){
		 if(count==2){
			 $("#goPre").show();
			 $(".bar").css({width:"30%"},1)
			 $(".bar").animate({left:"-=4%"},100);
			 $("#p2_1").animate({right: "+=100%"},1000);
			 $("#p2_2").animate({left:"+=100%"},1000);
			 $("#p2_2").hide(10);
			 
			 $("#p3_2").hide();
			 $("#page3").show();
			 $("#p3_2").animate({width:"+=1%"},10);
			 $("#p3_2").fadeIn(2000);
			 $("#p3_1").delay("1000").animate({left:"+=33%"},700);
			 $("#p3_3").delay("1000").animate({right:"0"},700);
			 $("#p3_1").animate({left:"-=8%"},400);
			 $("#p3_3").animate({right:"-=8%"},400);
			 $("#p3_1").delay("100").animate({left:"+=8%"},1000);
			 $("#p3_3").delay("100").animate({right:"0"},1000);
		 }else if(count==3){
			 $("#page3").fadeOut(2000);
			 $("#p4_im5").fadeIn(4000);
			 $("#p4_im2").fadeIn(3000);
			 $('#p4_im1').fadeIn(2000);
			 $('#p4_im6').fadeIn(3000);
			 $('#p4_im3').fadeIn(1000);
			 $('#p4_im4').fadeIn(2000);
			 $("#goNext").hide();
		 }
		 count++;
	});
});