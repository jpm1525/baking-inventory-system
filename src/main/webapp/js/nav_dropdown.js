dropdowns = [
  {
    button: document.getElementById('dropdownButtonReport'),
    menu: document.getElementById('dropdownMenuReport'),
    icon: document.getElementById('dropdownIconReport'),
  },
  {
    button: document.getElementById('dropdownButtonMaintenance'),
    menu: document.getElementById('dropdownMenuMaintenance'),
    icon: document.getElementById('dropdownIconMaintenance'),
  }
];

dropdowns.forEach(({ button, menu, icon }, index, allDropdowns) => {
  button.addEventListener('click', () => {
    const isOpen = !menu.classList.contains('hidden');
    allDropdowns.forEach(({ menu: otherMenu, icon: otherIcon }) => {
      otherMenu.classList.add('hidden');
      otherIcon.classList.remove('fa-angle-left');
      otherIcon.classList.add('fa-angle-down');
    });
    if (!isOpen) {
      menu.classList.toggle('hidden');
      icon.classList.toggle('fa-angle-down');
      icon.classList.toggle('fa-angle-left');
    }
  });
});


document.addEventListener('click', (event) => {
  dropdowns.forEach(({ button, menu, icon }) => {
    if (!button.contains(event.target) && !menu.contains(event.target)) {
      menu.classList.add('hidden');
      icon.classList.remove('fa-angle-left');
      icon.classList.add('fa-angle-down');
    }
  });
});

document.getElementById("sidebarToggle").addEventListener("click", function() {
    const sidebar = document.querySelector(".sidebar");
    const divContent = document.getElementById("divContent");

    // Toggle sidebar visibility
    sidebar.classList.toggle("sidebar-hidden");

    // Adjust divContent width based on sidebar visibility
    if (sidebar.classList.contains("sidebar-hidden")) {
        divContent.classList.add("sidebar-adjusted");
    } else {
        divContent.classList.remove("sidebar-adjusted");
    }
});

