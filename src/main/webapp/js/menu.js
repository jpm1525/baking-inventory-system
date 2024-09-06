$("#btnRegistration").click(function(){
$.get("RegistrationController",{
			action: "showRegistration"
		}, function(response){
			$("#divContent").html(response)

		});
		});	

$("#btnLogout").click(function() {
	$.post("UserController", {
		action: "logout"
	}, function(response) {
		$("#divMain").html(response);
		$("#divMenu").html("");
		/*history.go();*/
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