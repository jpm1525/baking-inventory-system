$("#btnShowMaintenance").click(function(){
	$.get("MaintenanceController",{
		action: "showMaintenance"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnDispatch").click(function(){
	$.get("MaintenanceController",{
		action: "showDispatch"
		}, function(response){
		$("#divContent").html(response)
	});
});	

function createInventoryTable(dispatchType) {
	let html = '';
	$.each(dispatchType, function(index, item) {
		html += '<tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50';
		html += '  even:dark:bg-gray-800 border-b dark:border-gray-700" id="item'+index+'Row">';
		html += '  <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap';
		html += '    dark:text-white" id="itemCode' + index + '">';
		html +=        item.dispatchTypeCd;
		html += '  </th>';
		html += '  <td class="px-6 py-4" id="itemName">';
		html +=      item.dispatchTypeName;
		html += '  </td>';
		html += '  <td class="px-6 py-4" id="itemName'+ index +'">';
		html += '    <button id="btnEdit'+ index +'" class="px-4 py-2 text-white bg-indigo-500 rounded">';
		html += '      Edit';
		html += '    </button>';
		html += '    <button id="btnDelete'+ index +'" class="px-4 py-2 ml-5 text-white bg-red-500 rounded">';
		html += '	    Delete';
		html += '    </button>';
		html += '  </td>';
		html += '</tr>';
	});
	$('#divTable').html(html);
	//bindRowsClick(dispatchType);
}

function bindRowsClick(dispatchType) {
	$.each(dispatchType, function(index, item) {
		$('#btnEdit'+ index).click(function() {
			$('#dispatchTypeCodeUpdate').val(item.dispatchTypeCd);
			$('#dispatchTypeNameUpdate').val(item.dispatchTypeName);
			//toggleAddButton();
		});
		$('#btnDelete' + index).click(function() {
			let data = {
					dispatchTypeCd: item.dispatchTypeCd,
					dispatchTypeName: item.dispatchTypeName
				};
			$.post('MaintenanceController', {
				action: 'deleteDispatchData',
				data: JSON.stringify(data)
			}, function(response) {
				if (response.includes('success')) {
					$('#btnDispatch').click();
				} else {
					alert('Unable to save changes');
				}
			});
		});
	});
}



function createData() {

	
	return data;
}

function validate(data) {
	let valid = true;
	if (data.materialCode === '' || data.materialName === '') {
		alert('Please correctly fill-out all required fields');
		valid = false;
	} 
	return valid;
}

function sendData(data){
	if (validate(data)) {
		$.post('MaintenanceController', {
			action: 'saveDispatchData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				$('#btnDispatch').click();
			} else {
				alert('Unable to save changes');
			}
		});
	}
}

function addData() {
	let data = {
		dispatchTypeCd: $('#dispatchTypeCodeCreate').val(),
		dispatchTypeName: $('#dispatchTypeNameCreate').val()
	};
	sendData(data);
}

function updateData() {
	let data = {
		dispatchTypeCd: $('#dispatchTypeCodeUpdate').val(),
		dispatchTypeName: $('#dispatchTypeNameUpdate').val()
	};
	sendData(data);
}


createInventoryTable(dispatchType);
bindRowsClick(dispatchType);
$('#btnCreateDispatchType').click(addData);
$('#btnUpdateDispatchType').click(updateData);