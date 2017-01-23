function myFunction() {
	
	nmUser = document.getElementById("ip-user").value;
	password = document.getElementById("ip-password").value;
	
	if (nmUser == ""){
		alert ('Please, put the information of user');    
		document.getElementById("ip-user").focus();
		return false;
	}
	
	if (password == ""){
		alert ('Please, put the information of password');    
		document.getElementById("ip-password").focus();
		return false;
	}
		
	$.ajax({
        url: "tspoLogin",
        type: 'POST',
        data: {'nmUser' : nmUser, 'password' : password},		
        success: function (data) {
        	
        	if	(data == 'OK'){
        		location.href='anotherPage.html';
        	}else{
        		alert ('Wrong informations');
        		location.reload();
        	}
        	
        	
        	return false;
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });
	
	return false;
}