package com.cpi.is.dao.maintenance;

import java.util.List;

import com.cpi.is.entity.maintenance.MaterialCodeEntity;

public interface MaterialCodeDAO {
	
	List<MaterialCodeEntity> getData() throws Exception;
	String saveData(MaterialCodeEntity data) throws Exception;
	String deleteData(MaterialCodeEntity data) throws Exception;
	
}
