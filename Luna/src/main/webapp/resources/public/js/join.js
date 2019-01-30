$(window).load(function() {
	$("td").val("");
	$("input").focusout(function() {
		if ($(this).val() != "") {
			$(this).addClass("has-content");
		} else {
			$(this).removeClass("has-content");
		}
	});
});

function isbranch(){
	var url='join.do?br=on';
	window.location=url;
}
function isMem(){
	var url='join.do?br=off';
	window.location=url;
}

function idCheck(){
	var id=$("#id").val();
	if (id=='') {
		alert("아이디를 입력해 주세요.");
		$("#id").focus();
		return;
	}else{
		var popupX = (window.screen.width / 2) - (200 / 2);
		var popupY= (window.screen.height /2) - (300 / 2);
		
		/* post */
		var form = document.createElement("form");
		url="idCheck.do";
		window.open("","form",'status=no, width=200,height=10,left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
		
		form.method="post";
		form.action=url;
		form.target="form";
		var input = document.createElement('input');
		input.type = 'hidden';
		input.name = 'id';
		input.value = id;
		form.appendChild(input);
		document.body.appendChild(form);
		
		form.submit();
		
		document.body.removeChild(form);
	}
}

function inputCheck() {	
	//일반 회원
	if ($("#id").val() == "") {
		alert("아이디를 입력해 주세요.");
		$("#id").focus();
		return false;
	}
	if ($("#pw").val() == "") {
		alert("비밀번호를 입력해주세요.");
		$("#pw").focus();
		return false;
	}
	if ($("#repw").val() == "") {
		alert("비밀번호를 확인해주세요.");
		$("#repw").focus();
		return false;
	}
	if ($("#pw").val() != $("#repw").val()) {
		alert("비밀번호가 일치하지 않습니다.");
		$("#repw").focus();
		return false;
	}
	
	if ($("#name").val() == "") {
		alert("이름을 입력해 주세요.");
		$("#name").focus();
		return false;
	}
	
	var regExphone = /^\d{3}-\d{3,4}-\d{4}$/;
	var tel=$("#phone").val();
	
	if (tel == "") {
		alert("전화번호를 입력해주세요.");
		$("#phone").focus();
		return false;
	}
	if(!regExphone.test(tel)){
		alert("원활할 예약을 위해 적절한 전화번호를 입력해주세요");
		$("#phone").focus();
		return false;
	}
	
	var regExpbirth = /^[0-9]+$/;
	
	var birth=$("#birth").val();
	if (birth == "") {
		alert("생일를 입력해주세요");
		$("#birth").focus();
		return false;
	}
	if(!regExpbirth.test(birth)){
		alert("생일에 숫자만 입력해주세요");
		$("#birth").focus();
		return false;
	}
	
	var str = $("#email").val();
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
	
	if (!(atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1&& commaPos == -1 && atPos + 1 < dotPos && dotPos + 1 < eMailSize)){
		alert("E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요!");
		$("#email").focus();
		return false;
	}
	/*
	if ($("#sample2_postcode").val() == "") {
		alert("우편번호를 입력해주세요.");
		$("#sample2_postcode").focus();
		return false;
	}
	if($("#sample2_address").val() == ""){
		alert("주소를 입력해주세요");
		$("#sample2_address").focus();
		return false;
	}
	if ($("#sample2_detailAddress").val() == "") {
		alert("상세주소를 입력해주세요.");
		$("#sample2_detailAddress").focus();
		return false;
	}
	if ($("#branch").val() == "") {
		alert("지점명을 입력해주세요");
		$("#branch").focus();
		return false;
	}
	*/
	$("join").submit();
}
