var stdate='';
var endate='';
var hasuserreview=new Array();
var stcount=0;  //별 갯수
var rvwroomNum='';  //리뷰선택시 해당 방번호
//리뷰 열고 닫고 
function openReview(num){
	rvwroomNum=num;
	$(".review").display="";
	$(".review").show();
	$('body > *:not(.review) ').css('filter',filterVal10);
}
function closeReview(){
	$('body > *:not(.review) ').css('filter',filterVal0);
	$(".star").attr('src','resources/util/unstar.png');
	stcount=0;
	$("#starcount").text(0);
	$(".review").hide();
}
$(function(){
	getKeepList(1);
	getalamList(1);
	//최근예약
	getReservList('pay',1);
	//지난예약
	getUserReview();
	getReservList('reserved',1);
});
//찜 리스트 가져옴
function getKeepList(kcurpage){
	$.ajax({      
		type:"GET",  
		url:"keeproomlist.udo",    
		data:{curpage:kcurpage},     
		success:function(data){
			var kstrDom='';
			//방있을때
			$("#fvTable").children().remove();
			for(var i=0; i<data.klist.length; i++){
				if(i%2==0){
					kstrDom+='<tr>';
				}
				kstrDom+='<td><a href="roomDetail.udo?roomnum='+data.klist[i].roomNum+'">';
				kstrDom+='<img src="resources/rooms/'+data.klist[i].fname+'"><br/>'+data.klist[i].roomName+'</a></td>';
				if(i%2==1){
					kstrDom+='<tr>';
					kstrDom+='</tr>';
				}
				if((data.klist.length-1)%2==0&&i==data.klist.length-1){
					kstrDom+='</tr>';
				}
			}
			$("#fvTable").append(kstrDom);
			//방 없을때
			if(data.klist.length==0){
				$("#nonroom").show();
			}
			blockPage("fvPaging",kcurpage,data.kpager.BLOCK_SCALE,data.kpager.totPage,"kpli","getKeepList");
		}
	});
}

//알림리스트 가져옴
function getalamList(acurpage){
	$.ajax({      
		type:"GET",  
		url:"alamlist.udo",    
		data:{curpage:acurpage},     
		success:function(data){
			var astrDom='';
			//방있을때
			$("#notification2").children().remove();
			for(var i=0; i<data.alist.length; i++){
				//읽은거
				astrDom+='<tr>';
				if(data.alist[i].readst==1){
					astrDom+='<td style="color:gray">'+data.alist[i].fromwho+'</td>';
					astrDom+='<td style="color:gray">'+data.alist[i].content+'</td>';
					astrDom+='<td style="color:gray">'+data.alist[i].almdate+'</td>';
					if(data.alist[i].numforwhat!=-1){
						astrDom+='<td> </td>';
					}
				}
				//안읽은거
				if(data.alist[i].readst==0){
					astrDom+='<td class="conf'+data.alist[i].seq+'">'+data.alist[i].fromwho+'</td>';
					astrDom+='<td class="conf'+data.alist[i].seq+'">'+data.alist[i].content+'</td>';
					astrDom+='<td class="conf'+data.alist[i].seq+'">'+data.alist[i].almdate+'</td>';
					//환불요청이면
					if(data.alist[i].numforwhat!=-1){
						astrDom+='<td><button id="conf'+data.alist[i].seq+'" onclick="confirmCancle('+data.alist[i].seq+')">확인완료</button></td>';
					}
				}
				//환불외의것들
				if(data.alist[i].numforwhat==-1){
					astrDom+='<td><button onclick="openElse('+data.alist[i].seq+',&#039'+data.alist[i].content+'&#039,&#039'+data.alist[i].fromwhat+'&#039)">내용보기</button></td>';
				} 
				astrDom+='</tr>';
			}
			//없으면
			if(data.alist.length==0){
				astrDom+='<tr><td colspan="4">알림이 없습니다.</td></tr>';
			}
			//방 없을때
			if(data.alist.length==0){
				$("#nonroom").show();
			}
			$("#notification2").append(astrDom);
			
			blockPage("alpaging",acurpage,data.apager.BLOCK_SCALE,data.apager.totPage,"alli","getalamList");
		}
	});
}
//후기 올리기 //룸넘, 리뷰내용, 별 카운트 
function writeReview(){
	stcount=$("#starcount").text();
	var rvwText=$("#rvwText").val();
	$.ajax({      
		type:"GET",  
		url:"writeReview.udo",    
		data:{starCount:stcount,roomnum:rvwroomNum,content:rvwText},     
		success:function(){
			closeReview();
			alert("감사합니다. 앞으로 더 힘쓰겠습니다^^");
			getUserReview("inreview");
		}
	});
}
//사용자가 달은 리뷰의 방 번호 가져오기
function getUserReview(state){
	$.ajax({      
		type:"GET",  
		url:"getUserReview.udo",         
		success:function(data){
			for(var i=0; i<data.length; i++){
				hasuserreview[i]=data[i];
			}
			if(state=='inreview'){
				if(stdate!=''){
					getReservList("search",1); //지금이라네
				}
				if(stdate==''){
					getReservList("reserved",1); //지금이라네
				}
			}
		}
	});
}
//결제내역 가져오기
function getReservList(listType,lrcurpage){
	$.ajax({      
		type:"GET",  
		url:"getReserveList.udo",    
		data:{listType:listType,curpage:lrcurpage,startdate:stdate,enddate:endate},     
		success:function(data){
			if(listType=='pay'){ //최근내역
				latelyList(lrcurpage,data);
			}else{ //지난내역
				lastList(lrcurpage,data);
			}
		}
	});
}
//최근내역 불러오기
function latelyList(lrcurpage,data){
	$("#lateTable tbody").children().remove();
	var ltDom='';
	if(data.rvlist.length==0){
		$("#lateTable").css({"position":"relative","top":"0px"});
		ltDom+='<tr><td colspan="7"> 최근 예약내역이 없습니다.</td>';
	}else{
		for(var i=0; i<data.rvlist.length; i++){
			ltDom+='<tr><td>'+data.rvlist[i].reservdate+'</td>';
			ltDom+='<td>'+data.rvlist[i].branchName+'</td>';
			ltDom+='<td><a href="javascript:window.location.href=roomDetail.udo?roomnum='+data.rvlist[i].roomNum+'">'+data.rvlist[i].roomName+'</a></td>';
			ltDom+='<td>02.2222.2222</td>';
			ltDom+='<td>'+data.rvlist[i].branchAddr1+'</td>';
			ltDom+='<td>'+data.rvlist[i].starttime+'~'+data.rvlist[i].endtime+'</td>';	
			ltDom+='<td id="'+data.rvlist[i].imp_uid+'">';
			//환불가능상태
			if(data.rvlist[i].status==1){
				ltDom+='<button class="cancle" onclick=cancleReserve(&#039'+data.rvlist[i].imp_uid+'&#039)>취소/환불</button>';
				ltDom+='<button class="showRecipe" onclick="window.open(&#039'+data.rvlist[i].receipt_url+'&#039,&#039window_name&#039,&#039width=500,height=750,location=no,status=n&#039)">영수증</button>';
			}
			//환불요청상태
			if(data.rvlist[i].status==-2){
				ltDom+='<label>환불진행중</label>';
			}
			//환불상태
			if(data.rvlist[i].status==-1){
				ltDom+='<label>환불완료</label>';
				ltDom+='</td></tr>';
			}
		}
	}
	$("#lateTable tbody").append(ltDom);
	blockPage("ltPaging",lrcurpage,data.rvpager.BLOCK_SCALE,data.rvpager.totPage,"ltli","getReservList","pay");
}
//지난내역 및 검색 불러오기
function lastList(lrcurpage,data){
	$("#lastTable tbody").children().remove();
	
	var ltDom='';
	var ltmDom='';
	if(data.rvlist.length==0&&stdate==''){
		ltDom+='<tr><td colspan="5"> 지난 6개월간의 예약정보가 없습니다.</td>';
	}else if(data.rvlist.length==0&&stdate!=''){
		ltDom+='<tr><td colspan="5"> 선택하신 날짜안의 지난 예약정보가 없습니다.</td>';
	}else{
		for(var i=0; i<data.rvlist.length; i++){
			ltDom+='<tr><td>'+data.rvlist[i].reservdate+'</td>';
			ltDom+='<td>'+data.rvlist[i].starttime+'~'+data.rvlist[i].endtime+'</td>';	
			ltDom+='<td>'+data.rvlist[i].branchName+'</td>';
			ltDom+='<td><a href="roomDetail.udo?roomnum='+data.rvlist[i].roomNum+'">'+data.rvlist[i].roomName+'</a></td>';
			console.log(data.rvlist[i].roomNum);
			if(data.rvlist[i].status==-2){
				ltDom+='<td colspan="2"><label>환불진행중</label>';
			}else if(data.rvlist[i].status==-1){
				ltDom+='<td><label>환불완료/label>';
				ltDom+='<button class="showRecipe" onclick="window.open(&#039'+data.rvlist[i].receipt_url+'&#039,&#039window_name&#039,&#039width=500,height=750,location=no,status=n&#039)">영수증</button></td>';
			}else{
				for(var j=0; j<hasuserreview.length; j++){
					if(data.rvlist[i].roomNum==hasuserreview[j]){
						ltmDom='<td><button class="showRecipe" onclick="window.open(&#039'+data.rvlist[i].receipt_url+'&#039,&#039window_name&#039,&#039width=500,height=750,location=no,status=n&#039)">영수증</button></td>';
						break;
					}else{//(hasuserreview[j]!=data.rvlist[i].roomNum)
						ltmDom='<td><button class="reviewBtn'+data.rvlist[i].imp_uid+'" onclick="openReview('+data.rvlist[i].roomNum+')">리뷰쓰기</button>'+
						'<button class="showRecipe" onclick="window.open(&#039'+data.rvlist[i].receipt_url+'&#039,&#039window_name&#039,&#039width=500,height=750,location=no,status=n&#039)">영수증</button></td>';
					}
				}
				ltDom+=ltmDom;
				
			}
			
		}
	}
	
	$("#lastTable tbody").append(ltDom);
	if(stdate!=''){
		blockPage("lastPaging",lrcurpage,data.rvpager.BLOCK_SCALE,data.rvpager.totPage,"lstli","getReservList","search");
	}else{
		blockPage("lastPaging",lrcurpage,data.rvpager.BLOCK_SCALE,data.rvpager.totPage,"lstli","getReservList","reserved");
	}
}
//적용시 처리
function lastSearch(){
	stdate=$("#stdate").val();
	endate=$("#endate").val();

	var localdate=new Date();
	var month = (localdate.getMonth() + 101).toString().substring(1);
	var day = (localdate.getDate() + 100).toString().substring(1);
	var year = localdate.getFullYear();
	var thisdate=year+month+day;
	
	var selsplit=stdate.split("-");
	var selstpdate="";
	
	for ( var i in selsplit ) {
		selstpdate+=selsplit[i];
     }
	
	selsplit=endate.split("-");
	var seledpdate="";
	
	for ( var i in selsplit ) {
		seledpdate+=selsplit[i];
     }
	
	
	if(selstpdate>thisdate){
		alert("지난내역은 오늘날짜 까지만 적용됩니다.");
	}else if(seledpdate>thisdate){
		alert("지난내역은 오늘날짜 까지만 적용됩니다.");
	}else if(stdate==''){
		alert("날짜를 모두 선택해주세요~ 하루만 선택시 두날짜 모두 같은날짜로 해주시면됩니다^^");
	}else if(endate==''){
		alert("날짜를 모두 선택해주세요~ 하루만 선택시 두날짜 모두 같은날짜로 해주시면됩니다^^");
	}else{
		getReservList('search',1,stdate,endate);
	}
}


//별 갯수 환산
function star1Click(){
		var image=$("#star1").attr('src');
		if(image.match("star.png")){
			switch(stcount){
			case 1:
				$("#star1").attr('src','resources/util/unstar.png');	
				stcount=0;
				break;
			case 2:
				$("#star2").attr('src','resources/util/unstar.png');	
				stcount=1;
				break;
			case 3:
				$("#star2").attr('src','resources/util/unstar.png');	
				$("#star3").attr('src','resources/util/unstar.png');	
				stcount=1;
				break;
			case 4:
				$("#star2").attr('src','resources/util/unstar.png');	
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');	
				stcount=1;
				break;
			case 5:
				$("#star2").attr('src','resources/util/unstar.png');	
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');
				$("#star5").attr('src','resources/util/unstar.png');	
				stcount=1;
				break;
			default : break;
			}
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			stcount=1;
		}
		$("#starcount").text(stcount);

}
function star2Click(){
		var image=$("#star2").attr('src');
		if(image.match("star.png")){
			switch(stcount){
			case 2:
				$("#star2").attr('src','resources/util/unstar.png');	
				stcount=1;
				break;
			case 3:
				$("#star3").attr('src','resources/util/unstar.png');	
				stcount=2;
				break;
			case 4:
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');	
				stcount=2;
				break;
			case 5:
				$("#star3").attr('src','resources/util/unstar.png');	
				$("#star4").attr('src','resources/util/unstar.png');
				$("#star5").attr('src','resources/util/unstar.png');	
				stcount=2;
				break;
			default : break;
			}
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			$("#star2").attr('src','resources/util/star.png');
			stcount=2;
		}
		$("#starcount").text(stcount);
}


function star3Click(){
		var image=$("#star3").attr('src');
		if(image.match("star.png")){
			switch(stcount){
			case 3:
				$("#star3").attr('src','resources/util/unstar.png');	
				stcount=2;
				break;
			case 4:
				$("#star4").attr('src','resources/util/unstar.png');	
				stcount=3;
				break;
			case 5:
				$("#star4").attr('src','resources/util/unstar.png');
				$("#star5").attr('src','resources/util/unstar.png');	
				stcount=3;
				break;
			default : break;
			}
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			$("#star2").attr('src','resources/util/star.png');
			$("#star3").attr('src','resources/util/star.png');
			stcount=3;
		}
		$("#starcount").text(stcount);
}


function star4Click(){
		var image=$("#star4").attr('src');
		if(stcount==4&&image.match("star.png")){
			$("#star4").attr('src','resources/util/unstar.png');
			stcount=3;
		}
		if(stcount==5&&image.match("star.png")){
			$("#star5").attr('src','resources/util/unstar.png');
			stcount=4;
		}
		if(image.match("unstar.png")){
			$("#star1").attr('src','resources/util/star.png');
			$("#star2").attr('src','resources/util/star.png');
			$("#star3").attr('src','resources/util/star.png');
			$("#star4").attr('src','resources/util/star.png');
			stcount=4;
		}
		$("#starcount").text(stcount);
}
function star5Click(){

		var image=$("#star5").attr('src');
		if(stcount==5&&image.match("star.png")){
			$("#star5").attr('src','resources/util/unstar.png');
			stcount=4;
			$("#starcount").text(stcount);
			return;
		}
		if(image.match("unstar.png")){
			$(".star").attr('src','resources/util/star.png');
			stcount=5;
		}
		$("#starcount").text(stcount);
}