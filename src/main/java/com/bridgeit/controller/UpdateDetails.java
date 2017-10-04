package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.dao.UserDao;
import com.bridgeit.model.Account;
import com.bridgeit.model.User;

public class UpdateDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("pname");
		String accountNo = request.getParameter("accountNo"); 
		String bankName = request.getParameter("bankName");
		String city = request.getParameter("city");
		HttpSession session = request.getSession();

		int id=  (int) session.getAttribute("id");

		String currentid = request.getParameter("id");
System.out.println("currentid "+currentid);
		if (currentid.equals("0")) {
			UserDao userdao = new UserDao();
		//	int userId = userdao.userid(id);

			User user = new User();
			user.setId(id);

			Account account = new Account();
			account.setName(name);
			account.setBankNmae(bankName);
			account.setAccountNo(Integer.parseInt(accountNo));
			account.setCity(city);
			account.setUser(user);
			
			userdao.addDetails(account);
		}

		else {
			UserDao userdao = new UserDao();
			int pid = Integer.parseInt(currentid);
			
			userdao.update(pid, name, Integer.parseInt(accountNo), bankName, city,id);
		}
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
