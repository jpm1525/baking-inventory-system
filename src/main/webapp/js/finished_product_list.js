$('.inputBranchId').val(branchId + ' - ' + branchName);

function getSkuCode() {
	let html = '';
	$.each(sku, function(index, data) {
		html += '<option value="' + data.skuCd + '">' + data.skuCd + ' - ' + data.skuCodeName + '</option>'
	});
	$('.selSkuCode').append(html);
}

getSkuCode();

if (typeof data === 'undefined' || data === null) { let data = ""; }
if (typeof callback === 'undefined' || callback === null) { let callback = ""; }
if (typeof observer === 'undefined' || observer === null) { let observer = ""; }

var editButton = function(value, data, cell, row, options) {
	let thisButton = '<button class="px-4 py-2 text-white bg-indigo-500 rounded editModalButton"> Edit </button>';
	thisButton += '<button class="px-4 py-2 ml-5 text-white bg-red-500 rounded deleteModalButton"> Delete </button>'
	return thisButton;
};

var divTable = new Tabulator("#divTableTabulator", {
	layout: "fitDataFill",
	data: finishedProductList, //json parse 
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector: [5, 10, 15, 20],
	paginationCounter: "rows",
	selectableRows: 1,
	columns: [
		{ title: "ID", field: 'fplId', minWidth: 50 },
		{ title: "SKU Code", field: 'skuCd', minWidth: 50 },
		{ title: "SKU", field: 'sku.skuCodeName', minWidth: 50 },
		{ title: "Name", field: 'quantity', minWidth: 100 },
		{ title: "Date Finished", field: 'dateFinished', minWidth: 100 },
		{ title: "Branch", field: 'branch.branchName', minWidth: 100 },
		{ title: "Action", headerSort: false, formatter: editButton, minWidth: 200 },
	],
});


$(".finishedProductListForm").submit(function(e) {
	e.preventDefault();
});

divTable.on('rowClick', function() {
	let row = divTable.getSelectedData()[0];
	if (row !== undefined) {
		populateForm(row);
	}
})

callback = function(mutationsList, observer) {
	for (let mutation of mutationsList) {
		if (mutation.type === 'childList') {
			$(".editModalButton").off("click");
			$(".editModalButton").on('click', function() {
				editModal.classList.remove("closing");
				editModal.showModal();
				editModal.classList.add("showing");
			});
			$(".deleteModalButton").off("click");
			$(".deleteModalButton").on('click', function() {
				$("#deleteModal").removeClass("closing")
				deleteModal.showModal();
				$("#deleteModal").addClass("showing")
			});
		}
	}
};

observer = new MutationObserver(callback);
observer.observe(document.getElementById('divTableTabulator'), { childList: true, subtree: true });

$("#btnShowFinishedProductList").click(function() {
	$.get("FinishedProductListController", {
		action: "showFinishedProductList"
	}, function(response) {
		$("#divContent").html(response)
	});
});

$('#deleteSaveModalButton').click(function(event) {
	event.stopImmediatePropagation();
	$.post('FinishedProductListController', {
		action: 'deleteData',
		data: JSON.stringify(data)
	}, function(response) {
		if (response.includes('success')) {
			closeDeleteModal();
			$('#btnShowFinishedProductList').click();
		} else {
			$('.errorMessage').text(response);
		}
	});
});

function populateForm(row) {
	$('#finishedProductListIdUpdate').val(row.fplId);
	$('#skuCodeUpdate').val(row.skuCd);
	$('#finishedProductListQuantityUpdate').val(row.quantity);
	$('#finishedProductListDateFinishedUpdate').val(row.dateFinished);
	$('#branchIdUpdate').val(branchId + " - " + branchName);
	data = {
		fplId: row.fplId.toString(),
		skuCd: row.skuCd.toString(),
		quantity: row.quantity.toString(),
		dateFinished: row.dateFinished.toString(),
		branchId: branchId
	};
}

function validate(data) {
	let valid = true;
	if (data.fplId === '' || data.skuCd === '' || data.quantity === '' ||
		data.dateFinished === '' || data.branchId === '') {
		$('.errorMessage').text("Please correctly fill-out all required fields");
		valid = false;
	} else if (!(/^[0-9]\d*$/.test(data.fplId))) {
		$('.errorMessage').text("Foreign Product List ID should only contain positive numbers");
		valid = false;
	} else if (data.fplId > 99999999999999) {
		$('.errorMessage').text("Foreign Product List ID value is too large");
		valid = false;
	} else if (data.skuCd.length > 10) {
		$('.errorMessage').text("SKU Code characters should be less than 11");
		valid = false;
	} else if (!(/^[0-9]\d*$/.test(data.quantity))) {
		$('.errorMessage').text("Quantity should only contain positive numbers and zero");
		valid = false;
	} else if (data.quantity > 99999999999999) {
		$('.errorMessage').text("Quantity value is too large");
		valid = false;
	} else if (!(!isNaN(Date.parse(data.dateFinished)) && (new Date(data.dateFinished).toISOString().startsWith(data.dateFinished)))) {
		$('.errorMessage').text("Please enter valid date");
		valid = false;
	} else if (!(/^[1-9][0-9]*$/.test(data.branchId))) {
		$('.errorMessage').text("Branch ID should only contain positive numbers");
		valid = false;
	} else if (data.branchId > 99999999999999) {
		$('.errorMessage').text("Branch ID value is too large");
		valid = false;
	}
	return valid;
}

function sendData(data) {
	if (validate(data)) {
		$.post('FinishedProductListController', {
			action: 'saveData',
			data: JSON.stringify(data)
		}, function(response) {
			if (response.includes('success')) {
				closeAddModal();
				closeEditModal();
				$('#btnShowFinishedProductList').click();
			} else {
				$('.errorMessage').text(response);
			}
		});
	}
}

function addData() {
	let data = {
		fplId: "0",
		skuCd: $('#skuCodeCreate').val().toString(),
		quantity: $('#finishedProductListQuantityCreate').val().toString(),
		dateFinished: $('#finishedProductListDateFinishedCreate').val().toString(),
		branchId: branchId.toString()
	};
	sendData(data);
}

function updateData() {
	let data = {
		fplId: $('#finishedProductListIdUpdate').val().toString(),
		skuCd: $('#skuCodeUpdate').val().toString(),
		quantity: $('#finishedProductListQuantityUpdate').val().toString(),
		dateFinished: $('#finishedProductListDateFinishedUpdate').val().toString(),
		branchId: branchId.toString()
	};
	sendData(data);
}

$('#btnCreateFinishedProductList').click(addData);
$('#btnUpdateFinishedProductList').click(updateData);