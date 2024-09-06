package com.cpi.is.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.entity.ProductionMaterialEntity;

public interface ProductionMaterialService {
	
	List<ProductionMaterialEntity> getData(String dppIdInput) throws Exception;
	String saveData(HttpServletRequest request) throws Exception;
	String deleteData(HttpServletRequest request) throws Exception;
	String validateData(HttpServletRequest request) throws Exception;
	Boolean validateDppId(HttpServletRequest request) throws Exception;
	
}
