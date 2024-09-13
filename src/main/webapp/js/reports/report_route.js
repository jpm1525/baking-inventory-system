$("#btnFin").click(function(){
$.get("ReportGenerationController",{
	action: "showReportFinished"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnPlan").click(function(){
$.get("ReportGenerationController",{
	action: "showReportPlanned"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnPro").click(function(){
$.get("ReportGenerationController",{
	action: "showReportProduction"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnRec").click(function(){
$.get("ReportGenerationController",{
	action: "showReportReceived"
	}, function(response){
	$("#divContent").html(response)

});
});	