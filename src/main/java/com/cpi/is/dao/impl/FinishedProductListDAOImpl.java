package com.cpi.is.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.FinishedProductListDAO;
import com.cpi.is.entity.FinishedProductListEntity;
import com.cpi.is.util.HBUtil;

public class FinishedProductListDAOImpl implements FinishedProductListDAO {
	
	@Override
	public List<FinishedProductListEntity> getData(Long branchId) throws Exception {
		List<FinishedProductListEntity> finishedProductList = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			finishedProductList = (List<FinishedProductListEntity>) 
					session.createQuery("From FinishedProductListEntity T WHERE T.branchId = :branchId ORDER BY T.fplId DESC", FinishedProductListEntity.class)
					.setParameter("branchId", branchId)
					.list();
		}
		return finishedProductList;
	}
	
	public Long getFinishedCount(Long branchId) throws Exception {
	    Long count = null;
	    try (Session session = HBUtil.getSessionFactory().openSession()) {
	        count = (Long) session.createQuery("SELECT COUNT(*) FROM FinishedProductListEntity T WHERE T.branchId = :branchId",Long.class)
	                              .setParameter("branchId", branchId)
	                              .uniqueResult();
	    }
	    return count;
	}
}
