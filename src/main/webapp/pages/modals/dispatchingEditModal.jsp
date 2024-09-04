<link rel="stylesheet" href="css/modal.css" type="text/css" />

<dialog id="editModal" class="relative p-6 bg-white dark:bg-gray-700 rounded-lg shadow-lg max-w-2xl">
  <form class="dispatchingForm">
    <div class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600">
      <h3 class="text-3xl font-semibold text-gray-900 dark:text-white">
          Edit Dispatching
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
      <div class="col-span-2">
        <label for="dispatchingIdUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">ID</label>
        <input type="text" name="dispatchingIdUpdate" id="dispatchingIdUpdate" class="bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" 
          required="required" placeholder="Type dispatch id" readonly="readonly">
      </div>
      <div>
        <label for="dispatchingTypeNameUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">Name</label>
        <select id="dispatchingTypeNameUpdate" name="dispatchingTypeNameUpdate" class="bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500 
          selectDispatchingTypeName" required="required">
          <option value="" disabled selected hidden>Select Dispatch Name</option>
        </select>
      </div>
      <div>
        <label for="dispatchingFinishedProductListIdUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">FPL ID</label>
        <input type="text" name="dispatchingFinishedProductListIdUpdate" id="dispatchingFinishedProductListIdUpdate" class="bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" 
          required="required" placeholder="Type finished product id list">
      </div>
      <div>
        <label for="dispatchingQuantityUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">Quantity</label>
        <input type="number" name="dispatchingQuantityUpdate" id="dispatchingQuantityUpdate" class="bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" 
          required="required" placeholder="Type quantity">
      </div>
      <div>
        <label for="dispatchingBranchNameUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">Branch Name</label>
        <select id="dispatchingBranchNameUpdate" name="dispatchingBranchNameUpdate" class="bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500 
          selectDispatchingBranch" required="required">
          <option value="" disabled selected hidden>Select Branch</option>
        </select>
      </div>
      <div>
        <label for="dispatchingDestinationUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">Destination</label>
        <input type="text" name="dispatchingDestinationUpdate" id="dispatchingDestinationUpdate" class="bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" 
          required="required" placeholder="Type destination">
      </div>
      <div>
        <label for="dispatchingDateUpdate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">Dispatch Date</label>
        <input id="dispatchingDateUpdate" type="date" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm 
          rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 
          dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Select date">
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
      <button id="btnUpdateDispatching" type="submit" class="text-white inline-flex items-center bg-blue-700 
        hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium 
        rounded px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 
        dark:focus:ring-blue-800">
        Save
      </button>
    </div>
  </form>  
</dialog>
