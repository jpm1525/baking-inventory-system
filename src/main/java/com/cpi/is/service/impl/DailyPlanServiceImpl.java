package com.cpi.is.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public List<DailyPlanEntity> getData() throws Exception {
		return dailyPlanDAO.getData();
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		return dailyPlanDAO.saveData(
				jsonToEntity(new JSONObject(request.getParameter("item"))));
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		return dailyPlanDAO.deleteData(
				jsonToEntity(new JSONObject(request.getParameter("item"))));
	}

}