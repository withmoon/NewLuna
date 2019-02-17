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

function insertboard() {

	$("#board").load("boardinsert.mdo");
}
