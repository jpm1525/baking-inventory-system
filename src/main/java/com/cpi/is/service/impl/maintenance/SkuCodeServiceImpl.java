package com.cpi.is.service.impl.maintenance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.cpi.is.dao.impl.maintenance.SkuCodeDAOImpl;
import com.cpi.is.entity.maintenance.SkuCodeEntity;
import com.cpi.is.service.maintenance.SkuCodeService;
import com.cpi.is.util.JsonEscapeUtil;

public class SkuCodeServiceImpl implements SkuCodeService {

	private SkuCodeDAOImpl skuCodeDAO;

	public SkuCodeDAOImpl getSkuCodeDAO() {
		return skuCodeDAO;
	}

	public void setSkuCodeDAO(SkuCodeDAOImpl skuCodeDAO) {
		this.skuCodeDAO = skuCodeDAO;
	}

	private SkuCodeEntity jsonToEntity(JSONObject json) {
		return new SkuCodeEntity(json.getString("skuCd"), json.getString("skuCodeName"),
				json.getString("unitOfMeasurement"));
	}

	@Override
	public List<SkuCodeEntity> getData() throws Exception {
		List<SkuCodeEntity> skuCodes = skuCodeDAO.getData();
		for (SkuCodeEntity skuCode : skuCodes) {
			skuCode.setSkuCd(JsonEscapeUtil.escape(skuCode.getSkuCd()));
			skuCode.setSkuCodeName(JsonEscapeUtil.escape(skuCode.getSkuCodeName()));
			skuCode.setUnitOfMeasurement(JsonEscapeUtil.escape(skuCode.getUnitOfMeasurement()));
		}
		return skuCodes;
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		String results = "";

		if (validation.equals("success")) {
			try {
				results = skuCodeDAO.saveData(jsonToEntity(new JSONObject(request.getParameter("data"))));
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (results.equals("success")) {
				return results;
			} else {
				return "Unable to save SKU Code Data";
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
				results = skuCodeDAO.deleteData(jsonToEntity(new JSONObject(request.getParameter("data"))));
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (results.equals("success")) {
				return results;
			} else {
				return "Unable to delete SKU Code Data";
			}
		} else {
			return "Unable to delete SKU Code data";
		}
	}

	public String validateData(HttpServletRequest request) throws Exception {
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "success";
		String errorResult = "Please fill-out the sku code form properly";

		if (!json.has("skuCd") || !(json.get("skuCd") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("skuCodeName") || !(json.get("skuCodeName") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("unitOfMeasurement") || !(json.get("unitOfMeasurement") instanceof String)) {
			validation = errorResult;
		} else if (json.getString("skuCd").length() < 1 || json.getString("skuCd").length() > 10) {
			validation = errorResult;
		} else if (json.getString("skuCodeName").length() < 1 || json.getString("skuCodeName").length() > 50) {
			validation = errorResult;
		} else if (json.getString("unitOfMeasurement").length() < 1
				|| json.getString("unitOfMeasurement").length() > 50) {
			validation = errorResult;
		}

		return validation;
	}

}
