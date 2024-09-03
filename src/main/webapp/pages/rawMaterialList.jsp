<link rel="stylesheet" href="css/modal.css" type="text/css" />
<link rel="stylesheet" href="css/tabulator_simple.min.css"
  type="text/css">
<link rel="stylesheet" href="css/tabulator_tailwind.css" type="text/css">
<script type="text/javascript" src="js/tabulator.min.js"></script>
<script src="js/modal/modal.js"></script>

<div class="flex place-content-center flex-col ">
  <div>
    <h1
      class="text-black dark:text-white text-center text-5xl font-bold m-10"
      id="btnRawMaterialList">Raw Material List</h1>
  </div>
  <div class="flex justify-end">
    <button id="openAddModalButton" class="px-4 py-2 m-2 text-white bg-indigo-500 rounded">
      <i class="fas fa-plus"></i>
    </button>
  </div>
  <div class="relative overflow-x-auto shadow-md sm:rounded-lg basis-6/12">
    <div id="divTableTabulator"> 
      
    </div>
  </div>
</div>

<jsp:include page="../pages/modals/rawMaterialListAddModal.jsp"></jsp:include>
<jsp:include page="../pages/modals/rawMaterialListEditModal.jsp"></jsp:include>
<jsp:include page="../pages/modals/maintenance/deleteModal.jsp"></jsp:include> 

<script type="text/javascript">
	var rawMaterialList = JSON.parse('${rawMaterialList}');
</script>
<script src="js/raw_material_list.js"></script>
