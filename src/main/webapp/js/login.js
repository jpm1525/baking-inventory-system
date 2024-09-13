$("#btnLogin").click(function() {
    // Get the username and password values
    let username = $('#username').val();
    let password = $('#login-password').val();

    // Validate the form inputs
    if (username === "" || password === "") {
		$('#errorResponse').text("Please fill in both the username and password.").show();
        return; // Stop if the form is not filled
    }

    // Hide login form and show loading screen
    $("#login-form").hide();
    $("#loading-screen").show();

    // Send login request to the server
    $.post("UserController", {
        action: "login",
        username: username,
        password: password
    }).done(function(response) {
        // Hide the loading screen
        $("#loading-screen").hide();

        if (response.includes("Invalid Username or Password")) {
            // Show login form again and display the error message
            $("#login-form").show();
            $("#loading-screen").hide();
            // Display error message
            $('#errorResponse').text("Invalid Username or Password").show();
        } else {
            // On successful login, load the main menu
            $("#divMenu").html(response);
            $('#divMain').html("");
        }
    }).fail(function() {
        // Hide the loading screen in case of an error (e.g., server is unreachable)
        $("#loading-screen").hide();
        // Show login form again on error
        $("#login-form").show();
        // Hide error message
        $("#login-form p.text-red-500").hide();
        alert("An error occurred. Please try again.");
    });
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
    // Function to handle Enter key press
    function handleEnterKeyPress(e) {
      if (e.key === 'Enter') {
        e.preventDefault(); // Prevent the default form submission
        loginButton.click(); // Trigger the login button click event
      }
    }

    form.addEventListener('keypress', handleEnterKeyPress);
  }
}
