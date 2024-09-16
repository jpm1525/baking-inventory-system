if (typeof data === 'undefined' || data === null) { let data = ""; }
if (typeof callback === 'undefined' || callback === null) { let callback = ""; }
if (typeof observer === 'undefined' || observer === null) { let observer = ""; }

var editButton = function(value, data, cell, row, options) {
	let thisButton = '<button class="px-4 py-2 text-white bg-indigo-500 rounded editModalButton"> Edit </button>';
	thisButton += '<button class="px-4 py-2 ml-5 text-white bg-red-500 rounded deleteModalButton"> Delete </button>';
	return thisButton;
};

var divTable = new Tabulator("#divTableTabulator", {
	layout: "fitColumns",
	data: userMain,
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector: [5, 10, 15, 20],
	paginationCounter: "rows",
	selectableRows: 1,
	columns: [
		{title:"User ID", field: 'userId', minWidth:50},
		{title:"Username", field: 'username', minWidth:100},
		{title:"Branch ID", field: 'branchId', minWidth:100},
		{title:"Action", headerSort:false, formatter:editButton, minWidth:200},
	],
});

$(".userForm").submit(function(e) {
	e.preventDefault();
});

divTable.on('rowClick', function() {
	let row = divTable.getSelectedData()[0];
	if (row !== undefined) {
		populateForm(row);
	}
})

callback = function(mutationsList, observer) {
	for (let mutation of mutationsList) {
		if (mutation.type === 'childList') {
			$(".editModalButton").off("click");
			$(".editModalButton").on('click', function() {
				editModal.classList.remove("closing");
				editModal.showModal();
				editModal.classList.add("showing");
			});
			$(".deleteModalButton").off("click");
			$(".deleteModalButton").on('click', function() {
				$("#deleteModal").removeClass("closing")
				deleteModal.showModal();
				$("#deleteModal").addClass("showing")
			});
		}
	}
};

observer = new MutationObserver(callback);
observer.observe(document.getElementById('divTableTabulator'), { childList: true, subtree: true });

$("#btnUserMain").click(function() {
	$.get("MaintenanceController", {
		action: "showUserMain"
	}, function(response) {
		$("#divContent").html(response)
	});
});

$('#deleteSaveModalButton').click(function(event) {
	event.stopImmediatePropagation();
	$.post('MaintenanceController', {
		action: 'deleteUserMaintenanceData',
		data: JSON.stringify(data)
	}, function(response) {
		if (response.includes('success')) {
			closeDeleteModal();
			$('#btnUserMain').click();
		} else {
			$('.errorMessage').text(response);
		}
	});
});

function populateForm(row) {
	$('#userIdUpdate').val(row.userId);
	$('#usernameUpdate').val(row.username);
	$('#branchIdUpdate').val(row.branchId);
	data = {
		userId: row.userId.toString(),
		username: row.username.toString(),
		password: row.password.toString(),
		branchId: row.branchId.toString()
	};
}


function validate(data) {
	let valid = true;
	if (data.username === '' || data.password === '' | data.branchId === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} else if (data.username.length > 50) {
		$('.errorMessage').text("User Name characters should be less than 51");
		valid = false;
	} else if (data.password.length > 50) {
		$('.errorMessage').text("Password characters should be less than 51");
		valid = false;
	} else if (data.branchId.length > 50) {
		$('.errorMessage').text("Branch ID characters should be less than 51");
		valid = false;
	}
	return valid;
}

function sendData(data) {
	if (validate(data)) {
		$.post('MaintenanceController', {
			action: 'saveUserMaintenanceData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				closeAddModal();
				closeEditModal();
				$('#btnUserMain').click();
			} else {
				$('.errorMessage').text(response);
			}
		});
	}
}

function addData() {
	let data = {
		userId: "0",
		username: $('#usernameCreate').val().toString(),
		password: $('#passwordCreate').val().toString(),
		branchId: $('#branchIdCreate').val().toString()
	};
	sendData(data);
}

function updateData() {
	let data = {
		userId: $('#userIdUpdate').val().toString(),
		username: $('#usernameUpdate').val().toString(),
		password: $('#passwordUpdate').val().toString(),
		branchId: $('#branchIdUpdate').val().toString()
	};
	sendData(data);
}

$('#btnCreateUserMain').click(addData);
$('#btnUpdateUserMain').click(updateData);