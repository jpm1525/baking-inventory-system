<link rel="stylesheet" href="css/modal.css" type="text/css" />

<dialog id="deleteModal" class="relative p-6 bg-white dark:bg-gray-700 rounded-lg shadow-lg max-w-xl">

  <button type="button" id="closeDeleteModalButton"
    class="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 
      hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center 
      items-center dark:hover:bg-gray-600 dark:hover:text-white">
    <svg class="w-3 h-3" aria-hidden="true"
      xmlns="http://www.w3.org/2000/svg" fill="none"
      viewBox="0 0 14 14">
      <path stroke="currentColor" stroke-linecap="round"
          stroke-linejoin="round" stroke-width="2"
          d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
    </svg>
    <span class="sr-only">Delete modal</span>
  </button>
  
  <div class="p-4 md:p-5 text-center">
    <svg
      class="mx-auto mb-4 text-gray-400 w-12 h-12 dark:text-gray-200"
      aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
      fill="none" viewBox="0 0 20 20">
      <path stroke="currentColor" stroke-linecap="round"
        stroke-linejoin="round" stroke-width="2"
        d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
    </svg>
    <h3 class="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">
      Are you sure you want to delete this data?
    </h3>
    
    <p class="text-red-500 errorMessage"></p>
    
    <button id="deleteSaveModalButton" class="text-white bg-red-600 hover:bg-red-800 focus:ring-4 
      focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 
      inline-flex items-center text-cente px-4 py-2 rounded">
      Delete
    </button>
    <button id="cancelDeleteModalButton" class="px-4 py-2 rounded ms-3 text-gray-900 
      focus:outline-none bg-white border border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:z-10 
      focus:ring-4 focus:ring-gray-100 dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 
      dark:border-gray-600 dark:hover:text-white dark:hover:bg-gray-700">
      Cancel
    </button>
  </div>
  
  <div class="flex justify-middle space-x-2">

  </div>
  
</dialog>


