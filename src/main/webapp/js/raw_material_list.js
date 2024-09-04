function getMaterialCode(){
	let html = '';
		$.each(materialCode, function(index, data) {
			html+= '<option value="' + data.materialCd + '">' + data.materialCd + '</option>'
		});
		$('.selectMaterialCode').html(html);
}

getMaterialCode();

function getBranchId(){
	let html = '';
		$.each(branchId, function(index, data) {
			html+= '<option value="' + data.branchId + '">' + data.branchId + '</option>'
		});
		$('.selectBranchIdCreate').html(html);
}

getBranchId();

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
	data: rawMaterialList, //json parse 
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector:[5, 10, 15, 20],
	paginationCounter:"rows",
	selectableRows:1,
	columns: [
		{title:"ID", field: 'materialListId'},
		{title:"Material Code", field: 'materialCd'},
		{title:"Quantity", field: 'quantity'},
		{title:"Date Receive", field: 'dateReceive'},
		{title:"User ID", field: 'userId'},
		{title:"Branch ID", field: 'branchId'},
		{title:"Action", headerSort:false, formatter:editButton, minWidth:75},
	],
});


$(".rawMaterialListForm").submit(function(e){
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

$("#btnShowRawMaterialList").click(function(){
	$.get("RawMaterialListController",{
		action: "showRawMaterialList"
		}, function(response){
		$("#divContent").html(response)
	});
});

$('#deleteSaveModalButton').click(function(event){
	event.stopImmediatePropagation();
	$.post('RawMaterialListController', {
		action: 'deleteData',
		data: JSON.stringify(data)
	}, function(response) {
		if (response.includes('success')) {
			closeDeleteModal();
			$('#btnShowRawMaterialList').click();
		} else {
			$('.errorMessage').text("Unable to save changes");
		}
	});
});	

function populateForm(row) {
	$('#rawMaterialListIdUpdate').val(row.materialListId);
	$('#materialCodeUpdate').val(row.materialCd);
	$('#rawMaterialListQuantityUpdate').val(row.quantity);
	$('#rawMaterialListDateReceiveUpdate').val(row.dateReceive);
	$('#userIdUpdate').val(row.userId);
	$('#branchIdUpdate').val(row.branchId);
	data = {
		materialListId: row.materialListId.toString(),
		materialCd: row.materialCd.toString(),
		quantity: row.quantity.toString(),
		dateReceive: row.dateReceive.toString(),
		userId: row.userId.toString(),
		branchId: row.branchId.toString()
	};
}

function validate(data) {
	let valid = true;
	if (data.materialCd === '' || data.quantity === '' || 
		data.dateReceive === '' || data.userId === '' || data.branchId === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} 
	return valid;
}

function sendData(data){
	if (validate(data)) {
		$.post('RawMaterialListController', {
			action: 'saveData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				closeAddModal();
				closeEditModal();
				$('#btnShowRawMaterialList').click();
			} else {
				$('.errorMessage').text("Unable to save changes");
			}
		});
	}
}

function addData() {
	let data = {
		materialListId: "0",
		materialCd: $('#selMaterialCode').val().toString(),
		quantity: $('#rawMaterialListQuantityCreate').val().toString(),
		dateReceive: $('#rawMaterialListDateReceiveCreate').val().toString(),
		userId: $('#userIdCreate').val(),
		branchId: $('#branchIdCreate').val()
	};
	sendData(data);
}

function updateData() {
	let data = {
		materialListId: $('#rawMaterialListIdUpdate').val().toString(),
		materialCd: $('#materialCodeUpdate').val().toString(),
		quantity: $('#rawMaterialListQuantityUpdate').val().toString(),
		dateReceive: $('#rawMaterialListDateReceiveUpdate').val().toString(),
		userId: $('#userIdUpdate').val().toString(),
		branchId: $('#branchIdUpdate').val().toString()
	};
	sendData(data);
}

$('#btnCreateRawMaterialList').click(addData);
$('#btnUpdateRawMaterialList').click(updateData);