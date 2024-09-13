if (typeof dppDate === 'undefined' || dppDate === null) {let dppDate = "";}
$.each(dailyPlannedProduction, function(index, data) {
	if(data.dppId == dppIdInp){
		dppDate = data.productionDate;
	}
});
function getMaterialCodeCreate(){
	let html = '';

		$.each(rawMaterialList, function(index, data) {
			if(dppDate >= data.dateReceive){
				$.each(materialCode, function(index2, data2) {
					if(data.materialCd == data2.materialCd){
						html+= '<option materialListId="' + data.materialListId +  '"index="' + index + 
							'"value="' + data.materialCd + '">' + data.materialCd + ' - ' + 
							data2.materialCodeName + ' - ' + data.dateReceive + '</option>';
					}
				});
			}
		});
	$('#materialCodeCreate').append(html);
}

getMaterialCodeCreate();

function getMaterialCodeUpdate(materialListIdInput, quantityInput){
	let html = '';
		$.each(rawMaterialList, function(index, data) {
			if(dppDate >= data.dateReceive){
				$.each(materialCode, function(index2, data2) {
					if(data.materialCd == data2.materialCd){
						if(materialListIdInput == data.materialListId){
							html+= '<option qty="' + (data.quantity + quantityInput) + '" materialListId="' + data.materialListId +  
								'" index="' + index + '" value="' + data.materialCd + '">' + data.materialCd + ' - ' + 
								data2.materialCodeName + ' - ' + data.dateReceive + '</option>';
						}else{
							html+= '<option qty="' + data.quantity + '" materialListId="' + data.materialListId +  
								'" index="' + index + '" value="' + data.materialCd + '">' + data.materialCd + ' - ' + 
								data2.materialCodeName + ' - ' + data.dateReceive + '</option>';				
						}
					}
				});
			}
		});
	$('#materialCodeUpdate').html(html);
}


$('#productionMaterialDppIdCreate').val(dppIdInp);

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
		action: "showProductionMaterial",
		dppIdInput: dppIdInp,
		}, function(response){
		$("#divContent").html(response)
	});
});

$("#btnShowDailyPlannedProduction").click(function(){
	$.get("DailyPlannedProductionController",{
		action: "showDailyPlannedProduction"
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
	getMaterialCodeUpdate(row.materialList.materialListId, row.quantityToUse);
	$('#productionMaterialIdUpdate').val(row.pmId);
	$('#productionMaterialDppIdUpdate').val(dppIdInp);
	$('#materialCodeUpdate').val(row.materialCd);
	$('#productionMaterialQuantityToUseUpdate').val(row.quantityToUse);
	UpdateStocksOnEdit();
	$('#productionMaterialQuantityToUseUpdate').val(row.quantityToUse);
	$('#productionMaterialResultingStockUpdate').val(
		$('#productionMaterialInitialStockUpdate').val() - 
		$('#productionMaterialQuantityToUseUpdate').val());
	data = {
		pmId: row.pmId.toString(),
		dppId: dppIdInp.toString(),
		materialCd: row.materialCd.toString(),
		quantityToUse: row.quantityToUse.toString(),
		materialListId: row.materialList.materialListId.toString()
	};
}

function validate(data) {
	let valid = true;
	if (data.pmId === '' || data.dppId === '' || data.materialCd === '' || 
		data.materialListId === '' || data.quantityToUse === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} else if (!(/^[0-9]\d*$/.test(data.pmId))) {
	    $('.errorMessage').text("Production Material ID should only contain positive numbers");
		valid = false;
	} else if (data.pmId > 99999999999999){
		$('.errorMessage').text("Production Material  ID value is too large");
		valid = false;
	} else if (!(/^[1-9][0-9]*$/.test(data.dppId))) {
	    $('.errorMessage').text("Daily Planned Production ID should only contain positive numbers");
		valid = false;
	} else if (data.dppId > 99999999999999){
		$('.errorMessage').text("Daily Planned Production ID value is too large");
		valid = false;
	} else if (data.materialCd.length > 10){
		$('.errorMessage').text("Material Code characters should be less than 11");
		valid = false;
	} else if (!(/^[1-9][0-9]*$/.test(data.materialListId))) {
	    $('.errorMessage').text("Daily Planned Production ID should only contain positive numbers");
		valid = false;
	} else if (data.materialListId > 99999999999999){
		$('.errorMessage').text("Daily Planned Production ID value is too large");
		valid = false;
	}  else if (!(/^[1-9][0-9]*$/.test(data.quantityToUse))) {
	    $('.errorMessage').text("Quantity value should only contain positive numbers");
		valid = false;
	} else if (data.quantityToUse > 99999999999999){
		$('.errorMessage').text("Quantity value is too large");
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
		pmId: "0",
		dppId: dppIdInp.toString(),
		materialCd: $('#materialCodeCreate').val().toString(),
		quantityToUse: $('#productionMaterialQuantityToUseCreate').val().toString(),
		materialListId: $('#materialCodeCreate').find(':selected').attr('materialListId').toString() 
	};
	sendData(data);
}

function updateData() {
	let data = {
		pmId: $('#productionMaterialIdUpdate').val().toString(),
		dppId: dppIdInp.toString(),
		materialCd: $('#materialCodeUpdate').val().toString(),
		quantityToUse: $('#productionMaterialQuantityToUseUpdate').val().toString(),
		materialListId: $('#materialCodeUpdate').find(':selected').attr('materialListId').toString() 
	};
	sendData(data);
}

$('#btnCreateProductionMaterial').click(addData);
$('#btnUpdateProductionMaterial').click(updateData);

$('#productionMaterialQuantityToUseCreate').on("input", function() {
	if (!(/^[0-9]\d*$/.test($('#productionMaterialQuantityToUseCreate').val()))){
		$('#productionMaterialQuantityToUseCreate').val(0);
	}else if($('#productionMaterialQuantityToUseCreate').val() > parseInt($('#productionMaterialInitialStockCreate').val())){
		$('#productionMaterialQuantityToUseCreate').val($('#productionMaterialInitialStockCreate').val());
		$('#productionMaterialResultingStockCreate').val(0);
	}else if($('#productionMaterialQuantityToUseCreate').val() < 0){
		$('#productionMaterialQuantityToUseCreate').val(0);
		$('#productionMaterialResultingStockCreate').val($('#productionMaterialInitialStockCreate').val());
	}else{
		$('#productionMaterialResultingStockCreate').val(
		$('#productionMaterialInitialStockCreate').val() - 
		$('#productionMaterialQuantityToUseCreate').val());
	}
});

$('#productionMaterialQuantityToUseUpdate').on("input", function() {
	if (!(/^[0-9]\d*$/.test($('#productionMaterialQuantityToUseUpdate').val()))){
		$('#productionMaterialQuantityToUseUpdate').val(0);
	}else if($('#productionMaterialQuantityToUseUpdate').val() > parseInt($('#productionMaterialInitialStockUpdate').val())){
		$('#productionMaterialQuantityToUseUpdate').val($('#productionMaterialInitialStockUpdate').val());
		$('#productionMaterialResultingStockUpdate').val(0);
	}else if($('#productionMaterialQuantityToUseUpdate').val() < 0){
		$('#productionMaterialQuantityToUseUpdate').val(0);
		$('#productionMaterialResultingStockUpdate').val($('#productionMaterialInitialStockUpdate').val());
	}else{
		$('#productionMaterialResultingStockUpdate').val(
			$('#productionMaterialInitialStockUpdate').val() - 
			$('#productionMaterialQuantityToUseUpdate').val());
	}
});

$('#materialCodeCreate').on("input", function() {
	let index = 0;
	let initialStock = 0;
	if(!($('#materialCodeCreate').find(':selected').attr('index') == 'undefined')){
		index = $('#materialCodeCreate').find(':selected').attr('index');
	}
	if(!(typeof rawMaterialList[index].quantity == 'undefined')){
		initialStock = rawMaterialList[index].quantity;
	}
	$('#productionMaterialInitialStockCreate').val(initialStock);
	$('#productionMaterialInitialStockCreate').prop('max', initialStock);
	$('#productionMaterialQuantityToUseCreate').val(0);
	$('#productionMaterialQuantityToUseCreate').prop('max', initialStock);
	$('#productionMaterialResultingStockCreate').val(initialStock);
	$('#productionMaterialQuantityToUseCreate').prop('max', initialStock);
});


function UpdateStocksOnEdit(){
	let index = 0;
	let initialStock = 0;
	if(!($('#materialCodeUpdate').find(':selected').attr('index') == 'undefined')){
		index = $('#materialCodeUpdate').find(':selected').attr('index');
	}
	if(!($('#materialCodeUpdate').find(':selected').attr('qty') == 'undefined')){
		initialStock = $('#materialCodeUpdate').find(':selected').attr('qty');
	}
	$('#productionMaterialInitialStockUpdate').val(initialStock);
	$('#productionMaterialInitialStockUpdate').prop('max', initialStock);
	$('#productionMaterialQuantityToUseUpdate').val(0);
	$('#productionMaterialQuantityToUseUpdate').prop('max', initialStock);
	$('#productionMaterialResultingStockUpdate').val(initialStock);
	$('#productionMaterialQuantityToUseUpdate').prop('max', initialStock);
}

$('#materialCodeUpdate').on("input", function() {
	UpdateStocksOnEdit();
});