package com.cpi.is.service.impl;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		return rawMaterialListDAO.saveData(
				jsonToEntity(new JSONObject(request.getParameter("item"))));
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		return rawMaterialListDAO.deleteData(
				jsonToEntity(new JSONObject(request.getParameter("item"))));
	}

}
