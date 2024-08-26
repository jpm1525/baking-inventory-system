<link rel="stylesheet" href="css/style.css" type="text/css" />
<h1 class="text-white">Dashboard</h1>
<div class="relative inline-block">
  <button id="dropdownButton" class="btn m-1 bg-red-500 text-white px-5 py-2 rounded"><i class="fas fa-bars"></i></button>
  <ul id="dropdownMenu" class="menu dropdown-content bg-slate-100 rounded-box z-[1] w-52 p-2 shadow hidden">
    <li><a href="#">Item 1</a></li>
    <li><a href="#">Item 2</a></li>
  </ul>
</div>

    
    <div class="relative inline-block">
      <button id="dropdownButton" class="btn m-1 bg-red-500 text-white px-5 py-2 rounded">
        <i class="fas fa-bars"></i>
      </button>
      <ul id="dropdownMenu" class="menu dropdown-content absolute left-0 top-full bg-red-900 rounded-box z-[1] w-52 p-2 shadow hidden">
        <li><a href="#">Item 1</a></li>
        <li><a href="#">Item 2</a></li>
      </ul>
    </div>
<script>
  const button = document.getElementById('dropdownButton');
  const menu = document.getElementById('dropdownMenu');

  button.addEventListener('click', () => {
    menu.classList.toggle('hidden');
  });

  document.addEventListener('click', (event) => {
    if (!button.contains(event.target) && !menu.contains(event.target)) {
      menu.classList.add('hidden');
    }
  });
</script>
<script src="js/menu.js"></script>