package com.tivenstudio.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tivenstudio.dao.UserDAO;
import com.tivenstudio.model.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uname = req.getParameter("username");
		String pass = req.getParameter("pwd");
		// PrintWriter out = resp.getWriter();

		User user = new User();
		UserDAO udao = new UserDAO();
		udao.init();
		Optional<User> optional = udao.get(uname);

		if (optional != null) {
			user = optional.get();
			if (user.getPwd().equals(pass)) {

				HttpSession session = req.getSession();
				session.setAttribute("uname", uname);

				resp.sendRedirect("welcome.jsp");

			} else {

				resp.sendRedirect("errorPage.jsp");
			}
		} else {

			System.out.println("Nie udalo sie wyszukac obiektu");
			resp.sendRedirect("errorPage.jsp");
		}

	}
}
