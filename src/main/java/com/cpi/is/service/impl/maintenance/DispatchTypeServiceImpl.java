package com.cpi.is.service.impl.maintenance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.cpi.is.dao.impl.maintenance.DispatchTypeDAOImpl;
import com.cpi.is.entity.maintenance.DispatchTypeEntity;
import com.cpi.is.service.maintenance.DispatchTypeService;

public class DispatchTypeServiceImpl implements DispatchTypeService {

	private DispatchTypeDAOImpl dispatchTypeDAO;
	
	public DispatchTypeDAOImpl getDispatchTypeDAO() {
		return dispatchTypeDAO;
	}

	public void setDispatchTypeDAO(DispatchTypeDAOImpl dispatchTypeDAO) {
		this.dispatchTypeDAO = dispatchTypeDAO;
	}
	
	private DispatchTypeEntity jsonToEntity(JSONObject json) {
		return new DispatchTypeEntity(
				json.getString("dispatchTypeCd"),
				json.getString("dispatchTypeName"));
	}

	@Override
	public List<DispatchTypeEntity> getData() throws Exception {
		return dispatchTypeDAO.getData();
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		return dispatchTypeDAO.saveData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		return dispatchTypeDAO.deleteData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
	}

}
