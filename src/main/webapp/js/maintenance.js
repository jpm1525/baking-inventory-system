$("#btnDis").click(function(){
	$.get("MaintenanceController",{
		action: "showDispatch"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnBra").click(function(){
	$.get("MaintenanceController",{
		action: "showBranches"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnSku").click(function(){
	$.get("MaintenanceController",{
		action: "showSkuCodes"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnMat").click(function(){
	$.get("MaintenanceController",{
		action: "showMaterialCodes"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnUserMain").click(function(){
	$.get("MaintenanceController",{
		action: "showUserMain"
		}, function(response){
		$("#divContent").html(response)
	});
});	