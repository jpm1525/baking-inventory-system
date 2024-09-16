package com.cpi.is.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.ProductionMaterialDAO;
import com.cpi.is.entity.ProductionMaterialEntity;
import com.cpi.is.util.HBUtil;

public class ProductionMaterialDAOImpl implements ProductionMaterialDAO {
	
	@Override
	public List<ProductionMaterialEntity> getData(Long dppIdInput) throws Exception {
		List<ProductionMaterialEntity> productionMaterial = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			productionMaterial = (List<ProductionMaterialEntity>) 
				session.createQuery("From ProductionMaterialEntity T WHERE T.dppId ="
						+ " :dppIdInput ORDER BY T.pmId ASC", ProductionMaterialEntity.class)
					.setParameter("dppIdInput", dppIdInput)
					.list();
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
