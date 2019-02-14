function changeChoiceImg(img){
	var image=$("#keep").attr('src');
	if(image.match("notChoiceList.png")){
		$("#keep").attr('src','resources/user/roomDetail/images/choice.png');
	}else{
		$("#keep").attr('src','resources/user/roomDetail/images/notChoiceList.png');
	}
}
$(function(){
$("#schdule tr td").click(function(){
	var txt = $(this).text();
	alert(txt);
});
});

function dataSet(){
	$.ajax({      
		 type:"POST",  
		 url:"/v1/payment/ready",    
		 header:"Authorization : Bearer 4148808bd5ab3e6b2b6709e3160815b6",
	     data:{
	    	 "cid":"TC0ONETIME",
		  "partner_order_id": "brman1",
		   "partner_user_id": "user1",
		   "item_name": "대로도라 단체룸(30)",
		   "quantity": "2",
		   "total_amount": "40000",
		   "vat_amount": "4000",
		  "tax_free_amount":"0",
		   "approval_url": "https://developers.kakao.com/v1/payment/approve",
		   "fail_url": "https://developers.kakao.com/fail",
		   "cancel_url": "https://developers.kakao.com/cancel"
	     },      
	     done:function(data){   
	    	 window.url=data.next_redirect_pc_url;
	     },
	     fail:function(data){
	    	 window.url=data.next_redirect_pc_url;
	     }
	});   
}