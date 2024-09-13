package com.cpi.is.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpi.is.service.impl.ReportServiceImpl;
import com.cpi.is.util.EscapeUtil;
import com.cpi.is.util.SessionUtil;

/**
 * Servlet implementation class ReportController
 */
@WebServlet("/ReportGenerationController")
public class ReportGenerationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static String action = "";
	private static String page = "";
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private ReportServiceImpl reportService = (ReportServiceImpl) context.getBean("reportService");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportGenerationController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (SessionUtil.checkUserSession(request)) {
				action = request.getParameter("action");
				
				if ("showReportGeneration".equals(action)) {
					page = "pages/reportGeneration.jsp";
					
				} else if ("showReportFinished".equals(action)) {
					request.setAttribute("defaultDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					page = "pages/reports/reportsFinished.jsp";
					
				} else if ("getReportFinished".equals(action)) {
					request.setAttribute("message", EscapeUtil.escapeQuotes(new JSONArray(reportService.getCurrentFinishedInventory(request))));
					page = "pages/message.jsp";
					
				} else if ("showReportPlanned".equals(action)) {
					request.setAttribute("defaultDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					page = "pages/reports/reportsPlanned.jsp";
					
				} else if ("getReportPlanned".equals(action)) {
					request.setAttribute("message", EscapeUtil.escapeQuotes(new JSONArray(reportService.getPlannedRawMaterialsInventory(request))));
					page = "pages/message.jsp";
					
				} else if ("showReportProduction".equals(action)) {
					request.setAttribute("defaultDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					page = "pages/reports/reportsProduction.jsp";
					
				} else if ("getReportProduction".equals(action)) {
					request.setAttribute("message", EscapeUtil.escapeQuotes(new JSONArray(reportService.getProductionReport(request))));
					page = "pages/message.jsp";
					
				} else if ("showReportReceived".equals(action)) {
					request.setAttribute("defaultDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					page = "pages/reports/reportsReceived.jsp";
					
				} else if ("getReportReceived".equals(action)) {
					request.setAttribute("message", EscapeUtil.escapeQuotes(new JSONArray(reportService.getReceivedInventoryReport(request))));
					page = "pages/message.jsp";
				}
			} else {
				page = "pages/reload.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage().contains("Cannot invoke *hibernate")) {
				request.setAttribute("message", "Unable to connect to database");
			} else {
				request.setAttribute("message", "Something went wrong");
			}
			page = "pages/message.jsp";
		} finally {
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}