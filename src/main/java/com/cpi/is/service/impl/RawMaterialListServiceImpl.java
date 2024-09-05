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

import com.cpi.is.dao.impl.RawMaterialListDAOImpl;
import com.cpi.is.entity.RawMaterialListEntity;
import com.cpi.is.service.RawMaterialListService;

public class RawMaterialListServiceImpl implements RawMaterialListService {

	private RawMaterialListDAOImpl rawMaterialListDAO;
	
	public RawMaterialListDAOImpl getRawMaterialListDAO() {
		return rawMaterialListDAO;
	}

	public void setRawMaterialListDAO(RawMaterialListDAOImpl rawMaterialListDAO) {
		this.rawMaterialListDAO = rawMaterialListDAO;
	}
	
	private RawMaterialListEntity jsonToEntity(JSONObject json) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(json.getString("dateReceive"));
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new RawMaterialListEntity(
		        Integer.parseInt(json.getString("materialListId")),
		        json.getString("materialCd"), 
		        Integer.parseInt(json.getString("quantity")), 
		        Integer.parseInt(json.getString("userId")), 
		        date1, 
		        Integer.parseInt(json.getString("branchId")));
	}

	@Override
	public List<RawMaterialListEntity> getData() throws Exception {
		return rawMaterialListDAO.getData();
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return rawMaterialListDAO.saveData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return validation;
		}
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return rawMaterialListDAO.deleteData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return "Unable to delete data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "Success";
		
		if (!json.has("materialListId") || !(json.get("materialListId") instanceof String)) {
			validation = "Please fill-out the raw material list form properly";
		} else if (!json.has("materialCd") || !(json.get("materialCd") instanceof String)) {
			validation = "Please fill-out the raw material list form properly";
		} else if (!json.has("quantity") || !(json.get("quantity") instanceof String)) {
			validation = "Please fill-out the raw material list form properly";
		} else if (!json.has("userId") || !(json.get("userId") instanceof String)) {
			validation = "Please fill-out the raw material list form properly";
		} else if (!json.has("dateReceive") || !(json.get("dateReceive") instanceof String)) {
			validation = "Please fill-out the raw material list form properly";
		} else if (!json.has("branchId") || !(json.get("branchId") instanceof String)) {
			validation = "Please fill-out the raw material list form properly";
		} else if (json.getString("materialListId").length() < 1 || json.getString("materialListId").length() > 19) {
			validation = "Please fill-out the raw material list form properly";
		} else if (!json.getString("materialListId").matches("^[0-9]\\d*$")) {
			validation = "Please fill-out the raw material list form properly";
		} else if ((new BigInteger(json.getString("materialListId"))).compareTo(new BigInteger("9223372036854775807")) == 1) {
			validation = "Please fill-out the raw material list form properly";
		} else if (json.getString("materialCd").length() < 1 || json.getString("materialCd").length() > 50) {
			validation = "Please fill-out the raw material list form properly";
		} else if (json.getString("quantity").length() < 1 || json.getString("quantity").length() > 19) {
			validation = "Please fill-out the raw material list form properly";
		} else if (!json.getString("quantity").matches("^[0-9]+$")) {
			validation = "Please fill-out the raw material list form properly";
		} else if ((new BigInteger(json.getString("quantity"))).compareTo(new BigInteger("9223372036854775807")) == 1) {
			validation = "Please fill-out the raw material list form properly";
		} else if (json.getString("userId").length() < 1 || json.getString("userId").length() > 19) {
			validation = "Please fill-out the raw material list form properly";
		} else if (!json.getString("userId").matches("^[1-9]\\d*$")) {
			validation = "Please fill-out the raw material list form properly";
		} else if ((new BigInteger(json.getString("userId"))).compareTo(new BigInteger("9223372036854775807")) == 1) {
			validation = "Please fill-out the raw material list form properly";
		} else if (json.getString("branchId").length() < 1 || json.getString("branchId").length() > 19) {
			validation = "Please fill-out the raw material list form properly";
		} else if (!json.getString("branchId").matches("^[1-9]\\d*$")) {
			validation = "Please fill-out the raw material list form properly";
		} else if ((new BigInteger(json.getString("branchId"))).compareTo(new BigInteger("9223372036854775807")) == 1) {
			validation = "Please fill-out the raw material list form properly";
		} else {
	        try {
	        	LocalDate.parse(json.getString("dateReceive"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	        } catch (DateTimeParseException e) {
	        	validation = "Please fill-out the raw material list form properly";
	        }
		}
		return validation;
	}

}
