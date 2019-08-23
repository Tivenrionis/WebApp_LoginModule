package com.tivenstudio.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class PasswordFilter
 */
@WebFilter("/register")
public class PasswordFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String pass = request.getParameter("pwd");
		String pass2 = request.getParameter("pwd_validate");
	
		if(pass.equals(pass2))
		{
		
			chain.doFilter(request, response);
			
		}
		else
		{
			
			request.setAttribute("pass", "Wrong password");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
		
		}


}
