package com.jp.hr.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;
import com.jp.hr.services.ServiceEmployeeImpl;

/*
 * Front Controller: A JEE design pattern.
 * Command pattern (GoF pattern). 
 */

@WebServlet("*.do") //A generic url.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceEmployee services;
	
	@Override
	public void init() throws ServletException{
		try {
			services = new ServiceEmployeeImpl();
		} catch (HrException e) {
			throw new ServletException("Init method failed.", e);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =getCommand(request.getRequestURI());
		RequestDispatcher dispatch = null;
		String jspName = null;
		String preFix = "/WEB-INF/jsps/";
		String postFix = ".jsp";
		
		try {
			switch (command) {
			case "*":
			case "home": {
				jspName = "Home";
				break;
			}
			case "login": {
				jspName = "Login";
				break;
			}
			case "authenticate": {
				String userName = request.getParameter("username");
				String password = request.getParameter("password");

				if (userName.equals("a") && password.equals("a")) {
					String userFullName = "aaaaa aaaa aaaa";
					HttpSession session = request.getSession();
					session.setAttribute("userFullName", userFullName);
					jspName = "MainMenu";

				} else {
					String msg = "Wrong credentials. Pls enter again";
					request.setAttribute("message", msg);
					jspName = "Login";
				}

				break;
			}

			case "logout": {
				HttpSession session = request.getSession();
				request.setAttribute("userFullName", session.getAttribute("userFullName"));
				session.invalidate();
				jspName = "ThanksPage";
				break;
			}

			case "mainMenu": {
				jspName = "MainMenu";
				break;
			}
			case "empList":{
				ArrayList<Employee> empList = services.getEmpList();
				// System.out.println(empList);
				request.setAttribute("empList", empList);
				jspName = "EmpList";
				break;
			}
			case "empDetails": {
				String idStr = request.getParameter("id"); // empDetails.do?id=x
				int empId = Integer.parseInt(idStr);
				Employee emp = services.getEmpDetails(empId);
				request.setAttribute("empDetails", emp);
				jspName = "EmpDetails";
				break;
			}
			case "newJoining": {
				jspName = "NewJoining";
				break;
			}
			case "submitJoinee": {
				String empIdStr = request.getParameter("empId");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				int empId = Integer.parseInt(empIdStr);
				Employee emp = new Employee(empId, firstName, lastName);
				boolean isSuccessfull = services.addNewEmployee(emp);
				String msg = isSuccessfull ? "Employee Inserted." : "Insertion Failed";
				request.setAttribute("message", msg);
				jspName = "NewJoining";
				break;
			}
			}
		} catch (HrException e) {
			e.printStackTrace();
		}
		dispatch = request.getRequestDispatcher(preFix + jspName + postFix);
		dispatch.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String getCommand(String uri){
		int leftPosi = uri.lastIndexOf("/");
		int rtPosi = uri.lastIndexOf(".");

		if (leftPosi == -1 || rtPosi == -1) {
			return "mainMenu";
		} else {
			return uri.substring(leftPosi + 1, rtPosi);
		}
}
}
