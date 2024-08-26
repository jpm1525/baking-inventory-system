package com.cpi.is.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SupplierController
 */
@WebServlet("/ReportGenerationController")
public class ReportGenerationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String page = "";
    private static String action = "";      
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
		
		action = request.getParameter("action");
		
		if("showReportGeneration".equals(action)) {
			page = "pages/reportgeneration.jsp";
		}
		request.getRequestDispatcher(page).forward(request,response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
