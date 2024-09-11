package com.cpi.is.service.impl.maintenance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.cpi.is.dao.impl.maintenance.BranchDAOImpl;
import com.cpi.is.entity.maintenance.BranchEntity;
import com.cpi.is.service.maintenance.BranchService;
import com.cpi.is.util.JsonEscapeUtil;

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
		List<BranchEntity> branches = branchDAO.getData();
		for (BranchEntity branch: branches) {
			branch.setBranchName(JsonEscapeUtil.escape(branch.getBranchName()));
		}
		return branches;
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		String results = "";
		
		if(validation.equals("success")) {
			try {
				results = 	branchDAO.saveData(
						jsonToEntity(new JSONObject(request.getParameter("data"))));
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			if(results.equals("success")) {
				return results;
			} else {
				return "Unable to save Branch Data";
			}
		} else {
			return validation;
		}
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		String results = "";
		
		if(validation.equals("success")) {
			try {
				results = 	branchDAO.deleteData(
						jsonToEntity(new JSONObject(request.getParameter("data"))));
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			if(results.equals("success")) {
				return results;
			} else {
				return "Unable to delete Branch Data";
			}
		} else {
			return "Unable to delete Branch data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "success";
		String errorResult = "Please fill-out the branch form properly";
		
		if (!json.has("branchId") || !(json.get("branchId") instanceof String)) {
			validation = errorResult;
		} else if(!json.has("branchName") || !(json.get("branchName") instanceof String)) {
			validation = errorResult;
		} else if (json.getString("branchId").length() < 1 || json.getString("branchId").length() > 14) {
			validation = errorResult;
		} else if (!json.getString("branchId").matches("^[0-9]\\d*$")) {
			validation = errorResult;
		} else if (json.getString("branchName").length() < 1 && json.getString("branchName").length() > 50) {
			validation = errorResult;
		} 
		
		return validation;
	}

}
