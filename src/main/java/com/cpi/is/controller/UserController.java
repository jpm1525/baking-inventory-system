package com.cpi.is.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cpi.is.entity.SessionEntity;
import com.cpi.is.entity.UserEntity;
import com.cpi.is.service.impl.UserServiceImpl;
import com.cpi.is.util.CookieUtil;
import com.cpi.is.util.SessionUtil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String page = "";
    private static String action = "";
    
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			action = request.getParameter("action");
			if ("login".equals(action)) {
				UserEntity user = userService.authenticate(request);
				if (user != null) {
					HttpSession session = request.getSession();
					
					session.setAttribute("username", user.getUsername());
					session.setAttribute("userId", user.getUserId());
					session.setAttribute("branchId", user.getBranchId());
					
					request.setAttribute("username", user.getUsername());
					userService.saveSession(request);

					Cookie userCookie = new Cookie("username", user.getUsername());
					userCookie.setMaxAge(12*60);
					response.addCookie(userCookie);

					Cookie sessionCookie = new Cookie("sessionId", request.getSession().getId());
					sessionCookie.setMaxAge(12*60);
					response.addCookie(sessionCookie);
					
					page = "pages/inner-pages/mainMenu.jsp";
				} else {
					request.setAttribute("message", "Invalid Username or Password");
					page = "pages/message.jsp";
				}
				
			} else if ("logout".equals(action)) {
				HttpSession session = request.getSession();
				session.invalidate();
				userService.deleteSession(request);

	 			Cookie userCookie = new Cookie("username", "");
				userCookie.setMaxAge(0);
				response.addCookie(userCookie);

				Cookie sessionCookie = new Cookie("sessionId", "");
				sessionCookie.setMaxAge(0);
				response.addCookie(sessionCookie);
				
				page = "pages/login.jsp";
				
			} else if ("checkUserSession".equals(action)) {
				if (SessionUtil.checkUserSession(request)) {
					page = "pages/inner-pages/mainMenu.jsp";
				}else{
					HttpSession session = request.getSession();
					
					session.setAttribute("username", CookieUtil.getCookieValue(request.getCookies(), "username"));
					
					if(SessionUtil.checkUserSession(request)) {
						request.setAttribute("username", session.getAttribute("username"));
						userService.saveSession(request);
						userService.deleteSession(request);
						Cookie sessionCookie = new Cookie("sessionId", request.getSession().getId());
						sessionCookie.setMaxAge(12*60);
						response.addCookie(sessionCookie);
						
						page = "pages/inner-pages/mainMenu.jsp";
					}else {
						page = "pages/login.jsp";
					}
				}
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