$("#btnReportFinished").click(function(){
	showLoading();
	$.get("ReportGenerationController",{ action: "showReportFinished" }, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	

$("#btnReportPlanned").click(function(){
	showLoading();
	$.get("ReportGenerationController",{ action: "showReportPlanned" }, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	

$("#btnReportProduction").click(function(){
	showLoading();
	$.get("ReportGenerationController",{ action: "showReportProduction" }, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	

$("#btnReportReceived").click(function(){
	showLoading();
	$.get("ReportGenerationController",{ action: "showReportReceived" }, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	