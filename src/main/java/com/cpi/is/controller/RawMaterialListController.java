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

import com.cpi.is.service.impl.RawMaterialListServiceImpl;
import com.cpi.is.service.impl.maintenance.BranchServiceImpl;
import com.cpi.is.service.impl.maintenance.MaterialCodeServiceImpl;
import com.cpi.is.util.SessionUtil;

/**
 * Controller for handling requests related to raw material lists.
 * Maps to the /RawMaterialListController endpoint.
 */
@WebServlet("/RawMaterialListController")
public class RawMaterialListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    // Variables for navigation and action control
    private static String page = "";
    private static String action = "";

    // Load Spring beans from beans.xml
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private RawMaterialListServiceImpl rawMaterialListService = (RawMaterialListServiceImpl) context.getBean("rawMaterialListService");
	private MaterialCodeServiceImpl materialCodeService = (MaterialCodeServiceImpl) context.getBean("materialCodeService");
	private BranchServiceImpl branchService = (BranchServiceImpl) context.getBean("branchService");

	/**
     * @see HttpServlet#HttpServlet()
     */
    public RawMaterialListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Check if user session is active
			if (SessionUtil.checkUserSession(request)) {
				action = request.getParameter("action");
				HttpSession session = request.getSession();
				Long branchId = Long.parseLong(session.getAttribute("branchId").toString());

				// If action is "showRawMaterialList", fetch the data and set it in the request attributes
				if ("showRawMaterialList".equals(action)) {
					// Populate raw material list and related data
					request.setAttribute("rawMaterialList", new JSONArray(rawMaterialListService.getData(branchId)));
					request.setAttribute("materialCode", new JSONArray(materialCodeService.getData()));
					request.setAttribute("branchId", new JSONArray(branchService.getData()));
					request.setAttribute("userId", session.getAttribute("userId").toString());
					request.setAttribute("branchIdUser", branchId);
					page = "pages/rawMaterialList.jsp";
				} else if ("saveData".equals(action)) {
					request.setAttribute("message", rawMaterialListService.saveData(request));
					page = "pages/message.jsp";
				} else if ("deleteData".equals(action)) {
					request.setAttribute("message", rawMaterialListService.deleteData(request));
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
