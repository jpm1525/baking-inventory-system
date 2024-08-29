<h1 class="text-white" id="btnShowMaintenance">Maintenance</h1>
<p></p>
<h1 class="text-white" id="btnDispatch">Dispatch Types</h1>
<label class="text-white-100 text-lg">Add Dispatch Type</label>
  <div class="grid gap-4 mb-4 sm:grid-cols-2 mt-5">
    <div>
      <label for="dispatchTypeCodeCreate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Dispatch Type Code</label>
      <input type="text" name="dispatchTypeCodeCreate" id="dispatchTypeCodeCreate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="dispatchTypeNameCreate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Dispatch Name</label>
      <input type="text" name="dispatchTypeNameCreate" id="dispatchTypeNameCreate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
  </div>
  <div class="flex justify-start space-x-2">
    <button id="btnCreateDispatchType" class="px-4 py-2 text-white bg-indigo-500 rounded">
      Add
    </button>
  </div>
<label class="text-white-100 text-lg">Read Dispatch Type</label>
<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
  <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
    <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
      <tr>
        <th th scope="col" class="px-6 py-3">
          Dispatch Type Code
        </th>
        <th th scope="col" class="px-6 py-3">
          Dispatch Type Name
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

<label class="text-white-100 text-lg">Update Dispatch Type</label>
  <div class="grid gap-4 mb-4 sm:grid-cols-2 mt-5">
    <div>
      <label for="dispatchTypeCodeUpdate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Dispatch Type Code</label>
      <input type="text" name="dispatchTypeCodeUpdate" id="dispatchTypeCodeUpdate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
    <div>
      <label for="dispatchTypeNameUpdate" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Dispatch Name</label>
      <input type="text" name="dispatchTypeNameUpdate" id="dispatchTypeNameUpdate" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#f23634] focus:border-[#f23634] block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" required="">
    </div>
  </div>
  <div class="flex justify-start space-x-2">
    <button id="btnUpdateDispatchType" class="px-4 py-2 text-white bg-indigo-500 rounded">
      Update
    </button>
  </div>
<p class="text-white" id="btnDeleteDispatchType">Delete Dispatch Type</p>


<script type="text/javascript">
  var dispatchType = JSON.parse('${dispatchType}');
</script>
<script src="js/maintenance/dispatch.js"></script>