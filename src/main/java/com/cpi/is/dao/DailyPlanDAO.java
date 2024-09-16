package com.cpi.is.dao;

import java.util.List;

import com.cpi.is.entity.DailyPlanEntity;

public interface DailyPlanDAO {
	
	List<DailyPlanEntity> getData(Long branchId) throws Exception;
	String saveData(DailyPlanEntity item) throws Exception;
	String deleteData(DailyPlanEntity item) throws Exception;
	Long getDailyCount(Long branchId) throws Exception;

}
