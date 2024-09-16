$(document).ready(function() {
    const buttonActions = {
        'btnToDash': { url: 'DashboardController', action: 'showDashboard' },
        'btnToRaw': { url: 'RawMaterialListController', action: 'showRawMaterialList' },
        'btnToDaily': { url: 'DailyPlannedProductionController', action: 'showDailyPlannedProduction' },
        'btnToFinishedProductList': { url: 'FinishedProductListController', action: 'showFinishedProductList' },
        'btnToDispatching': { url: 'DispatchingController', action: 'showDispatching' },
        'btnToReport': { url: 'ReportGenerationController', action: 'showReportGeneration' },
        'btnToMaintenance': { url: 'MaintenanceController', action: 'showMaintenance' }
    };

    $(".menu-btn").click(function() {
        const buttonId = $(this).attr('id');
        const buttonData = buttonActions[buttonId];

        if (buttonData) {
            showLoading();
            $("#divVeryOuter").hide();
            $("#divOuter").show();
            $("#divContent").css("overflow", "hidden");
			$("#sidebarToggle").css("visibility", "visible");
            $.get(buttonData.url, { action: buttonData.action }, function(response) {
                $("#divContent").html(response);
                hideLoading();
            });
        }
    });

    $("#btnMainMenu").click(function() {
        $("#divOuter").hide();
        $("#divVeryOuter").show();
		$("#sidebarToggle").css("visibility", "hidden");
    });

    $("#btnLogout").click(function() {
        $.post("UserController", { action: "logout" }, function(response) {
            $("#divMain").html(response);
            $("#divMenu").html("");
            window.location.reload();
        });
    });
});

function showLoading() {
    $("#content-loading-screen").show();
    $("#divContent").prepend(`
      <div id="content-loading-screen" class="relative flex justify-center items-center align-center h-full w-full mb-[200px] overflow-hidden">
        <div class="absolute animate-spin rounded-full h-20 w-20 border-t-4 border-b-4 dark:border-white border-[#68411b] mb-20"></div>
        <p class="animate-pulse text-xl font-bold grid-rows-2 mt-6">Loading content . . .</p>
      </div>
    `);
}

function hideLoading() {
    $("#content-loading-screen").remove();
    $("#divContent").css("overflow", "auto");
}
