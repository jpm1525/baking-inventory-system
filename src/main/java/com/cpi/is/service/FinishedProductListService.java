package com.cpi.is.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.entity.FinishedProductListEntity;

public interface FinishedProductListService {
	
	List<FinishedProductListEntity> getData(Long branchId) throws Exception;
	Long getFinishedCount(Long branchId) throws Exception;
	
}