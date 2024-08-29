package com.cpi.is.dao.maintenance;

import java.util.List;

import com.cpi.is.entity.maintenance.SkuCodeEntity;

public interface SkuCodeDAO {
	
	List<SkuCodeEntity> getData() throws Exception;
	String saveData(SkuCodeEntity data) throws Exception;
	String deleteData(SkuCodeEntity data) throws Exception;
	
}
