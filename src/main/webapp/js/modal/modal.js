$( document ).ready(function() {
	
	editModal = document.getElementById("editModal");
	//editModalButton = document.getElementsByClass("editModalButton");
	closeEditModalButton = document.getElementById("closeEditModalButton");
	cancelEditModalButton = document.getElementById("cancelEditModalButton");
	//saveEditModalButton = document.getElementById("saveEditModalButton");

	deleteModal = document.getElementById("deleteModal");
	//deleteModalButton = document.getElementById("deleteModalButton");
	closeDeleteModalButton = document.getElementById("closeDeleteModalButton");
	cancelDeleteModalButton = document.getElementById("cancelDeleteModalButton");
	//deleteSaveModalButton = document.getElementById("deleteSaveModalButton");

	addModal = document.getElementById("addModal");
	openAddModalButton = document.getElementById("openAddModalButton");
	closeAddModalButton = document.getElementById("closeAddModalButton");
	cancelAddModalButton = document.getElementById("cancelAddModalButton");
	//saveAddModalButton = document.getElementById("saveAddModalButton");

	$(".editModalButton").on('click', function(event){
	    event.stopPropagation();
	    event.stopImmediatePropagation();
		editModal.classList.remove("closing");
		editModal.showModal();
		editModal.classList.add("showing");
	});

	closeEditModalButton.addEventListener("click", closeEditModal);
	cancelEditModalButton.addEventListener("click", closeEditModal);
/*
	saveEditModalButton.addEventListener("click", () => {
	  console.log("Save action executed");
	  closeEditModal();
	});*/

	/*deleteModalButton.addEventListener("click", () => {
		deleteModal.classList.remove("closing");
		deleteModal.showModal();
		deleteModal.classList.add("showing");
	});*/

	closeDeleteModalButton.addEventListener("click", closeDeleteModal);
	cancelDeleteModalButton.addEventListener("click", closeDeleteModal);

/*	deleteSaveModalButton.addEventListener("click", () => {
	  console.log("Delete action executed");
	  closeDeleteModal();
	});*/

	openAddModalButton.addEventListener("click", () => {
	  addModal.classList.remove("closing");
	  addModal.showModal();
	  addModal.classList.add("showing");
	});

	closeAddModalButton.addEventListener("click", closeAddModal);
	cancelAddModalButton.addEventListener("click", closeAddModal);

/*	saveAddModalButton.addEventListener("click", () => {
	  console.log("Save action executed");
	  closeAddModal();
	});*/
});

function closeEditModal() {
	editModal.classList.remove("showing");
	editModal.classList.add("closing");
	editModal.addEventListener(
    	"animationend",
    	() => {
	        editModal.close();
	        editModal.classList.remove("closing");
    	},
    	{ once: true }
	);
	$('.errorMessage').empty();
}

function closeAddModal() {
  addModal.classList.remove("showing");
  addModal.classList.add("closing");
  addModal.addEventListener(
    "animationend",
    () => {
      addModal.close();
      addModal.classList.remove("closing");
    },
    { once: true }
  );
  $('.errorMessage').empty();
}

function closeDeleteModal() {
  deleteModal.classList.remove("showing");
  deleteModal.classList.add("closing");
  $('#deleteSaveModalButton').off('click');
  deleteModal.addEventListener(
    "animationend",
    () => {
      deleteModal.close();
      deleteModal.classList.remove("closing");
    },
    { once: true }
  );
  $('.errorMessage').empty();
}
