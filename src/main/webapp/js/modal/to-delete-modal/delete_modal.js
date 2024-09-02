// Get modal elements
const editModal1 = document.getElementById("editModal");
const editModalButton1 = document.getElementById("editModalButton");
const closeEditModalButton1 = document.getElementById("closeEditModalButton");
const saveEditModalButton1 = document.getElementById("saveEditModalButton");

// Open Edit Modal
editModalButton1.addEventListener("click", () => {
  editModal1.classList.remove("closing");
  editModal1.showModal();
  editModal1.classList.add("showing");
});

// Close Edit Modal
function closeEditModal() {
  editModal1.classList.remove("showing");
  editModal1.classList.add("closing");
  editModal1.addEventListener(
    "animationend",
    () => {
      editModal1.close();
      editModal1.classList.remove("closing");
    },
    { once: true }
  );
}

closeEditModalButton1.addEventListener("click", closeEditModal);

// Save Edit Modal
saveEditModalButton1.addEventListener("click", () => {
  console.log("Save action executed");

  // Perform the save action here, such as form validation or sending data to a server

  closeEditModal();
});
