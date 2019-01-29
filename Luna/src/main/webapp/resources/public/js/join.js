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
	if ($("#id").val()=='') {
		alert("아이디를 입력해 주세요.");
		$("#id").focus();
		return;
	}

	if ($("#pw").val()=='') {
		alert("비밀번호를 입력해주세요.");
		$("#pw").focus();
		return;
	}

	if ($("#repw").val()=='') {
		alert("비밀번호를 확인해주세요.");
		$("#repw").focus();
		return;
	}

	if ($("#pw").val() != $("#repw").val()) {
		alert("비밀번호가 일치하지 않습니다.");
		$("#repw").focus();
		return;
	}

	if ($("#name").val()=='') {
		alert("이름을 입력해 주세요.");
		$("#name").focus();
		return;
	}

	if ($("#tel").val()=='') {
		alert("전화번호를 입력해주세요.");
		$("#tel").focus();
		return;
	}

	if ($("#birth").val()=='') {
		alert("생일를 입력해주세요");
		$("#birth").focus();
		return;
	}

	var str = $("#email").val();
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;

	if (atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1
			&& commaPos == -1 && atPos + 1 < dotPos && dotPos + 1 < eMailSize)
		;
	else {
		alert("E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요!");
		$("#email").focus();
		return;
	}

	//지점장
	

	if (document.join.address1.value = "") {
		alert("주소를 입력해주세요.");
		document.join.address1.focus();
		return;
	}

	if (document.join.address2.value = "") {
		alert("상세주소를 입력해주세요.");
		document.join.address2.focus();
		return;
	}
	
	if (document.join.branch.value = "") {
		alert("지점명을 입력해주세요");
		document.join.branch.focus();
		return;
	}

	document.join.submit();
}
