package com.cpi.is.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.entity.DailyPlanEntity;

public interface DailyPlanService {
	
	List<DailyPlanEntity> getData(Long branchId) throws Exception;
	String saveData(HttpServletRequest request) throws Exception;
	String deleteData(HttpServletRequest request) throws Exception;
	Long getDailyCount(Long branchId) throws Exception;
}
