$("#btnLogin").click(function() {
	let username = $('#username').val();
	let password = $('#login-password').val();

	if (username === "" || password === "") {
		$('#errorResponse').text("Please fill in both the username and password.").show();
		return;
	}
	
	$("#login-form").hide();
	$("#loading-screen").show();

	$.post("UserController", {
		action: "login",
		username: username,
		password: password
	}).done(function(response) {
		$("#loading-screen").hide();

		if (response.includes("Invalid Username or Password")) {
			$("#login-form").show();
			$("#loading-screen").hide();
			$('#errorResponse').text("Invalid Username or Password").show();
		} else {
			$("#divMenu").html(response);
			$('#divMain').html("");
		}
	})
});

$("#login-clear").click(function() {
	$('#errorResponse').hide();
});

document.addEventListener('DOMContentLoaded', (event) => {
	attachLoginEvent();
});

function attachLoginEvent() {
	form = document.getElementById('login-form');
	loginButton = document.getElementById('btnLogin');

	if (form && loginButton) {
		function handleEnterKeyPress(e) {
			if (e.key === 'Enter') {
				e.preventDefault();
				loginButton.click();
			}
		}
		form.addEventListener('keypress', handleEnterKeyPress);
	}
}
