if (typeof data === 'undefined' || data === null) {let data = "";}
if (typeof callback === 'undefined' || callback === null) {let callback = "";}
if (typeof observer === 'undefined' || observer === null) {let observer = "";}

var editButton = function(value, data, cell, row, options){
	let thisButton = '<button class="px-4 py-2 text-white bg-indigo-500 rounded editModalButton"> Edit </button>';
		thisButton +='<button class="px-4 py-2 ml-5 text-white bg-red-500 rounded deleteModalButton"> Delete </button>';
    return thisButton;
};

var divTable = new Tabulator("#divTableTabulator" , {
	layout:"fitColumns",
	data: materialCode, //json parse 
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector:[5, 10, 15, 20],
	paginationCounter:"rows",
	selectableRows:1,
	columns: [
		{title:"Code", field: 'materialCd'},
		{title:"Name", field: 'materialCodeName'},
		{title:"Unit of Measurement", field: 'unitOfMeasurement'},
		{title:"Action" , field: 'unitOfMeasurement', headerSort:false, formatter:editButton},
	],
});

$(".materialCodeForm").submit(function(e){
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
            $(".editModalButton").on('click', function(){
                editModal.classList.remove("closing");
                editModal.showModal();
                editModal.classList.add("showing");
            });
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

$("#btnMaterialCode").click(function(){
	$.get("MaintenanceController",{
		action: "showMaterialCodes"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$('#deleteSaveModalButton').click(function(event){
	event.stopImmediatePropagation();
	$.post('MaintenanceController', {
		action: 'deleteMaterialCodeData',
		data: JSON.stringify(data)
	}, function(response) {
		if (response.includes('success')) {
			closeDeleteModal();
			$('#btnMaterialCode').click();
		} else {
			$('.errorMessage').text("Unable to save changes");
		}
	});
});	

function populateForm(row) {
	$('#materialCodeUpdate').val(row.materialCd).toString();
	$('#materialCodeNameUpdate').val(row.materialCodeName);
	$('#materialCodeUnitOfMeasurementUpdate').val(row.unitOfMeasurement);
	data = {
		materialCd: row.materialCd.toString(),
		materialCodeName: row.materialCodeName,
		unitOfMeasurement: row.unitOfMeasurement
	};
}


function validate(data) {
	let valid = true;
	if (data.materialCd === '' || data.materialName === '' | data.unitOfMeasurement === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} 
	return valid;
}

function sendData(data){
	if (validate(data)) {
		$.post('MaintenanceController', {
			action: 'saveMaterialCodeData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				closeAddModal();
				closeEditModal();
				$('#btnMaterialCode').click();
			} else {
				alert('Unable to save changes');
			}
		});
	}
}

function addData() {
	let data = {
		materialCd: $('#materialCodeCreate').val(),
		materialCodeName: $('#materialCodeNameCreate').val(),
		unitOfMeasurement: $('#materialCodeUnitOfMeasurementCreate').val()
	};
	sendData(data);
}

function updateData() {
	let data = {
		materialCd: $('#materialCodeUpdate').val(),
		materialCodeName: $('#materialCodeNameUpdate').val(),
		unitOfMeasurement: $('#materialCodeUnitOfMeasurementUpdate').val()
	};
	sendData(data);
}

$('#btnCreateMaterialCode').click(addData);
$('#btnUpdateMaterialCode').click(updateData);