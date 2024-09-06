$("#btnReportFinished").click(function(){
$.get("ReportGenerationController",{
	action: "showReportFinished"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnReportPlanned").click(function(){
$.get("ReportGenerationController",{
	action: "showReportPlanned"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnReportProduction").click(function(){
$.get("ReportGenerationController",{
	action: "showReportProduction"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnReportReceived").click(function(){
$.get("ReportGenerationController",{
	action: "showReportReceived"
	}, function(response){
	$("#divContent").html(response)

});
});	