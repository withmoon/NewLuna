/*$(document).ready(function() {
	$("#write").click(function() {
		$ajax({
			url : "boardinsert.mdo",
			dataType : "html",
			type : "get",
			success : function(result) {
				$("#board").html(result);
				alert("성공");
			},
			error: function() {
				alert("실패");
			}			
		});
	});

	// $("#div 아이디").load("로딩할 페이지 URL", {넘길 파라메터});

});
 */

/*function boardview() {
	var	title = $("#title");
	$.ajax({
		type : 'get',
		url : 'boardview.mdo',
		data : title,
		dataType: 'Json',
		success : function(data) {
			$("#board").load("boardview.mdo",data);
			$("#board").html(data);
			alert("성공"+$("#title"));
		},
		complete : function(data) {
		
			alert( "실패"+console.log(data));
		},
		error: function(data) {
			alert("에러"+console.log(data));
		}
	});
}*/ 
$(function(){
	getReportlist(1);
});
function writeReport(){
	$("#board").hide();
	$(".board").show();
}
//리포트 보내기
function changeContent(){
	$("#content").val($("#ctt").val());
}
//리포트 삭제
function deleteReport(){
	
}
//리포트 수정
function updateReport(){
	
}
//보내기 취소
function nosend(){
	$(".board").hide();
	$("#board").show();
}
//리포트 검색
function searchReport(){
	
}
//리포트 가져오기
function getReportlist(curPage){
	var searchOption='';
	var keyword='';
	$.ajax({
		type : 'POST',
		url : 'getReportlist.do',
		data : {curPage:curPage,searchOption:searchOption,keyword:keyword },
		success : function(data) {
			$("#write").append(data.count+"개의 개시물이 있습니다.");
			
		}
	});
}
function insertboard() {

	$("#board").load("boardinsert.mdo");
}
