package com.cpi.is.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpi.is.service.impl.DispatchingServiceImpl;
import com.cpi.is.service.impl.maintenance.BranchServiceImpl;
import com.cpi.is.service.impl.maintenance.DispatchTypeServiceImpl;
import com.cpi.is.service.impl.maintenance.SkuCodeServiceImpl;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/DispatchingController")
public class DispatchingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String page = "";
    private static String action = "";
    
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private DispatchingServiceImpl dispatchingService = (DispatchingServiceImpl) context.getBean("dispatchingService");
	private DispatchTypeServiceImpl dispatchTypeService = (DispatchTypeServiceImpl) context.getBean("dispatchTypeService");
	private BranchServiceImpl branchService = (BranchServiceImpl) context.getBean("branchService");
	private SkuCodeServiceImpl skuCodeService = (SkuCodeServiceImpl) context.getBean("skuCodeService");

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchingController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			action = request.getParameter("action");
			
			if ("showDispatching".equals(action)) {
				request.setAttribute("dispatching", new JSONArray(dispatchingService.getData()));
				request.setAttribute("dispatchType", new JSONArray(dispatchTypeService.getData()));
				request.setAttribute("branch",new JSONArray(branchService.getData()));
				request.setAttribute("skuCode",new JSONArray(skuCodeService.getData()));
				page = "pages/dispatching.jsp";
			} else if ("saveData".equals(action)) {
				request.setAttribute("message", dispatchingService.saveData(request));
				page = "pages/message.jsp";
			} else if ("deleteData".equals(action)) {
				request.setAttribute("message", dispatchingService.deleteData(request));
				page = "pages/message.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
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
