function check() {
	if(title.value==""){
		alert("제목이 입력되지않았습니다");
		$("#title").focus();
		return false;
	}else if(content.value==""){
		alert("내용이 입력되지않았습니다");
		$("#content").focus();
		return false;
	}
	return true;
}