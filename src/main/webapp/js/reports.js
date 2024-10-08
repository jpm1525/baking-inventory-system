$('#btnGenerateReport').click(function() {
	$('#errorMessage').css("display", "none");
	let reportDate = $('#txtReportDate').val();
	if (reportDate === '') {
		$('#errorMessage').text("Please correctly fill-out all required fields");
		$('#errorMessage').css("display", "block");
	}else if (!(!isNaN(Date.parse(reportDate)) && (new Date(reportDate).toISOString().startsWith(reportDate)))) {
	    $('#errorMessage').text("Please enter valid date");
		$('#errorMessage').css("display", "block");
	}else{
		switch (reportAction) {
			case 'getReportFinished':
				$.post('ReportGenerationController', {
					action: "getReportFinished",
					reportDate: $('#txtReportDate').val()
				}, function(response) {
					generateReport(response);
				});
				break;
			case 'getReportPlanned':
				$.post('ReportGenerationController', {
					action: "getReportPlanned",
					reportDate: $('#txtReportDate').val()
				}, function(response) {
					generateReport(response);
				});
				break;
			case 'getReportProduction':
				$.post('ReportGenerationController', {
					action: "getReportProduction",
					reportDate: $('#txtReportDate').val()
				}, function(response) {
					generateReport(response);
				});
				break;
			case 'getReportReceived':
				$.post('ReportGenerationController', {
					action: "getReportReceived",
					reportDate: $('#txtReportDate').val()
				}, function(response) {
					generateReport(response);
				});
				break;
		}
	}
});

$('#btnPrint').click(function() {
	objReportTable.download("xlsx", reportName + ".xlsx");
});

function generateReport(response) {
	reportData = JSON.parse(response);

	switch (reportAction) {
		case 'getReportFinished':
			reportName = "CurrentFinishedInventory";
			reportCols = [
				{ title: 'FPL ID', 		  field: 'fplId', 		 minWidth: 50 },
				{ title: 'Date Finished', field: 'dateFinished', minWidth: 100 },
				{ title: 'Quantity', 	  field: 'quantity', 	 minWidth: 50 },
				{ title: 'SKU Code', 	  field: 'skuCd', 		 minWidth: 50 },
				{ title: 'Branch ID', 	  field: 'branchId', 	 minWidth: 50 },
				{ title: 'Material', 	  field: 'materialName', minWidth: 100 }
			];
			break;
		case 'getReportPlanned':
			reportName = "PlannedRawMaterialsInventory";
			reportCols = [
				{ title: 'Material', field: 'materialName', minWidth: 150 },
				{ title: 'Quantity', field: 'quantity', 	minWidth: 150 }
			];
			break;
		case 'getReportProduction':
			reportName = "ProductionReport";
			reportCols = [
				{ title: 'Material', field: 'materialName', minWidth: 150 },
				{ title: 'Quantity', field: 'quantity', 	minWidth: 150 }
			];
			break;
		case 'getReportReceived':
			reportName = "ReceivedInventoryReport";
			reportCols = [
				{ title: 'Material', 	  field: 'materialName', minWidth: 150 },
				{ title: 'Quantity', 	  field: 'quantity', 	 minWidth: 150 },
				{ title: 'Date Received', field: 'dateReceived', minWidth: 150 }
			];
			break;
	}

	objReportTable = new Tabulator('#divReportTable', {
		layout: "fitDataFill",
		data: reportData,
		pagination: 'local',
		pagination: true,
		paginationSize: 10,
		paginationSizeSelector: [5, 10, 15, 20],
		paginationCounter: "rows",
		columns: reportCols
	});

	$('#btnPrint').prop('disabled', false);
}

$(document).ready(function() {
    $('#btnGenerateReport').click();
});