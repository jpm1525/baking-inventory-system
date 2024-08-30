<jsp:include page="../nav/header.jsp"></jsp:include>
<div id="divVeryOuter">
  <div id="divMainMenu"> 
    <div class="flex w-screen my-20 text-white place-content-center flex-wrap mx-10px">
      <div class="dashboardbox bg-rose-500 hover:bg-rose-700 menu-btn" id="btnToRaw">
        <h1>Raw Material<br>List</h1>
        <img class="w-[350px] h-[270px] ml-[160px] mt-[10px]" src="images/dash-icons/list_icon.png">
      </div>
      <div class="dashboardbox bg-pink-500 hover:bg-pink-700 menu-btn" id="btnToDaily">
        <h1>Daily Planned<br>Production</h1>
        <img class="w-[300px] h-[260px] ml-[180px] mt-[20px]" src="images/dash-icons/plan_icon.png">
      </div>
      <div class="dashboardbox bg-fuchsia-500 hover:bg-fuchsia-700 menu-btn" id="btnToDispatching">
        <h1>Dispatching</h1>
        <img class="w-[400px] h-[400px] ml-[100px] mt-[-20px]" src="images/dash-icons/truck_icon.png">
      </div>
      <div class="dashboardbox bg-purple-500 hover:bg-purple-700 menu-btn" id="btnToReport">
        <h1>Report<br>Generation</h1>
        <img class="w-[310px] h-[260px] ml-[165px] mt-[20px]" src="images/dash-icons/report_icon.png">
      </div>
      <div class="dashboardbox bg-blue-500 hover:bg-blue-700 menu-btn" id="btnToMaintenance">
        <h1>Maintenance</h1>
        <img class="w-[370px] h-[320px] ml-[135px] mt-[-10px]" src="images/dash-icons/maint_icon.png">
      </div>
    </div>
  </div>
</div>
<div id="divOuter" style="display: none">
  <jsp:include page="../nav/sidebar.jsp"></jsp:include>
  <div class="flex mt-[60px] text-white flex-wrap ml-[280px]">
    <div id="divContent" class="m-[20px] w-full">
    </div>  
  </div>
</div>
<script src="js/main_menu_route.js"></script>
<script src="js/menu.js"></script>