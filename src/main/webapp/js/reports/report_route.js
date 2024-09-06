$("#btnFin").click(function(){
$.get("ReportGenerationController",{
	action: "showFin"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnPlan").click(function(){
$.get("ReportGenerationController",{
	action: "showPlan"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnPro").click(function(){
$.get("ReportGenerationController",{
	action: "showPro"
	}, function(response){
	$("#divContent").html(response)

});
});	

$("#btnRec").click(function(){
$.get("ReportGenerationController",{
	action: "showRec"
	}, function(response){
	$("#divContent").html(response)

});
});	