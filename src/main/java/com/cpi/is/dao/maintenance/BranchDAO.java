package com.cpi.is.dao.maintenance;

import java.util.List;

import com.cpi.is.entity.maintenance.BranchEntity;

public interface BranchDAO {
	
	List<BranchEntity> getData() throws Exception;
	String saveData(BranchEntity data) throws Exception;
	String deleteData(BranchEntity data) throws Exception;
	
}
