package com.cpi.is.dao.impl.maintenance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.maintenance.BranchDAO;
import com.cpi.is.entity.maintenance.BranchEntity;
import com.cpi.is.util.HBUtil;

public class BranchDAOImpl implements BranchDAO {
	
	@Override
	public List<BranchEntity> getData() throws Exception {
		List<BranchEntity> branch = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			branch = (List<BranchEntity>) 
					session.createQuery("FROM BranchEntity T ORDER BY T.branchId DESC", BranchEntity.class).list();
		}
		return branch;
	}

	@Override
	public String saveData(BranchEntity data) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			if (0 == data.getBranchId()) {
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
	public String deleteData(BranchEntity data) throws Exception {
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
