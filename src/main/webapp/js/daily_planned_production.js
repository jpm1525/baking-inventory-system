if (typeof data === 'undefined' || data === null) {let data = "";}
if (typeof callback === 'undefined' || callback === null) {let callback = "";}
if (typeof observer === 'undefined' || observer === null) {let observer = "";}

var editButton = function(value, data, cell, row, options){
	let thisButton = '<button class="px-4 py-2 text-white bg-indigo-500 rounded editModalButton"> Edit </button>';
		thisButton +='<button class="px-4 py-2 ml-5 text-white bg-red-500 rounded deleteModalButton"> Delete </button>'
    return thisButton;
};

var divTable = new Tabulator("#divTableTabulator" , {
	layout:"fitDataFill",
	data: dailyPlannedProduction, //json parse 
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector:[5, 10, 15, 20],
	paginationCounter:"rows",
	selectableRows:1,
	columns: [
		{title:"ID", field: 'dppId'},
		{title:"Production Data", field: 'productionDate'},
		{title:"Branch ID", field: 'branchId'},
		{title:"SKU Code", field: 'skuCd'},
		{title:"Quantity", field: 'quantity'},
		{title:"Status", field: 'status'},
		{title:"Action" , headerSort:false, formatter:editButton},
	],
});

$(".dailyPlannedProductionForm").submit(function(e){
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

$("#btnShowDailyPlannedProduction").click(function(){
	$.get("DailyPlannedProductionController",{
		action: "showDailyPlannedProduction"
		}, function(response){
		$("#divContent").html(response)
	});
});

$('#deleteSaveModalButton').click(function(event){
	event.stopImmediatePropagation();
	$.post('DailyPlannedProductionController', {
		action: 'deleteData',
		data: JSON.stringify(data)
	}, function(response) {
		if (response.includes('success')) {
			closeDeleteModal();
			$('#btnShowDailyPlannedProduction').click();
		} else {
			$('.errorMessage').text("Unable to save changes");
		}
	});
});	

function populateForm(row) {
	$('#dailyPlannedProductionIdUpdate').val(row.dppId);
	$('#dailyPlannedProductionDateUpdate').val(row.productionDate);
	$('#dailyPlannedProductionBranchIdUpdate').val(row.branchId);
	$('#dailyPlannedProductionSkuCdUpdate').val(row.skuCd);
	$('#dailyPlannedProductionQuantityUpdate').val(row.quantity);
	$('#dailyPlannedProductionStatusUpdate').val(row.status);
	data = {
		dppId: row.dppId.toString(),
		productionDate: row.productionDate.toString(),
		branchId: row.branchId.toString(),
		skuCd: row.skuCd.toString(),
		quantity: row.quantity.toString(),
		status: row.status.toString()
	};
}

function validate(data) {
	let valid = true;
	if (data.dppId === '' || data.productionDate === '' || data.branchId === '' || 
		data.skuCd === '' || data.quantity === '' || data.status === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} 
	return valid;
}

function sendData(data){
	if (validate(data)) {
		$.post('DailyPlannedProductionController', {
			action: 'saveData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				closeAddModal();
				closeEditModal();
				$('#btnShowDailyPlannedProduction').click();
			} else {
				$('.errorMessage').text("Unable to save changes");
			}
		});
	}
}

function addData() {
	let data = {
		dppId: "0",
		productionDate: $('#dailyPlannedProductionDateCreate').val().toString(),
		branchId: $('#dailyPlannedProductionBranchIdCreate').val().toString(),
		skuCd: $('#dailyPlannedProductionSkuCdCreate').val().toString(),
		quantity: $('#dailyPlannedProductionQuantityCreate').val(),
		status: $('#dailyPlannedProductionStatusCreate').val()
	};
	sendData(data);
}

function updateData() {
	let data = {
		dppId: $('#dailyPlannedProductionIdUpdate').val().toString(),
		productionDate: $('#dailyPlannedProductionDateUpdate').val().toString(),
		branchId: $('#dailyPlannedProductionBranchIdUpdate').val().toString(),
		skuCd: $('#dailyPlannedProductionSkuCdUpdate').val().toString(),
		quantity: $('#dailyPlannedProductionQuantityUpdate').val(),
		status: $('#dailyPlannedProductionStatusUpdate').val()
	};
	sendData(data);
}

$('#btnCreateDailyPlannedProduction').click(addData);
$('#btnUpdateDailyPlannedProduction').click(updateData);