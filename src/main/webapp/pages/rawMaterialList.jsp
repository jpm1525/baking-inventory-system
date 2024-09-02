<h1 class="text-white text-center text-5xl font-bold m-10">Raw Material List</h1>

<div id="divInventoryTable"></div>
<br>
<div id="divInventoryForm">
  <form>
    <table>
      <tr>
        <td><label for="txtMaterialListId">ID</label></td>
        <td><input type="text" class="input" id="txtMaterialListId" readonly="readonly" /></td>
      </tr>
      <tr>
        <td><label for="txtMaterialCode">Material Code</label></td>
        <td><input type="text" class="input" id="txtMaterialCode" maxlength="200" /></td>
      </tr>
      <tr>
        <td><label for="txtQuantity">Quantity</label></td>
        <td><input type="number" class="input" id="txtQuantity" maxlength="12" /></td>
      </tr>
      <tr>
        <td><label for="txtUserId">User ID</label></td>
        <td><input type="text" class="input" id="txtUserId" maxlength="200" /></td>
      </tr>
      <tr>
        <td><label for="txtDateReceive">Date Receive</label></td>
        <td><input type="date" class="input" id="txtDateReceive" maxlength="200" /></td>
      </tr>
      <tr>
        <td><label for="txtBranchId">Branch Id</label></td>
        <td><input type="text" class="input" id="txtBranchId" maxlength="200" /></td>
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
	var rawmateriallist = JSON.parse('${rawmateriallist}');
</script>
<script src="js/raw_material_list.js"></script>


<style>

.input{
color:BLACK;
}

</style>
