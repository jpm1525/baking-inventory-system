package com.cpi.is.service.impl;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.cpi.is.dao.impl.FinishedProductListDAOImpl;
import com.cpi.is.entity.FinishedProductListEntity;
import com.cpi.is.service.FinishedProductListService;

public class FinishedProductListServiceImpl implements FinishedProductListService {

	private FinishedProductListDAOImpl finishedProductListDAO;

	public FinishedProductListDAOImpl getFinishedProductListDAO() {
		return finishedProductListDAO;
	}

	public void setFinishedProductListDAO(FinishedProductListDAOImpl finishedProductListDAO) {
		this.finishedProductListDAO = finishedProductListDAO;
	}

	private FinishedProductListEntity jsonToEntity(JSONObject json) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(json.getString("dateFinished"));
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new FinishedProductListEntity(Long.parseLong(json.getString("fplId")), json.getString("skuCd"),
				Long.parseLong(json.getString("quantity")), Long.parseLong(json.getString("branchId")), date1);
	}

	@Override
	public List<FinishedProductListEntity> getData(Long branchId) throws Exception {
		List<FinishedProductListEntity> finishedProductLists = finishedProductListDAO.getData(branchId);
		return finishedProductLists;
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		String validation = validateData(request);
		String results = "";

		if (validation.equals("success")) {
			try {
				results = finishedProductListDAO.saveData(jsonToEntity(
						new JSONObject(request.getParameter("data"))));
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (results.equals("success")) {
				return results;
			} else {
				return "Unable to save Finished Product List Data";
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
				results = finishedProductListDAO.deleteData(jsonToEntity(
						new JSONObject(request.getParameter("data"))));
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (results.equals("success")) {
				return results;
			} else {
				return "Unable to delete Finished Product List Data";
			}
		} else {
			return "Unable to delete Finished Product List data";
		}
	}

	public String validateData(HttpServletRequest request) throws Exception {
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "success";
		String errorResult = "Please fill-out the finished product list form properly";

		if (!json.has("fplId") || !(json.get("fplId") instanceof String)) {
			validation = errorResult + " 1";
		} else if (!json.has("skuCd") || !(json.get("skuCd") instanceof String)) {
			validation = errorResult + " 2";
		} else if (!json.has("quantity") || !(json.get("quantity") instanceof String)) {
			validation = errorResult + " 3";
		} else if (!json.has("branchId") || !(json.get("branchId") instanceof String)) {
			validation = errorResult + " 4";
		} else if (!json.has("dateFinished") || !(json.get("dateFinished") instanceof String)) {
			validation = errorResult + " 5";
		} else if (json.getString("fplId").length() < 1 || json.getString("fplId").length() > 14) {
			validation = errorResult + " 6";
		} else if (!json.getString("fplId").matches("^[0-9]+$")) {
			validation = errorResult + " 7";
		} else if (json.getString("skuCd").length() < 1 || json.getString("skuCd").length() > 10) {
			validation = errorResult + " 8";
		} else if (json.getString("quantity").length() < 1 || json.getString("quantity").length() > 14) {
			validation = errorResult + " 9";
		} else if (!json.getString("quantity").matches("^[0-9]+$")) {
			validation = errorResult + " 10";
		} else if (json.getString("branchId").length() < 1 || json.getString("branchId").length() > 14) {
			validation = errorResult + " 11";
		} else if (!json.getString("branchId").matches("^[1-9]\\d*$")) {
			validation = errorResult + " 12";
		} else {
			try {
				LocalDate.parse(json.getString("dateFinished"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			} catch (DateTimeParseException e) {
				validation = errorResult + " 13";
			}
		}
		return validation;
	}

	public Long getFinishedCount(Long branchId) throws Exception {
	    return finishedProductListDAO.getFinishedCount(branchId);
	}
}
