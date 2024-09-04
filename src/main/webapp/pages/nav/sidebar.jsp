<nav class="sidebar text-[#68411b] dark:text-white bg-white dark:bg-[#1f2937]">

       
		    <div id="btnDashboard" class="my-2">
		        <i class="fas fa-home p-2"></i>
		        <a>Dashboard</a>
		    </div>
		    <div id="btnRawMaterialList" class="my-2">
		        <i class="fas fa-cogs p-2"></i>
                <a>Raw Material List</a>
		    </div>
		    <div id="btnDailyPlannedProduction" class="my-2">
		        <i class="fas fa-calendar-day p-2"></i>
		        <a>Daily Planned Production</a>
		    </div>
		    <div id="btnDispatching" class="my-2">
		        <i class="fas fa-truck p-2"></i>
		        <a>Dispatching</a>
		    </div>
      
                <div class="p-2 my-2">
                    <i class="fas fa-file-alt ml-1 mr-2"></i>
                    <button id="dropdownButtonReport">
                        Report Generation <i id="dropdownIconReport" class="fas fa-angle-down ml-1"></i>
                    </button>
                    <ul id="dropdownMenuReport" class="bg-base-100 rounded-box z-[1] w-52 p-2 hidden">
                        <li><a id="btnReportGeneration">Planned Raw Materials Inventory by Date</a></li>
                        <li><a>Production Report by Date</a></li>
                        <li><a>Received Inventory Report by Date</a></li>
                    </ul>
                </div>
                
                <div class="p-2 my-2">
                    <i class="fas fa-tools"></i>
                    <button id="dropdownButtonMaintenance" class="ml-2">
                        Maintenance <i id="dropdownIconMaintenance" class="fas fa-angle-down ml-1"></i>
                    </button>
                    <ul id="dropdownMenuMaintenance" class="bg-base-100 rounded-box z-[1] w-52 p-2 hidden">
                          <li><a id="btnDispatch">Manage Dispatch Types</a></li>
                          <li><a id="btnBranches">Manage Branches</a></li>
                          <li><a id="btnSkuCodes">Manage SKU Codes</a></li>
                          <li><a id="btnMaterialCodes">Manage Material Codes</a></li>
                    </ul>
                </div>
</nav>
<script src="js/menu.js"></script>
<script src="js/nav_dropdown.js"></script>