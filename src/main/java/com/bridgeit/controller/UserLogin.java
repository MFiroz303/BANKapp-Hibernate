package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.dao.UserDao;
import com.bridgeit.model.User;

public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();
		User user=userDao.ValidateLogin(email, password);
		
		if ( user != null) {

			HttpSession session = request.getSession();
			session.setAttribute("name", user.getFullName());
			session.setAttribute("id", user.getId());
			 
			response.sendRedirect("homepage");
		} else {
			out.println("<p>Username or Password incorrect<p>");
			response.sendRedirect("loginpage");
		}
		out.close();
	}
}
