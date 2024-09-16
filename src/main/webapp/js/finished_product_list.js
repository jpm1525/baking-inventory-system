if (typeof data === 'undefined' || data === null) {let data = "";}
if (typeof callback === 'undefined' || callback === null) {let callback = "";}
if (typeof observer === 'undefined' || observer === null) {let observer = "";}

var divTable = new Tabulator("#divTableTabulator" , {
	layout:"fitDataFill",
	data: finishedProductList, //json parse 
	pagination: 'local',
	pagination: true,
	paginationSize: 10,
	paginationSizeSelector:[5, 10, 15, 20],
	paginationCounter:"rows",
	selectableRows:1,
	columns: [
		{title:"ID", field: 'fplId', minWidth:50},
		{title:"SKU Code", field: 'skuCd', minWidth:50},
		{title:"SKU", field: 'sku.skuCodeName', minWidth:50},
		{title:"Name", field: 'quantity', minWidth:100},
		{title:"Date Finished", field: 'dateFinished', minWidth:100},
		{title:"Branch", field: 'branch.branchName', minWidth:100}
	],
});


$(".finishedProductListForm").submit(function(e){
	e.preventDefault();
});

divTable.on('rowClick',function() {
	let row = divTable.getSelectedData()[0];
	if (row !== undefined) {
		populateForm(row);
	} 
})

$("#btnShowFinishedProductList").click(function(){
	$.get("FinishedProductListController",{
		action: "showFinishedProductList"
		}, function(response){
		$("#divContent").html(response)
	});
});