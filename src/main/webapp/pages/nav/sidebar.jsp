<nav class="sidebar">
        <table>
		    <tr id="btnDashboard">
		        <td class="p-2"><a href="#"><i class="fas fa-home"></i></a></td>
		        <td><a href="#">Dashboard</a></td>
		    </tr>
		    <tr id="btnRawMaterialList">
		        <td class="p-2"><a href="#"><i class="fas fa-cogs"></i></a></td>
		        <td><a href="#">Raw Material List</a></td>
		    </tr>
		    <tr id="btnDailyPlannedProduction">
		        <td class="p-2"><a href="#"><i class="fas fa-calendar-day"></i></a></td>
		        <td><a href="#">Daily Planned Production</a></td>
		    </tr>
		    <tr id="btnDispatching">
		        <td class="p-2"><a href="#"><i class="fas fa-truck"></i></a></td>
		        <td><a href="#">Dispatching</a></td>
		    </tr>
		  </table>
      
                <div class="p-2">
                    <i class="fas fa-file-alt ml-1"></i>
                    <button id="dropdownButtonReport" class="ml-2">
                        Report Generation <i id="dropdownIconReport" class="fas fa-angle-down ml-1"></i>
                    </button>
                    <ul id="dropdownMenuReport" class="bg-base-100 rounded-box z-[1] w-52 p-2 hidden">
                        <li><a id="btnReportGeneration">Planned Raw Materials Inventory by Date</a></li>
                        <li><a>Production Report by Date</a></li>
                        <li><a>Received Inventory Report by Date</a></li>
                    </ul>
                </div>
                
                <div class="p-2">
                    <i class="fas fa-tools"></i>
                    <button id="dropdownButtonMaintenance" class="ml-2">
                        Maintenance <i id="dropdownIconMaintenance" class="fas fa-angle-down ml-1"></i>
                    </button>
                    <ul id="dropdownMenuMaintenance" class="bg-base-100 rounded-box z-[1] w-52 p-2 hidden">
                          <li><a id="btnMaintenance">Manage Dispatch Types</a></li>
                          <li><a>Manage Branches</a></li>
                          <li><a>Manage SKU Codes</a></li>
                          <li><a>Manage Material Codes</a></li>
                    </ul>
                </div>
</nav>
<script src="js/menu.js"></script>
<script src="js/navDropdown.js"></script>