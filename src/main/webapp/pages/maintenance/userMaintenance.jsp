<link rel="stylesheet" href="css/modal.css" type="text/css" />
<link rel="stylesheet" href="css/tabulator_simple.min.css"
  type="text/css">
<link rel="stylesheet" href="css/tabulator_tailwind.css" type="text/css">
<script type="text/javascript" src="js/tabulator.min.js"></script>
<script src="js/modal/modal.js"></script>

<div class="flex place-content-center flex-col ">
  <div>
    <h1
      class="text-[#68411b]  dark:text-white text-center text-5xl font-bold m-10"
      id="btnUserMain">User Maintenance</h1>
  </div>
  <div class="flex justify-end">
    <button id="openAddModalButton" class="px-4 py-2 m-2 text-white bg-indigo-500 rounded">
      <i class="fas fa-plus"></i>
    </button>
  </div>
  <div class="relative overflow-x-auto shadow-md sm:rounded-lg basis-6/12">
    <div id="divTableTabulator"> 
      <div class="tabulator" role="grid" tabulator-layout="fitColumns">
        <div class="tabulator-header" role="rowgroup">
          <div class="tabulator-header-contents" role="rowgroup">
            <div class="tabulator-headers" role="row"
              style="height: 45px; width: 100%;">
              <div
                class="tabulator-col tabulator-sortable tabulator-col-sorter-element"
                role="columnheader" aria-sort="none"
                tabulator-field="materialCd"
                style="min-width: 40px; width: 25%; height: 45px;">
                <div class="tabulator-col-content">
                  <div class="tabulator-col-title-holder">
                    <div class="tabulator-col-title">User ID</div>
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
                tabulator-field="materialCd"
                style="min-width: 40px; width: 25%; height: 45px;">
                <div class="tabulator-col-content">
                  <div class="tabulator-col-title-holder">
                    <div class="tabulator-col-title">User Name</div>
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
                tabulator-field="unitOfMeasurement"
                style="min-width: 40px; width: 25%; height: 45px;">
                <div class="tabulator-col-content">
                  <div class="tabulator-col-title-holder">
                    <div class="tabulator-col-title">Branch ID</div>
                    <div class="tabulator-col-sorter">
                      <div class="tabulator-arrow"></div>
                    </div>
                  </div>
                </div>
              </div>
              <span class="tabulator-col-resize-handle"
                style="height: 45px;"></span>
              <div class="tabulator-col" role="columnheader"
                aria-sort="none"
                style="min-width: 40px; width: 25%; height: 45px;">
                <div class="tabulator-col-content">
                  <div class="tabulator-col-title-holder">
                    <div class="tabulator-col-title">Action</div>
                  </div>
                </div>
              </div>
              <span class="tabulator-col-resize-handle"
                style="height: 45px;"></span>
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
                  0 </span><span>rows</span></span></span><span class="tabulator-paginator"><label>Page
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
                aria-label="Prev Page" title="Prev Page" data-page="prev"
                disabled="">Prev</button>
              <span class="tabulator-pages"><button
                  class="tabulator-page active" type="button"
                  role="button" aria-label="Show Page 1"
                  title="Show Page 1" data-page="1">1</button></span>
            <button class="tabulator-page" type="button" role="button"
                aria-label="Next Page" title="Next Page" data-page="next"
                disabled="">Next</button>
              <button class="tabulator-page" type="button" role="button"
                aria-label="Last Page" title="Last Page" data-page="last"
                disabled="">Last</button></span>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../modals/maintenance/userAddModal.jsp"></jsp:include>
<jsp:include page="../modals/maintenance/userEditModal.jsp"></jsp:include>
<jsp:include page="../modals/maintenance/deleteModal.jsp"></jsp:include>

<script type="text/javascript">
  var userMain = JSON.parse('${userMain}');
</script>
<script src="js/maintenance/user_maintenance.js"></script>

