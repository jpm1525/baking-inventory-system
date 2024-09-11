package com.cpi.is.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpi.is.entity.SessionEntity;
import com.cpi.is.entity.UserEntity;
import com.cpi.is.service.impl.UserServiceImpl;

public class SessionUtil {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private static UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
	
	public static Boolean checkUserSession(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		SessionEntity userSession = new SessionEntity();
		Boolean exist = true;
		
		if(session.getAttribute("username") != null) {
			request.setAttribute("username", session.getAttribute("username"));
			userSession = userService.validateSession(request);
			if (userSession == null) {
				exist = false;
			}else {
				UserEntity user = userService.getUser(session.getAttribute("username").toString());
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("branchId", user.getBranchId());
				session.setAttribute("branchName", user.getBranch().getBranchName());			
			}
		} else {
			exist = false;
		}
		return exist;
	}
	
}