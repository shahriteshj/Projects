package com.jp.shopping.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LayoutFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "*.do" })
public class LayoutFilter implements Filter {

 
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/Header.jsp");
		dispatch.include(request, response);

		
		chain.doFilter(request, response);
		
		RequestDispatcher dispatch1 = request.getRequestDispatcher("/WEB-INF/jsps/Footer.jsp");
		dispatch1.include(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}


	
}
