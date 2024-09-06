if (typeof data === 'undefined' || data === null) {let data = "";}
if (typeof callback === 'undefined' || callback === null) {let callback = "";}
if (typeof observer === 'undefined' || observer === null) {let observer = "";}

var editButton = function(value, data, cell, row, options){
	let thisButton = '<button class="px-4 py-2 text-white bg-indigo-500 rounded editModalButton"> Edit </button>';
		thisButton +='<button class="px-4 py-2 ml-5 text-white bg-red-500 rounded deleteModalButton"> Delete </button>'
    return thisButton;
};

var divTable = new Tabulator("#divTableTabulator" , {
	layout:"fitColumns",
	data: branch, 
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector:[5, 10, 15, 20],
	paginationCounter:"rows",
	selectableRows:1,
	columns: [
		{title:"Id", field: 'branchId', minWidth:50},
		{title:"Name", field: 'branchName', minWidth:100},
		{title:"Action" , headerSort:false, formatter:editButton, minWidth:200},
	],
});

$(".branchForm").submit(function(e){
	e.preventDefault();
});

divTable.on('rowClick',function() {
	let row = divTable.getSelectedData()[0];
	if (row !== undefined) {
		populateForm(row);
	} 
})

callback = function(mutationsList, observer) {
    for(let mutation of mutationsList) {
        if (mutation.type === 'childList') {
			$(".editModalButton").off("click");
            $(".editModalButton").on('click', function(){
                editModal.classList.remove("closing");
                editModal.showModal();
                editModal.classList.add("showing");
            });
			$(".deleteModalButton").off("click");
            $(".deleteModalButton").on('click', function(){
                $("#deleteModal").removeClass("closing")
                deleteModal.showModal();
                $("#deleteModal").addClass("showing")
            });
        }
    }
};

observer = new MutationObserver(callback);
observer.observe(document.getElementById('divTableTabulator'), { childList: true, subtree: true });

$("#btnBranch").click(function(){
	$.get("MaintenanceController",{
		action: "showBranches"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$('#deleteSaveModalButton').click(function(event){
	event.stopImmediatePropagation();
	$.post('MaintenanceController', {
		action: 'deleteBranchData',
		data: JSON.stringify(data)
	}, function(response) {
		if (response.includes('success')) {
			closeDeleteModal();
			$('#btnBranch').click();
		} else {
			$('.errorMessage').text(response);
		}
	});
});

function populateForm(row) {
	$('#branchIdUpdate').val(row.branchId);
	$('#branchNameUpdate').val(row.branchName);
	data = {
		branchId: row.branchId.toString(),
		branchName: row.branchName.toString()
	};
}

function validate(data) {
	let valid = true;
	if (data.branchId === '' || data.branchName === '') {
		alert('Please correctly fill-out all required fields');
		valid = false;
	} else if (!(/^[0-9]\d*$/.test(data.branchId))) {
	    $('.errorMessage').text("Branch ID should only contain positive numbers");
		valid = false;
	} else if (data.branchId > 99999999999999){
		$('.errorMessage').text("Branch ID value is too large");
		valid = false;
	} else if (data.branchName.length > 50){
		$('.errorMessage').text("Branch Name characters should be less than 51");
		valid = false;
	} 
	return valid;
}

function sendData(data){
	if (validate(data)) {
		$.post('MaintenanceController', {
			action: 'saveBranchData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				closeAddModal();
				closeEditModal();
				$('#btnBranch').click();
			} else {
				$('.errorMessage').text(response);
			}
		});
	}
}

function addData() {
	let data = {
		branchId: $('#branchIdCreate').val().toString(),
		branchName: $('#branchNameCreate').val().toString()
	};
	sendData(data);
}

function updateData() {
	let data = {
		branchId: $('#branchIdUpdate').val().toString(),
		branchName: $('#branchNameUpdate').val().toString()
	};
	sendData(data);
}

$('#btnCreateBranch').click(addData);
$('#btnUpdateBranch').click(updateData);