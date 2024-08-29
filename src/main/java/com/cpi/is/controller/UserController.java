package com.cpi.is.controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    
    private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
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
					Cookie cookie = new Cookie("user", user.getUsername());
					cookie.setMaxAge(24*60*60);
					response.addCookie(cookie);
					request.setAttribute("username", user.getUsername());
					page = "pages/innerPages/mainMenu.jsp";
				}	else {
					request.setAttribute("message", "Invalid Username or Password");
					page = "pages/message.jsp";
				}
				
			} else if ("logout".equals(action)) {
				Cookie cookie = new Cookie("user","");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				page = "pages/login.jsp";
			}else if ("checkUserCookie".equals(action)) {
				Cookie [] cookies = request.getCookies();
				request.setAttribute("message", "No existing user cookie");
				page = "pages/message.jsp";
				
				if (cookies != null) {
					for(Cookie cookie : cookies) {
						request.setAttribute("username", cookie.getValue());
						break;
					}
				}
			}
		} catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
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
