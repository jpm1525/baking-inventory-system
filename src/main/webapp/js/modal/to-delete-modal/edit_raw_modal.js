// Get modal elements
editModal = document.getElementById("editModal");
editModalButton = document.getElementById("editModalButton");
closeEditModalButton = document.getElementById("closeEditModalButton");
saveEditModalButton = document.getElementById("saveEditModalButton");

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

// Save Edit Modal
saveEditModalButton.addEventListener("click", () => {
  console.log("Save action executed");

  // Perform the save action here, such as form validation or sending data to a server

  closeEditModal();
});
