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
	data: dispatching, //json parse 
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector:[5, 10, 15, 20],
	paginationCounter:"rows",
	selectableRows:1,
	columns: [
		{title:"Id", field: 'dispatchTrackId', visible: false},
		{title:"Code", field: 'dispatchTypeCd', minWidth:50},
		{title:"Name", field: 'dispatchType.dispatchTypeName', minWidth:100},
		{title:"FPL ID", field: 'fplId', minWidth:50},
		{title:"SKU Name", field: 'fpl.sku.skuCodeName', minWidth:100},
		{title:"Quantity", field: 'quantity', minWidth:50},
		{title:"Branch ID", field: 'branchId', minWidth:50},
		{title:"Branch Name", field: 'branch.branchName', minWidth:100},
		{title:"Destination", field: 'destination', minWidth:100},
		{title:"Dispatch Date", field: 'dispatchDate', minWidth:100},
		{title:"Action" , headerSort:false, formatter:editButton, minWidth:200},
	],
});

$(".dispatchingForm").submit(function(e){
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

$("#btnShowDispatching").click(function(){
	$.get("DispatchingController",{
		action: "showDispatching"
		}, function(response){
		$("#divContent").html(response)
	});
});

$('#deleteSaveModalButton').click(function(event){
	event.stopImmediatePropagation();
	$.post('DispatchingController', {
		action: 'deleteData',
		data: JSON.stringify(data)
	}, function(response) {
		if (response.includes('success')) {
			closeDeleteModal();
			$('#btnShowDispatching').click();
		} else {
			$('.errorMessage').text(response);
		}
	});
});	

function populateForm(row) {
	var initialStock = 0;
	$('#dispatchingIdUpdate').val(row.dispatchTrackId);
	$('#dispatchingTypeNameUpdate').val(row.dispatchTypeCd);
	$('#fplDateUpdate').val(row.fpl.dateFinished);
	$('#dispatchingQuantityUpdate').val(row.quantity);
	$('#dispatchingBranchUpdate').val(branchNameUser);
	$('#dispatchingDestinationUpdate').val(row.destination);
	$('#dispatchingDateUpdate').val(row.dispatchDate);
	let html = '<option value="" disabled selected hidden>Select Product</option>';
	$.each(finishedProductList, function(index, data) {
		if(data.dateFinished <= $('#dispatchingDateUpdate').val()){
			if(row.fplId == data.fplId){
				initialStock = data.quantity + row.quantity;
				html += '<option selected value="' + data.fplId + '" data-quantity="' + initialStock + 
					'" data-date-finished="' + data.dateFinished + '">' + data.fplId + " - " + 
					data.sku.skuCodeName + ' - [' + data.dateFinished + ']' + '</option>';
			}else{
				html += '<option value="' + data.fplId + '" data-quantity="' + data.quantity + 
					'" data-date-finished="' + data.dateFinished + '">' + data.fplId + " - " + 
					data.sku.skuCodeName + ' - [' + data.dateFinished + ']' + '</option>';
			}
		}
	});
	$('#dispatchingFinishedProductListIdUpdate').html(html);
	$('#dispatchingFinishedProductListIdUpdate').val(row.fplId);
	$('#fplQuantityUpdate').val(initialStock);
	$('#fplQuantityUpdate').prop('max', initialStock);
	$('#dispatchingQuantityUpdate').prop('max', initialStock);
	$('#fplResultingStockUpdate').val(initialStock - row.quantity);
	$('#fplResultingStockUpdate').prop('max', initialStock);

	$('#dispatchingDateUpdate').off('change');
	$('#dispatchingDateUpdate').on('change',function() {
		let html = '<option value="" disabled selected hidden>Select Product</option>';
		$.each(finishedProductList, function(index, data) {
			if(data.dateFinished <= $('#dispatchingDateUpdate').val()){
				if(row.fplId == data.fplId){
					initialStock = data.quantity + row.quantity;
					html += '<option value="' + data.fplId + '" data-quantity="' + initialStock + 
						'" data-date-finished="' + data.dateFinished + '">' + data.fplId + " - " + 
						data.sku.skuCodeName + ' - [' + data.dateFinished + ']' + '</option>';
				}else{
					html += '<option value="' + data.fplId + '" data-quantity="' + data.quantity + 
						'" data-date-finished="' + data.dateFinished + '">' + data.fplId + " - " + 
						data.sku.skuCodeName + ' - [' + data.dateFinished + ']' + '</option>';
				}
			}
		});
		$('#dispatchingFinishedProductListIdUpdate').html(html);	
		$('#fplDateUpdate').val(0);
		$('#dispatchingQuantityUpdate').val(0);
		$('#fplResultingStockUpdate').val(0);
		$('#fplQuantityUpdate').val(0);
	});
	
	data = {
		dispatchTrackId: row.dispatchTrackId.toString(),
		dispatchTypeCd: row.dispatchTypeCd.toString(),
		fplId: row.fplId.toString(),
		quantity: row.quantity.toString(),
		branchId: row.branchId.toString(),
		destination: row.destination.toString(),
		dispatchDate: row.dispatchDate.toString()
	};
}

function validate(data) {
	let valid = true;
	console.log(data.dispatchTrackId)
	if (data.dispatchTrackId === '' || data.dispatchTypeCd === '' || data.fplId === '' || 
		data.quantity === '' || data.branchId === '' || data.destination === '' || data.dispatchDate === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} else if (!(/^[0-9]\d*$/.test(data.dispatchTrackId))) {
	    $('.errorMessage').text("Dispatch Track ID should only contain positive numbers");
		valid = false;
	} else if (!(/^[1-9][0-9]*$/.test(data.fplId))) {
	    $('.errorMessage').text("FPL ID should only contain positive numbers");
		valid = false;
	} else if (!(/^[0-9]\d*$/.test(data.quantity))) {
	    $('.errorMessage').text("Quantity should only contain positive numbers and zero");
		valid = false;
	} else if (!(/^[1-9][0-9]*$/.test(data.branchId))) {
	    $('.errorMessage').text("Branch ID should only contain positive numbers");
		valid = false;
	} else if (!(!isNaN(Date.parse(data.dispatchDate)) && (new Date(data.dispatchDate).toISOString().startsWith(data.dispatchDate)))) {
	    $('.errorMessage').text("Please enter valid date");
		valid = false;
	} else if (data.dispatchTrackId > 99999999999999){
		$('.errorMessage').text("Dispatch Track ID value is too large");
		valid = false;
	} else if (data.dispatchTypeCd.length > 10){
		$('.errorMessage').text("Dispatch Type Code characters should be less than 11");
		valid = false;
	} else if (data.fplId > 99999999999999){
		$('.errorMessage').text("FPL ID value is too large");
		valid = false;
	} else if (data.quantity > 99999999999999){
		$('.errorMessage').text("Quantity value is too large");
		valid = false;
	} else if (data.branchId > 99999999999999){
		$('.errorMessage').text("Branch ID value is too large");
		valid = false;
	} else if (data.destination.length > 50){
		$('.errorMessage').text("Destination characters should be less than 51");
		valid = false;
	}
	return valid;
}

function sendData(data){
	if (validate(data)) {
		console.log(data);
		$.post('DispatchingController', {
			action: 'saveData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				closeAddModal();
				closeEditModal();
				$('#btnShowDispatching').click();
			} else {
				$('.errorMessage').text(response);
			}
		});
	}
}

function addData() {
	let data = {
		dispatchTrackId: "0",
		dispatchTypeCd: $('#dispatchingTypeNameCreate').val().toString(),
		fplId: $('#dispatchingFinishedProductListIdCreate').val().toString(),
		quantity: $('#dispatchingQuantityCreate').val().toString(),
		branchId: branchIdUser.toString(),
		destination: $('#dispatchingDestinationCreate').val().toString(),
		dispatchDate: $('#dispatchingDateCreate').val().toString()
	};
	sendData(data);
}

function updateData() {
	let data = {
		dispatchTrackId: $('#dispatchingIdUpdate').val().toString(),
		dispatchTypeCd: $('#dispatchingTypeNameUpdate').val().toString(),
		fplId: $('#dispatchingFinishedProductListIdUpdate').val().toString(),
		quantity: $('#dispatchingQuantityUpdate').val().toString(),
		branchId: branchIdUser.toString(),
		destination: $('#dispatchingDestinationUpdate').val().toString(),
		dispatchDate: $('#dispatchingDateUpdate').val().toString()
	};
	sendData(data);
}

$('#btnCreateDispatching').click(addData);
$('#btnUpdateDispatching').click(updateData);

function getDispatchType() {
	let html = '';
	$.each(dispatchType, function(index, data) {
		html+= '<option value="' + data.dispatchTypeCd + '">' + data.dispatchTypeCd + ' - ' + data.dispatchTypeName + '</option>'
	});
	$('.selectDispatchingTypeName').append(html);
}

getDispatchType();

function getCurrentDate(){
	var today = new Date();
    today.setMinutes(today.getMinutes() - today.getTimezoneOffset());
    today = today.toISOString().slice(0,10);
	$('#dispatchingDateCreate').val(today);
}

function getFplCreateOption(){
	let html = '<option value="" disabled selected hidden>Select Product</option>';
	$.each(finishedProductList, function(index, data) {
		if(data.dateFinished <= $('#dispatchingDateCreate').val()){
	        html += '<option value="' + data.fplId + '" data-quantity="' + data.quantity + 
				'" data-date-finished="' + data.dateFinished + '">' + data.fplId + " - " + 
				data.sku.skuCodeName + '</option>';
		}
	});
	$('#dispatchingFinishedProductListIdCreate').html(html);
}

function initializeAddModal() {
	$('#dispatchingBranchCreate').val(branchNameUser);
	getCurrentDate();
	getFplCreateOption();
	

	$('#dispatchingDateCreate').change(function() {
		getFplCreateOption();
		$('#dispatchingQuantityCreate').val(0);
		$('#fplDateCreate').val(0);
		$('#fplQuantityCreate').val(0);
		$('#fplResultingStockCreate').val(0);
	});
	
    $('#dispatchingFinishedProductListIdCreate').change(function() {
		let initialStock = $('#dispatchingFinishedProductListIdCreate').find(':selected').attr('data-quantity');
		$('#fplQuantityCreate').val(initialStock);
		$('#fplQuantityCreate').prop('max', initialStock);
		$('#dispatchingQuantityCreate').val(0);
		$('#dispatchingQuantityCreate').prop('max', initialStock);
		$('#c').val(initialStock);
		$('#fplResultingStockCreate').prop('max', initialStock);
        $('#fplDateCreate').val($('#dispatchingFinishedProductListIdCreate').find(':selected').attr('data-date-finished'));
        
    });
	
	$('#dispatchingQuantityCreate').on("input", function() {
		if (!(/^[0-9]\d*$/.test($('#dispatchingQuantityCreate').val()))){
			$('#dispatchingQuantityCreate').val(0);
		}else if($('#dispatchingQuantityCreate').val() > parseInt($('#fplQuantityCreate').val())){
			$('#dispatchingQuantityCreate').val($('#fplQuantityCreate').val());
			$('#fplResultingStockCreate').val(0);
		}else if($('#dispatchingQuantityCreate').val() < 0){
			$('#dispatchingQuantityCreate').val(0);
			$('#fplResultingStockCreate').val($('#fplQuantityCreate').val());
		}else{
			$('#fplResultingStockCreate').val(
			$('#fplQuantityCreate').val() - 
			$('#dispatchingQuantityCreate').val());
		}
	});
}

initializeAddModal();

function initializeEditModal() {
    $('#dispatchingFinishedProductListIdUpdate').change(function() {
		var initialStock = $('#dispatchingFinishedProductListIdUpdate').find(':selected').attr('data-quantity');
			$('#fplQuantityUpdate').val(initialStock);
			$('#fplQuantityUpdate').prop('max', initialStock);
			$('#dispatchingQuantityUpdate').val(0);
			$('#dispatchingQuantityUpdate').prop('max', initialStock);
			$('#fplResultingStockUpdate').val(initialStock);
			$('#fplResultingStockUpdate').prop('max', initialStock);
	        $('#fplDateUpdate').val($('#dispatchingFinishedProductListIdUpdate').find(':selected').attr('data-date-finished'));
    });
	
	$('#dispatchingQuantityUpdate').on("input", function() {
		if (!(/^[0-9]\d*$/.test($('#dispatchingQuantityUpdate').val()))){
			$('#dispatchingQuantityUpdate').val(0);
		}else if($('#dispatchingQuantityUpdate').val() > parseInt($('#fplQuantityUpdate').val())){
			$('#dispatchingQuantityUpdate').val($('#fplQuantityUpdate').val());
			$('#fplResultingStockUpdate').val(0);
		}else if($('#dispatchingQuantityUpdate').val() < 0){
			$('#dispatchingQuantityUpdate').val(0);
			$('#fplResultingStockUpdate').val($('#fplQuantityUpdate').val());
		}else{
			$('#fplResultingStockUpdate').val(
			$('#fplQuantityUpdate').val() - 
			$('#dispatchingQuantityUpdate').val());
		}
	});
}

initializeEditModal();