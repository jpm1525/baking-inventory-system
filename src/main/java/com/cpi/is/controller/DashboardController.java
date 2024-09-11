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

import com.cpi.is.entity.SessionEntity;
import com.cpi.is.entity.UserEntity;
import com.cpi.is.service.impl.maintenance.BranchServiceImpl;
import com.cpi.is.util.SessionUtil;

/**
 * Servlet implementation class DashboardController
 */
@WebServlet("/DashboardController")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String page = "";
    private static String action = "";
    
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private BranchServiceImpl branchService = (BranchServiceImpl) context.getBean("branchService");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			if (SessionUtil.checkUserSession(request)) {
				HttpSession session = request.getSession();
				action = request.getParameter("action");

				if ("showDashboard".equals(action)) {
					request.setAttribute("branchName", session.getAttribute("branchName").toString());
					request.setAttribute("userId", session.getAttribute("userId").toString());
					request.setAttribute("username", session.getAttribute("username").toString());
					request.setAttribute("branchId", session.getAttribute("branchId").toString());
					page = "pages/dashboard.jsp";
				} else {
					page = "pages/reload.jsp";
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