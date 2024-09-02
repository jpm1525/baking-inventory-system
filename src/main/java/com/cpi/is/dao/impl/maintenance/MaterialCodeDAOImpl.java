package com.cpi.is.dao.impl.maintenance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.maintenance.MaterialCodeDAO;
import com.cpi.is.entity.maintenance.MaterialCodeEntity;
import com.cpi.is.util.HBUtil;

public class MaterialCodeDAOImpl implements MaterialCodeDAO {
	
	@Override
	public List<MaterialCodeEntity> getData() throws Exception {
		List<MaterialCodeEntity> materialCode = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			materialCode = (List<MaterialCodeEntity>) 
					session.createQuery("FROM MaterialCodeEntity T ORDER BY T.createDate DESC", MaterialCodeEntity.class).list();
		}
		return materialCode;
	}

	@Override
	public String saveData(MaterialCodeEntity data) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if ("" == data.getMaterialCd()) {
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
	public String deleteData(MaterialCodeEntity data) throws Exception {
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
