<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 class="text-[#68411b] dark:text-white text-center text-5xl font-bold m-10">Dashboard</h1>
<hr class="h-px my-6 bg-gray-200 border-0 dark:bg-gray-700">
<div class="dashContent w-full h-full">
  <div class="flex flex-wrap gap-5 justify-center p-2">
  
    <div class="dashInfo bg-[#965c5b]">
    <img class="w-[200px] h-[170px] ml-[-22px] mt-[-4px]" src="images/info-icons/raw_icon.png" ondragstart="return false;">
    <p class="text-white font-bold font-bold text-6xl mt-10">${materialCount}</p>
    <p class="text-white font-bold text-xs mt-24">total count</p>
    <p class="text-white font-bold text-lg">Raw Materials</p>
    </div>
    
    <div class="dashInfo bg-[#b0b980]">
    <img class="w-[160px] h-[150px] mt-[5px]" src="images/info-icons/pro_icon.png" ondragstart="return false;">
    <p class="text-white font-bold text-6xl mt-10">${dailyCount}</p>
    <p class="text-white font-bold text-xs mt-24">total count</p>
    <p class="text-white font-bold text-lg">Production</p>
    </div>
    
    <div class="dashInfo bg-[#7db7ce]">
    <img class="w-[150px] h-[140px] ml-[3px] mt-[8px]" src="images/dash-icons/list_icon.png" ondragstart="return false;">
    <p class="text-white font-bold text-6xl mt-10">${finishedCount}</p>
    <p class="text-white font-bold text-xs mt-24">total count</p>
    <p class="text-white font-bold text-lg">Finished Products</p>
    </div>
    
    <div class="dashInfo bg-[#e4ac4f]">
    <img class="w-[170px] h-[160px] ml-[-5px]" src="images/dash-icons/truck_icon.png" ondragstart="return false;">
    <p class="text-white font-bold text-6xl mt-10">${dispatchCount}</p>
    <p class="text-white font-bold text-xs mt-24">total count</p>
    <p class="text-white font-bold text-lg">Dispatch Records</p>
    </div>
    
  </div>

</div>