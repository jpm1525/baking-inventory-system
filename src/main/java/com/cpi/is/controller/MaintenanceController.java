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

import com.cpi.is.service.impl.maintenance.DispatchTypeServiceImpl;
import com.cpi.is.service.impl.maintenance.SkuCodeServiceImpl;
import com.cpi.is.service.impl.maintenance.UserMaintenanceServiceImpl;
import com.cpi.is.util.SessionUtil;
import com.cpi.is.service.impl.maintenance.BranchServiceImpl;
import com.cpi.is.service.impl.maintenance.MaterialCodeServiceImpl;

/**
 * Servlet implementation class MaintenanceController
 */
@WebServlet("/MaintenanceController")
public class MaintenanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String page = "";
    private static String action = "";      
    
	private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private DispatchTypeServiceImpl dispatchTypeService = (DispatchTypeServiceImpl) context.getBean("dispatchTypeService");
	private BranchServiceImpl branchService = (BranchServiceImpl) context.getBean("branchService");
	private SkuCodeServiceImpl skuCodeService = (SkuCodeServiceImpl) context.getBean("skuCodeService");
	private MaterialCodeServiceImpl materialCodeService = (MaterialCodeServiceImpl) context.getBean("materialCodeService");
	private UserMaintenanceServiceImpl userMaintenanceService = (UserMaintenanceServiceImpl) context.getBean("userMaintenanceService");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaintenanceController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if (SessionUtil.checkUserSession(request)) {
			
				action = request.getParameter("action");
				
				if("showMaintenance".equals(action)) {
					page = "pages/maintenance.jsp";
				} else if("showDispatch".equals(action)) {
					request.setAttribute("dispatchType", new JSONArray(dispatchTypeService.getData()));
					page = "pages/maintenance/dispatch.jsp";
				} else if ("saveDispatchData".equals(action)) {
					request.setAttribute("message", dispatchTypeService.saveData(request));
					page = "pages/message.jsp";
				} else if ("deleteDispatchData".equals(action)) {
					request.setAttribute("message", dispatchTypeService.deleteData(request));
					page = "pages/message.jsp";
				} else if("showBranches".equals(action)) {
					request.setAttribute("branch",new JSONArray(branchService.getData()));
					page = "pages/maintenance/branch.jsp";
				} else if ("saveBranchData".equals(action)) {
					request.setAttribute("message", branchService.saveData(request));
					page = "pages/message.jsp";
				} else if ("deleteBranchData".equals(action)) {
					request.setAttribute("message", branchService.deleteData(request));
					page = "pages/message.jsp";
				} else if("showSkuCodes".equals(action)) {
					request.setAttribute("skuCode",new JSONArray(skuCodeService.getData()));
					page = "pages/maintenance/skuCode.jsp";
				} else if ("saveSkuCodeData".equals(action)) {
					request.setAttribute("message", skuCodeService.saveData(request));
					page = "pages/message.jsp";
				} else if ("deleteSkuCodeData".equals(action)) {
					request.setAttribute("message", skuCodeService.deleteData(request));
					page = "pages/message.jsp";
				} else if("showMaterialCodes".equals(action)) {
					request.setAttribute("materialCode",new JSONArray(materialCodeService.getData()));
					page = "pages/maintenance/materialCode.jsp";
				} else if ("saveMaterialCodeData".equals(action)) {
					request.setAttribute("message", materialCodeService.saveData(request));
					page = "pages/message.jsp";
				} else if ("deleteMaterialCodeData".equals(action)) {
					request.setAttribute("message", materialCodeService.deleteData(request));
					page = "pages/message.jsp";
				} else if ("showUserMain".equals(action)) {
					request.setAttribute("userMain",new JSONArray(userMaintenanceService.getData()));
					page = "pages/maintenance/userMaintenance.jsp";
				} else if ("saveUserMaintenanceData".equals(action)) {
					request.setAttribute("message", userMaintenanceService.saveData(request));
					page = "pages/message.jsp";
				} else if ("deleteUserMaintenanceData".equals(action)) {
					request.setAttribute("message", userMaintenanceService.deleteData(request));
					page = "pages/message.jsp";
				}
				
			} else {
					page = "pages/reload.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(page).forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
