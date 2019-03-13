function check() {
	/* || $("#subject").value=="" */
	if(subject.value==""){
		alert("제목이 입력되지않았습니다");
		$("#subject").focus();
		return false;
	}else if(content.value==""){
		alert("내용이 입력되지않았습니다");
		$("#content").focus();
		return false;
	}
	return true;
}