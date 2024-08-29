<link rel="stylesheet" href="css/modal.css" type="text/css" />
<script src="js/modal/rawModal.js"></script>

<button id="openAddModalButton" class="px-4 py-2 m-2 text-white bg-indigo-500 rounded">
  <i class="fas fa-plus"></i>
</button>

<!-- Modal Dialog -->
<dialog id="addModal" class="relative p-6 bg-[#161624] rounded-lg shadow-lg max-w-3xl">
  <!-- Close Button -->
  <button id="closeAddModalButton" class="close-button">
    <i class="fa-solid fa-x text-white text-xl mr-1.5"></i>
  </button>
  
  <!-- Modal Content -->
  <label class="text-white-100 text-lg">Add Raw Material</label>
  <div class="grid gap-4 mb-4 sm:grid-cols-2 mt-5">
    <div>
      <label for="materialCode" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Material Code</label>
      <input type="text" name="materialCode" id="materialCode" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="materialName" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Material Name</label>
      <input type="text" name="materialName" id="materialName" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="unitMeasurement" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Unit of Measurement</label>
      <input type="text" name="unitMeasurement" id="unitMeasurement" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
  </div>
  <div class="grid gap-4 mb-4 sm:grid-cols-3 mt-5">
    <div>
      <label for="dateReceived" class="block mb-2 text-sm font-medium text-gray-300 dark:text-white">Date Received</label>
      <input type="date" id="dateReceived" name="dateReceived">
    </div>
    <div>
      <label for="userId" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">User ID</label>
      <label for="userId" class="block mb-2 text-sm font-medium text-gray-300 dark:text-white">#</label>
    </div>
    <div>
      <label for="branchId" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Branch ID</label>
      <label for="branchId" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">#</label>
    </div>
  </div>
  
  <!-- Save Button -->
  <div class="flex justify-end space-x-2">
    <button id="saveAddModalButton" class="px-4 py-2 text-white bg-indigo-500 rounded">
      Save
    </button>
  </div>
</dialog>
