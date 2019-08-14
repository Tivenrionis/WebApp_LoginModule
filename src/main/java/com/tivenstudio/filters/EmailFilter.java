package com.tivenstudio.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



/**
 * Servlet Filter implementation class EmailFilter
 */
@WebFilter("/register")
public class EmailFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String name = request.getParameter("email");


		if (name.contains("@")) {
			chain.doFilter(request, response);
			
		}  else {
		
			
		request.setAttribute("wrong_email", "Wrong email pattern");
		request.getRequestDispatcher("registration.jsp").forward(request, response);
			
		}
	
	}


}
