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
		return new MaterialCodeEntity(json.getString("materialCd"), json.getString("materialCodeName"),
				json.getString("unitOfMeasurement"));
	}

	@Override
	public List<MaterialCodeEntity> getData() throws Exception {
		List<MaterialCodeEntity> materialCodes = materialCodeDAO.getData();
		return materialCodes;
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		String results = "";

		if (validation.equals("success")) {
			try {
				results = materialCodeDAO.saveData(jsonToEntity(new JSONObject(request.getParameter("data"))));
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (results.equals("success")) {
				return results;
			} else {
				return "Unable to save Material Code Data";
			}
		} else {
			return validation;
		}
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		String results = "";

		if (validation.equals("success")) {
			try {
				results = materialCodeDAO.deleteData(jsonToEntity(new JSONObject(request.getParameter("data"))));
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (results.equals("success")) {
				return results;
			} else {
				return "Unable to delete Material Code Data";
			}
		} else {
			return "Unable to delete Material Code data";
		}
	}

	public String validateData(HttpServletRequest request) throws Exception {
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "success";
		String errorResult = "Please fill-out the material code form properly";

		if (!json.has("materialCd") || !(json.get("materialCd") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("materialCodeName") || !(json.get("materialCodeName") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("unitOfMeasurement") || !(json.get("unitOfMeasurement") instanceof String)) {
			validation = errorResult;
		} else if (json.getString("materialCd").length() < 1 || json.getString("materialCd").length() > 10) {
			validation = errorResult;
		} else if (json.getString("materialCodeName").length() < 1
				|| json.getString("materialCodeName").length() > 50) {
			validation = errorResult;
		} else if (json.getString("unitOfMeasurement").length() < 1
				|| json.getString("unitOfMeasurement").length() > 50) {
			validation = errorResult;
		}

		return validation;
	}

}
