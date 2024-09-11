package com.cpi.is.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cpi.is.dao.impl.UserDAOImpl;
import com.cpi.is.entity.SessionEntity;
import com.cpi.is.entity.UserEntity;
import com.cpi.is.service.UserService;
import com.cpi.is.util.CookieUtil;

public class UserServiceImpl implements UserService {

	private UserDAOImpl userDAO;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserDAOImpl getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAOImpl userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserEntity authenticate(HttpServletRequest request) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Fetch user from the database by username
		UserEntity user = userDAO.getUser(username);  
		
		// Check if user exists and if the password matches
		if (user != null && passwordEncoder.matches(password, user.getPassword())) {
			return user;  // Authentication successful
		} else {
			return null;  // Authentication failed
		}
	}

	// Register user with encoded password
	public void registerUser(UserEntity user) throws Exception {
		// Encode the user's password before saving to the database
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDAO.getUser(user);  // Save user to the database (Implement saveUser in your DAO)
	}

	@Override
	public void saveSession(HttpServletRequest request) throws Exception {
		userDAO.saveSession(new SessionEntity(
				request.getSession().getId(), 
				request.getAttribute("username").toString()));
	}

	public UserEntity getUser(String username) throws Exception {
		return userDAO.getUser(username);  // Fetch the user by username from the database
	}

	@Override
	public SessionEntity validateSession(HttpServletRequest request) throws Exception {
		// Validate session based on session ID and username from cookies
		return userDAO.validateSession(new SessionEntity(
				CookieUtil.getCookieValue(request.getCookies(), "sessionId"),
				CookieUtil.getCookieValue(request.getCookies(), "username")));
	}

	@Override
	public void deleteSession(HttpServletRequest request) throws Exception {
		userDAO.deleteSession(new SessionEntity(
				CookieUtil.getCookieValue(request.getCookies(), "sessionId"),
				CookieUtil.getCookieValue(request.getCookies(), "username")));
	}

	public boolean isSessionValid(HttpServletRequest request) {
		// Implement session validation logic based on session ID or cookies
		return false;  // Stub implementation for now
	}
}
