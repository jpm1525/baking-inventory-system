
package com.cpi.is.dao;

import java.util.List;

import com.cpi.is.entity.FinishedProductListEntity;

public interface FinishedProductListDAO {
	
	List<FinishedProductListEntity> getData(Long branchId) throws Exception;
	Long getFinishedCount(Long branchId) throws Exception;

}