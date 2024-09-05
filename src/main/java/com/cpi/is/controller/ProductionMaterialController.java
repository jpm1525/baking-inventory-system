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

import com.cpi.is.service.impl.ProductionMaterialServiceImpl;
import com.cpi.is.service.impl.RawMaterialListServiceImpl;
import com.cpi.is.service.impl.maintenance.MaterialCodeServiceImpl;
import com.cpi.is.util.SessionUtil;

/**
 * Servlet implementation class DashboardController
 */
@WebServlet("/ProductionMaterialController")
public class ProductionMaterialController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static String page = "";
    private static String action = "";
       
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private ProductionMaterialServiceImpl productionMaterialService = (ProductionMaterialServiceImpl) context.getBean("productionMaterialService");
	private MaterialCodeServiceImpl materialCodeService = (MaterialCodeServiceImpl) context.getBean("materialCodeService");
	private RawMaterialListServiceImpl rawMaterialListService = (RawMaterialListServiceImpl) context.getBean("rawMaterialListService");

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProductionMaterialController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (SessionUtil.checkUserSession(request)) {
				action = request.getParameter("action");
				if ("showProductionMaterial".equals(action)) {
					request.setAttribute("productionMaterial", new JSONArray(productionMaterialService.getData()));
					request.setAttribute("materialCode", new JSONArray(materialCodeService.getData()));
					request.setAttribute("rawMaterialList", new JSONArray(rawMaterialListService.getData()));
					page = "pages/productionMaterial.jsp";
				} else if ("saveData".equals(action)) {
					request.setAttribute("message", productionMaterialService.saveData(request));
					page = "pages/message.jsp";
				} else if ("deleteData".equals(action)) {
					request.setAttribute("message", productionMaterialService.deleteData(request));
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
