package com.cpi.is.dao.impl.maintenance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.maintenance.SkuCodeDAO;
import com.cpi.is.entity.maintenance.SkuCodeEntity;
import com.cpi.is.util.HBUtil;

public class SkuCodeDAOImpl implements SkuCodeDAO {
	
	@Override
	public List<SkuCodeEntity> getData() throws Exception {
		List<SkuCodeEntity> skuCode = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			skuCode = (List<SkuCodeEntity>) 
					session.createQuery("FROM SkuCodeEntity T ORDER BY T.createDate DESC", SkuCodeEntity.class).list();
		}
		return skuCode;
	}

	@Override
	public String saveData(SkuCodeEntity data) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if ("" == data.getSkuCd()) {
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
	public String deleteData(SkuCodeEntity data) throws Exception {
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
