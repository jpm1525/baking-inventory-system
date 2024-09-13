$("#btnFin").click(function(){
	showLoading();
	$.get("ReportGenerationController",{ action: "showFin" }, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	

$("#btnPlan").click(function(){
	showLoading();
$.get("ReportGenerationController",{
	action: "showPlan"
	}, function(response){
	$("#divContent").html(response)
	hideLoading();

});
});	

$("#btnPro").click(function(){
	showLoading();
$.get("ReportGenerationController",{
	action: "showPro"
	}, function(response){
	$("#divContent").html(response)
	hideLoading();

});
});	

$("#btnRec").click(function(){
	showLoading();
$.get("ReportGenerationController",{
	action: "showRec"
	}, function(response){
	$("#divContent").html(response)
	hideLoading();

});
});	