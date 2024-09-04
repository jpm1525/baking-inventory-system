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
	data: skuCode,
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector:[5, 10, 15, 20],
	paginationCounter:"rows",
	selectableRows:1,
	columns: [
		{title:"Code", field: 'skuCd', minWidth:50},
		{title:"Name", field: 'skuCodeName', minWidth:100},
		{title:"Unit of Measurement", field: 'unitOfMeasurement', minWidth:100},
		{title:"Action" , headerSort:false, formatter:editButton, minWidth:200},
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
			$('.errorMessage').text(response);
		}
	});
});	

function populateForm(row) {
	$('#skuCodeUpdate').val(row.skuCd);
	$('#skuCodeNameUpdate').val(row.skuCodeName);
	$('#skuCodeUnitOfMeasurementUpdate').val(row.unitOfMeasurement);
	data = {
		skuCd: row.skuCd.toString(),
		skuCodeName: row.skuCodeName.toString(),
		unitOfMeasurement: row.unitOfMeasurement.toString()
	};
}

function validate(data) {
	let valid = true;
	if (data.skuCd === '' || data.skuCodeName === '' || data.unitOfMeasurement === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} else if (data.skuCd.length > 50){
		$('.errorMessage').text("SKU Code characters should be less than 51");
		valid = false;
	} else if (data.skuCodeName.length > 200){
		$('.errorMessage').text("SKU Code Name characters should be less than 201");
		valid = false;
	} else if (data.unitOfMeasurement.length > 100){
		$('.errorMessage').text("Unit of Measurement characters should be less than 101");
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
				$('.errorMessage').text(response);
			}
		});
	}
}

function addData() {
	let data = {
		skuCd: $('#skuCodeCreate').val().toString(),
		skuCodeName: $('#skuCodeNameCreate').val().toString(),
		unitOfMeasurement: $('#skuCodeUnitOfMeasurementCreate').val().toString()
	};
	sendData(data);
}

function updateData() {
	let data = {
		skuCd: $('#skuCodeUpdate').val().toString(),
		skuCodeName: $('#skuCodeNameUpdate').val().toString(),
		unitOfMeasurement: $('#skuCodeUnitOfMeasurementUpdate').val().toString()
	};
	sendData(data);
}

$('#btnCreateSkuCode').click(addData);
$('#btnUpdateSkuCode').click(updateData);