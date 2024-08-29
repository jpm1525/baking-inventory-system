$("#btnDispatch").click(function(){
	$.get("MaintenanceController",{
		action: "showDispatch"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnBranches").click(function(){
	$.get("MaintenanceController",{
		action: "showBranches"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnSkuCodes").click(function(){
	$.get("MaintenanceController",{
		action: "showSkuCodes"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnMaterialCodes").click(function(){
	$.get("MaintenanceController",{
		action: "showMaterialCodes"
		}, function(response){
		$("#divContent").html(response)
	});
});	