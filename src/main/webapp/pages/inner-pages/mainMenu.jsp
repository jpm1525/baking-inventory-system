<jsp:include page="../nav/header.jsp"></jsp:include>
<div class="flex w-screen h-screen backdrop-blur-sm dark-">
<div id="divVeryOuter" class="flex w-screen h-screen ">
  <div id="divMainMenu"> 
    <div class=" menuBtn flex text-white align-center justify-center flex-wrap mx-10px">
      
      <div class="dashboardbox bg-[#f9e4ad] hover:bg-[#D6C495] menu-btn transition transform hover:-translate-y-1 motion-reduce:transition-none motion-reduce:hover:transform-none" id="btnToDash">
        <h1>Dashboard</h1>
        <img class="w-[320px] h-[280px] ml-[150px] mt-[10px]" src="images/dash-icons/dash_icon.png" ondragstart="return false;">
      </div>
      
      <div class="dashboardbox bg-[#965c5b] hover:bg-[#7F4F4E] menu-btn transform hover:-translate-y-1 motion-reduce:transition-none motion-reduce:hover:transform-none" id="btnToRaw">
        <h1>Raw Material<br>List</h1>
         <img class="w-[350px] h-[270px] ml-[160px] mt-[10px]" src="images/dash-icons/list_icon.png" ondragstart="return false;">
      </div>
      
      <div class="dashboardbox bg-[#b0b980] hover:bg-[#899064] menu-btn transform hover:-translate-y-1 motion-reduce:transition-none motion-reduce:hover:transform-none" id="btnToDaily">
        <h1>Daily Planned<br>Production</h1>
         <img class="w-[300px] h-[260px] ml-[180px] mt-[20px]" src="images/dash-icons/plan_icon.png" ondragstart="return false;">
      </div>
      
      <div class="dashboardbox bg-[#e4ac4f] hover:bg-[#AA813B] menu-btn transform hover:-translate-y-1 motion-reduce:transition-none motion-reduce:hover:transform-none" id="btnToFinishedProductList">
        <h1>Finished Product<br>List</h1>
         <img class="w-[400px] h-[400px] ml-[100px] mt-[-20px]" src="images/dash-icons/truck_icon.png" ondragstart="return false;">
      </div>
      
      <div class="dashboardbox bg-[#e4ac4f] hover:bg-[#AA813B] menu-btn transform hover:-translate-y-1 motion-reduce:transition-none motion-reduce:hover:transform-none" id="btnToDispatching">
        <h1>Dispatching</h1>
         <img class="w-[400px] h-[400px] ml-[100px] mt-[-20px]" src="images/dash-icons/truck_icon.png" ondragstart="return false;">
      </div>
      
      <div class="dashboardbox bg-[#f95757] hover:bg-[#B94141] menu-btn transform hover:-translate-y-1 motion-reduce:transition-none motion-reduce:hover:transform-none" id="btnToReport">
        <h1>Report<br>Generation</h1>
         <img class="w-[310px] h-[260px] ml-[165px] mt-[20px]" src="images/dash-icons/report_icon.png" ondragstart="return false;">
      </div>
      
      <div class="dashboardbox bg-[#7db7ce] hover:bg-[#5A8394] menu-btn transform hover:-translate-y-1 motion-reduce:transition-none motion-reduce:hover:transform-none" id="btnToMaintenance">
        <h1>Maintenance</h1>
         <img class="w-[370px] h-[320px] ml-[135px] mt-[-10px]" src="images/dash-icons/maint_icon.png" ondragstart="return false;">
      </div>
      
    </div>
  </div>
</div>

<div id="divOuter" style="display: none" class="flex w-screen h-screen ">
  <div>
  <jsp:include page="../nav/sidebar.jsp"></jsp:include>
    <div id="divContent" class="text-[#68411b] dark:text-white bg-white dark:bg-[#1f2937]">
    </div>  
  </div>
</div>
</div>
    

<script src="js/maintenance.js"></script>
<script src="js/reports.js"></script>
<script src="js/main_menu_route.js"></script>
<script src="js/menu.js"></script>