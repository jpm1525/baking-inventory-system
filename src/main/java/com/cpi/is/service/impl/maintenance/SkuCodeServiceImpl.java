package com.cpi.is.service.impl.maintenance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.cpi.is.dao.impl.maintenance.SkuCodeDAOImpl;
import com.cpi.is.entity.maintenance.SkuCodeEntity;
import com.cpi.is.service.maintenance.SkuCodeService;

public class SkuCodeServiceImpl implements SkuCodeService {

	private SkuCodeDAOImpl skuCodeDAO;
	
	public SkuCodeDAOImpl getSkuCodeDAO() {
		return skuCodeDAO;
	}

	public void setSkuCodeDAO(SkuCodeDAOImpl skuCodeDAO) {
		this.skuCodeDAO = skuCodeDAO;
	}
	
	private SkuCodeEntity jsonToEntity(JSONObject json) {
		return new SkuCodeEntity(
				json.getString("skuCd"),
				json.getString("skuCodeName"),
				json.getString("unitOfMeasurement"));
	}

	@Override
	public List<SkuCodeEntity> getData() throws Exception {
		return skuCodeDAO.getData();
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return skuCodeDAO.saveData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return validation;
		}
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return skuCodeDAO.deleteData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return "Unable to delete data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "Success";
		
		if (!json.has("skuCd") || !(json.get("skuCd") instanceof String)) {
			validation = "Please fill-out the sku code form properly";
		} else if (!json.has("skuCodeName") || !(json.get("skuCodeName") instanceof String)) {
			validation = "Please fill-out the sku code form properly";
		} else if (!json.has("unitOfMeasurement") || !(json.get("unitOfMeasurement") instanceof String)) {
			validation = "Please fill-out the sku code form properly";
		} else if (json.getString("skuCd").length() < 1 || json.getString("skuCd").length() > 10) {
			validation = "Please fill-out the sku code form properly";
		} else if (json.getString("skuCodeName").length() < 1 || json.getString("skuCodeName").length() > 50) {
			validation = "Please fill-out the sku code form properly";
		} else if (json.getString("unitOfMeasurement").length() < 1 || json.getString("unitOfMeasurement").length() > 50) {
			validation = "Please fill-out the sku code form properly";
		}
		
		return validation;
	}

}
