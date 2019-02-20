/*공지사항*/
$(function() {
	$('.informNotice').click(function() {
		$.ajax({
			type:"GET",
			url:"informChange.udo",
			data:{"informQ":""},
			success:function(data) {
				/*테이블*/
				var inform_table = document.getElementById('inform_table');
				var new_table = document.createElement('tbody');
				new_table.id = 'inform_table';
				
				/*페이지*/
				var inform_page = document.getElementById('inform_page');
				var new_page = document.createElement('tbody');
				new_page.id = 'inform_page';
				
				for(var i=0; i<data.length; i++) {
					var newRow = new_table.insertRow(new_table.rows.length);
					
					/*var newNum = newRow.insertCell(0);
					var num = data[i].num;
					var newText = document.createTextNode(num);
					newNum.appendChild(newText);*/
				}
			}
		}); //end ajax
	}); //end click
});

/*자주묻는계시판*/
$(function() {
	$('.informQnA').click(function() {
		$.ajax({
			type:"GET",
			url:"informChange.udo",
			data:{"informQ":"informQnA"}
		}); //end ajax
	}); //end click
});