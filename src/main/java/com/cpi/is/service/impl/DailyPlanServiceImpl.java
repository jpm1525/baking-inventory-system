package com.cpi.is.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.cpi.is.dao.impl.DailyPlanDAOImpl;
import com.cpi.is.entity.DailyPlanEntity;
import com.cpi.is.service.DailyPlanService;

public class DailyPlanServiceImpl implements DailyPlanService{

	private DailyPlanDAOImpl dailyPlanDAO;
	
	public DailyPlanDAOImpl getDailyPlanDAO() {
		return dailyPlanDAO;
	}

	public void setDailyPlanDAO(DailyPlanDAOImpl dailyPlanDAO) {
		this.dailyPlanDAO = dailyPlanDAO;
	}
	
	private DailyPlanEntity jsonToEntity(JSONObject json) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(json.getString("productionDate"));
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new DailyPlanEntity(
		        Integer.parseInt(json.getString("dppId")),
		        date1,
		        Integer.parseInt(json.getString("branchId")),
		        json.getString("skuCd"),
		        Integer.parseInt(json.getString("quantity")),
		        json.getString("status"));
	}

	@Override
	public List<DailyPlanEntity> getData(Long branchId) throws Exception {
		return dailyPlanDAO.getData(branchId);
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		String results = "";
		
		if(validation.equals("success")) {
			results = 	dailyPlanDAO.saveData(
							jsonToEntity(new JSONObject(request.getParameter("data"))));
			if(results.equals("success")) {
				return results;
			} else {
				return "Unable to save Raw Material List Data";
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
			results = 	dailyPlanDAO.deleteData(
							jsonToEntity(new JSONObject(request.getParameter("data"))));
			if(results.equals("success")) {
				return results;
			} else {
				return "Unable to delete Raw Material List Data";
			}
		} else {
			return "Unable to delete Raw Material List data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "success";
		String errorResult = "Please fill-out the daily planned production form properly";
		
		if (!json.has("dppId") || !(json.get("dppId") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("productionDate") || !(json.get("productionDate") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("branchId") || !(json.get("branchId") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("skuCd") || !(json.get("skuCd") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("quantity") || !(json.get("quantity") instanceof String)) {
			validation = errorResult;
		} else if (!json.has("status") || !(json.get("status") instanceof String)) {
			validation = errorResult;
		} else if (json.getString("dppId").length() < 1 || json.getString("dppId").length() > 14) {
			validation = errorResult;
		} else if (!json.getString("dppId").matches("^[0-9]+$")) {
			validation = errorResult;
		} else if (json.getString("branchId").length() < 1 || json.getString("branchId").length() > 14) {
			validation = errorResult;
		} else if (!json.getString("branchId").matches("^[1-9]\\d*$")) {
			validation = errorResult;
		} else if (json.getString("skuCd").length() < 1 || json.getString("skuCd").length() > 10) {
			validation = errorResult;
		} else if (json.getString("quantity").length() < 1 || json.getString("quantity").length() > 14) {
			validation = errorResult;
		} else if (!json.getString("quantity").matches("^[0-9]+$")) {
			validation = errorResult;
		} else if (json.getString("skuCd").length() < 1 || json.getString("skuCd").length() > 20) {
			validation = errorResult;
		} else {
	        try {
	        	LocalDate.parse(json.getString("productionDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	        } catch (DateTimeParseException e) {
	        	validation = errorResult;
	        }
		}
		return validation;
	}

}