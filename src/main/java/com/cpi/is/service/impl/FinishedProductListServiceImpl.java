package com.cpi.is.service.impl;

import java.util.List;

import com.cpi.is.dao.impl.FinishedProductListDAOImpl;
import com.cpi.is.entity.FinishedProductListEntity;
import com.cpi.is.service.FinishedProductListService;

public class FinishedProductListServiceImpl implements FinishedProductListService {

	private FinishedProductListDAOImpl finishedProductListDAO;

	public FinishedProductListDAOImpl getFinishedProductListDAO() {
		return finishedProductListDAO;
	}

	public void setFinishedProductListDAO(FinishedProductListDAOImpl finishedProductListDAO) {
		this.finishedProductListDAO = finishedProductListDAO;
	}
	
	@Override
	public List<FinishedProductListEntity> getData(Long branchId) throws Exception {
		List<FinishedProductListEntity> finishedProductLists = finishedProductListDAO.getData(branchId);
		return finishedProductLists;
	}

	public Long getFinishedCount(Long branchId) throws Exception {
	    return finishedProductListDAO.getFinishedCount(branchId);
	}
}
