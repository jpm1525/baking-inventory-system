$("#btnShowMaintenance").click(function(){
	$.get("MaintenanceController",{
		action: "showMaintenance"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnMaterialCode").click(function(){
	$.get("MaintenanceController",{
		action: "showMaterialCodes"
		}, function(response){
		$("#divContent").html(response)
	});
});	

function createTable(materialCode) {
	let html = '';
	$.each(materialCode, function(index, item) {
		html += '<tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50';
		html += '  even:dark:bg-gray-800 border-b dark:border-gray-700" id="item'+index+'Row">';
		html += '  <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap';
		html += '    dark:text-white" id="itemCode' + index + '">';
		html +=        item.materialCd;
		html += '  </th>';
		html += '  <td class="px-6 py-4" id="itemName' + index + '">';
		html +=      item.materialCodeName;
		html += '  </td>';
		html += '  <td class="px-6 py-4" id="itemUnit' + index + '">';
		html +=      item.unitOfMeasurement;
		html += '  </td>';
		html += '  <td class="px-6 py-4">';
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
}

function bindRowsClick(materialCode) {
	$.each(materialCode, function(index, item) {
		$('#btnEdit'+ index).click(function() {
			$('#materialCodeUpdate').val(item.materialCd);
			$('#materialCodeNameUpdate').val(item.materialCodeName);
			$('#materialCodeUnitOfMeasurementUpdate').val(item.unitOfMeasurement);
		});
		$('#btnDelete' + index).click(function() {
			let data = {
					materialCd: item.materialCd,
					materialCodeName: item.materialCodeName,
					unitOfMeasurement: item.unitOfMeasurement
				};
			$.post('MaintenanceController', {
				action: 'deleteMaterialCodeData',
				data: JSON.stringify(data)
			}, function(response) {
				if (response.includes('success')) {
					$('#btnMaterialCode').click();
				} else {
					alert('Unable to save changes');
				}
			});
		});
	});
}

function validate(data) {
	let valid = true;
	if (data.materialCd === '' || data.materialName === '') {
		alert('Please correctly fill-out all required fields');
		valid = false;
	} 
	return valid;
}

function sendData(data){
	if (validate(data)) {
		$.post('MaintenanceController', {
			action: 'saveMaterialCodeData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				$('#btnMaterialCode').click();
			} else {
				alert('Unable to save changes');
			}
		});
	}
}

function addData() {
	let data = {
		materialCd: $('#materialCodeCreate').val(),
		materialCodeName: $('#materialCodeNameCreate').val(),
		unitOfMeasurement: $('#materialCodeUnitOfMeasurementCreate').val()
	};
	sendData(data);
}

function updateData() {
	let data = {
		materialCd: $('#materialCodeUpdate').val(),
		materialCodeName: $('#materialCodeNameUpdate').val(),
		unitOfMeasurement: $('#materialCodeUnitOfMeasurementUpdate').val()
	};
	sendData(data);
}


createTable(materialCode);
bindRowsClick(materialCode);
$('#btnCreateMaterialCode').click(addData);
$('#btnUpdateMaterialCode').click(updateData);