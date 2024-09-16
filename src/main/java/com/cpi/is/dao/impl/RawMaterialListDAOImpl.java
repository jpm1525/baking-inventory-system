package com.cpi.is.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.RawMaterialListDAO;
import com.cpi.is.entity.RawMaterialListEntity;
import com.cpi.is.util.HBUtil;

public class RawMaterialListDAOImpl implements RawMaterialListDAO {

	@Override
	public List<RawMaterialListEntity> getData(Long branchId) throws Exception {
		List<RawMaterialListEntity> rawMaterialList = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			rawMaterialList = (List<RawMaterialListEntity>) session.createQuery(
					"From RawMaterialListEntity T WHERE T.branchId = :branchId ORDER BY T.materialListId DESC",
					RawMaterialListEntity.class).setParameter("branchId", branchId).list();
		}
		return rawMaterialList;
	}

	@Override
	public String saveData(RawMaterialListEntity item) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (0 == item.getMaterialListId()) {
				item.setMaterialListId(null);
				session.persist(item);
			} else {
				session.merge(item);
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
	public String deleteData(RawMaterialListEntity item) throws Exception {
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
	
	@Override
	public Long getMaterialCount(Long branchId) throws Exception {
	    Long count = null;
	    try (Session session = HBUtil.getSessionFactory().openSession()) {
	        count = (Long) session.createQuery("SELECT COUNT(*) FROM RawMaterialListEntity T WHERE T.branchId = :branchId", Long.class)
	                              .setParameter("branchId", branchId)
	                              .uniqueResult();
	    }
	    return count;
	}
	
}
