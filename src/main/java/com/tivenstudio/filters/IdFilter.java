package com.tivenstudio.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/searchSomething")
public class IdFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		HttpServletResponse resp = (HttpServletResponse) response;
		
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				if (id > 1) {
					chain.doFilter(request, response);}
				else
				{
					out.println("Tylko wieksze od 0");
				}
			}
			catch(Exception e)
			{
				out.println(e.getMessage());
				resp.sendRedirect("home.jsp");
			}


	}

}
