/*공지사항*/
$(function() {
	$('.list_tab2').hide();

	$('.informNotice').click(function() {
		$('.list_tab2').hide();
		$('.list_tab').show();
		
		$.ajax({
			type:"GET",
			url:"informChange.udo",
			data:{"informQ":""},
			success:function(data) {
				/*테이블*/
				var inform_table = document.getElementById('inform_table');
				var new_table = document.createElement('tbody');
				new_table.id = 'inform_table';
				console.log(data.length);
				for(var i=0; i<data.length; i++) {
					var newRow = new_table.insertRow(new_table.rows.length);
					
					var newNum = newRow.insertCell(0);
					var num = data[i].num;
					var newText = document.createTextNode(num);
					newNum.appendChild(newText);
					
					var newTitle = newRow.insertCell(1);
					var a = document.createElement('a');
					var newText1 = document.createTextNode(data[i].title);
					a.appendChild(newText1);
					newTitle.appendChild(a);
					(function(num) {
						a.addEventListener('click', function() {
							window.open('viewNotice.udo?num='+num,'_self');
						}, false);
					})(num);
					
					var newDate = newRow.insertCell(2);
					var regdate = new Date(data[i].regdate);
					var regdateFormat = regdate.toISOString().slice(2,10);
					var newText2 = document.createTextNode(regdateFormat);
					newDate.appendChild(newText2);
				}
				inform_table.parentNode.replaceChild(new_table,inform_table);
				
			}
		}); //end ajax
	}); //end click
});

/*자주묻는계시판*/
$(function() {
	$('.list_tab2').hide();

	$('.informQnA').click(function() {
		$('.list_tab2').hide();
		$('.list_tab').show();
		
		$.ajax({
			type:"GET",
			url:"informChange.udo",
			data:{"informQ":"informQnA"},
			success:function(data) {
				/*테이블*/
				var inform_table = document.getElementById('inform_table');
				var new_table = document.createElement('tbody');
				new_table.id = 'inform_table';
				
				for(var i=0; i<data.length; i++) {
					var newRow = new_table.insertRow(new_table.rows.length);
					
					var newNum = newRow.insertCell(0);
					var num = data[i].num;
					var newText = document.createTextNode(num);
					newNum.appendChild(newText);
					var newSubject = newRow.insertCell(1);
					var a = document.createElement('a');
					var newText1 = document.createTextNode(data[i].subject);
					a.appendChild(newText1);
					newSubject.appendChild(a);
					(function(num) {
						a.addEventListener('click', function() {
							window.open('viewQnA.udo?num='+num,'_self');
						}, false);
					})(num);
					
					var newDate = newRow.insertCell(2);
					var regdate = new Date(data[i].regdate);
					var regdateFormat = regdate.toISOString().slice(2,10);
					var newText2 = document.createTextNode(regdateFormat);
					newDate.appendChild(newText2);
					
					/*페이지*/
					$('#inform_page').children().remove();
					
					var num = data[i].num;
					var curBlock = data.curBlock;
					var prevPage = data.prevPage;
					var nextPage = data.nextPage;
					var blockBegin = data.blockBegin;
					var blockEnd = data.blockEnd;
					var totBlock = data.totBlock;
					var totPage = data.totPage;
					
					var paging='';
					
					paging += '<tr><td>';
					
					paging += '<b>하하하ㅏ</b>';
					
					if(curBlock > 1) {
						paging += '<a href=\"javascript:qnaList(1)">[처음]</a>'
							'<a href=\"avascript:qnaList('+prevPage+')">[이전]</a>';
					}
					
					for(var x=blockBegin; x<=blockEnd; x++) {
						if(num == curpage) {
							paging += num+'&nbsp;';
						} else {
							paging += '<a href=\"javascript:qnaList('+num+')">'+num+'</a>&nbsp;';
						}
					}
					
					if(curBlock <= totBlock) {
						paging += '<a href=\"javascript:qnaList('+nextPage+')">[다음]</a>';
					}
					
					if(curBlock <= totPage) {
						paging += '<a href=\"javascript:qnaList('+totPage+')">[끝]</a>';
					}
					
					paging += '</td></tr>';
					
					$('#inform_page').append(paging);
				}
				inform_table.parentNode.replaceChild(new_table,inform_table);
				
			}
		}); //end ajax
	}); //end click
});

function noticeList(page) {
	location.href="inform.udo?curPage="+page;
}

function qnaList(page) {
	location.href="inform.udo?curPage="+page;
}

/*고객의 소리*/
$(function() {
	$('.informUser').click(function() {
		$('.list_tab').hide();
		$('.list_tab2').show();
		
	});
	
var area0= $("#sido_select>option").map(function() { return $(this).val(); });
	
	
	// 시/도 선택 박스 초기화
	$("select[name^=sido]").each(function() {
		$selsido = $(this);
		$selsido.next().append("<option value=''>시/구/군 선택</option>");
	});

	 
	// 시/도 선택시 구/군 설정
	$("select[name^=sido]").change(function() {
		var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의
																					// 구군
																					// Array
		var $gugun = $(this).next(); // 선택영역 군구 객체
		$("option",$gugun).remove(); // 구군 초기화
		
		var sido=$("option:selected",$(this));
		
		$.ajax({      
			 type:"GET",  
			 url:"getSidoGugun.udo",    
		     data:sido,      
		     success:function(data){   
		    	 for(var i=0; i<data.length; i++){
		    		 $gugun.append("<option value='"+data[i]+"'>"+data[i]+"</option>");
		    	 }
		     }
		});
	});
	
	$("select[name^=gugun]").each(function() {
		$selgugun = $(this);
		$selgugun.next().append("<option value=''>지점 선택</option>");
	});
	
	// 지점 설정
	$("select[name^=gugun]").change(function() {
		var area = "area"+$("option",$(this)).index($("option:selected",$(this)));
		
		var $branch = $(this).next();
		$("option",$branch).remove();
		
		var gugun = $("option:selected", $(this));
		
		$.ajax({      
			 type:"GET",  
			 url:"branchName.udo",    
		     data:gugun,      
		     success:function(data){   
		    	 for(var i=0; i<data.length; i++){
		    		 $branch.append("<option value='"+data[i]+"'>"+data[i]+"</option>");
		    	 }
		     }
		});
	});
});

//고객의 소리 보내기
function userCommand(){
	var branchName=$("#branch").val();
	var title=$("#title").val();
	var content=$("#content").val();

	$.ajax({
		type:"POST",
		url:"informUser.udo",
		data:{branchName:branchName,title:title,content:content},
		success:function(data) {
			$('#branch').val("");
			$('#title').val("");
			$('#content').val("");
			
			alert("소중한 의견 너무나 감사합니다~");
			
			var url='mypage.udo';
			window.location=url;
		}
	});
}