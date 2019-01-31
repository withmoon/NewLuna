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
function insertboard() {
	$("#board").load("boardinsert.mdo");
}

