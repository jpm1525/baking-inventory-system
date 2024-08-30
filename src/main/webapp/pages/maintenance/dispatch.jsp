<link rel="stylesheet" href="css/modal.css" type="text/css" />
<script src="js/modal/raw_modal.js"></script>

<h1 class="text-white" id="btnShowMaintenance">Maintenance</h1>

<div class="flex place-content-center flex-col ">
  <div>
    <h1 class="text-white text-center text-5xl font-bold m-10" id="btnDispatch">Dispatch Type</h1>
  </div>
  <div class="flex justify-end">
    <button id="openAddModalButton" class="px-4 py-2 m-2 text-white bg-indigo-500 rounded">
      <i class="fas fa-plus"></i>
    </button>
    <jsp:include page="../modals/modal-raw/rawModal.jsp"></jsp:include>
  </div>
  <div class="relative overflow-x-auto shadow-md sm:rounded-lg basis-6/12">
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
        <tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-gray-800 border-b dark:border-gray-700">
            <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                Apple MacBook Pro 17"
            </th>
            <td class="px-6 py-4">
                $2999
            </td>
            <td class="px-6 py-4">
                <jsp:include page="../modals/modal-raw/editRaw.jsp"></jsp:include>
                <jsp:include page="../modals/modal-raw/deleteRaw.jsp"></jsp:include>
            </td>
        </tr>
    </table>
  </div>
</div>


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