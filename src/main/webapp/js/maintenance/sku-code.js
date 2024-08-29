$("#btnShowMaintenance").click(function(){
	$.get("MaintenanceController",{
		action: "showMaintenance"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnSkuCode").click(function(){
	$.get("MaintenanceController",{
		action: "showSkuCodes"
		}, function(response){
		$("#divContent").html(response)
	});
});	

function createTable(skuCode) {
	let html = '';
	$.each(skuCode, function(index, item) {
		html += '<tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50';
		html += '  even:dark:bg-gray-800 border-b dark:border-gray-700" id="item'+index+'Row">';
		html += '  <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap';
		html += '    dark:text-white" id="itemCode' + index + '">';
		html +=        item.skuCd;
		html += '  </th>';
		html += '  <td class="px-6 py-4" id="itemName' + index + '">';
		html +=      item.skuCodeName;
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

function bindRowsClick(skuCode) {
	$.each(skuCode, function(index, item) {
		$('#btnEdit'+ index).click(function() {
			$('#skuCodeUpdate').val(item.skuCd);
			$('#skuCodeNameUpdate').val(item.skuCodeName);
			$('#skuCodeUnitOfMeasurementUpdate').val(item.unitOfMeasurement);
		});
		$('#btnDelete' + index).click(function() {
			let data = {
					skuCd: item.skuCd,
					skuCodeName: item.skuCodeName,
					unitOfMeasurement: item.unitOfMeasurement
				};
			$.post('MaintenanceController', {
				action: 'deleteSkuCodeData',
				data: JSON.stringify(data)
			}, function(response) {
				if (response.includes('success')) {
					$('#btnSkuCode').click();
				} else {
					alert('Unable to save changes');
				}
			});
		});
	});
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
			action: 'saveSkuCodeData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				$('#btnSkuCode').click();
			} else {
				alert('Unable to save changes');
			}
		});
	}
}

function addData() {
	let data = {
		skuCd: $('#skuCodeCreate').val(),
		skuCodeName: $('#skuCodeNameCreate').val(),
		unitOfMeasurement: $('#skuCodeUnitOfMeasurementCreate').val()
	};
	sendData(data);
}

function updateData() {
	let data = {
		skuCd: $('#skuCodeUpdate').val(),
		skuCodeName: $('#skuCodeNameUpdate').val(),
		unitOfMeasurement: $('#skuCodeUnitOfMeasurementUpdate').val()
	};
	sendData(data);
}


createTable(skuCode);
bindRowsClick(skuCode);
$('#btnCreateSkuCode').click(addData);
$('#btnUpdateSkuCode').click(updateData);