package com.jp;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
		while(headerNames.hasMoreElements()){
			String headerName = headerNames.nextElement();
			System.out.println( headerName + ": " + request.getHeader(headerName));
		}
		
		
		Iterator<String> resHeaderNamesIT = response.getHeaderNames().iterator();
		while(resHeaderNamesIT.hasNext())
		{
			System.out.println("in res for");
			String headerName = resHeaderNamesIT.next();
			System.out.println( headerName + ": " + response.getHeader(headerName));
		}
		
		
		String action = request.getParameter("action");

		RequestDispatcher rd = null;
		switch (action) {
		case "login":
			rd = request.getRequestDispatcher("/WEB-INF/jsps/Login.jsp");
			break;
		case "register":
			rd = request.getRequestDispatcher("/WEB-INF/jsps/Registration.jsp");
			break;
		case "authenticate":
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (username.equals("admin") && password.equals("password")) {
				rd = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
			} else {
				String errMsg = "Invalid Username or Password!!";
				request.setAttribute("errMsg", errMsg);
				rd = request.getRequestDispatcher("/WEB-INF/jsps/Login.jsp");
			}

			break;
		default:
			rd = request.getRequestDispatcher("/WEB-INF/jsps/Welcome.jsp");
			break;
		}
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
