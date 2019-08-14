package com.tivenstudio.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tivenstudio.dao.UserDAO;
import com.tivenstudio.model.User;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");

		UserDAO udao = new UserDAO();

		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setUsername(username);
		user.setPwd(pwd);
		udao.init();
		udao.save(user);

		req.setAttribute("info", "Registered");
		resp.setHeader("Refresh", "3;url=home.jsp");
		req.getRequestDispatcher("registration.jsp").forward(req, resp);

	}

}
