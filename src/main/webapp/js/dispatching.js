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
	$('#dispatchingIdUpdate').val(row.dispatchTrackId);
	$('#dispatchingTypeNameUpdate').val(row.dispatchTypeCd);
	$('#dispatchingFinishedProductListIdUpdate').val(row.fplId);
	$('#dispatchingQuantityUpdate').val(row.quantity);
	$('#dispatchingBranchNameUpdate').val(row.branchId);
	$('#dispatchingDestinationUpdate').val(row.destination);
	$('#dispatchingDateUpdate').val(row.dispatchDate);
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
		branchId: $('#dispatchingBranchNameCreate').val().toString(),
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
		branchId: $('#dispatchingBranchNameUpdate').val().toString(),
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
		html+= '<option value="' + data.dispatchTypeCd + '">' + data.dispatchTypeName + '</option>'
	});
	$('.selectDispatchingTypeName').append(html);
}

function getBranchName() {
	let html = '';
	$.each(branch, function(index, data) {
		html += '<option value="' + data.branchId + '">' + data.branchName + '</option>'
	});
	$('.selectDispatchingBranch').append(html);
}

getDispatchType();
getBranchName();
