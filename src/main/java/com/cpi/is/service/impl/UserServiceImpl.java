package com.cpi.is.service.impl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.dao.impl.UserDAOImpl;
import com.cpi.is.entity.UserEntity;
import com.cpi.is.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDAOImpl userDAO;
	
	public UserDAOImpl getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAOImpl userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserEntity authenticate(HttpServletRequest request) throws FileNotFoundException, ClassNotFoundException, SQLException{
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", request.getParameter("username"));
		params.put("password", request.getParameter("password"));
		return userDAO.authenticate(params);
	}

}
