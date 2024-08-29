<h1 class="text-white">Dispatching</h1>
<div id="divDispatchingTable"></div>
<br>
<div id="divDispatchingForm">
	<form>
		<table>
			<tr>
				<td><label for="txtDispatchId">Dispatch Track ID</label></td>
				<td><input type="text" class="input" id="txtDispatchId"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td><label for="txtDispatchType">Dispatch Type Code</label></td>
				<td><input type="text" class="input" id="txtDispatchType"
					maxlength="200" /></td>
			</tr>
			<tr>
				<td><label for="txtFinishedProdId">Finished Product ID</label></td>
				<td><input type="text" class="input" id="txtFinishedProdId"
					maxlength="200" /></td>
			</tr>
			<tr>
				<td><label for="txtQuantity">Quantity</label></td>
				<td><input type="number" class="input" id="txtQuantity"
					maxlength="12" /></td>
			</tr>
			<tr>
				<td><label for="txtBranchId">Branch ID</label></td>
				<td><input type="number" class="input" id="txtBranchId"
					maxlength="12" /></td>
			</tr>
			<tr>
				<td><label for="txtDestination">Destination</label></td>
				<td><input type="text" class="input" id="txtDestination"
					maxlength="200" /></td>
			</tr>
			<tr>
				<td><label for="txtDispatchDate">Dispatch Date</label></td>
				<td><input type="date" class="block" id="txtDispatchDate"
					maxlength="200" /></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="button" class="button" style="color: white;" id="btnClear">Clear</button>
					<button type="button" class="button blue" style="color: white;" id="btnAdd">Add</button>
					<button type="button" class="button red" style="color: white;" id="btnDelete">Delete</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<br>
<script type="text/javascript">
	var dispatching = JSON.parse('${dispatching}');
</script>
<script src="js/dispatching.js"></script>