package com.cpi.is.dao;

import java.util.List;

import com.cpi.is.entity.DailyPlanEntity;

public interface DailyPlanDAO {
	
	List<DailyPlanEntity> getData() throws Exception;
	String saveData(DailyPlanEntity item) throws Exception;
	String deleteData(DailyPlanEntity item) throws Exception;

}
