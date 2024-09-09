<link rel="stylesheet" href="css/modal.css" type="text/css" />

<dialog id="editModal" class="relative p-6 bg-white dark:bg-gray-700 rounded-lg shadow-lg max-w-2xl">
  <form class="dailyPlannedProductionForm">
    <div class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600">
      <h3 class="text-3xl font-semibold text-gray-900 dark:text-white">
          Edit Daily Planned Production
      </h3>
      <button type="button" id="closeEditModalButton" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 
        rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 
        dark:hover:text-white">
        <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
          <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
        </svg>
        <span class="sr-only">Close modal</span>
      </button>
    </div>
    
    <div class="grid gap-4 mb-4 sm:grid-cols-2 mt-5">
      <div>
        <label for="dailyPlannedProductionIdUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">ID</label>
        <input type="text" name="dailyPlannedProductionIdUpdate" id="dailyPlannedProductionIdUpdate" class="bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" 
          required="required" placeholder="Type raw material list id" readonly="readonly">
      </div>
      <div>
        <label for="dailyPlannedProductionDateUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">Production Date</label>
        <input id="dailyPlannedProductionDateUpdate" type="date" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm 
          rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 
          dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Select date">
      </div>
      <div>          
        <label for="dailyPlannedProductionBranchId" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">Branch ID - Name</label>
        <input id="dailyPlannedProductionBranchId" dataBranchId="" name="dailyPlannedProductionBranchId" class="bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500 
          dailyPlannedProductionBranchId" required="required" readonly="readonly">
      </div>
       <div>          
        <label for="dailyPlannedProductionSkuCdUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">SKU</label>
        <select id="dailyPlannedProductionSkuCdUpdate" name="dailyPlannedProductionSkuCdUpdate" class="bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500 
          dailyPlannedProductionSkuCdCreate" required="required">
          <option value="" disabled selected hidden>Select SKU</option>
        </select>
      </div>
      <div>
        <label for="dailyPlannedProductionQuantityUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">Quantity</label>
        <input type="number" name="dailyPlannedProductionQuantityUpdate" id="dailyPlannedProductionQuantityUpdate" class="num-input bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" 
          required="required" placeholder="Type quantity">
      </div>
      <div>
      	<label for="dailyPlannedProductionStatusUpdate"
        class="block mb-2 text-m font-medium text-gray-900 dark:text-white">Status</label>
        <select id="dailyPlannedProductionStatusUpdate"
        		name="dailyPlannedProductionStatusUpdate"
        		class="input bg-gray-50 border border-gray-300 
          		text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          		dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500">
        	<option value="" disabled selected hidden>Select Status</option>
        	<option>Planned
	        <option>In Progress
	        <option>Completed
        </select>
      </div>
    </div>
  
    <div class="grid gap-4 mb-4 sm:grid-cols-1 mt-5">
      <div>
        <p class="text-red-500 errorMessage"></p>
      </div>
    </div>
  
    <div class="flex justify-end space-x-2">
      <button id="cancelEditModalButton" class="px-4 py-2 rounded ms-3 text-gray-900 
        focus:outline-none bg-white border border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:z-10 
        focus:ring-4 focus:ring-gray-100 dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 
        dark:border-gray-600 dark:hover:text-white dark:hover:bg-gray-700">
        Cancel
      </button>
      <button id="btnUpdateDailyPlannedProduction" type="submit" class="text-white inline-flex items-center bg-blue-700 
        hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium 
        rounded px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 
        dark:focus:ring-blue-800">
        Save
      </button>
    </div>
  </form>  
</dialog>
