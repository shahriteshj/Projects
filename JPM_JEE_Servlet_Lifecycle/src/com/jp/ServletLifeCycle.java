package com.jp;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifeCycle")
public class ServletLifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLifeCycle() {
		System.out.println("Message from constructor");
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Message from init(param)");
	}
	
	@Override
	public void init()  {
		System.out.println("Message from init()");
	}

	public void destroy() {
		System.out.println("Message from destroy");
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Message from service");
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Message from doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Message from doPost");
	}
	
	public void finalize(){
		System.out.println("Message from finalize");

	}

}
