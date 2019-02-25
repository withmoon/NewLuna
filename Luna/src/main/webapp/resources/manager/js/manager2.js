/*function manager(){
    var f= null; //form name
//    f.page.value = s_page; //POST방식으로 넘기고 싶은 값
//    f.src_name.value = s_name; //POST값
//    f.src_value.value = s_value;//값
	alert("???");
    f.action="/manager.mdo"
    f.method="post"
    f.submit();
}*/

function manager() {
	var f = document.getElementById("logo");
	f.action = "/manager.mdo";
	f.method ="post";
	f.submit();
}



