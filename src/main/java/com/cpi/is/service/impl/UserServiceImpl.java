package com.cpi.is.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.dao.impl.UserDAOImpl;
import com.cpi.is.entity.SessionEntity;
import com.cpi.is.entity.UserEntity;
import com.cpi.is.service.UserService;
import com.cpi.is.util.CookieUtil;

public class UserServiceImpl implements UserService {

	private UserDAOImpl userDAO;
	
	public UserDAOImpl getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAOImpl userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public UserEntity authenticate(HttpServletRequest request) throws Exception {
		UserEntity user = new UserEntity();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		return userDAO.authenticate(user);
	}

	@Override
	public void saveSession(HttpServletRequest request) throws Exception {
		userDAO.saveSession(new SessionEntity(
				request.getSession().getId(), request.getAttribute("username").toString()));
		
	}

	@Override
	public SessionEntity validateSession(HttpServletRequest request) throws Exception {
		return userDAO.validateSession(new SessionEntity(
				CookieUtil.getCookieValue(request.getCookies(), "sessionId"), 
				CookieUtil.getCookieValue(request.getCookies(), "user")));
	}

	@Override
	public void deleteSession(HttpServletRequest request) throws Exception {
		userDAO.deleteSession(new SessionEntity(
				CookieUtil.getCookieValue(request.getCookies(), "sessionId"), 
				CookieUtil.getCookieValue(request.getCookies(), "user")));		
	}

	public boolean isSessionValid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
