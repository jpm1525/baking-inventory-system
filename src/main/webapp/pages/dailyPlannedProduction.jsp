
<h1 class="text-white text-center text-5xl font-bold m-10">Daily Planned Production</h1>
<%--
<script src="js/modal.js"></script>
<link rel="stylesheet" href="css/modal.css" type="text/css" />

 <div class="flex justify-end">
<jsp:include page="../pages/modals/rawModal.jsp"></jsp:include>
</div> --%>

<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
     <%-- <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 py-3" id="txtMaterialCode">
                    Material Code
                </th>
                <th scope="col" class="px-6 py-3"  id="txtQuantity">
                    Quantity
                </th>
                <th scope="col" class="px-6 py-3" id="txtUserId">
                    User ID
                </th>
                <th scope="col" class="px-6 py-3" id="txtBranchId">
                    Branch Id
                </th>
                <th scope="col" class="px-6 py-3" id="txtDateReceive">
                    Date Receive
                </th>
                <th scope="col" class="px-6 py-3">
                    Action
                </th>
            </tr>
        </thead>
        
        <tbody>
            <tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-gray-800 border-b dark:border-gray-700">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    Apple MacBook Pro 17"
                </th>
                <td class="px-6 py-4">
                    Silver
                </td>
                <td class="px-6 py-4">
                    Laptop
                </td>
                <td class="px-6 py-4">
                    $2999
                </td>
                <td class="px-6 py-4">
                    $2999
                </td>
                <td class="px-6 py-4">
                    <jsp:include page="../pages/modals/editRaw.jsp"></jsp:include>
                    <button id="deleteModalButton" class="px-4 py-2 ml-5 text-white bg-red-500 rounded">
                        Delete
                    </button>
                </td>
            </tr>
            <tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-gray-800 border-b dark:border-gray-700">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    Microsoft Surface Pro
                </th>
                <td class="px-6 py-4">
                    White
                </td>
                <td class="px-6 py-4">
                    Laptop PC
                </td>
                <td class="px-6 py-4">
                    $1999
                </td>
                <td class="px-6 py-4">
                    $2999
                </td>
                <td class="px-6 py-4">
                    <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
                </td>
            </tr>
            <tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-gray-800 border-b dark:border-gray-700">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    Magic Mouse 2
                </th>
                <td class="px-6 py-4">
                    Black
                </td>
                <td class="px-6 py-4">
                    Accessories
                </td>
                <td class="px-6 py-4">
                    $99
                </td>
                <td class="px-6 py-4">
                    $2999
                </td>
                <td class="px-6 py-4">
                    <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
                </td>
            </tr>
            <tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-gray-800 border-b dark:border-gray-700">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    Google Pixel Phone
                </th>
                <td class="px-6 py-4">
                    Gray
                </td>
                <td class="px-6 py-4">
                    Phone
                </td>
                <td class="px-6 py-4">
                    $799
                </td>
                <td class="px-6 py-4">
                    $2999
                </td>
                <td class="px-6 py-4">
                    <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
                </td>
            </tr>
            <tr>
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    Apple Watch 5
                </th>
                <td class="px-6 py-4">
                    Red
                </td>
                <td class="px-6 py-4">
                    Wearables
                </td>
                <td class="px-6 py-4">
                    $999
                </td>
                <td class="px-6 py-4">
                    $2999
                </td>
                <td class="px-6 py-4">
                    <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
                </td>
            </tr>
        </tbody> 
    </table> --%>
</div>




<style>
th{
color:white;
}
td{
color:gray;
}
</style>
















<div id="divInventoryTable"></div>
<br>
<div id="divInventoryForm">
  <form>
    <table>
      <tr>
        <td><label for="txtDppId">Daily Planned Production ID</label></td>
        <td><input type="text" class="input" id="txtDppId" readonly="readonly" /></td>
      </tr>
      <tr>
        <td><label for="txtProductionDate">Production Date</label></td>
        <td><input type="date" class="input" id="txtProductionDate" maxlength="200" /></td>
      </tr>
      <tr>
        <td><label for="txtBranchId">Branch Id</label></td>
        <td><input type="text" class="input" id="txtBranchId" maxlength="200" /></td>
      </tr>
      <tr>
        <td><label for="txtSkuCd">SKU CODE</label></td>
        <td><input type="text" class="input" id="txtSkuCd" maxlength="200" /></td>
      </tr>
      <tr>
        <td><label for="txtQuantity">Quantity</label></td>
        <td><input type="number" class="input" id="txtQuantity" maxlength="12" /></td>
      </tr>
      <tr>
        <td><label for="txtStatus">Status</label></td>
        <td><input type="text" class="input" id="txtStatus" maxlength="12" /></td>
      </tr>
      
      
      
      <tr>
        <td></td>
        <td>
          <button type="button" class="button" id="btnClear">Clear</button>
          <button type="button" class="button blue" id="btnAdd">Add</button>
          <button type="button" class="button red" id="btnDelete">Delete</button>
        </td>
      </tr>
    </table>
  </form>
</div>
<br>
<script type="text/javascript">
	var dailyplannedproduction = JSON.parse('${dailyplannedproduction}');
</script>
<script src="js/daily_planned_production.js"></script>
