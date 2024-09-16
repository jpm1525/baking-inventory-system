<h1 class="dark:text-white flex justify-center text-4xl font-bold mx-10">Reports</h1>
<hr class="h-px my-6 bg-gray-200 border-0 dark:bg-gray-700">
<div class="flex flex-wrap gap-5 rounded justify-center">

  <div id="btnFin"
    class="reports bg-[#f95757] hover:bg-[#B94141] transform transition-transform hover:scale-105">
    <img class="w-[170px] h-[160px] ml-[184px] mt-6"
      src="images/report-icons/inventory_icon.png" ondragstart="return false;">
    <h1 class="dark:text-white text-white">Finished Inventory by Date</h1>
  </div>

  <div id="btnPlan"
    class="reports bg-[#f95757] hover:bg-[#B94141] transform transition-transform hover:scale-105">
    <img class="w-[240px] h-[220px] ml-[130px] mt-1"
      src="images/info-icons/raw_icon.png" ondragstart="return false;">
    <h1 class="dark:text-white text-white">Planned Raw Materials Inventory by Date</h1>
  </div>

  <div id="btnPro"
    class="reports bg-[#f95757] hover:bg-[#B94141] transform transition-transform hover:scale-105">
    <img class="w-[160px] h-[150px] ml-[185px] mt-7"
      src="images/dash-icons/plan_icon.png" ondragstart="return false;">
    <h1 class="dark:text-white text-white">Production Report by Date</h1>
  </div>

  <div id="btnRec"
    class="reports bg-[#f95757] hover:bg-[#B94141] transform transition-transform hover:scale-105">
    <img class="w-[170px] h-[160px] ml-[195px] mt-7"
      src="images/dash-icons/list_icon.png" ondragstart="return false;">
    <h1 class="dark:text-white text-white">Received Inventory Report by Date</h1>
  </div>
</div>

<script src="js/reports/report_route.js"></script>