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
					session.setAttribute("user", user);
					
					request.setAttribute("username", user.getUsername());
					userService.saveSession(request);

					Cookie userCookie = new Cookie("user", user.getUsername());
					userCookie.setMaxAge(12*60);
					response.addCookie(userCookie);

					Cookie sessionCookie = new Cookie("sessionId", request.getSession().getId());
					sessionCookie.setMaxAge(12*60);
					response.addCookie(sessionCookie);
					
					page = "pages/menu.jsp";
				} else {
					request.setAttribute("message", "Invalid Username or Password");
					page = "pages/message.jsp";
				}
				
			} else if ("logout".equals(action)) {
				HttpSession session = request.getSession();
				session.invalidate();
				userService.deleteSession(request);

				Cookie userCookie = new Cookie("user", "");
				userCookie.setMaxAge(0);
				response.addCookie(userCookie);

				Cookie sessionCookie = new Cookie("sessionId", "");
				sessionCookie.setMaxAge(0);
				response.addCookie(sessionCookie);
				
				page = "pages/login.jsp";
				
			} else if ("checkUserSession".equals(action)) {
				HttpSession session = request.getSession();
				UserEntity user = (UserEntity) session.getAttribute("user");
				page = "pages/menu.jsp";
				
				if (user != null) {
					request.setAttribute("username", user.getUsername());
					
				} else {
					SessionEntity userSession = userService.validateSession(request);
					
					if (userSession != null) {
						request.setAttribute("username", userSession.getUsername());
						
					} else {
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
