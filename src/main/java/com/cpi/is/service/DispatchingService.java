package com.cpi.is.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.entity.DispatchingEntity;

public interface DispatchingService {
	
	List<DispatchingEntity> getData(Long branchId) throws Exception;
	List<Object[]> getCurrentInventory(Long branchId) throws Exception;
	String saveData(HttpServletRequest request) throws Exception;
	String deleteData(HttpServletRequest request) throws Exception;
	String validateData(HttpServletRequest request) throws Exception;

}
