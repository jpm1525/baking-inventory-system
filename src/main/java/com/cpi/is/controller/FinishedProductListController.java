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

import com.cpi.is.service.impl.FinishedProductListServiceImpl;
import com.cpi.is.service.impl.maintenance.BranchServiceImpl;
import com.cpi.is.service.impl.maintenance.SkuCodeServiceImpl;
import com.cpi.is.util.SessionUtil;

/**
 * Servlet implementation class DashboardController
 */
@WebServlet("/FinishedProductListController")
public class FinishedProductListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static String page = "";
    private static String action = "";
       
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private FinishedProductListServiceImpl finishedProductListService = (FinishedProductListServiceImpl) context.getBean("finishedProductListService");
	private SkuCodeServiceImpl skuCodeService = (SkuCodeServiceImpl) context.getBean("skuCodeService");

	/**
     * @see HttpServlet#HttpServlet()
     */
    public FinishedProductListController() {
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
				
				if ("showFinishedProductList".equals(action)) {
					request.setAttribute("finishedProductList", new JSONArray(finishedProductListService.getData(branchId)));
					request.setAttribute("sku", new JSONArray(skuCodeService.getData()));
					request.setAttribute("userId", session.getAttribute("userId").toString());
					request.setAttribute("branchIdUser", branchId);
					request.setAttribute("branchNameUser", session.getAttribute("branchName").toString());
					page = "pages/finishedProductList.jsp";
				} else if ("saveData".equals(action)) {
					request.setAttribute("message", finishedProductListService.saveData(request));
					page = "pages/message.jsp";
				} else if ("deleteData".equals(action)) {
					request.setAttribute("message", finishedProductListService.deleteData(request));
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
