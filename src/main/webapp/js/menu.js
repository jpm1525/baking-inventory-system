$("#btnRegistration").click(function(){
$.get("RegistrationController",{
			action: "showRegistration"
		}, function(response){
			$("#divContent").html(response)

		});
		});	

$("#btnDashboard").click(function(){
$.get("DashboardController",{
			action: "showDashboard"
		}, function(response){
			$("#divContent").html(response)
		});
		});	
		
$("#btnRawMaterialList").click(function(){
$.get("RawMaterialListController",{
	action: "showRawMaterialList"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnDailyPlannedProduction").click(function(){
$.get("DailyPlannedProductionController",{
	action: "showDailyPlannedProduction"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnDispatching").click(function(){
$.get("DispatchingController",{
	action: "showDispatching"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnReportGeneration").click(function(){
$.get("ReportGenerationController",{
	action: "showReportGeneration"
	}, function(response){
	$("#divContent").html(response)

});
});	

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


