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

	@Override
	public String saveData(FinishedProductListEntity item) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (0 == item.getFplId()) {
				item.setFplId(null);
				session.persist(item);	// add a new record
			} else {
				session.merge(item);	// update an existing record
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			throw e;
		}
		return "success";
	}

	@Override
	public String deleteData(FinishedProductListEntity item) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.remove(item);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
		return "success";
	}
	
	public Long getFinishedCount(Long branchId) throws Exception {
	    Long count = null;
	    try (Session session = HBUtil.getSessionFactory().openSession()) {
	        count = (Long) session.createQuery("SELECT COUNT(*) FROM FinishedProductListEntity T WHERE T.branchId = :branchId")
	                              .setParameter("branchId", branchId)
	                              .uniqueResult();
	    }
	    return count;
	}
}
