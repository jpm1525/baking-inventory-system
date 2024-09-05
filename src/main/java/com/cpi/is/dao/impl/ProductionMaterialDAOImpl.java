package com.cpi.is.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.ProductionMaterialDAO;
import com.cpi.is.entity.ProductionMaterialEntity;
import com.cpi.is.util.HBUtil;

public class ProductionMaterialDAOImpl implements ProductionMaterialDAO {
	
	@Override
	public List<ProductionMaterialEntity> getData() throws Exception {
		List<ProductionMaterialEntity> productionMaterial = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			productionMaterial = (List<ProductionMaterialEntity>) 
					session.createQuery("From ProductionMaterialEntity T ORDER BY T.pmId ASC", ProductionMaterialEntity.class).list();
		}
		return productionMaterial;
	}

	@Override
	public String saveData(ProductionMaterialEntity data) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (0 == data.getPmId()) {
				data.setPmId(null);
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
	public String deleteData(ProductionMaterialEntity data) throws Exception {
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
