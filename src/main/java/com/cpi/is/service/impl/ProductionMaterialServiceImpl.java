package com.cpi.is.service.impl;

import java.util.List;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.cpi.is.dao.impl.ProductionMaterialDAOImpl;
import com.cpi.is.entity.ProductionMaterialEntity;
import com.cpi.is.service.ProductionMaterialService;

public class ProductionMaterialServiceImpl implements ProductionMaterialService {

	private ProductionMaterialDAOImpl productionMaterialDAO;
	
	public ProductionMaterialDAOImpl getProductionMaterialDAO() {
		return productionMaterialDAO;
	}

	public void setProductionMaterialDAO(ProductionMaterialDAOImpl productionMaterialDAO) {
		this.productionMaterialDAO = productionMaterialDAO;
	}
	
	private ProductionMaterialEntity jsonToEntity(JSONObject json) {
		return new ProductionMaterialEntity(
		        Long.parseLong(json.getString("pmId")), 
		        Long.parseLong(json.getString("dppId")), 
		        json.getString("materialCd"),
		        Long.parseLong(json.getString("quantityToUse")));
	}

	@Override
	public List<ProductionMaterialEntity> getData(String dppIdInput) throws Exception {
		return productionMaterialDAO.getData(Long.parseLong(dppIdInput));
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		String results = "";
		
		if(validation.equals("success")) {
			results = 	productionMaterialDAO.saveData(
							jsonToEntity(new JSONObject(request.getParameter("data"))));
			if(results.equals("success")) {
				return results;
			} else {
				return "Unable to save Production Material Data";
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
			results = 	productionMaterialDAO.deleteData(
							jsonToEntity(new JSONObject(request.getParameter("data"))));
			if(results.equals("success")) {
				return results;
			} else {
				return "Unable to delete Production Material Data";
			}
		} else {
			return "Unable to delete Production Material data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "success";
		String errorResult = "Please fill-out the production material form properly";
		
		if (!json.has("pmId") || !(json.get("pmId") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("dppId") || !(json.get("dppId") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("materialCd") || !(json.get("materialCd") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("quantityToUse") || !(json.get("quantityToUse") instanceof String)) {
			validation = errorResult;
		} else if (json.getString("pmId").length() < 1 || json.getString("pmId").length() > 14) {
			validation = errorResult;
		} else if (!json.getString("pmId").matches("^[0-9]\\d*$")) {
			validation = errorResult;
		} else if (json.getString("dppId").length() < 1 || json.getString("dppId").length() > 14) {
			validation = errorResult;
		} else if (!json.getString("dppId").matches("^[0-9]\\d*$")) {
			validation = errorResult;
		} else if (json.getString("materialCd").length() < 1 || json.getString("materialCd").length() > 10) {
			validation = errorResult;
		} else if (json.getString("quantityToUse").length() < 1 || json.getString("quantityToUse").length() > 14) {
			validation = errorResult;
		} else if (!json.getString("quantityToUse").matches("^[0-9]\\d*$")) {
			validation = errorResult;
		} 
		return validation;
	}
	
	public Boolean validateDppId(HttpServletRequest request) {
		String dppIdInput = "";
			if(request.getParameter("dppIdInput") instanceof String) {
				dppIdInput = request.getParameter("dppIdInput");
			} else {
				return false;
			}
			
			if (dppIdInput.length() < 1 || dppIdInput.length() > 14) {
				return false;
			} else if (!dppIdInput.matches("^[1-9]\\d*$")) {
				return false;
			}
			
		return true;
	}

}
