package com.cpi.is.dao;

import java.util.List;

import com.cpi.is.entity.ProductionMaterialEntity;

public interface ProductionMaterialDAO {
	
	List<ProductionMaterialEntity> getData() throws Exception;
	String saveData(ProductionMaterialEntity item) throws Exception;
	String deleteData(ProductionMaterialEntity item) throws Exception;

}
