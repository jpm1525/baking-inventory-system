package com.cpi.is.dao;

import java.util.List;

import com.cpi.is.entity.RawMaterialListEntity;

public interface RawMaterialListDAO {
	
	List<RawMaterialListEntity> getData() throws Exception;
	String saveData(RawMaterialListEntity item) throws Exception;
	String deleteData(RawMaterialListEntity item) throws Exception;

}
