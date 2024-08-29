package com.cpi.is.service.impl.maintenance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.cpi.is.dao.impl.maintenance.SkuCodeDAOImpl;
import com.cpi.is.entity.maintenance.SkuCodeEntity;
import com.cpi.is.service.maintenance.SkuCodeService;

public class SkuCodeServiceImpl implements SkuCodeService {

	private SkuCodeDAOImpl skuCodeDAO;
	
	public SkuCodeDAOImpl getSkuCodeDAO() {
		return skuCodeDAO;
	}

	public void setSkuCodeDAO(SkuCodeDAOImpl skuCodeDAO) {
		this.skuCodeDAO = skuCodeDAO;
	}
	
	private SkuCodeEntity jsonToEntity(JSONObject json) {
		return new SkuCodeEntity(
				json.getString("skuCd"),
				json.getString("skuCodeName"),
				json.getString("unitOfMeasurement"));
	}

	@Override
	public List<SkuCodeEntity> getData() throws Exception {
		return skuCodeDAO.getData();
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		return skuCodeDAO.saveData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		return skuCodeDAO.deleteData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
	}

}
