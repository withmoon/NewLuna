var count=0;
function openReview(num){
	console.log(num);
	$(".review").display="";
	$(".review").show();
}
function closeReview(){
	$(".star").attr('src','resources/util/unstar.png');
	count=0;
	$("#starcount").text(0);
	$(".review").hide();
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
