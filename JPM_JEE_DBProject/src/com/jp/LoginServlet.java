package com.jp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.db.ConnectionUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("txtName");
		String password = request.getParameter("txtPassword");

		ConnectionUtil connUtil = new ConnectionUtil();

		PrintWriter out = response.getWriter();
		if (connUtil.UserExists(userName, password)) {
			// response.setContentType("text/html");
			// out.write("<h1>Valid user</h1>");
			// out.flush();
			response.sendRedirect("/DBProject/DBTablesServlet");
		} else {
			response.setContentType("text/html");
			out.write("<h1>Invalid user</h1>");
			out.flush();
		}

	}

}
