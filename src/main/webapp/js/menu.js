function showLoading() {
	$("#content-loading-screen").show();
	$("#divContent").prepend(`
    <div id="content-loading-screen" class="relative flex justify-center items-center align-center h-full w-full mb-[200px] overflow-hidden">
      <div class="absolute animate-spin rounded-full h-20 w-20 border-t-4 border-b-4 dark:border-white border-[#68411b] mb-20"></div>
      <p class="animate-pulse text-xl font-bold grid-rows-2 mt-6">Loading content . . .</p>
    </div>
  `);
	$("#divContent").css("overflow", "hidden");
}

function hideLoading() {
	$("#content-loading-screen").remove();
	$("#divContent").css("overflow", "auto");
}

$("#btnDashboard").click(function() {
	showLoading();
	$.get("DashboardController", {
		action: "showDashboard"
	}, function(response) {
		hideLoading();
		$("#divContent").html(response);
	});
});

$("#btnRawMaterialList").click(function() {
	showLoading();
	$.get("RawMaterialListController", {
		action: "showRawMaterialList"
	}, function(response) {
		hideLoading();
		$("#divContent").html(response);
	});
});

$("#btnDailyPlannedProduction").click(function() {
	showLoading();
	$.get("DailyPlannedProductionController", {
		action: "showDailyPlannedProduction"
	}, function(response) {
		hideLoading();
		$("#divContent").html(response);
	});
});

$("#btnFinishedProductList").click(function() {
	showLoading();
	$.get("FinishedProductListController", {
		action: "showFinishedProductList"
	}, function(response) {
		hideLoading();
		$("#divContent").html(response);
	});
});

$("#btnDispatching").click(function() {
	showLoading();
	$.get("DispatchingController", {
		action: "showDispatching"
	}, function(response) {
		hideLoading();
		$("#divContent").html(response);
	});
});

$("#btnReportGeneration").click(function() {
	showLoading();
	$.get("ReportGenerationController", {
		action: "showReportGeneration"
	}, function(response) {
		hideLoading();
		$("#divContent").html(response);
	});
});
