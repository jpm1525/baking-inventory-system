package com.cpi.is.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.RawMaterialListDAO;
import com.cpi.is.entity.RawMaterialListEntity;
import com.cpi.is.util.HBUtil;

public class RawMaterialListDAOImpl implements RawMaterialListDAO {
	
	@Override
	public List<RawMaterialListEntity> getData() throws Exception {
		List<RawMaterialListEntity> rawMaterialList = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			rawMaterialList = (List<RawMaterialListEntity>) 
					session.createQuery("From RawMaterialListEntity T ORDER BY T.materialCd ASC", RawMaterialListEntity.class).list();
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
	
}
