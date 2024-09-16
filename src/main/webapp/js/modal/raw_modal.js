editModal = document.getElementById("editModal");
editModalButton = document.getElementById("editModalButton");
closeEditModalButton = document.getElementById("closeEditModalButton");
saveEditModalButton = document.getElementById("saveEditModalButton");

deleteModal = document.getElementById("deleteModal");
deleteModalButton = document.getElementById("deleteModalButton");
closeDeleteModalButton = document.getElementById("closeDeleteModalButton");
deleteSaveModalButton = document.getElementById("deleteSaveModalButton");

addModal = document.getElementById("addModal");
openAddModalButton = document.getElementById("openAddModalButton");
closeAddModalButton = document.getElementById("closeAddModalButton");
saveAddModalButton = document.getElementById("saveAddModalButton");

editModalButton.addEventListener("click", () => {
  editModal.classList.remove("closing");
  editModal.showModal();
  editModal.classList.add("showing");
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
}

closeEditModalButton.addEventListener("click", closeEditModal);

saveEditModalButton.addEventListener("click", () => {
  console.log("Save action executed");

  closeEditModal();
});

deleteModalButton.addEventListener("click", () => {
  deleteModal.classList.remove("closing");
  deleteModal.showModal();
  deleteModal.classList.add("showing");
});

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

deleteSaveModalButton.addEventListener("click", () => {
  console.log("Delete action executed");

  closeDeleteModal();
});

openAddModalButton.addEventListener("click", () => {
  addModal.classList.remove("closing");
  addModal.showModal();
  addModal.classList.add("showing");
});

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

saveAddModalButton.addEventListener("click", () => {
  console.log("Save action executed");

  closeAddModal();
});