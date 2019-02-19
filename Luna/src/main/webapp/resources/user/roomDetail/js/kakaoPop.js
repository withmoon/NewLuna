function kakapop(){
	var popupX = (window.screen.width / 2) - (200 / 2);
	var popupY= (window.screen.height /2) - 300;
	
	var form = document.createElement("form");
	url="kakaopay.udo";
	window.open("","form","scrollbars=1,resizable=1,width=400,height=550,left="+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	
	form.method="post";
	form.action=url;
	form.target="form";
	
	var input1 = document.createElement('input');
	input1.type = 'hidden';
	input1.name = 'payAmount';
	input1.value = $("#payAmount").val();
	form.appendChild(input1);
	var input2 = document.createElement('input');
	input2.type = 'hidden';
	input2.name = 'roomName';
	input2.value = $("#rname").val();
	form.appendChild(input2);
	var input3 = document.createElement('input');
	input3.type = 'hidden';
	input3.name = 'branchName';
	input3.value = $("#bex1").text();
	form.appendChild(input3);
	var input4 = document.createElement('input');
	input4.type = 'hidden';
	input4.name = 'roomNum';
	input4.value = $("#roomNum").val();
	form.appendChild(input4);
	
	document.body.appendChild(form);
	
	form.submit();
	
	document.body.removeChild(form);
}