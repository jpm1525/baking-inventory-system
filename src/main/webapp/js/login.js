$("#btnLogin").click(function() {
	$.post("UserController", {
		action: "login",
		username: $('#username').val(),
		password: $('#login-password').val()
	}, function(response) {
		
		if(response.includes("Invalid Username or Password")){
			alert(response);
		}else{
			$("#divMenu").html(response);
			$('#divMain').html("");
		}
		
		//$("btnDashboard").click();
		
	});
});


function checkUserCookie() {
	$.get("UserController", {
		action: "checkUserCookie"
	}, function(response) {
		if(response.includes("No existing user cookie")) {
			console.log(response);
		} else {
			$("#divMenu").html(response);
			$("#btnDashboard").click();
		}
	});
}

checkUserCookie();