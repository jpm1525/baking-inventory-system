function getMaterialCode(){
	let html = '';
		$.each(rawMaterialList, function(index, data) {
			$.each(materialCode, function(index2, data2) {
				if(data.materialCd == data2.materialCd)
				html+= '<option index="' + index + '"value="' + data.materialCd + '">' + data.materialCd + ' - ' + data2.materialCodeName + '</option>'
			});
		});
	$('.selMaterialCode').append(html);
}

getMaterialCode();

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
	$('#productionMaterialIdUpdate').val(row.pmId);
	$('#productionMaterialDppIdUpdate').val(dppIdInp);
	$('#materialCodeUpdate').val(row.materialCd);
	$('#productionMaterialQuantityToUseUpdate').val(row.quantityToUse);
	data = {
		pmId: row.pmId.toString(),
		dppId: dppIdInp.toString(),
		materialCd: row.materialCd.toString(),
		quantityToUse: row.quantityToUse.toString(),
	};
}

function validate(data) {
	let valid = true;
	if (data.pmId === '' || data.dppId === '' || 
		data.materialCd === '' || data.quantityToUse === '') {
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
	} else if (!(/^[0-9]\d*$/.test(data.quantityToUse))) {
	    $('.errorMessage').text("Quantity value should only contain positive numbers and zero");
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
		quantityToUse: $('#productionMaterialQuantityToUseCreate').val().toString()
	};
	sendData(data);
}

function updateData() {
	let data = {
		pmId: $('#productionMaterialIdUpdate').val().toString(),
		dppId: dppIdInp.toString(),
		materialCd: $('#materialCodeUpdate').val().toString(),
		quantityToUse: $('#productionMaterialQuantityToUseUpdate').val().toString()
	};
	sendData(data);
}

$('#btnCreateProductionMaterial').click(addData);
$('#btnUpdateProductionMaterial').click(updateData);

$('#productionMaterialQuantityToUseCreate').on("input", function() {
	if (!(/^[0-9]\d*$/.test($('#productionMaterialQuantityToUseCreate').val()))){
		$('#productionMaterialQuantityToUseCreate').val(0);
	}else if($('#productionMaterialQuantityToUseCreate').val() > parseInt($('#productionMaterialInitialStockCreate').val())){
		console.log("GREATER THAN");
		$('#productionMaterialQuantityToUseCreate').val($('#productionMaterialInitialStockCreate').val());
		$('#productionMaterialResultingStockCreate').val(0);
	}else if($('#productionMaterialQuantityToUseCreate').val() < 0){
		console.log("LESS THAN");
		$('#productionMaterialQuantityToUseCreate').val(0);
		$('#productionMaterialResultingStockCreate').val($('#productionMaterialInitialStockCreate').val());
	}else{
		$('#productionMaterialResultingStockCreate').val(
		$('#productionMaterialInitialStockCreate').val() - 
		$('#productionMaterialQuantityToUseCreate').val());
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