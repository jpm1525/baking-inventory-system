
function toggleAddButton() {
	if ('' === $('#txtMaterialListId').val()) {
		$('#btnAdd').html('Add');
	} else {
		$('#btnAdd').html('Update');
	}
}

function bindRowsClick(rawmateriallist) {
	$.each(rawmateriallist, function(index, item) {
		$('#item'+index+'row').click(function() {
			$('#txtMaterialListId').val(item.materialListId);
			$('#txtMaterialCode').val(item.materialCd);
			$('#txtQuantity').val(item.quantity);
			$('#txtUserId').val(item.userId);
			$('#txtDateReceive').val(item.dateReceive);
			$('#txtBranchId').val(item.branchId);
			toggleAddButton();
		});
	});
}

function createRawMaterialListTable(rawmateriallist) {
	let html = '';
	html += '<table class="inventory">';
	html += '  <tr>';
	html += '    <th>Material ID List</th>';
	html += '    <th>Material Code</th>';
	html += '    <th>Quantity</th>';
	html += '    <th>User ID</th>';
	html += '    <th>Date Receive</th>';
	html += '    <th>Branch Id</th>';
	html += '  </tr>';
	$.each(rawmateriallist, function(index, item) {
		html += '<tr id="item'+index+'row">';
		html += '  <td id="item'+index+'materialListId">' + item.materialListId + '</td>';
		html += '  <td id="item'+index+'materialCd">' + item.materialCd + '</td>';
		html += '  <td id="item'+index+'qty" class="center-aligned">' + item.quantity + '</td>';
		html += '  <td id="item'+index+'userId" class="center-aligned">' + item.userId + '</td>';
		html += '  <td id="item'+index+'dateReceive" class="center-aligned">' + item.dateReceive + '</td>';
		html += '  <td id="item'+index+'branchId" class="center-aligned">' + item.branchId + '</td>';
		html += '</tr>';
	});
	html += '</table>';
	$('#divInventoryTable').html(html);
	bindRowsClick(rawmateriallist);
}

function createItem() {
	let item;
	if($('#txtMaterialListId').val() == "") {
		item = {
			materialListId: '0',
			materialCd: $('#txtMaterialCode').val(),
			quantity: $('#txtQuantity').val(),
			userId: $('#txtUserId').val(),
			dateReceive: $('#txtDateReceive').val(),
			branchId: $('#txtBranchId').val()
		};
	} else {
		item = {
			materialListId: $('#txtMaterialListId').val(),
			materialCd: $('#txtMaterialCode').val(),
			quantity: $('#txtQuantity').val(),
			userId: $('#txtUserId').val(),
			dateReceive: $('#txtDateReceive').val(),
			branchId: $('#txtBranchId').val()
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
		$.post('RawMaterialListController', {
			action: 'saveData',
			item: JSON.stringify(item)
		}, function(response) {
			if (response.includes('success')) {
				$('#btnRawMaterialList').click();
			} else {
				alert('Unable to save changes');
			}
		});
	}
}

$('#btnAdd').click(addItem);

function resetInventoryForm() {
	$('#txtMaterialListId').val('');
	$('#txtMaterialCode').val('');
	$('#txtQuantity').val('');
	$('#txtUserId').val('');
	$('#txtDateReceive').val('');
	$('#txtBranchId').val('');
	toggleAddButton();
}

$('#btnClear').click(resetInventoryForm);

$('#btnDelete').click(function() {
	if ($('#txtMaterialListId').val() !== '') {
		let item = createItem();
		$.post('RawMaterialListController', {
			action: 'deleteData',
			item: JSON.stringify(item)
		}, function(response) {
			if (response.includes('success')) {
				alert('Deleted successfully');
				$('#btnRawMaterialList').click();
			} else {
				alert('Unable to save changes');
			}
		});
	} else {
		alert('Please select an item to delete');
	}
});

createRawMaterialListTable(rawmateriallist);