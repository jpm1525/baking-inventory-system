package com.cpi.is.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public List<DispatchingEntity> getData(Integer branchId) throws Exception {
		// TODO Auto-generated method stub
		return dispatchingDAO.getData(branchId);
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return dispatchingDAO.saveData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return dispatchingDAO.deleteData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
	}

}
