<h1 class="text-white" id="btnShowMaintenance">Maintenance</h1>
<p></p>
<h1 class="text-white" id="btnMaterialCode">Material Codes</h1>
<label class="text-white-100 text-lg">Add Material Code</label>
  <div class="grid gap-4 mb-4 sm:grid-cols-2 mt-5">
    <div>
      <label for="materialCodeCreate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Material Code</label>
      <input type="text" name="materialCodeCreate" id="materialCodeCreate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="materialCodeNameCreate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Material Name</label>
      <input type="text" name="materialCodeNameCreate" id="materialCodeNameCreate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="materialCodeUnitOfMeasurementCreate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Unit of Measurement</label>
      <input type="text" name="materialCodeUnitOfMeasurementCreate" id="materialCodeUnitOfMeasurementCreate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
  </div>
  <div class="flex justify-start space-x-2">
    <button id="btnCreateMaterialCode" class="px-4 py-2 text-white bg-indigo-500 rounded">
      Add
    </button>
  </div>
<label class="text-white-100 text-lg">Read Material Code</label>
<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
  <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
    <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
      <tr>
        <th th scope="col" class="px-6 py-3">
          Material Code 
        </th>
        <th th scope="col" class="px-6 py-3">
          Material Code Name
        </th>
        <th th scope="col" class="px-6 py-3">
          Unit of Measurement
        </th>
        <th scope="col" class="px-6 py-3">
          Action
        </th>
      </tr>
    </thead>
    <tbody id="divTable">
    </tbody>
  </table>
</div>

<label class="text-white-100 text-lg">Update Material Code</label>
  <div class="grid gap-4 mb-4 sm:grid-cols-2 mt-5">
    <div>
      <label for="materialCodeUpdate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Material Code</label>
      <input type="text" name="materialCodeUpdate" id="materialCodeUpdate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="materialCodeNameUpdate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Material Name</label>
      <input type="text" name="materialCodeNameUpdate" id="materialCodeNameUpdate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="materialCodeUnitOfMeasurementUpdate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Unit of Measurement</label>
      <input type="text" name="materialCodeUnitOfMeasurementUpdate" id="materialCodeUnitOfMeasurementUpdate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
  </div>
  <div class="flex justify-start space-x-2">
    <button id="btnUpdateMaterialCode" class="px-4 py-2 text-white bg-indigo-500 rounded">
      Update
    </button>
  </div>
<p class="text-white" id="btnDeleteMaterialCode">Delete Material Code</p>


<script type="text/javascript">
  var materialCode = JSON.parse('${materialCode}');
</script>
<script src="js/maintenance/material-code.js"></script>