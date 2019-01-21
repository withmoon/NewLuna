$(document).ready(function() {
	$("#img1").hover(showSd(),hideSd());
});
function showSd(){
	$("#showSchedule").display="";
	$("#showSchedule").show();
}
function hideSd(){
	$("#showSchedule").hide();
}