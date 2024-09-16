package com.cpi.is.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.dao.impl.ReportDAOImpl;
import com.cpi.is.entity.report.CurrentFinishedInventoryEntity;
import com.cpi.is.entity.report.PlannedRawMaterialsInventoryEntity;
import com.cpi.is.entity.report.ProductionReportEntity;
import com.cpi.is.entity.report.ReceivedInventoryReportEntity;
import com.cpi.is.service.ReportService;

public class ReportServiceImpl implements ReportService {

	private ReportDAOImpl reportDAO;

	public ReportDAOImpl getReportDAO() {
		return reportDAO;
	}

	public void setReportDAO(ReportDAOImpl reportDAO) {
		this.reportDAO = reportDAO;
	}

	@Override
	public List<CurrentFinishedInventoryEntity> getCurrentFinishedInventory(HttpServletRequest request, Long branchId) 
			throws Exception {
		if(validateData(request.getParameter("reportDate")).equals("success")) {
			return reportDAO.getCurrentFinishedInventory(request.getParameter("reportDate"), branchId);
		} else {
			return reportDAO.getCurrentFinishedInventory(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), branchId);
		}
	}
	
	@Override
	public List<PlannedRawMaterialsInventoryEntity> getPlannedRawMaterialsInventory(HttpServletRequest request, Long branchId)
			throws Exception {
		if(validateData(request.getParameter("reportDate")).equals("success")) {
			return reportDAO.getPlannedRawMaterialsInventory(request.getParameter("reportDate"), branchId);
		} else {
			return reportDAO.getPlannedRawMaterialsInventory(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), branchId);
		}
	}

	@Override
	public List<ProductionReportEntity> getProductionReport(HttpServletRequest request, Long branchId) 
			throws Exception {
		if(validateData(request.getParameter("reportDate")).equals("success")) {
			return reportDAO.getProductionReport(request.getParameter("reportDate"), branchId);
		} else {
			return reportDAO.getProductionReport(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), branchId);
		}
		
	}

	@Override
	public List<ReceivedInventoryReportEntity> getReceivedInventoryReport(HttpServletRequest request, Long branchId) 
			throws Exception {
		if(validateData(request.getParameter("reportDate")).equals("success")) {
			return reportDAO.getReceivedInventoryReport(request.getParameter("reportDate"), branchId);
		} else {
			return reportDAO.getReceivedInventoryReport(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), branchId);
		}
	}
	
	public String validateData(String reportDate) throws Exception{
		String validation = "success";
		String errorResult = "Please fill-out the report generation form properly";
		
		if (reportDate == null) {
			validation = errorResult;
		} else {
	        try {
	        	LocalDate.parse(reportDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	        } catch (DateTimeParseException e) {
	        	validation = errorResult;
	        }
		}
		
		return validation;
	}
}