$("#btnDis").click(function(){
	showLoading();
	$.get("MaintenanceController",{ action: "showDispatch" }, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	

$("#btnBra").click(function(){
	showLoading();
	$.get("MaintenanceController",{ action: "showBranches" }, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	

$("#btnSku").click(function(){
	showLoading();
	$.get("MaintenanceController",{ action: "showSkuCodes" }, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	

$("#btnMat").click(function(){
	showLoading();
	$.get("MaintenanceController",{ action: "showMaterialCodes" }, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	

$("#btnUserMain").click(function(){
	showLoading();
	$.get("MaintenanceController",{ action: "showUserMain" }, function(response){
		$("#divContent").html(response)
		hideLoading();
	});
});	