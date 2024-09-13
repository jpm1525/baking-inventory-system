package com.cpi.is.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cpi.is.dao.impl.UserDAOImpl;
import com.cpi.is.entity.SessionEntity;
import com.cpi.is.entity.UserEntity;
import com.cpi.is.service.UserService;
import com.cpi.is.util.CookieUtil;

public class UserServiceImpl implements UserService {

	private UserDAOImpl userDAO;
	private BCryptPasswordEncoder passwordEncoder;
	
	public BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	public UserDAOImpl getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAOImpl userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public UserEntity authenticate(HttpServletRequest request) throws Exception {
		UserEntity user = userDAO.getUser(request.getParameter("username"));;
		if(!(user != null && passwordEncoder.matches(request.getParameter("password"), user.getPassword()))) {
			user = null;
		};
		return user;
	}

	@Override
	public void saveSession(HttpServletRequest request) throws Exception {
		userDAO.saveSession(new SessionEntity(
				request.getSession().getId(), 
				request.getAttribute("username").toString()));
		
	}
	
	public UserEntity getUser(String username) throws Exception {
		return userDAO.getUser(username);
	}

	@Override
	public SessionEntity validateSession(HttpServletRequest request) throws Exception {
		SessionEntity result  = userDAO.validateSession(new SessionEntity(
				CookieUtil.getCookieValue(request.getCookies(), "sessionId"), 
				CookieUtil.getCookieValue(request.getCookies(), "username")));
		return result;
	}

	@Override
	public void deleteSession(HttpServletRequest request) throws Exception {
		userDAO.deleteSession(new SessionEntity(
				CookieUtil.getCookieValue(request.getCookies(), "sessionId"), 
				CookieUtil.getCookieValue(request.getCookies(), "username")));		
	}

	public boolean isSessionValid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}
}