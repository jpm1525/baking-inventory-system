package com.cpi.is.dao.maintenance;

import java.util.List;

import com.cpi.is.entity.UserEntity;

public interface UserMaintenanceDAO {
	
	List<UserEntity> getData() throws Exception;
	String saveData(UserEntity data) throws Exception;
	String deleteData(UserEntity data) throws Exception;

}
