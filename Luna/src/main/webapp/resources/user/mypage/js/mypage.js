var count=0;

var revroomNum='';
//리뷰 열고 닫고 
function openReview(num){
	console.log(num);
	revroomNum=num;
	$(".review").display="";
	$(".review").show();
	$('body > *:not(.review) ').css('filter',filterVal10);
}
function closeReview(){
	$('body > *:not(.review) ').css('filter',filterVal0);
	$(".star").attr('src','resources/util/unstar.png');
	count=0;
	$("#starcount").text(0);
	$(".review").hide();
}

//후기 올리기

function writeReview(){
	$.ajax({      
		type:"POST",  
		url:"writeReview.udo",    
		data:{roomnum:revroomNum},     
		success:function(){
			$("#conf"+seq).remove();
			readTd(seq);
		}
	});
}

//메신져이미지 누르면 알림으로 바로 내려감
function goToNotice(){
	scrollDown(".allnon");
}
var keepdc=0;
var reserdc=0;
var noticedc=0;
function displayBoard(num){
	if(num==1&&keepdc==0){
		$(".favorlist").hide();
		keepdc=1;
		scrollOn(".favorlist");
		return;
	}
	if(num==1&&keepdc==1){
		$(".favorlist").display="";
		$(".favorlist").show();
		keepdc=0;
		scrollDown(".favorlist");
		return;
	}
	if(num==2&&reserdc==0){
		$(".rslist").hide();
		reserdc=1;
		scrollOn(".reservation");
		return;
	}
	if(reserdc==1&&reserdc==1){
		$(".rslist").display="";
		$(".rslist").show();
		reserdc=0;
		scrollDown(".rslist");
		return;
	}
	
}
function scrollOn(str){
	var offset = $(str).offset();
    $('html, body').animate({scrollTop : offset.top}, 400);
}
function scrollDown(str){
	var offset = $(str).offset();
    $('html, body').animate({scrollTop : offset.top-50}, 400);
}
$(function(){
	$("#star1").click(function(){
		var image=$("#star1").attr('src');
		if(image.match("star.png")){
			switch(count){
			case 1:
				$("#star1").attr('src','resources/util/unstar.png');	
				count=0;
				break;
			case 2:
				$("#star2").attr('src','resources/util/unstar.png');	
				count=1;
				break;
			case 3:
				$("#star2").attr('src','resources/util/unstar.png');	
				$("#star3").attr('src','resources/util/unstar.png');	
				count=1;
				break;
			case 4:
				$("#star2").attr('src','resources/util/unstar.png');	
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');	
				count=1;
				break;
			case 5:
				$("#star2").attr('src','resources/util/unstar.png');	
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');
				$("#star5").attr('src','resources/util/unstar.png');	
				count=1;
				break;
			default : break;
			}
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			count=1;
		}
		$("#starcount").text(count);
	});


	$("#star2").click(function(){
		var image=$("#star2").attr('src');
		if(image.match("star.png")){
			switch(count){
			case 2:
				$("#star2").attr('src','resources/util/unstar.png');	
				count=1;
				break;
			case 3:
				$("#star3").attr('src','resources/util/unstar.png');	
				count=2;
				break;
			case 4:
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');	
				count=2;
				break;
			case 5:
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');
				$("#star5").attr('src','resources/util/unstar.png');	
				count=2;
				break;
			default : break;
			}
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			$("#star2").attr('src','resources/util/star.png');
			count=2;
		}
		$("#starcount").text(count);
	});


	$("#star3").click(function(){
		var image=$("#star3").attr('src');
		if(image.match("star.png")){
			switch(count){
			case 3:
				$("#star3").attr('src','resources/util/unstar.png');	
				count=2;
				break;
			case 4:
				$("#star4").attr('src','resources/util/unstar.png');	
				count=3;
				break;
			case 5:
				$("#star4").attr('src','resources/util/unstar.png');
				$("#star5").attr('src','resources/util/unstar.png');	
				count=3;
				break;
			default : break;
			}
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			$("#star2").attr('src','resources/util/star.png');
			$("#star3").attr('src','resources/util/star.png');
			count=3;
		}
		$("#starcount").text(count);
	});


	$("#star4").click(function(){
		var image=$("#star4").attr('src');
		if(count==4&&image.match("star.png")){
			$("#star4").attr('src','resources/util/unstar.png');
			count=3;
		}
		if(count==5&&image.match("star.png")){
			$("#star5").attr('src','resources/util/unstar.png');
			count=4;
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			$("#star2").attr('src','resources/util/star.png');
			$("#star3").attr('src','resources/util/star.png');
			$("#star4").attr('src','resources/util/star.png');
			count=4;
		}
		$("#starcount").text(count);
	});
	$("#star5").click(function(){
		var image=$("#star5").attr('src');
		if(count==5&&image.match("star.png")){
			$("#star5").attr('src','resources/util/unstar.png');
			count=4;
			$("#starcount").text(count);
			return;
		}
		if(image.match("unstar.png")){
			$(".star").attr('src','resources/util/star.png');
			count=5;
		}
		$("#starcount").text(count);
	});
});
