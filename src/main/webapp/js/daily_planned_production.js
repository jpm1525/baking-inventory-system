function getBranchId(){
	let html = '';
		$.each(branchId, function(index, data) {
			html+= '<option value="' + data.branchId + '">' + data.branchId + ' - ' + data.branchName + '</option>'
		});
		$('.dailyPlannedProductionBranchIdCreate').append(html);
}

getBranchId();

function getSkuCd(){
	let html = '';
		$.each(skuCd, function(index, data) {
			html+= '<option value="' + data.skuCd + '">' + data.skuCd + ' - ' + data.skuCodeName + '</option>'
		});
		$('.dailyPlannedProductionSkuCdCreate').append(html);
}

getSkuCd();

$('#dailyPlannedProductionBranchIdCreate').val(branchIdInput);

if (typeof dppIdInput === 'undefined' || dppIdInput === null) {let dppIdInput = "";}
if (typeof data === 'undefined' || data === null) {let data = "";}
if (typeof callback === 'undefined' || callback === null) {let callback = "";}
if (typeof observer === 'undefined' || observer === null) {let observer = "";}

var editButton = function(value, data, cell, row, options){
	let thisButton = '<button class="px-4 py-2 text-white bg-indigo-500 rounded editModalButton"> Edit </button>';
		thisButton +='<button class="px-4 py-2 ml-5 text-white bg-red-500 rounded deleteModalButton"> Delete </button>'	;
		thisButton +='<button class="px-4 py-2 ml-5 text-white bg-green-500 rounded viewButton"> View Details</button>'
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
		{title:"Id", field: 'dppId', visible: false},
		{title:"Production Date", field: 'productionDate'},
		{title:"Branch Name", field:'branch.branchName'},
		{title:"SKU Code", field: 'skuCd'},
		{title:"Name", field: 'skuName.skuCodeName'},
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
			$(".viewButton").off("click");
			$(".viewButton").on('click', function(){
				setTimeout(function() { 
					$.post("ProductionMaterialController",{
						action: "showProductionMaterial",
						dppIdInput: JSON.stringify(dppIdInput),
						}, function(response){
						$("#divContent").html(response)
					});
				}, 100);
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
	$('#dailyPlannedProductionBranchIdUpdate').val(branchIdInput);
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
	dppIdInput = row.dppId;
}

function validate(data) {
	let valid = true;
	if (data.dppId === '' || data.productionDate === '' || data.branchId === '' || 
		data.skuCd === '' || data.quantity === '' || data.status === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} else if (!(/^[0-9]\d*$/.test(data.dppId))) {
	    $('.errorMessage').text("Daily Planned Production ID should only contain positive numbers");
		valid = false;
	} else if (data.dppId > 99999999999999){
		$('.errorMessage').text("Daily Planned Production ID value is too large");
		valid = false;
	} else if (!(!isNaN(Date.parse(data.productionDate)) && (new Date(data.productionDate).toISOString().startsWith(data.productionDate)))) {
	    $('.errorMessage').text("Please enter a valid date");
		valid = false;
	} else if (!(/^[1-9][0-9]*$/.test(data.branchId))) {
	    $('.errorMessage').text("Branch ID should only contain positive numbers");
		valid = false;
	} else if (data.branchId > 99999999999999){
		$('.errorMessage').text("Branch ID value is too large");
		valid = false;
	} else if (data.skuCd.length > 10){
		$('.errorMessage').text("SKU Code characters should be less than 11");
		valid = false;
	} else if (!(/^[0-9]\d*$/.test(data.quantity))) {
	    $('.errorMessage').text("Quantity should only contain positive numbers and zero");
		valid = false;
	} else if (data.quantity > 99999999999999){
		$('.errorMessage').text("Quantity value is too large");
		valid = false;
	} else if (data.status.length > 20){
		$('.errorMessage').text("Status characters should be less than 21");
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
