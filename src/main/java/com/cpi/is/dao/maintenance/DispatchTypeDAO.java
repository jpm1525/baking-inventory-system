package com.cpi.is.dao.maintenance;

import java.util.List;

import com.cpi.is.entity.maintenance.DispatchTypeEntity;

public interface DispatchTypeDAO {
	
	List<DispatchTypeEntity> getData() throws Exception;
	String saveData(DispatchTypeEntity data) throws Exception;
	String deleteData(DispatchTypeEntity data) throws Exception;
	
}
