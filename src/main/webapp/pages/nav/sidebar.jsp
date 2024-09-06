<nav class="sidebar text-[#68411b] dark:text-white bg-white dark:bg-[#1f2937]">

       
		    <div id="btnDashboard" class="inline-flex hover:bg-[#f9e4ad] rounded py-2 hover:text-black ">
                <div class="w-[40px] align-middle"><i class="fas fa-home p-2"></i></div>
		        <a class="flex items-center">Dashboard</a>
		    </div>
		    <div id="btnRawMaterialList" class="inline-flex hover:bg-[#965c5b] rounded py-2 hover:text-white">
		        <div class="w-[40px] align-middle"><i class="fas fa-cogs p-2"></i></div>
                <a class="flex items-center">Raw Material List</a>
		    </div>
		    <div id="btnDailyPlannedProduction" class="inline-flex hover:bg-[#b0b980] rounded py-2 hover:text-white">
		        <div class="w-[40px] align-middle"><i class="fas fa-calendar-day p-2"></i></div>
		        <a class="flex items-center">Daily Planned Production</a>
		    </div>
		    <div id="btnDispatching" class="inline-flex hover:bg-[#e4ac4f] rounded py-2 hover:text-white">
		        <div class="w-[40px] align-middle"><i class="fas fa-truck p-2"></i></div>
		        <a class="flex items-center">Dispatching</a>
		    </div>
      
                <div class="my-2">
                    <div class="inline-flex">
                        <div class="w-[40px] align-middle "><i class="fas fa-file-alt p-2"></i></div>
                        <button id="dropdownButtonReport">
                            Report Generation <i id="dropdownIconReport" class="fas fa-angle-down ml-1"></i>
                        </button>
                    </div>
                    <ul id="dropdownMenuReport" class="bg-base-100 rounded-box z-[1] w-68 p-2 hidden">
                        <li><a id="btnReportFinished" class="hover:bg-[#f95757] hover:text-white">Finished Inventory</a></li>
                        <li><a id="btnReportPlanned" class="hover:bg-[#f95757] hover:text-white">Planned Raw Materials Inventory</a></li>
                        <li><a id="btnReportProduction" class="hover:bg-[#f95757] hover:text-white">Production Report</a></li>
                        <li><a id="btnReportReceived" class="hover:bg-[#f95757] hover:text-white">Received Inventory Report</a></li>
                    </ul>
                </div>
                
                <div class="my-2">
                    <div class="inline-flex">
                      <div class="w-[40px] align-middle"><i class="fas fa-tools p-2"></i></div>
                      <button id="dropdownButtonMaintenance">
                          Maintenance <i id="dropdownIconMaintenance" class="fas fa-angle-down ml-1"></i>
                      </button>
                    </div>
                    <ul id="dropdownMenuMaintenance" class="bg-base-100 rounded-box z-[1] w-68 p-2 hidden">
                          <li><a id="btnDispatch" class="hover:bg-[#7db7ce] hover:text-white">Dispatch Types</a></li>
                          <li><a id="btnBranches" class="hover:bg-[#7db7ce] hover:text-white">Branches</a></li>
                          <li><a id="btnSkuCodes" class="hover:bg-[#7db7ce] hover:text-white">SKU Codes</a></li>
                          <li><a id="btnMaterialCodes" class="hover:bg-[#7db7ce] hover:text-white">Material Codes</a></li>
                    </ul>
                </div>
</nav>
<script src="js/menu.js"></script>
<script src="js/nav_dropdown.js"></script>