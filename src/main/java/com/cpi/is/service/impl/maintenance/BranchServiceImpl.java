package com.cpi.is.service.impl.maintenance;

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
		return branchDAO.saveData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		return branchDAO.deleteData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
	}

}
