package com.jp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCokies
 */
@WebServlet("/createCookies")
public class CreateCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("c1","Session-Cookie");
		Cookie cookie2 = new Cookie("c2","Persistent-Cookie");
		cookie2.setMaxAge(120); //in secs
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.sendRedirect("showCookies");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
