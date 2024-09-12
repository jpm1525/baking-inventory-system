package com.cpi.is.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.DispatchingDAO;
import com.cpi.is.entity.DispatchingEntity;
import com.cpi.is.util.HBUtil;

public class DispatchingDAOImpl implements DispatchingDAO {
	
	@Override
    public List<DispatchingEntity> getData(Long branchId) throws Exception {
        List<DispatchingEntity> dispatching = null;
        try (Session session = HBUtil.getSessionFactory().openSession()) {
            dispatching = session.createQuery("FROM DispatchingEntity T "
            		+ "WHERE T.branchId = :branchId ORDER BY "
            		+ "T.dispatchTrackId ASC", DispatchingEntity.class)
                                 .setParameter("branchId", branchId)
                                 .list();
        }
        return dispatching;
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
