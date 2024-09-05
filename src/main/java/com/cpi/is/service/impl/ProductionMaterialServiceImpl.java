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
	public List<ProductionMaterialEntity> getData() throws Exception {
		return productionMaterialDAO.getData();
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return productionMaterialDAO.saveData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return validation;
		}
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return productionMaterialDAO.deleteData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return "Unable to delete data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "Success";
		
		if (!json.has("pmId") || !(json.get("pmId") instanceof String)) {
			validation = "Please fill-out the production material form properly";
		} else if (!json.has("dppId") || !(json.get("dppId") instanceof String)) {
			validation = "Please fill-out the production material form properly";
		} else if (!json.has("materialCd") || !(json.get("materialCd") instanceof String)) {
			validation = "Please fill-out the production material form properly";
		} else if (!json.has("quantityToUse") || !(json.get("quantityToUse") instanceof String)) {
			validation = "Please fill-out the production material form properly";
		} else if (json.getString("pmId").length() < 1 || json.getString("pmId").length() > 14) {
			validation = "Please fill-out the production material form properly";
		} else if (!json.getString("pmId").matches("^[0-9]\\d*$")) {
			validation = "Please fill-out the production material form properly";
		} else if (json.getString("dppId").length() < 1 || json.getString("dppId").length() > 14) {
			validation = "Please fill-out the production material form properly";
		} else if (!json.getString("dppId").matches("^[0-9]\\d*$")) {
			validation = "Please fill-out the production material form properly";
		} else if (json.getString("materialCd").length() < 1 || json.getString("materialCd").length() > 10) {
			validation = "Please fill-out the production material form properly";
		} else if (json.getString("quantityToUse").length() < 1 || json.getString("quantityToUse").length() > 14) {
			validation = "Please fill-out the production material form properly";
		} else if (!json.getString("quantityToUse").matches("^[0-9]\\d*$")) {
			validation = "Please fill-out the production material form properly";
		} 
		return validation;
	}

}
