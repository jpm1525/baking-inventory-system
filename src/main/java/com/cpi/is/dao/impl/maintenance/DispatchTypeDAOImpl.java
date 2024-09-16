package com.cpi.is.dao.impl.maintenance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.maintenance.DispatchTypeDAO;
import com.cpi.is.entity.maintenance.DispatchTypeEntity;
import com.cpi.is.util.HBUtil;

public class DispatchTypeDAOImpl implements DispatchTypeDAO {
	
	@Override
	public List<DispatchTypeEntity> getData() throws Exception {
		List<DispatchTypeEntity> dispatchType = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			dispatchType = (List<DispatchTypeEntity>) 
					session.createQuery("FROM DispatchTypeEntity T ORDER BY T.createDate DESC", DispatchTypeEntity.class).list();
		}
		return dispatchType;
	}

	@Override
	public String saveData(DispatchTypeEntity data) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if ("" == data.getDispatchTypeCd()) {
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
	public String deleteData(DispatchTypeEntity data) throws Exception {
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
