<h1
  class="text-[#68411b] dark:text-white text-center text-5xl font-bold m-10">Dashboard</h1>

<div class="dashContent p-5 mt-10 w-full">
  <div
    class="dashTitle flex dark:text-white justify-center text-3xl m-5">User
    Info</div>
  <div class="grid">
    <div class="row-start-2 flex justify-center">
      <div class="bg-[#f9e4ad] dark:bg-[#34455d] flex p-8 rounded-lg">
        <img src="images/dash-pfp.jpg"
          class="w-[140px] h-[140px] mr-5 rounded-lg "
          ondragstart="return false;">
        <div class="row-start-2">

          <div class="flex">
            <label class="dark:text-white mr-3">User ID:</label>
            <p>${userId}</p>
          </div>

          <div class="flex pt-2">
            <label class="dark:text-white mr-3">Name:</label>
            <p>${username}</p>
          </div>

          <div class="flex pt-2">
            <label class="dark:text-white mr-3">Branch ID:</label>
            <p>${branchId}</p>
          </div>

          <div class="flex pt-2">
            <label class="dark:text-white mr-3">Branch Name:</label>
            <p>${branchName}</p>
          </div>

        </div>
      </div>
    </div>
  </div>
</div>