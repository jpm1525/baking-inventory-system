package com.cpi.is.dao;

import java.util.List;

import com.cpi.is.entity.DispatchingEntity;

public interface DispatchingDAO {
	
	List<DispatchingEntity> getData() throws Exception;
	String saveData(DispatchingEntity data) throws Exception;
	String deleteData(DispatchingEntity data) throws Exception;

}
