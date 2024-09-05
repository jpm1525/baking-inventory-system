/*function getMaterialCode(){
	let html = '';
		$.each(materialCode, function(index, data) {
			html+= '<option value="' + data.materialCd + '">' + data.materialCd + ' - ' + data.materialCodeName + '</option>'
		});
		$('.selMaterialCode').append(html);
}

getMaterialCode();

function getBranchId(){
	let html = '';
		$.each(branchId, function(index, data) {
			html+= '<option value="' + data.branchId + '">' + data.branchId + ' - ' + data.branchName + '</option>'
		});
		$('.selectBranchIdCreate').append(html);
}

getBranchId();*/

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
	data: productionMaterial, //json parse 
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector:[5, 10, 15, 20],
	paginationCounter:"rows",
	selectableRows:1,
	columns: [
		{title:"PM ID", field: 'pmId', minWidth:50},
		{title:"DPP ID", field: 'dppId', minWidth:50},
		{title:"Material Code", field: 'materialCd', minWidth:50},
		{title:"Material Name", field: 'materialCode.materialCodeName', minWidth:100},
		{title:"Quantity to Use", field: 'quantityToUse', minWidth:50},
		{title:"Action", headerSort:false, formatter:editButton, minWidth:200},
	],
});


$(".productionMaterialForm").submit(function(e){
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

$("#btnShowProductionMaterial").click(function(){
	$.get("ProductionMaterialController",{
		action: "showProductionMaterial"
		}, function(response){
		$("#divContent").html(response)
	});
});

$('#deleteSaveModalButton').click(function(event){
	event.stopImmediatePropagation();
	$.post('ProductionMaterialController', {
		action: 'deleteData',
		data: JSON.stringify(data)
	}, function(response) {
		if (response.includes('success')) {
			closeDeleteModal();
			$('#btnShowProductionMaterial').click();
		} else {
			$('.errorMessage').text(response);
		}
	});
});	

function populateForm(row) {
	$('#productionMaterialIdUpdate').val(row.materialListId);
	$('#materialCodeUpdate').val(row.materialCd);
	$('#productionMaterialQuantityUpdate').val(row.quantity);
	$('#productionMaterialDateReceiveUpdate').val(row.dateReceive);
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
	if (data.materialListId === '' || data.materialCd === '' || data.quantity === '' || 
		data.dateReceive === '' || data.userId === '' || data.branchId === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} else if (!(/^[0-9]\d*$/.test(data.materialListId))) {
	    $('.errorMessage').text("Material List ID should only contain positive numbers");
		valid = false;
	} else if (data.materialListId > 99999999999999){
		$('.errorMessage').text("Material List ID value is too large");
		valid = false;
	}else if (data.materialCd.length > 10){
		$('.errorMessage').text("Material Code characters should be less than 11");
		valid = false;
	} else if (!(/^[0-9]\d*$/.test(data.quantity))) {
	    $('.errorMessage').text("Quantity should only contain positive numbers and zero");
		valid = false;
	} else if (data.quantity > 99999999999999){
		$('.errorMessage').text("Quantity value is too large");
		valid = false;
	} else if (!(!isNaN(Date.parse(data.dateReceive)) && (new Date(data.dateReceive).toISOString().startsWith(data.dateReceive)))) {
	    $('.errorMessage').text("Please enter valid date");
		valid = false;
	} else if (!(/^[1-9][0-9]*$/.test(data.userId))) {
	    $('.errorMessage').text("User ID should only contain positive numbers");
		valid = false;
	} else if (data.userId > 99999999999999){
		$('.errorMessage').text("User ID value is too large");
		valid = false;
	} else if (!(/^[1-9][0-9]*$/.test(data.branchId))) {
	    $('.errorMessage').text("Branch ID should only contain positive numbers");
		valid = false;
	} else if (data.branchId > 99999999999999){
		$('.errorMessage').text("Branch ID value is too large");
		valid = false;
	}
	return valid;
}

function sendData(data){
	if (validate(data)) {
		$.post('ProductionMaterialController', {
			action: 'saveData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				closeAddModal();
				closeEditModal();
				$('#btnShowProductionMaterial').click();
			} else {
				$('.errorMessage').text(response);
			}
		});
	}
}

function addData() {
	let data = {
		materialListId: "0",
		materialCd: $('#selMaterialCode').val().toString(),
		quantity: $('#productionMaterialQuantityCreate').val().toString(),
		dateReceive: $('#productionMaterialDateReceiveCreate').val().toString(),
		userId: $('#userIdCreate').val(),
		branchId: $('#branchIdCreate').val()
	};
	sendData(data);
}

function updateData() {
	let data = {
		materialListId: $('#productionMaterialIdUpdate').val().toString(),
		materialCd: $('#materialCodeUpdate').val().toString(),
		quantity: $('#productionMaterialQuantityUpdate').val().toString(),
		dateReceive: $('#productionMaterialDateReceiveUpdate').val().toString(),
		userId: $('#userIdUpdate').val().toString(),
		branchId: $('#branchIdUpdate').val().toString()
	};
	sendData(data);
}

$('#btnCreateProductionMaterial').click(addData);
$('#btnUpdateProductionMaterial').click(updateData);