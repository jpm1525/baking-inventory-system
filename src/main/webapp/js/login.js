$("#btnLogin").click(function() {
	$.post("UserController", {
		action: "login",
		username: $('#username').val(),
		password: $('#login-password').val()
	}, function(response) {
		
		if(response.includes("Invalid Username or Password")) {
			alert(response);
		} else {
			$("#divMenu").html(response);
			$('#divMain').html("");
			$("#btnDashboard").click();
		}
		
	});
});


function checkUserSession() {
	$.get('UserController', {
		action: 'checkUserSession'
	}, function(response) {
		if (response !== 'No existing user session') {
			$("#divMenu").html(response);
			$('#divMain').html("");
			$('#btnDashboard').click();
		}
	});
}

checkUserSession();