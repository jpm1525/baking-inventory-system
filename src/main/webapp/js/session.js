function checkUserSession() {
	$.get('UserController', {
		action: 'checkUserSession'
	}, function(response) {
		if (response.includes('loginjsp')) {
			$('#divContent').html(response);
		} else {
			$('#divMenu').html(response);
			$('#divMain').html("");
			$('#btnDashboard').click();
		}
	});
}

checkUserSession();