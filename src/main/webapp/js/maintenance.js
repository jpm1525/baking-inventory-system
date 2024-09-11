$("#btnDis").click(function(){
	$.get("MaintenanceController",{
		action: "showDis"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnBra").click(function(){
	$.get("MaintenanceController",{
		action: "showBra"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnSku").click(function(){
	$.get("MaintenanceController",{
		action: "showSku"
		}, function(response){
		$("#divContent").html(response)
	});
});	

$("#btnMat").click(function(){
	$.get("MaintenanceController",{
		action: "showMat"
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