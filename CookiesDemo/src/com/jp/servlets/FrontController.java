package com.jp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("pg");
		Cookie[] cookies;
		RequestDispatcher dispatch = null;
		switch (page) {
		case "Welcome": {
			cookies = request.getCookies();
			dispatch = request.getRequestDispatcher("/WEB-INF/jsps/Welcome.jsp");
			for(Cookie c:cookies){
				if(c.getName().equals("bypassPage")){
					dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
					break;
				}
			}
			
			dispatch.forward(request, response);
			break;
		}
		case "Menu": {
			String isBoxChecked = request.getParameter("ToBypass");
			System.out.println(isBoxChecked);
			if(isBoxChecked!=null && isBoxChecked.equalsIgnoreCase("yes")){
				Cookie cookie = new Cookie("bypassPage","");
				cookie.setMaxAge(60*60*48);
				response.addCookie(cookie);
			}
			dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
			dispatch.forward(request, response);
			break;
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
