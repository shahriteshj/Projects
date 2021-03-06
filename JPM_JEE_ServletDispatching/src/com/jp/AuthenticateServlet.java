package com.jp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthenticateServlet
 */
@WebServlet("/authenticateServlet")
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		RequestDispatcher rd = null;

		if (username.equals("admin") && password.equals("password")) {
			rd = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
		} else {
			String errMsg = "Invalid Username or Password!!";
			request.setAttribute("errMsg", errMsg);
			rd = request.getRequestDispatcher("/WEB-INF/jsps/Login.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
