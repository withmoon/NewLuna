/*진행 이벤트*/
$(function() {
	$('.eventNow1').click(function() {
		$('.eventFinsh2').hide();
		$('.eventNow2').show();
	});
});

/*종료 이벤트*/
$(function() {
	$('.eventFinsh2').hide();
	$('.eventFinsh1').click(function() {
		$('.eventNow2').hide();
		$('.eventFinsh2').show();
	});
});

function eventChanging(){
	$.ajax({      
		 type:"GET",  
		 url:"eventChange.udo",    
	     data:{"eEvnet":""},      
	     success:function(data){   
	    	 var my_tbody = document.getElementById('my-tbody');
	    	 var new_tbody=document.createElement('tbody');
	    	 new_tbody.id='my-tbody'
	    	 
	    	 for(var i=0; i<data.length; i++){
	    	
	    		 var newRow   = new_tbody.insertRow(new_tbody.rows.length);

	    	 	var newCell  = newRow.insertCell(0);

	    	 	var newText  = document.createTextNode('New row2');
	    	 	newCell.appendChild(newText);
	    	 }
	    	 my_tbody.parentNode.replaceChild(new_tbody,my_tbody);
	     }
	});   
}

function eventChange(){
	alert("안냥");
	$.ajax({      
		 type:"GET",  
		 url:"eventChange.udo",    
	     data:{"eEvnet":"end"},      
	     success:function(data){   
	    	 var my_tbody = document.getElementById('my-tbody');
	    	 var new_tbody=document.createElement('tbody');
	    	 new_tbody.id='my-tbody';
	    	 for(var i=0; i<data.length; i++){
	    	
	    		 var newRow   = new_tbody.insertRow(new_tbody.rows.length);

	    	 	var newCell  = newRow.insertCell(0);

	    	 	/*var newText  = document.createTextNode('New row');*/
	    	 	ocument.createElement('tbody');
	    	 	
	    	 	newCell.appendChild(newText);
	    	 }
	    	 my_tbody.parentNode.replaceChild(new_tbody,my_tbody);
	     }
	});   
}