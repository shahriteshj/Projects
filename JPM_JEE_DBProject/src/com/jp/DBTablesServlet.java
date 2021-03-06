package com.jp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.db.ConnectionUtil;

/**
 * Servlet implementation class DBTablesServlet
 */
@WebServlet("/DBTablesServlet")
public class DBTablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> tablesList = new ArrayList<String>();
		
		ConnectionUtil connUtil = new ConnectionUtil();
		tablesList = connUtil.getDatabaseTables();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<h1>Table List</h1>");
		Iterator<String> tableIt = tablesList.iterator();
		while(tableIt.hasNext()){
			String tableName = tableIt.next();
			out.write("<a href='/DBProject/DBTableServlet?tableName=" + tableName + "' >"+tableName + "</a>");
			out.write("<br/>");
		}
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
