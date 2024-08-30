// Get modal elements
addModal = document.getElementById("addModal");
openAddModalButton = document.getElementById("openAddModalButton");
closeAddModalButton = document.getElementById("closeAddModalButton");
saveAddModalButton = document.getElementById("saveAddModalButton");

// Open Modal
openAddModalButton.addEventListener("click", () => {
  addModal.classList.remove("closing");
  addModal.showModal();
  addModal.classList.add("showing");
});

// Close Modal
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

// Save Modal Action
saveAddModalButton.addEventListener("click", () => {
  console.log("Save action executed");

  // Perform the save action here, such as form validation or sending data to a server

  closeAddModal();
});
