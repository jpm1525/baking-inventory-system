<h1 class="text-black text-[#68411b] dark:text-white text-center text-5xl font-bold m-10">Dashboard</h1>

<div class="dashContent p-5 mt-10 w-[600px]">
    <div class="dashTitle flex dark:text-white justify-center mb-5 text-3xl">User Info</div>
    <div class="grid">
      <div class="row-start-2">
      <img src="images/dash-pfp.jpg" class="w-[155px] h-[155px" ondragstart="return false;">
      </div>
      
      <div class="row-start-2 mr-20">
        <div class="flex">
            <label class="dark:text-white mr-3">User ID:</label>
            <p>${userId}</p>
        </div>
        
        <div class="flex">
            <label class="dark:text-white mr-3">Name:</label>
            <p>${username}</p>
        </div>
        
        <div class="flex">
            <label class="dark:text-white mr-3">Branch ID:</label>
            <p>${branchId}</p>
        </div>
        
        <div class="flex">
            <label class="dark:text-white mr-3">Branch Name:</label>
            <p>${branch.branchName}</p>
        </div>
        
      </div>
    </div>

</div>
