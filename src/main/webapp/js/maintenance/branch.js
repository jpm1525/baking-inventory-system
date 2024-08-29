$("#btnShowMaintenance").click(function(){
	$.get("MaintenanceController",{
		action: "showMaintenance"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnBranch").click(function(){
	$.get("MaintenanceController",{
		action: "showBranches"
		}, function(response){
		$("#divContent").html(response)
	});
});	

function createBranchTable(branch) {
	let html = '';
	$.each(branch, function(index, item) {
		html += '<tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50';
		html += '  even:dark:bg-gray-800 border-b dark:border-gray-700" id="item'+index+'Row">';
		html += '  <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap';
		html += '    dark:text-white" id="itemCode' + index + '">';
		html +=        item.branchId;
		html += '  </th>';
		html += '  <td class="px-6 py-4" id="itemName">';
		html +=      item.branchName;
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
}

function bindRowsClick(branch) {
	$.each(branch, function(index, item) {
		$('#btnEdit'+ index).click(function() {
			$('#branchIdUpdate').val(item.branchId);
			$('#branchNameUpdate').val(item.branchName);
		});
		$('#btnDelete' + index).click(function() {
			let data = {
					branchId: item.branchId.toString(),
					branchName: item.branchName
				};
			$.post('MaintenanceController', {
				action: 'deleteBranchData',
				data: JSON.stringify(data)
			}, function(response) {
				if (response.includes('success')) {
					$('#btnBranch').click();
				} else {
					alert('Unable to save changes');
				}
			});
		});
	});
}

function validate(data) {
	let valid = true;
	if (data.branchId === '' || data.branchName === '') {
		alert('Please correctly fill-out all required fields');
		valid = false;
	} 
	return valid;
}

function sendData(data){
	if (validate(data)) {
		$.post('MaintenanceController', {
			action: 'saveBranchData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				$('#btnBranch').click();
			} else {
				alert('Unable to save changes');
			}
		});
	}
}

function addData() {
	let data = {
		branchId: $('#branchIdCreate').val(),
		branchName: $('#branchNameCreate').val()
	};
	sendData(data);
}

function updateData() {
	let data = {
		branchId: $('#branchIdUpdate').val().toString(),
		branchName: $('#branchNameUpdate').val()
	};
	sendData(data);
}


createBranchTable(branch);
bindRowsClick(branch);
$('#btnCreateBranch').click(addData);
$('#btnUpdateBranch').click(updateData);