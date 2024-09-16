package com.cpi.is.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpi.is.dao.UserDAO;
import com.cpi.is.entity.SessionEntity;
import com.cpi.is.entity.UserEntity;
import com.cpi.is.util.HBUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public UserEntity authenticate(UserEntity user) throws Exception {
		UserEntity authenticated = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			authenticated = (UserEntity) session
					.createQuery("FROM UserEntity T WHERE T.username = :username AND T.password = :password", UserEntity.class)
					.setParameter("username", user.getUsername())
					.setParameter("password", user.getPassword())
					.getSingleResultOrNull();
		}
		return authenticated;
	}

	public UserEntity getUser(String username) throws Exception {
		UserEntity user = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			 user = (UserEntity) session
					.createQuery("FROM UserEntity T WHERE T.username = :username", UserEntity.class)
					.setParameter("username", username)
					.getSingleResultOrNull();
		}
		return user;
	}

	@Override
	public void saveSession(SessionEntity userSession) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(userSession);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
	}

	@Override
	public SessionEntity validateSession(SessionEntity userSession) throws Exception {
		SessionEntity validated = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			List<SessionEntity> results = session
					.createQuery("FROM SessionEntity T WHERE T.sessionId = :sessionId AND T.username = :username",
							SessionEntity.class)
					.setParameter("sessionId", userSession.getSessionId())
					.setParameter("username", userSession.getUsername()).list();
			if (results.size() > 0) {
				validated = results.get(0);
			}
		}
		return validated;
	}

	@Override
	public void deleteSession(SessionEntity userSession) throws Exception {
		Transaction transaction = null;
		try (Session session = HBUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.remove(userSession);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
	}
}