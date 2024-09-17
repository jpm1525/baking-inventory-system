package com.cpi.is.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.entity.DailyPlanEntity;
import com.cpi.is.entity.ProductionMaterialEntity;
import com.cpi.is.entity.RawMaterialListEntity;

public interface ProductionMaterialService {
	
	List<ProductionMaterialEntity> getData(String dppIdInput) throws Exception;
	String saveData(HttpServletRequest request, List<RawMaterialListEntity> rawMaterialList, List<DailyPlanEntity> dailyPlans) throws Exception;
	String deleteData(HttpServletRequest request) throws Exception;
	
}
