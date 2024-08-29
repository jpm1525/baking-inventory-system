$(document).ready(function(){
    $(".menu-btn").click(function(){
        var buttonId = $(this).attr('id');
        var url, action;

        switch (buttonId) {
            case 'btnToRaw':
                url = 'RawMaterialListController';
                action = 'showRawMaterialList';
                $("#divVeryOuter").hide();
                $("#divOuter").show(); 
                break;
            case 'btnToDaily':
                url = 'DailyPlannedProductionController';
                action = 'showDailyPlannedProduction';
                $("#divVeryOuter").hide();
                $("#divOuter").show(); 
                break;
            case 'btnToDispatching':
                url = 'DispatchingController';
                action = 'showDispatching';
                $("#divVeryOuter").hide();
                $("#divOuter").show();
                break;
            case 'btnToReport':
                url = 'ReportGenerationController';
                action = 'showReportGeneration';
                $("#divVeryOuter").hide(); 
                $("#divOuter").show(); 
                break;
            case 'btnToMaintenance':
                url = 'MaintenanceController';
                action = 'showMaintenance';
                $("#divVeryOuter").hide(); 
                $("#divOuter").show();
                break;

			
            default:
                return;
        }


        $.get(url, { action: action }, function(response){
            if (buttonId === 'btnMainMenu') {
                $("#divVeryOuter").html(response);
            } else {
                $("#divContent").html(response);
            }
        });
    });
	
	$("#btnMainMenu").click(function() {
		$("#divOuter").hide(); 
		$("#divVeryOuter").show(); 
	});
});
