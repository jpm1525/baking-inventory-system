package com.cpi.is.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.entity.DispatchingEntity;
import com.cpi.is.entity.FinishedProductListEntity;

public interface DispatchingService {
	
	List<DispatchingEntity> getData(Long branchId) throws Exception;
	String saveData(HttpServletRequest request, List<FinishedProductListEntity> finishedProductList) throws Exception;
	String deleteData(HttpServletRequest request) throws Exception;
	String validateData(HttpServletRequest request) throws Exception;
	String validateQuantity(HttpServletRequest request, List<FinishedProductListEntity> finishedProductList) throws Exception;
	Long getDispatchCount(Long branchId) throws Exception;

}
