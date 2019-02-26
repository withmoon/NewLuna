//favorite id들
var fvTableId="#fvTable";
var fvTableTrId="fv";
var fvTableCount=$("#fvTable tbody tr").length-1;
var fvUlid="#fvPaging";
var fvlistlimit=2; //게시글제한수
var fvPageBox=5; //페이지 제한수

//최근내역 id들
var lateTaleId="#lateTable";
var lateTableTrId="ltd";
var lateTableCount=$("#lateTable tbody tr").length-1;
var lateUlid="#ltPaging";
var ltlistlimit=3; //게시글제한수
var ltPageBox=3; //페이지 제한수

//지난내역 id들
var lastTableId="#lastTable";
var lastTableTrId="ld";
var lastTableliId="ltli"
var lastTableCount=$("#lastTable tbody tr").length-1;
var lastUlid="#lastPaging";
var lslistlimit=5; //게시글제한수
var lsPageBox=3; //페이지 제한수

$(function(){
	getKeepList(1);
	
	//최근		  //테이블 전체 글수   , 테이블 id    , 테이블 tr id ,페이지ul아이디, 게시글번호제한, 페이지번호제한
	firstPageView(lateTableCount,lateTaleId,lateTableTrId,lateUlid,ltlistlimit,ltPageBox);
	//지난
	firstPageView(lastTableCount,lastTableId,lastTableTrId,lastUlid,lslistlimit,lsPageBox);
});

function getKeepList(kcurpage){
	$.ajax({      
		type:"GET",  
		url:"keeproomlist.udo",    
		data:{curpage:kcurpage},     
		success:function(data){
			console.log(data.kpager.totPage);
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
			//페이지처리
			$("#fvPaging").children().remove();
			var kpageDom='';
			for(var i=0; i<data.kpager.totPage; i++){
				kpageDom+='<a onclick="getKeepList('+(i+1)+')"><li>'+(i+1)+'</li></a>';
			}
			$("#fvPaging").append(kpageDom);
		}
	});
	return;
}

//첫 로딩시테이블 나눔
function firstPageView(pagingListCt,tableId,trId,ulid,listLimit,pageBox){
	//페이징 번호								//3==listLimit
	var pagecount=Math.floor(pagingListCt/listLimit)+1; //페이지 총 번호
	
	//번호에따른 li생성
	var pageStr=''; 
	for(var i=1; i<pagecount+1; i++){
		if(i<=pageBox){ //page번호 매기기
			pageStr+='<a id="'+ulid+i+'" onclick="javascript: changeClr(this); paging('+listLimit+','+pageBox+','+i+',&#039'+tableId+'&#039,&#039'+trId+'&#039);"><li>'+i+'</li></a>       '; 
		}else if(i==(pageBox+1)){//한정숫자가 되면 다음페이지에 다음번호 기억
			pageStr+='<a onclick="paging('+listLimit+','+pageBox+','+i+',&#039'+tableId+'&#039,&#039'+trId+'&#039,&#039'+ulid+'&#039,'+pagingListCt+')"><li>[다음]</li></a>       ';
			break;
		}
	}
	//3번째까지만 보여줌
	for(var i=1; i<listLimit+1; i++){ //1  listLimit+1
		$(tableId+" tbody #"+trId+i).show();
	}
	
	$(ulid).append(pageStr);
}
//게시글 보이기
function paging(listLimit,pageBox,pagenum,tableId,trId,ulid,pagingListCt){
	
	$(tableId+" tbody tr").hide();
						   //listLimit-(listLimit-1)
	var startnumber=pagenum*listLimit-(listLimit-1); //페이지 글 시작 번호

	if(pagenum!=1&&pagenum%pageBox==1){ //1이 아니고  pagenum%pageBox==1
		goNextPaging(pagenum,tableId,trId,ulid,pagingListCt,listLimit,pageBox); //3한정 페이지 넘어가면
	}
	
	if(ulid!=null&&pagenum%pageBox==0){ //null이 아니고  pagenum%pageBox==0
		goBeforePaging(pagenum,tableId,trId,ulid,pagingListCt,listLimit,pageBox);
	}
										//시작 번호부터 게시글 제한번호까지
	for(var i=startnumber; i<startnumber+listLimit; i++){
		$(tableId+" tbody #"+trId+i).show();
	}
}
//이전 눌렀을때
function goBeforePaging(pagenum,tableId,trId,ulid,pagingListCt,listLimit,pageBox){
	$(ulid+" li").remove();
	
	//페이징 총 번호
	var pagecount=Math.floor(pagingListCt/listLimit)+1; //pageListCt/listLimit +1
	
	//번호에따른 li생성
	var pageStr=''; //pageBox보다 크면 이전 생성
	if(pagenum!=pageBox){ //pageBox
		pageStr+='<a onclick="paging('+listLimit+','+pageBox+','+(pagenum-1)+',&#039'+tableId+'&#039,&#039'+trId+'&#039,&#039'+ulid+'&#039,'+pagingListCt+')"><li>[이전]</li></a>       ';
	}
	var startPagenum=pagenum-(pageBox-1); //pagenum-(pageBox-1)
	for(var i=startPagenum; i<pagecount+1; i++){
			if(i<=startPagenum+(pageBox-1)){ //startPagenum+(pageBox-1)
				pageStr+='<a onclick="paging('+listLimit+','+pageBox+','+i+',&#039'+tableId+'&#039,&#039'+trId+'&#039)"><li>'+i+'</li></a>       ';
			}else if(i==startPagenum+pageBox){ //startPagenum+pageBox
				pageStr+='<a onclick="paging('+listLimit+','+pageBox+','+i+',&#039'+tableId+'&#039,&#039'+trId+'&#039,&#039'+ulid+'&#039,'+pagingListCt+')"><li>[다음]</li></a>       ';
				break;
			}
	}
	
	$(ulid).append(pageStr);
	
}
//다음 눌렀을때
function goNextPaging(pagenum,tableId,trId,ulid,pagingListCt,listLimit,pageBox){
	$(ulid+" li").remove();
	
	//페이징 번호
	var pagecount=Math.floor(pagingListCt/listLimit)+1; //pageListCt/listLimit +1
	
	//번호에따른 li생성
	var pageStr=''; //이전 생성
	pageStr+='<a onclick="paging('+listLimit+','+pageBox+','+(pagenum-1)+',&#039'+tableId+'&#039,&#039'+trId+'&#039,&#039'+ulid+'&#039,'+pagingListCt+')"><li>[이전]</li></a>       ';
	for(var i=pagenum; i<pagecount+1; i++){
			if(i<=pagenum+(pageBox-1)){  //startPagenum+(pageBox-1)
				pageStr+='<a onclick="paging('+listLimit+','+pageBox+','+i+',&#039'+tableId+'&#039,&#039'+trId+'&#039)"><li>'+i+'</li></a>       ';
			}else if(i==pagenum+pageBox){ //startPagenum+pageBox
				pageStr+='<a onclick="paging('+listLimit+','+pageBox+','+i+',&#039'+tableId+'&#039,&#039'+trId+'&#039,&#039'+ulid+'&#039,'+pagingListCt+')"><li>[다음]</li></a>       ';
				break;
			}
	}
	
	$(ulid).append(pageStr);
}

function changeClr(tag){
	var x = document.getElementById(tag.id);
    x.style.fontSize = "20px";           
    x.style.color = "orange"; 
    $(x).siblings().css({"color": "black","font-size":"1.7vw"});
}