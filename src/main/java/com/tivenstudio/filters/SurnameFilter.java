package com.tivenstudio.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/**
 * Servlet Filter implementation class SurnameFilter
 */
@WebFilter("/register")
public class SurnameFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String name = request.getParameter("surname");;

		if (name.length() > 40 || name.length() == 0) {
			request.setAttribute("wrong_surname", "Surname lenght exceeds 40 characters");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			
		} 
		else {
			chain.doFilter(request, response);
		}
	
	}

}
