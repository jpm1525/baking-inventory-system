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
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return dispatchTypeDAO.saveData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return validation;
		}
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return dispatchTypeDAO.deleteData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return "Unable to delete data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "Success";
		
		if (!json.has("dispatchTypeCd") || !(json.get("dispatchTypeCd") instanceof String)) {
			validation = "Please fill-out the dispatch type form properly";
		} else if(!json.has("dispatchTypeName") || !(json.get("dispatchTypeName") instanceof String)) {
			validation = "Please fill-out the dispatch type form properly";
		} else if (json.getString("dispatchTypeCd").length() < 1 || json.getString("dispatchTypeCd").length() > 50) {
			validation = "Please fill-out the dispatch type form properly";
		} else if (json.getString("dispatchTypeName").length() < 1 || json.getString("dispatchTypeName").length() > 200) {
			validation = "Please fill-out the dispatch type form properly";
		}
		
		return validation;
	}

}
