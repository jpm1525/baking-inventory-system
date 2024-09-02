<link rel="stylesheet" href="css/modal.css" type="text/css" />
<script src="js/modal/raw_modal.js"></script>

<button id="deleteModalButton" class="px-4 py-2 ml-2 text-white bg-red-500 rounded">
  Delete
</button>

<dialog id="deleteModal" class="relative p-6 bg-[#161624] rounded-lg shadow-lg max-w-3xl">

  <button id="closeDeleteModalButton" class="close-button">
    <i class="fa-solid fa-x text-white text-xl mr-1.5"></i>
  </button>
  
  <div class="grid gap-4 mb-4 sm:grid-cols-1 mt-5">
    <div>
      <label for="materialCode" class="block mb-2 text-3xl text-white">Delete Data?</label>
    </div>
  </div>
 
  
  <div class="flex justify-end space-x-2">
    <button id="deleteSaveModalButton" class="px-4 py-2 text-white bg-red-500 rounded">
      Confirm Delete
    </button>
  </div>
</dialog>
