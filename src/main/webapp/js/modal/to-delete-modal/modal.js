// Get modal elements
addModal = document.getElementById("modal");
openModalButton = document.getElementById("openModalButton");
closeAddModalButton = document.getElementById("closeModalButtonTop");
addModalButton = document.getElementById("addModalButton");

// Open Modal
openModalButton.addEventListener("click", () => {
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

// Add Modal Action
addModalButton.addEventListener("click", () => {
  console.log("Add action executed");

  // Perform the add action here, such as form validation or sending data to a server

  closeAddModal();
});
