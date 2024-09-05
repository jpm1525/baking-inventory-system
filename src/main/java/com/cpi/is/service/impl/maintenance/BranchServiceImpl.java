package com.cpi.is.service.impl.maintenance;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.cpi.is.dao.impl.maintenance.BranchDAOImpl;
import com.cpi.is.entity.maintenance.BranchEntity;
import com.cpi.is.service.maintenance.BranchService;

public class BranchServiceImpl implements BranchService {

	private BranchDAOImpl branchDAO;
	
	public BranchDAOImpl getBranchDAO() {
		return branchDAO;
	}

	public void setBranchDAO(BranchDAOImpl branchDAO) {
		this.branchDAO = branchDAO;
	}
	
	private BranchEntity jsonToEntity(JSONObject json) {
		return new BranchEntity(
				Long.parseLong(json.getString("branchId")),
				json.getString("branchName"));
	}

	@Override
	public List<BranchEntity> getData() throws Exception {
		return branchDAO.getData();
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return branchDAO.saveData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return validation;
		}
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return branchDAO.deleteData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return "Unable to delete data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "Success";
		if (!json.has("branchId") || !(json.get("branchId") instanceof String)) {
			validation = "Please fill-out the branch form properly";
		} else if(!json.has("branchName") || !(json.get("branchName") instanceof String)) {
			validation = "Please fill-out the branch form properly";
		} else if (json.getString("branchId").length() < 1 || json.getString("branchId").length() > 14) {
			validation = "Please fill-out the branch form properly";
		} else if (!json.getString("branchId").matches("^[0-9]\\d*$")) {
			validation = "Please fill-out the branch form properly";
		} else if (json.getString("branchName").length() < 1 && json.getString("branchName").length() > 50) {
			validation = "Please fill-out the branch form properly";
		} 
		
		return validation;
	}

}
