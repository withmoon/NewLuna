/*진행 이벤트*/
$(function() {
	$('.eventNow').click(function() {
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
	});
});

/*종료 이벤트*/
$(function() {
	$('.eventFinsh').click(function() {
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

		    	 	var newSeq = newRow.insertCell(0);
		    	 	var newText  = document.createTextNode(data[i].seq);
		    	 	newSeq.appendChild(newText);
		    	 	
		    	 	var newTitle = newRow.insertCell(1);
		    	 	var newText1  = document.createTextNode(data[i].title);
		    	 	newTitle.appendChild(newText1);
		    	 	
		    	 	var newWriter = newRow.insertCell(2);
		    	 	var newbtnText = document.createElement('a');
		    	 	var newText2  = document.createTextNode(data[i].writer);
		    	 	
		    	 	newbtnText.appendChild(newText2);
		    	 	newWriter.appendChild(newText2);
		    	 	
		    	 	var newDate = newRow.insertCell(3);
		    	 	var startdate = new Date(data[i].startdate);
		    	 	var startdateFormat = startdate.toISOString().slice(2,10);
		    	 	var enddate = new Date(data[i].enddate);
		    	 	var enddateFormat = enddate.toISOString().slice(2,10);
		    	 	var newText3  = document.createTextNode(startdateFormat + ' ~ ' + enddateFormat);
		    	 	newDate.appendChild(newText3);
		    	 }
		    	 my_tbody.parentNode.replaceChild(new_tbody,my_tbody);
		     }
		});   
	});
	
	
});

/*function eventChanging(){
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

	    	 	var newText  = document.createTextNode('New row');
	    	 	ocument.createElement('tbody');
	    	 	
	    	 	newCell.appendChild(newText);
	    	 }
	    	 my_tbody.parentNode.replaceChild(new_tbody,my_tbody);
	     }
	});   
}*/