package com.cpi.is.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.DispatchingDAO;
import com.cpi.is.entity.DispatchingEntity;
import com.cpi.is.util.HBUtil;

public class DispatchingDAOImpl implements DispatchingDAO {

//	@Override
//	public List<DispatchingEntity> getData() throws Exception {
//		List<DispatchingEntity> dispatching = null;
//		try (Session session = HBUtil.getSessionFactory().openSession()) {
//			dispatching = (List<DispatchingEntity>) 
//					session.createQuery("From DispatchingEntity T ORDER BY T.dispatchTrackId ASC", DispatchingEntity.class).list();
//		}
//		return dispatching;
//	}
	
	@Override
    public List<DispatchingEntity> getData(Long branchId) throws Exception {
        List<DispatchingEntity> dispatching = null;
        try (Session session = HBUtil.getSessionFactory().openSession()) {
            dispatching = session.createQuery("SELECT T FROM DispatchingEntity T JOIN T.branch J WHERE T.branchId = :branchId AND J.branchId = T.branchId ORDER BY T.dispatchTrackId ASC", DispatchingEntity.class)
                                 .setParameter("branchId", branchId)
                                 .list();
        }
        return dispatching;
    }
	
	@Override
	public List<Object[]> getCurrentInventory(Long branchId) throws Exception {
	    List<Object[]> result = null;
	    try (Session session = HBUtil.getSessionFactory().openSession()) {
	        result = session.createQuery(
	            "SELECT fpl.skuCD, " +
	            "(COALESCE(MAX(fpl.quantity), 0) - COALESCE(SUM(dispatch.quantity), 0)), " +
	            "sku.skuCodeName " +
	            "FROM FinishedProductListEntity fpl " +
	            "LEFT JOIN DispatchingEntity dispatch ON fpl.fplId = dispatch.fplId " +
	            "AND dispatch.dispatchDate <= current_date " +
	            "JOIN fpl.sku sku " +
	            "WHERE fpl.dateFinished <= current_date AND fpl.branchId = :branchId " +  // Fixed branchId and space issue
	            "GROUP BY fpl.skuCD, sku.skuCodeName " +
	            "ORDER BY fpl.skuCD",
	            Object[].class).setParameter("branchId", branchId).list();
	    }
	    return result;
	}

	@Override
	public String saveData(DispatchingEntity data) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (0 == data.getDispatchTrackId()) {
				data.setDispatchTrackId(null);
				session.persist(data);
			} else {
				session.merge(data);
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
	public String deleteData(DispatchingEntity data) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.remove(data);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
		return "success";
	}

}
