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
		UserEntity user = (UserEntity) session.getAttribute("user");
		Boolean exist = true;
		if (user != null) {
			request.setAttribute("username", user.getUsername());
			request.setAttribute("userId", user.getUserId());
			request.setAttribute("branchId", user.getBranchId());
			request.setAttribute("branch", user.getBranch());

		} else {
			UserEntity userSession = userService.validateSession(request);
			if (userSession != null) {
				request.setAttribute("username", userSession.getUsername());
				request.setAttribute("userId", userSession.getUserId());
				request.setAttribute("branchId", userSession.getBranchId());
				request.setAttribute("branch", userSession.getBranch());

			} else {
				exist = false;
			}
		}
		return exist;
	}
	
}