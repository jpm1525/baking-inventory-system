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
	data: skuCode, //json parse 
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector:[5, 10, 15, 20],
	paginationCounter:"rows",
	selectableRows:1,
	columns: [
		{title:"Code", field: 'skuCd'},
		{title:"Name", field: 'skuCodeName'},
		{title:"Unit of Measurement", field: 'unitOfMeasurement'},
		{title:"Action" , headerSort:false, formatter:editButton},
	],
});

$(".skuCodeForm").submit(function(e){
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

$("#btnSkuCode").click(function(){
	$.get("MaintenanceController",{
		action: "showSkuCodes"
		}, function(response){
		$("#divContent").html(response)
	});
});

$('#deleteSaveModalButton').click(function(event){
	event.stopImmediatePropagation();
	$.post('MaintenanceController', {
		action: 'deleteSkuCodeData',
		data: JSON.stringify(data)
	}, function(response) {
		if (response.includes('success')) {
			closeDeleteModal();
			$('#btnSkuCode').click();
		} else {
			$('.errorMessage').text("Unable to save changes");
		}
	});
});	

function populateForm(row) {
	$('#skuCodeUpdate').val(row.skuCd).toString();
	$('#skuCodeNameUpdate').val(row.skuCodeName);
	$('#skuCodeUnitOfMeasurementUpdate').val(row.unitOfMeasurement);
	data = {
		skuCd: row.skuCd.toString(),
		skuCodeName: row.skuCodeName,
		unitOfMeasurement: row.unitOfMeasurement
	};
}

function validate(data) {
	let valid = true;
	if (data.skuCd === '' || data.skuCodeName === '' || data.unitOfMeasurement === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} 
	return valid;
}

function sendData(data){
	if (validate(data)) {
		$.post('MaintenanceController', {
			action: 'saveSkuCodeData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				closeAddModal();
				closeEditModal();
				$('#btnSkuCode').click();
			} else {
				$('.errorMessage').text("Unable to save changes");
			}
		});
	}
}

function addData() {
	let data = {
		skuCd: $('#skuCodeCreate').val(),
		skuCodeName: $('#skuCodeNameCreate').val(),
		unitOfMeasurement: $('#skuCodeUnitOfMeasurementCreate').val()
	};
	sendData(data);
}

function updateData() {
	let data = {
		skuCd: $('#skuCodeUpdate').val(),
		skuCodeName: $('#skuCodeNameUpdate').val(),
		unitOfMeasurement: $('#skuCodeUnitOfMeasurementUpdate').val()
	};
	sendData(data);
}

$('#btnCreateSkuCode').click(addData);
$('#btnUpdateSkuCode').click(updateData);