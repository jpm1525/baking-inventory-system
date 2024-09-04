package com.cpi.is.service.maintenance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.entity.maintenance.BranchEntity;

public interface BranchService {
	
	List<BranchEntity> getData() throws Exception;
	String saveData(HttpServletRequest request) throws Exception;
	String deleteData(HttpServletRequest request) throws Exception;
	String validateData(HttpServletRequest request) throws Exception;
	
}
