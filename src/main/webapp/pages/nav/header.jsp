<header>
  <div
    class="flex topbar bg-white dark:bg-[#1f2937] text-[#68411b] dark:text-white">
    <button
      class="fa fa-bars text-[#68411b] hover:text-white dark:text-white text-3xl hover:bg-[#fd5d18] py-2 px-3 rounded mx-2 mr-5 transform transition-transform hover:scale-105"
      id="sidebarToggle"></button>
    <div class="topbar-left">
      <img src="images/banners/log_img.png" ondragstart="return false;"
        class="w-24 h-[86px] transition  transform transition-transform hover:scale-110"
        id="btnMainMenu">
    </div>

    <div class="topbar-right gap-5">
      <div
        class="rounded-lg flex bg-gray-200 shadow-inner dark:bg-[#34455d] dark:text-white p-2 gap-2 divide-x shadow-inner">
        <div class="flex">
          <p class="font-bold mr-1">USER ID:</p>
          <p>${userId}</p>
        </div>

        <div class="flex">
          <p class="font-bold mr-1 ml-2">NAME:</p>
          <p>${username}</p>
        </div>

        <div class="flex">
          <p class="font-bold mr-1 ml-2">BRANCH ID:</p>
          <p>${branchId}</p>
        </div>

        <div class="flex">
          <p class="font-bold mr-1 ml-2">BRANCH NAME:</p>
          <p>${branchName}</p>
        </div>

      </div>
      <button id="btnLogout" class="hover:text-white dark:text-white">Logout</button>
    </div>
  </div>
</header>
<link rel="stylesheet" href="css/style.css" type="text/css" />
