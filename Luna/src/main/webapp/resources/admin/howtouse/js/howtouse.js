var formnum=0;
//글쓰기 폼
function showWriteForm(){
	$("#listForm").hide();
	$("#writeForm").show();
}
//글쓰기 취소
function cancleWrite(){
	$(".form0tx").val("");
	$("#listForm").show();
	for(var i=1; i<formnum+1; i++){
		$(".form"+i).remove();
	}
	$("#writeForm").hide();
}
//글쓰기 폼 추가
function addWriteForm(){
	formnum++;
	var addDom='';
	addDom+='<tr class="form'+formnum+'"><th>내용:</th>';
	addDom+='<td><textarea id="content'+formnum+'" name="content'+formnum+'" cols="110" rows="5"></textarea></td>';
	addDom+='<td align="center" rowspan="2"><input type="button"  onclick="addWriteForm()" value="추가"/><br/>';
	addDom+='<input type="button"  onclick="delWriteForm('+formnum+')" value="삭제"/></td>';
	addDom+='</tr> <tr class="form'+formnum+'"> <th>파일:</th>';
	addDom+='<td><input type="file" name="file" placeholder="file" id="file" value="file" class="form-control" ></td> </tr>';
   $("#writeForm table tbody").append(addDom);
}
//write중 삭제 클릭시
function delWriteForm(formnum){
	$(".form"+formnum).remove();
}
//값 세팅
function setVal(){
	$("#maxCnum").val(formnum);
}