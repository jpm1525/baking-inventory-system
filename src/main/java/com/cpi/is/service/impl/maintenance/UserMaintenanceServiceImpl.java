package com.cpi.is.service.impl.maintenance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cpi.is.dao.impl.maintenance.UserMaintenanceDAOImpl;
import com.cpi.is.entity.UserEntity;


public class UserMaintenanceServiceImpl {
	
	private UserMaintenanceDAOImpl userMaintenanceDAO;
	private BCryptPasswordEncoder passwordEncoder;
	
	public BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	public UserMaintenanceDAOImpl getUserMaintenanceDAO() {
		return userMaintenanceDAO;
	}

	public void setUserMaintenanceDAO(UserMaintenanceDAOImpl userMaintenanceDAO) {
		this.userMaintenanceDAO = userMaintenanceDAO;
	}
	
	private UserEntity jsonToEntity(JSONObject json) {
		return new UserEntity(
				json.getLong("userId"),
				json.getString("username"),
				passwordEncoder.encode(json.getString("password")),
				json.getLong("branchId"));
	}
	
	public List<UserEntity> getData() throws Exception {
		List<UserEntity> userIds = userMaintenanceDAO.getData();
		userIds.forEach(userId -> {
			userId.setPassword(null);
		});
		
		return userIds;
	}

	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		String results = "";
		
		if(validation.equals("success")) {
			try {
				results = 	userMaintenanceDAO.saveData(
								jsonToEntity(new JSONObject(request.getParameter("data"))));
			} catch(Exception e) {
				e.printStackTrace();
			}
			if(results.equals("success")) {
				return results;
			} else {
				return "Unable to save User Data";
			}
		} else {
			return validation;
		}
	}

	public String deleteData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		String results = "";
		
		if(validation.equals("success")) {
			try {
				results = 	userMaintenanceDAO.deleteData(
								jsonToEntity(new JSONObject(request.getParameter("data"))));
			} catch(Exception e) {
				e.printStackTrace();
			}
			if(results.equals("success")) {
				return results;
			} else {
				return "Unable to delete User Data";
			}
		} else {
			return "Unable to delete User Data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "success";
		String errorResult = "Please fill-out the user form properly";
		
		if (!json.has("username") || !(json.get("username") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("password") || !(json.get("password") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("branchId") || !(json.get("branchId") instanceof String)) {
			validation = errorResult;
		} else if (json.getString("username").length() < 1 || json.getString("username").length() > 10) {
			validation = errorResult;
		} else if (json.getString("password").length() < 1 || json.getString("password").length() > 100) {
			validation = errorResult;
		} else if (json.getString("branchId").length() < 1 || json.getString("branchId").length() > 50) {
			validation = errorResult;
		} else if (!json.getString("branchId").matches("^[1-9]\\d*$")) {
			validation = errorResult;
		} 
		
		return validation;
	}

}
