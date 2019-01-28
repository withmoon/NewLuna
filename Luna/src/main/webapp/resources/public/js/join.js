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

function inputCheck() {
	/*일반 회원*/
	if (document.join.id.value == "") {
		alert("아이디를 입력해 주세요.");
		document.join.id.focus();
		return;
	}

	if (document.join.pass.value == "") {
		alert("비밀번호를 입력해주세요.");
		document.join.pw.focus();
		return;
	}

	if (document.join.repass.value == "") {
		alert("비밀번호를 확인해주세요.");
		document.join.repw.focus();
		return;
	}

	if (document.join.pass.value != document.join.repass.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.join.repw.focus();
		return;
	}

	if (document.join.name.value == "") {
		alert("이름을 입력해 주세요.");
		document.join.name.focus();
		return;
	}

	if (document.join.phone.value == "") {
		alert("전화번호를 입력해주세요.");
		document.join.phone.focus();
		return;
	}

	if (document.join.birth.value == "") {
		alert("생일를 입력해주세요");
		document.join.birth.focus();
		return;
	}

	var str = document.join.email.value;
	var atPos = str.indexOf('@');
	var atLasPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;

	if (atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1
			&& commaPos == -1 && atPos + 1 < dotPos && dotPos + 1 < eMailSize)
		;
	else {
		alert("E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요!");
		document.join.email.focus();
		return;
	}

	/*지점장*/
	if (document.join.branch.value = "") {
		alert("지점명을 입력해주세요");
		document.join.branch.focus();
		return;
	}

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

	document.join.submit();
}