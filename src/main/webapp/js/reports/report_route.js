$("#btnFin").click(function(){
	showLoading();
	$.get("ReportGenerationController",{ 
		action: "showReportFinished" 
	}, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	

$("#btnPlan").click(function(){
	showLoading();
$.get("ReportGenerationController",{
	action: "showReportPlanned"
	}, function(response){
	$("#divContent").html(response)
	hideLoading();

});
});	

$("#btnPro").click(function(){
	showLoading();
$.get("ReportGenerationController",{
	action: "showReportProduction"
	}, function(response){
	$("#divContent").html(response)
	hideLoading();

});
});	

$("#btnRec").click(function(){
	showLoading();
$.get("ReportGenerationController",{
	action: "showReportReceived"
	}, function(response){
	$("#divContent").html(response)
	hideLoading();

});
});	