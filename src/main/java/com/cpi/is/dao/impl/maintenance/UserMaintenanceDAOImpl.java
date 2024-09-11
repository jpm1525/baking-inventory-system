package com.cpi.is.dao.impl.maintenance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.maintenance.UserMaintenanceDAO;
import com.cpi.is.entity.UserEntity;
import com.cpi.is.util.HBUtil;

public class UserMaintenanceDAOImpl implements UserMaintenanceDAO{
	
	@Override
	public List<UserEntity> getData() throws Exception {
		List<UserEntity> user = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			user = (List<UserEntity>) 
					session.createQuery("FROM UserEntity T ORDER BY T.userId DESC", UserEntity.class).list();
		}
		return user;
	}
	
	@Override
	public String saveData(UserEntity data) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (0 == data.getUserId()) {
				data.setUserId(null);
				session.persist(data);	// add a new record
			} else {
				session.merge(data);	// update an existing record
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
	public String deleteData(UserEntity data) throws Exception {
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
