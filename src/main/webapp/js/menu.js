
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
		history.go();
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

$("#btnMaintenance").click(function(){
$.get("MaintenanceController",{
	action: "showMaintenance"
	}, function(response){
	$("#divContent").html(response)

});
});	


document.addEventListener("DOMContentLoaded", function(event) {
	const button = document.getElementById('dropdownButton');
	const menu = document.getElementById('dropdownMenu');
    document.getElementById('defaultModalButton').click();

	button.addEventListener('click', function(event) {
	  event.stopPropagation();
	  menu.classList.toggle('hidden');
	});

	document.addEventListener('click', function(event) {
	  if (!button.contains(event.target) && !menu.contains(event.target)) {
	    menu.classList.add('hidden');
	  }
	});

	// Prevent clicks inside the dropdown from closing it
	menu.addEventListener('click', function(event) {
	  event.stopPropagation();
	});
	
});
