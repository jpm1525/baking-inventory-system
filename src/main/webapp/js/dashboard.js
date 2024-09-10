function getBranchName(){
	$.each(branch, function(index, data) {
		if(data.branchId == branchIdUser){
			$('#dashboardBranch').html(data.branchName);
			console.log(data.branchName);
		}
	});
}

getBranchName();