// Select all edit buttons in the table
const editButtons = document.querySelectorAll("button[id^='editModalButton']");

// Iterate over each edit button and add the event listener
editButtons.forEach((button) => {
    button.addEventListener("click", () => {
        const editModal = document.getElementById("editModal");

        // Show the modal when the edit button is clicked
        editModal.classList.remove("closing");
        editModal.showModal();
        editModal.classList.add("showing");
    });
});

// Close the modal when clicking the close buttons
const closeModalTopButton = document.getElementById("closeModalTopButton");
const addMaterialButton = document.getElementById("addMaterialButton");

closeModalTopButton.addEventListener("click", closeModal);
addMaterialButton.addEventListener("click", closeModal);

function closeModal() {
    const editModal = document.getElementById("editModal");

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
