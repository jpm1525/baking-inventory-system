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
			$('#txtDispatchType').val(data.dispatchTypeCd);
			$('#txtFinishedProdId').val(data.fplId);
			$('#txtQuantity').val(data.quantity);
			$('#txtBranchId').val(data.branchId);
			$('#txtDestination').val(data.destination);
			$('#txtDispatchDate').val(data.dispatchDate);
			toggleAddButton();
		});
	});
}

function createDispatchingTable(dispatching) {
	let html = '';
	html += '<table class="dispatching text-white">';
	html += '  <tr>';
	html += '    <th>Dispatch Type Code</th>';
	html += '    <th>Finished Product ID</th>';
	html += '    <th>Quantity</th>';
	html += '    <th>Branch ID</th>';
	html += '    <th>Destination</th>';
	html += '    <th>Dispatch Date</th>';
	html += '  </tr>';
	$.each(dispatching, function(index, data) {
		html += '<tr id="data'+index+'row">';
		html += '  <td id="data'+index+'disType">' + data.dispatchTypeCd + '</td>';
		html += '  <td id="data'+index+'fplId">' + data.fplId + '</td>';
		html += '  <td id="data'+index+'qty" style="align: center;">' + data.quantity + '</td>';
		html += '  <td id="data'+index+'brId" style="align: center;">' + data.branchId + '</td>';
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
			dispatchTypeCd: $('#txtDispatchType').val(),
			fplId: $('#txtFinishedProdId').val(),
			quantity: $('#txtQuantity').val(),
			branchId: $('#txtBranchId').val(),
			destination: $('#txtDestination').val(),
			dispatchDate: $('#txtDispatchDate').val()
		};
	}
	else{
		data = {
			dispatchTrackId: $('#txtDispatchId').val() !== '' ? $('#txtDispatchId').val() : '0',
			dispatchTypeCd: $('#txtDispatchType').val(),
			fplId: $('#txtFinishedProdId').val(),
			quantity: $('#txtQuantity').val(),
			branchId: $('#txtBranchId').val(),
			destination: $('#txtDestination').val(),
			dispatchDate: $('#txtDispatchDate').val()
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
	$('#txtDispatchType').val('');
	$('#txtFinishedProdId').val('');
	$('#txtQuantity').val('');
	$('#txtBranchId').val('');
	$('#txtDestination').val('');
	$('#txtDispatchDate').val('');
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