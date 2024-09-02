// Get modal elements for Edit Modal
editModal = document.getElementById("editModal");
editModalButton = document.getElementById("editModalButton");
closeEditModalButton = document.getElementById("closeEditModalButton");
saveEditModalButton = document.getElementById("saveEditModalButton");

// Get modal elements for Delete Modal
deleteModal = document.getElementById("deleteModal");
deleteModalButton = document.getElementById("deleteModalButton");
closeDeleteModalButton = document.getElementById("closeDeleteModalButton");
deleteSaveModalButton = document.getElementById("deleteSaveModalButton");

// Get modal elements for Add Modal
addModal = document.getElementById("addModal");
openAddModalButton = document.getElementById("openAddModalButton");
closeAddModalButton = document.getElementById("closeAddModalButton");
saveAddModalButton = document.getElementById("saveAddModalButton");

// Open Edit Modal
editModalButton.addEventListener("click", () => {
  editModal.classList.remove("closing");
  editModal.showModal();
  editModal.classList.add("showing");
});

// Close Edit Modal
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
}

closeEditModalButton.addEventListener("click", closeEditModal);

// Save Edit Modal Action
saveEditModalButton.addEventListener("click", () => {
  console.log("Save action executed");

  // Perform the save action here, such as form validation or sending data to a server

  closeEditModal();
});

// Open Delete Modal
deleteModalButton.addEventListener("click", () => {
  deleteModal.classList.remove("closing");
  deleteModal.showModal();
  deleteModal.classList.add("showing");
});

// Close Delete Modal
function closeDeleteModal() {
  deleteModal.classList.remove("showing");
  deleteModal.classList.add("closing");
  deleteModal.addEventListener(
    "animationend",
    () => {
      deleteModal.close();
      deleteModal.classList.remove("closing");
    },
    { once: true }
  );
}

closeDeleteModalButton.addEventListener("click", closeDeleteModal);

// Save Delete Modal Action
deleteSaveModalButton.addEventListener("click", () => {
  console.log("Delete action executed");

  // Perform the delete action here, such as confirming deletion or sending data to a server

  closeDeleteModal();
});

// Open Add Modal
openAddModalButton.addEventListener("click", () => {
  addModal.classList.remove("closing");
  addModal.showModal();
  addModal.classList.add("showing");
});

// Close Add Modal
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
}

closeAddModalButton.addEventListener("click", closeAddModal);

// Save Add Modal Action
saveAddModalButton.addEventListener("click", () => {
  console.log("Save action executed");

  // Perform the save action here, such as form validation or sending data to a server

  closeAddModal();
});
