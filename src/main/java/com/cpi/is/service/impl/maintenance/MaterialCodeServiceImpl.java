package com.cpi.is.service.impl.maintenance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.cpi.is.dao.impl.maintenance.MaterialCodeDAOImpl;
import com.cpi.is.entity.maintenance.MaterialCodeEntity;
import com.cpi.is.service.maintenance.MaterialCodeService;

public class MaterialCodeServiceImpl implements MaterialCodeService {

	private MaterialCodeDAOImpl materialCodeDAO;
	
	public MaterialCodeDAOImpl getMaterialCodeDAO() {
		return materialCodeDAO;
	}

	public void setMaterialCodeDAO(MaterialCodeDAOImpl materialCodeDAO) {
		this.materialCodeDAO = materialCodeDAO;
	}
	
	private MaterialCodeEntity jsonToEntity(JSONObject json) {
		return new MaterialCodeEntity(
				json.getString("materialCd"),
				json.getString("materialCodeName"),
				json.getString("unitOfMeasurement"));
	}

	@Override
	public List<MaterialCodeEntity> getData() throws Exception {
		return materialCodeDAO.getData();
	}

	@Override
	public String saveData(HttpServletRequest request) throws Exception {
		return materialCodeDAO.saveData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
	}

	@Override
	public String deleteData(HttpServletRequest request) throws Exception {
		return materialCodeDAO.deleteData(
				jsonToEntity(new JSONObject(request.getParameter("data"))));
	}

}
