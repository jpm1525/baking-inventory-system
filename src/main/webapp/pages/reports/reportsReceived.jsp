<link rel="stylesheet" href="css/tabulator_simple.min.css"
  type="text/css">
<link rel="stylesheet" href="css/tabulator_tailwind.css" type="text/css">
<script type="text/javascript" src="js/tabulator.min.js"></script>
<div class="flex place-content-center flex-col ">
  <div>
    
  <h1 class="text-[#68411b] dark:text-white text-center text-5xl font-bold m-10">Report Received</h1>
  </div>
	 <div class="d-flex justify-content-center">
	  <form>
	  <div class="relative overflow-x-auto shadow-md sm:rounded-lg basis-6/12">
	    <div id="divReportTable">
	      <div class="tabulator" role="grid"
	        tabulator-layout="fitData">
	        <div class="tabulator-header" role="rowgroup">
	          <div class="tabulator-header-contents" role="rowgroup">
	            <div class="tabulator-headers" role="row"
	              style="height: 45px;">
	              <div
	                class="tabulator-col tabulator-sortable tabulator-col-sorter-element"
	                role="columnheader" aria-sort="none"
	                tabulator-field="materialName"
	                style="min-width: 40px; width: 14%; height: 45px;">
	                <div class="tabulator-col-content">
	                  <div class="tabulator-col-title-holder">
	                    <div class="tabulator-col-title">Material</div>
	                    <div class="tabulator-col-sorter">
	                      <div class="tabulator-arrow"></div>
	                    </div>
	                  </div>
	                </div>
	              </div>
	              <span class="tabulator-col-resize-handle"
	                style="height: 45px;"></span>
	              <div
	                class="tabulator-col tabulator-sortable tabulator-col-sorter-element"
	                role="columnheader" aria-sort="none"
	                tabulator-field="quantity"
	                style="min-width: 40px; width: 14%; height: 45px;">
	                <div class="tabulator-col-content">
	                  <div class="tabulator-col-title-holder">
	                    <div class="tabulator-col-title">Quantity</div>
	                    <div class="tabulator-col-sorter">
	                      <div class="tabulator-arrow"></div>
	                    </div>
	                  </div>
	                </div>
	              </div>
	              <div
	                class="tabulator-col tabulator-sortable tabulator-col-sorter-element"
	                role="columnheader" aria-sort="none"
	                tabulator-field="dateReceived"
	                style="min-width: 40px; width: 14%; height: 45px;">
	                <div class="tabulator-col-content">
	                  <div class="tabulator-col-title-holder">
	                    <div class="tabulator-col-title">Date Received</div>
	                    <div class="tabulator-col-sorter">
	                      <div class="tabulator-arrow"></div>
	                    </div>
	                  </div>
	                </div>
	              </div>
	              <span class="tabulator-col-resize-handle" style="height: 45px;"></span>
	            </div>
	            <br>
	            <div class="tabulator-frozen-rows-holder"
	              style="min-width: 0px;"></div>
	          </div>
	        </div>
	        <div class="tabulator-tableholder" tabindex="0" style="height: 40px;">
	          <div class="tabulator-table" role="rowgroup" style="width: 100%;">
	            <div class="text-center dark:bg-gray-800">
	              <div role="status">
	                  <svg aria-hidden="true" class="inline w-8 h-8 text-gray-200 animate-spin dark:text-gray-600 
	                    fill-blue-600" viewBox="0 0 100 101" fill="none" xmlns="http://www.w3.org/2000/svg">
	                      <path d="M100 50.5908C100 78.2051 77.6142 100.591 50 100.591C22.3858 100.591 0 78.2051 
	                        0 50.5908C0 22.9766 22.3858 0.59082 50 0.59082C77.6142 0.59082 100 22.9766 100 
	                        50.5908ZM9.08144 50.5908C9.08144 73.1895 27.4013 91.5094 50 91.5094C72.5987 91.5094 
	                        90.9186 73.1895 90.9186 50.5908C90.9186 27.9921 72.5987 9.67226 50 9.67226C27.4013 
	                        9.67226 9.08144 27.9921 9.08144 50.5908Z" fill="currentColor"/>
	                      <path d="M93.9676 39.0409C96.393 38.4038 97.8624 35.9116 97.0079 33.5539C95.2932 28.8227 
	                        92.871 24.3692 89.8167 20.348C85.8452 15.1192 80.8826 10.7238 75.2124 7.41289C69.5422 
	                        4.10194 63.2754 1.94025 56.7698 1.05124C51.7666 0.367541 46.6976 0.446843 41.7345 
	                        1.27873C39.2613 1.69328 37.813 4.19778 38.4501 6.62326C39.0873 9.04874 41.5694 10.4717 
	                        44.0505 10.1071C47.8511 9.54855 51.7191 9.52689 55.5402 10.0491C60.8642 10.7766 65.9928
	                        12.5457 70.6331 15.2552C75.2735 17.9648 79.3347 21.5619 82.5849 25.841C84.9175 28.9121 
	                        86.7997 32.2913 88.1811 35.8758C89.083 38.2158 91.5421 39.6781 93.9676 39.0409Z" 
	                        fill="currentFill"/>
	                  </svg>
	                  <span class="sr-only">Loading...</span>
	              </div>
	            </div>
	          </div>
	        </div>
	        <div class="tabulator-footer">
	          <div class="tabulator-footer-contents">
	            <span class="tabulator-page-counter"><span><span>Showing</span><span>
	                  1-5 </span><span>of</span><span> 5 </span><span>rows</span></span></span><span
	              class="tabulator-paginator"><label>Page
	                Size</label><select class="tabulator-page-size"
	              aria-label="Page Size" title="Page Size"><option
	                  value="5">5</option>
	                <option value="10">10</option>
	                <option value="15">15</option>
	                <option value="20">20</option></select>
	            <button class="tabulator-page" type="button" role="button"
	                aria-label="First Page" title="First Page"
	                data-page="first" disabled="">First</button>
	              <button class="tabulator-page" type="button" role="button"
	                aria-label="Prev Page" title="Prev Page"
	                data-page="prev" disabled="">Prev</button>
	              <span class="tabulator-pages"><button
	                  class="tabulator-page active" type="button"
	                  role="button" aria-label="Show Page 1"
	                  title="Show Page 1" data-page="1">1</button></span>
	            <button class="tabulator-page" type="button" role="button"
	                aria-label="Next Page" title="Next Page"
	                data-page="next" disabled="">Next</button>
	              <button class="tabulator-page" type="button" role="button"
	                aria-label="Last Page" title="Last Page"
	                data-page="last" disabled="">Last</button></span>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	  <div class="grid gap-4 mb-4 sm:grid-cols-2 mt-5">
	    <label for="txtReportDate" class="block mb-2 text-m font-medium text-gray-900 dark:text-white">Report Date</label>
        <input type="date" name="txtReportDate" id="txtReportDate" class="bg-gray-50 border border-gray-300 
          text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 
          dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" 
          required="required" placeholder="Type destination" maxlength="50" minlength="1" value="${defaultDate}">
	  </div>
	  <div class="grid gap-4 mb-4 sm:grid-cols-2 mt-5">
	    <label class="col-sm-4 col-form-label"></label>
	    <div class="col-sm-8">
	      <button id="btnGenerateReport" type="button" class="text-white inline-flex items-center bg-blue-700 
	        hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium 
	        rounded px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 
	        dark:focus:ring-blue-800">
	        Generate
	      </button>
	      <button id="btnPrint" type="button" class="px-4 py-2 rounded ms-3 text-gray-900 
	        focus:outline-none bg-white border border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:z-10 
	        focus:ring-4 focus:ring-gray-100 dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 
	        dark:border-gray-600 dark:hover:text-white dark:hover:bg-gray-700">
	        Print
	      </button>
	    </div>
	  </div>
	  </form>
	</div>
	<div class="d-flex justify-content-center mt-3">
	  <div id="divReportTable"></div>
	</div>
</div>
	<script type="text/javascript">
	  var reportAction = "getReportReceived";
	  var objReportTable = {};
	  var reportName = "";
	  var reportData = {};
	  var reportCols = {};
	</script>
	<script src="js/reports.js"></script>