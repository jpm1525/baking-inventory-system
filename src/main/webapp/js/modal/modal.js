$(document).ready(function() {

	editModal = document.getElementById("editModal");
	closeEditModalButton = document.getElementById("closeEditModalButton");
	cancelEditModalButton = document.getElementById("cancelEditModalButton");

	deleteModal = document.getElementById("deleteModal");
	closeDeleteModalButton = document.getElementById("closeDeleteModalButton");
	cancelDeleteModalButton = document.getElementById("cancelDeleteModalButton");

	addModal = document.getElementById("addModal");
	openAddModalButton = document.getElementById("openAddModalButton");
	closeAddModalButton = document.getElementById("closeAddModalButton");
	cancelAddModalButton = document.getElementById("cancelAddModalButton");

	$(".editModalButton").on('click', function(event) {
		event.stopPropagation();
		event.stopImmediatePropagation();
		editModal.classList.remove("closing");
		editModal.showModal();
		editModal.classList.add("showing");
	});

	closeEditModalButton.addEventListener("click", closeEditModal);
	cancelEditModalButton.addEventListener("click", closeEditModal);
	closeDeleteModalButton.addEventListener("click", closeDeleteModal);
	cancelDeleteModalButton.addEventListener("click", closeDeleteModal);

	openAddModalButton.addEventListener("click", () => {
		addModal.classList.remove("closing");
		addModal.showModal();
		addModal.classList.add("showing");
	});

	closeAddModalButton.addEventListener("click", closeAddModal);
	cancelAddModalButton.addEventListener("click", closeAddModal);


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
