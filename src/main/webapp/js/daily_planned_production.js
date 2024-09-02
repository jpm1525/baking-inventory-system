
function toggleAddButton() {
	if ('' === $('#txtDppId').val()) {
		$('#btnAdd').html('Add');
	} else {
		$('#btnAdd').html('Update');
	}
}

function bindRowsClick(dailyplannedproduction) {
	$.each(dailyplannedproduction, function(index, item) {
		$('#item'+index+'row').click(function() {
			$('#txtDppId').val(item.dppId);
			$('#txtProductionDate').val(item.productionDate);
			$('#txtBranchId').val(item.branchId);
			$('#txtSkuCd').val(item.skuCd);
			$('#txtQuantity').val(item.quantity);
			$('#txtStatus').val(item.status);
			toggleAddButton();
		});
	});
}

function createDailyPlannedProductionTable(dailyplannedproduction) {
	let html = '';
	html += '<table class="inventory">';
	html += '  <tr>';
	html += '    <th>Daily Planned Production ID</th>';
	html += '    <th>Production Date</th>';
	html += '    <th>Branch ID</th>';
	html += '    <th>SKU Code</th>';
	html += '    <th>Quantity</th>';
	html += '    <th>Status</th>';
	html += '  </tr>';
	$.each(dailyplannedproduction, function(index, item) {
		html += '<tr id="item'+index+'row">';
		html += '  <td id="item'+index+'dppId">' + item.dppId + '</td>';
		html += '  <td id="item'+index+'productionDate">' + item.productionDate + '</td>';
		html += '  <td id="item'+index+'branchId" class="center-aligned">' + item.branchId + '</td>';
		html += '  <td id="item'+index+'skuCd" class="center-aligned">' + item.skuCd + '</td>';
		html += '  <td id="item'+index+'quantity" class="center-aligned">' + item.quantity + '</td>';
		html += '  <td id="item'+index+'status" class="center-aligned">' + item.status + '</td>';
		html += '</tr>';
	});
	html += '</table>';
	$('#divInventoryTable').html(html);
	bindRowsClick(dailyplannedproduction);
}

function createItem() {
	let item;
	if($('#txtDppId').val() == "") {
		item = {
			dppId: '0',
			productionDate: $('#txtProductionDate').val(),
			branchId: $('#txtBranchId').val(),
			skuCd: $('#txtSkuCd').val(),
			quantity: $('#txtQuantity').val(),
			status: $('#txtStatus').val()
		};
	} else {
		item = {
			dppId: $('#txtDppId').val(),
			productionDate: $('#txtProductionDate').val(),
			branchId: $('#txtBranchId').val(),
			skuCd: $('#txtSkuCd').val(),
			quantity: $('#txtQuantity').val(),
			status: $('#txtStatus').val()
		};
	}
	
	return item;
}

function validate(item) {
	let valid = true;
	if (item.description === '' || item.quantity === '') {
		alert('Please correctly fill-out all required fields');
		valid = false;
	} else if (item.quantity < 0) {
		alert('Quantity must be a non-negative number');
		valid = false;
	}
	return valid;
}

function addItem() {
	let item = createItem();
	if (validate(item)) {
		$.post('DailyPlannedProductionController', {
			action: 'saveData',
			item: JSON.stringify(item)
		}, function(response) {
			if (response.includes('success')) {
				$('#btnDailyPlannedProduction').click();
			} else {
				alert('Unable to save changes 1');
			}
		});
	}
}

$('#btnAdd').click(addItem);

function resetInventoryForm() {
	$('#txtDppId').val('');
	$('#txtProductionDate').val('');
	$('#txtBranchId').val('');
	$('#txtSkuCd').val('');
	$('#txtQuantity').val('');
	$('#txtStatus').val('');
	toggleAddButton();
}

$('#btnClear').click(resetInventoryForm);

$('#btnDelete').click(function() {
	if ($('#txtDppId').val() !== '') {
		let item = createItem();
		$.post('DailyPlannedProductionController', {
			action: 'deleteData',
			item: JSON.stringify(item)
		}, function(response) {
			if (response.includes('success')) {
				alert('Deleted successfully');
				$('#btnDailyPlannedProduction').click();
			} else {
				alert('Unable to save changes 2');
			}
		});
	} else {
		alert('Please select an item to delete');
	}
});

createDailyPlannedProductionTable(dailyplannedproduction);