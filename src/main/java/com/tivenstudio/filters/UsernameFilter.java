package com.tivenstudio.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.tivenstudio.dao.UserDAO;

/**
 * Servlet Filter implementation class UsernameFilter
 */
@WebFilter("/register")
public class UsernameFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		UserDAO udao = new UserDAO();
		String username = request.getParameter("username");
		
		udao.init();
		if (username.length() > 0) {
			
			if (udao.check(username)) {
				request.setAttribute("message", "User exist");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);

			} else {
				chain.doFilter(request, response);
			}

		} else {
			request.setAttribute("message", "Enter the username");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);

		}

	}

}
