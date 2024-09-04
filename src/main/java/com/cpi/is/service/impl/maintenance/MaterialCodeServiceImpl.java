package com.cpi.is.service.impl.maintenance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.cpi.is.dao.impl.maintenance.MaterialCodeDAOImpl;
import com.cpi.is.entity.maintenance.MaterialCodeEntity;
import com.cpi.is.service.maintenance.MaterialCodeService;

public class MaterialCodeServiceImpl implements MaterialCodeService {

	private MaterialCodeDAOImpl materialCodeDAO;
	
	public MaterialCodeDAOImpl getMaterialCodeDAO() {
		return materialCodeDAO;
	}

	public void setMaterialCodeDAO(MaterialCodeDAOImpl materialCodeDAO) {
		this.materialCodeDAO = materialCodeDAO;
	}
	
	private MaterialCodeEntity jsonToEntity(JSONObject json) {
		return new MaterialCodeEntity(
				json.getString("materialCd"),
				json.getString("materialCodeName"),
				json.getString("unitOfMeasurement"));
	}

	@Override
	public List<MaterialCodeEntity> getData() throws Exception {
		return materialCodeDAO.getData();
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return materialCodeDAO.saveData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return validation;
		}
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return materialCodeDAO.deleteData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return "Unable to delete data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "Success";
		
		if (!json.has("materialCd") || !(json.get("materialCd") instanceof String)) {
			validation = "Please fill-out the material code form properly";
		} else if (!json.has("materialCodeName") || !(json.get("materialCodeName") instanceof String)) {
			validation = "Please fill-out the material code form properly";
		} else if (!json.has("unitOfMeasurement") || !(json.get("unitOfMeasurement") instanceof String)) {
			validation = "Please fill-out the material code form properly";
		} else if (json.getString("materialCd").length() < 1 || json.getString("materialCd").length() > 50) {
			validation = "Please fill-out the material code form properly";
		} else if (json.getString("materialCodeName").length() < 1 || json.getString("materialCodeName").length() > 200) {
			validation = "Please fill-out the material code form properly";
		} else if (json.getString("unitOfMeasurement").length() < 1 || json.getString("unitOfMeasurement").length() > 100) {
			validation = "Please fill-out the material code form properly";
		}
		
		return validation;
	}

}
