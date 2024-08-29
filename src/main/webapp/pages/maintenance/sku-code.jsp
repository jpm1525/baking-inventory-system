<h1 class="text-white" id="btnShowMaintenance">Maintenance</h1>
<p></p>
<h1 class="text-white" id="btnSkuCode">SKU Codes</h1>
<label class="text-white-100 text-lg">Add SKU Code</label>
  <div class="grid gap-4 mb-4 sm:grid-cols-2 mt-5">
    <div>
      <label for="skuCodeCreate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">SKU Code</label>
      <input type="text" name="skuCodeCreate" id="skuCodeCreate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="skuCodeNameCreate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">SKU Name</label>
      <input type="text" name="skuCodeNameCreate" id="skuCodeNameCreate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="skuCodeUnitOfMeasurementCreate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Unit of Measurement</label>
      <input type="text" name="skuCodeUnitOfMeasurementCreate" id="skuCodeUnitOfMeasurementCreate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
  </div>
  <div class="flex justify-start space-x-2">
    <button id="btnCreateSkuCode" class="px-4 py-2 text-white bg-indigo-500 rounded">
      Add
    </button>
  </div>
<label class="text-white-100 text-lg">Read SKU Code</label>
<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
  <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
    <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
      <tr>
        <th th scope="col" class="px-6 py-3">
          SKU Code 
        </th>
        <th th scope="col" class="px-6 py-3">
          SKU Code Name
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

<label class="text-white-100 text-lg">Update SKU Code</label>
  <div class="grid gap-4 mb-4 sm:grid-cols-2 mt-5">
    <div>
      <label for="skuCodeUpdate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">SKU Code</label>
      <input type="text" name="skuCodeUpdate" id="skuCodeUpdate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="skuCodeNameUpdate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">SKU Name</label>
      <input type="text" name="skuCodeNameUpdate" id="skuCodeNameUpdate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="skuCodeUnitOfMeasurementUpdate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Unit of Measurement</label>
      <input type="text" name="skuCodeUnitOfMeasurementUpdate" id="skuCodeUnitOfMeasurementUpdate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
  </div>
  <div class="flex justify-start space-x-2">
    <button id="btnUpdateSkuCode" class="px-4 py-2 text-white bg-indigo-500 rounded">
      Update
    </button>
  </div>
<p class="text-white" id="btnDeleteSkuCode">Delete SKU Code</p>


<script type="text/javascript">
  var skuCode = JSON.parse('${skuCode}');
</script>
<script src="js/maintenance/sku-code.js"></script>