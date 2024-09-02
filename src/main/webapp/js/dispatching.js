function toggleAddButton() {
	if ('' === $('#txtDispatchId').val()) {
		$('#btnAdd').html('Add');
	} else {
		$('#btnAdd').html('Update');
	}
}

function bindRowsClick(dispatching) {
	$.each(dispatching, function(index, data) {
		$('#data'+index+'row').click(function() {
			$('#txtDispatchId').val(data.dispatchTrackId);
			$('#selDispatchType').val(data.dispatchTypeCd);
			$('#txtFinishedProdId').val(data.fplId);
			$('#txtQuantity').val(data.quantity);
			$('#selBranch').val(data.branchId);
			$('#txtDestination').val(data.destination);
			$('#dateDispatchDate').val(data.dispatchDate);
			toggleAddButton();
		});
	});
}

function getDispatchType() {
	let html = '<option value="">';
	$.each(dispatchType, function(index, data) {
		html+= '<option value="' + data.dispatchTypeCd + '">' + data.dispatchTypeName + '</option>'
	});
	$('#selDispatchType').html(html);

	/*$.each(skuCode, function(index, data) {
		html += '<option value="' + data.skuCd + '">' + data.skuCodeName + '</option>'
	});
	$('#selSkuCode').html(html);*/
	
			
}

function getBranchName() {
	let html = '<option value="">';
	$.each(branch, function(index, data) {
		html += '<option value="' + data.branchId + '">' + data.branchName + '</option>'
	});
	$('#selBranch').html(html);
}

getDispatchType();
getBranchName();

function createDispatchingTable(dispatching) {
	let html = '';
	html += '<table class="dispatching text-white">';
	html += '  <tr>';
	html += '    <th>Dispatch Type ID</th>';
	html += '    <th>Dispatch Type Name</th>';
	html += '    <th>Finished Product ID</th>';
	html += '    <th>SKU Name</th>';
	html += '    <th>Quantity</th>';
	html += '    <th>Branch ID</th>';
	html += '    <th>Branch Name</th>';
	html += '    <th>Destination</th>';
	html += '    <th>Dispatch Date</th>';
	html += '  </tr>';
	$.each(dispatching, function(index, data) {
		html += '<tr id="data'+index+'row">';
		html += '  <td id="data'+index+'disType" style="align: center;">' + data.dispatchTypeCd + '</td>';
		html += '  <td id="data'+index+'disName">' + data.dispatchType.dispatchTypeName + '</td>';
		html += '  <td id="data'+index+'fplId" style="align: center;">' + data.fplId + '</td>';
		html += '  <td id="data'+index+'skuCode">' + data.fpl.sku.skuCodeName + '</td>';
		html += '  <td id="data'+index+'qty" style="align: center;">' + data.quantity + '</td>';
		html += '  <td id="data'+index+'brId" style="align: center;">' + data.branchId + '</td>';
		html += '  <td id="data'+index+'brName">' + data.branch.branchName + '</td>';
		html += '  <td id="data'+index+'desti">' + data.destination + '</td>';
		html += '  <td id="data'+index+'disDate">' + data.dispatchDate + '</td>';
		html += '</tr>';
	});
	html += '</table>';
	$('#divDispatchingTable').html(html);
	bindRowsClick(dispatching);
}

function createData() {
	let data;
	if($('#txtDispatchId').val() == ""){
		data = {
			dispatchTrackId: '0',
			dispatchTypeCd: $('#selDispatchType').val(),
			fplId: $('#txtFinishedProdId').val(),
			quantity: $('#txtQuantity').val(),
			branchId: $('#selBranch').val(),
			destination: $('#txtDestination').val(),
			dispatchDate: $('#dateDispatchDate').val()
		};
	}
	else{
		data = {
			dispatchTrackId: $('#txtDispatchId').val() !== '' ? $('#txtDispatchId').val() : '0',
			dispatchTypeCd: $('#selDispatchType').val(),
			fplId: $('#txtFinishedProdId').val(),
			quantity: $('#txtQuantity').val(),
			branchId: $('#selBranch').val(),
			destination: $('#txtDestination').val(),
			dispatchDate: $('#dateDispatchDate').val()
		};
	}
	return data;
}

function validate(data) {
	let valid = true;
	if (data.description === '' || data.quantity === '') {
		alert('Please correctly fill-out all required fields');
		valid = false;
	} else if (data.quantity < 0) {
		alert('Quantity must be a non-negative number');
		valid = false;
	}
	return valid;
}

function addData() {
	let data = createData();
	if (validate(data)) {
		$.post('DispatchingController', {
			action: 'saveData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				$('#btnDispatching').click();
			} else {
				alert('Unable to save changes');
			}
		});
	}
}

$('#btnAdd').click(addData);

function resetDispatchingForm() {
	$('#txtDispatchId').val('');
	$('#selDispatchType').val('');
	$('#txtFinishedProdId').val('');
	$('#txtQuantity').val('');
	$('#selBranch').val('');
	$('#txtDestination').val('');
	$('#dateDispatchDate').val('');
	toggleAddButton();
}

$('#btnClear').click(resetDispatchingForm);

$('#btnDelete').click(function() {
	if ($('#txtDispatchId').val() !== '') {
		let data = createData();
		$.post('DispatchingController', {
			action: 'deleteData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				$('#btnDispatching').click();
			} else {
				alert('Unable to save changes');
			}
		});
	} else {
		alert('Please select an item to delete');
	}
});

createDispatchingTable(dispatching);