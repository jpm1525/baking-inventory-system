package com.cpi.is.service.impl;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.cpi.is.dao.impl.DispatchingDAOImpl;
import com.cpi.is.entity.DispatchingEntity;
import com.cpi.is.service.DispatchingService;

public class DispatchingServiceImpl implements DispatchingService {
	
	private DispatchingDAOImpl dispatchingDAO;
	
	public DispatchingDAOImpl getDispatchingDAO() {
		return dispatchingDAO;
	}

	public void setDispatchingDAO(DispatchingDAOImpl dispatchingDAO) {
		this.dispatchingDAO = dispatchingDAO;
	}
	
	private DispatchingEntity jsonToEntity(JSONObject json) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date dispatchDate = null;
	    try {
	        dispatchDate = dateFormat.parse(json.getString("dispatchDate"));
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
		return new DispatchingEntity(
				Long.parseLong(json.getString("dispatchTrackId")),
				json.getString("dispatchTypeCd"),
				json.getString("fplId"),
				Long.parseLong(json.getString("quantity")),
				Long.parseLong(json.getString("branchId")),
				json.getString("destination"),
				dispatchDate);
	}
	
	@Override
	public List<DispatchingEntity> getData() throws Exception {
		// TODO Auto-generated method stub
		return dispatchingDAO.getData();
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String validation = validateData(request);
		if(validation.equals("Success")) {		
			return dispatchingDAO.saveData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return validation;
		}
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String validation = validateData(request);
		if(validation.equals("Success")) {
			return dispatchingDAO.deleteData(
					jsonToEntity(new JSONObject(request.getParameter("data"))));
		} else {
			return "Unable to delete data";
		}
	}
	
	public String validateData(HttpServletRequest request) throws Exception{
		JSONObject json = new JSONObject(request.getParameter("data"));
		String validation = "Success";
		
		if (!json.has("dispatchTrackId") || !(json.get("dispatchTrackId") instanceof String)) {
			validation = "Please fill-out the dispatching form properly";
		} else if (!json.has("dispatchTypeCd") || !(json.get("dispatchTypeCd") instanceof String)) {
			validation = "Please fill-out the dispatching form properly";
		} else if (!json.has("fplId") || !(json.get("fplId") instanceof String)) {
			validation = "Please fill-out the dispatching form properly";
		} else if (!json.has("quantity") || !(json.get("quantity") instanceof String)) {
			validation = "Please fill-out the dispatching form properly";
		} else if (!json.has("branchId") || !(json.get("branchId") instanceof String)) {
			validation = "Please fill-out the dispatching form properly";
		} else if (!json.has("destination") || !(json.get("destination") instanceof String)) {
			validation = "Please fill-out the dispatching form properly";
		} else if (!json.has("dispatchDate") || !(json.get("dispatchDate") instanceof String)) {
			validation = "Please fill-out the dispatching form properly";
		} else if (json.getString("dispatchTrackId").length() < 1 || json.getString("dispatchTrackId").length() > 14) {
			validation = "Please fill-out the dispatching form properly";
		} else if (!json.getString("dispatchTrackId").matches("^[0-9]\\d*$")) {
			validation = "Please fill-out the dispatching form properly";
		} else if (json.getString("fplId").length() < 1 || json.getString("fplId").length() > 14) {
			validation = "Please fill-out the dispatching form properly";
		} else if (!json.getString("fplId").matches("^[1-9]\\d*$")) {
			validation = "Please fill-out the dispatching form properly";
		} else if (json.getString("quantity").length() < 1 || json.getString("quantity").length() > 14) {
			validation = "Please fill-out the dispatching form properly";
		} else if (!json.getString("quantity").matches("^[0-9]+$")) {
			validation = "Please fill-out the dispatching form properly";
		} else if (json.getString("branchId").length() < 1 || json.getString("branchId").length() > 14) {
			validation = "Please fill-out the dispatching form properly";
		} else if (!json.getString("branchId").matches("^[1-9]\\d*$")) {
			validation = "Please fill-out the dispatching form properly";
		} else if (json.getString("dispatchTypeCd").length() < 1 || json.getString("dispatchTypeCd").length() > 10) {
			validation = "Please fill-out the dispatching form properly";
		} else if (json.getString("destination").length() < 1 || json.getString("destination").length() > 50) {
			validation = "Please fill-out the dispatching form properly";
		} else {
	        try {
	        	LocalDate.parse(json.getString("dispatchDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	        } catch (DateTimeParseException e) {
	        	validation = "Please fill-out the dispatching form properly";
	        }
		}
		
		return validation;
	}

}
