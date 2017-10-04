package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.dao.UserDao;
import com.bridgeit.model.User;

//@WebServlet("/Registration")

public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int phoneNo = Integer.parseInt(request.getParameter("phoneNo"));

		User user = new User();
		user.setFullName(fullName);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhoneNo(phoneNo);

		// -----------------------------------
		UserDao userdao = new UserDao();
		System.out.println("line 2");
		userdao.saveUser(user);
		out.print("<p> Account created successfully!</p>");
		// request.getRequestDispatcher("index.jsp").include(request, response);
		response.sendRedirect("loginpage");
		;
		out.close();
	}

}
