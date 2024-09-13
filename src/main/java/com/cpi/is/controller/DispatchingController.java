package com.cpi.is.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpi.is.service.impl.DispatchingServiceImpl;
import com.cpi.is.service.impl.FinishedProductListServiceImpl;
import com.cpi.is.service.impl.maintenance.DispatchTypeServiceImpl;
import com.cpi.is.util.EscapeUtil;
import com.cpi.is.util.SessionUtil;

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
	private FinishedProductListServiceImpl finishedProductListService = (FinishedProductListServiceImpl) context.getBean("finishedProductListService");

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
			
			if (SessionUtil.checkUserSession(request)) {
			
				action = request.getParameter("action");
				HttpSession session = request.getSession();
				Long branchId = Long.parseLong(session.getAttribute("branchId").toString());
		
				if ("showDispatching".equals(action)) {
					request.setAttribute("dispatching", EscapeUtil.escapeQuotes(new JSONArray(dispatchingService.getData(branchId))));
					request.setAttribute("dispatchType", EscapeUtil.escapeQuotes(new JSONArray(dispatchTypeService.getData())));
					request.setAttribute("finishedProductList",EscapeUtil.escapeQuotes(new JSONArray(finishedProductListService.getData(branchId))));
					request.setAttribute("branchIdUser", branchId);
					request.setAttribute("branchNameUser", session.getAttribute("branchName").toString());
					page = "pages/dispatching.jsp";
				} else if ("saveData".equals(action)) {
					request.setAttribute("message", dispatchingService.saveData(request, finishedProductListService.getData(branchId)));
					page = "pages/message.jsp";
				} else if ("deleteData".equals(action)) {
					request.setAttribute("message", dispatchingService.deleteData(request));
					page = "pages/message.jsp";
				}
			} else {
				page = "pages/reload.jsp";
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
