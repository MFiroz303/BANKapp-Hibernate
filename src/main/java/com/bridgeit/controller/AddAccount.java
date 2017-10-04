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

public class AddAccount extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
    
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			              throws ServletException, IOException {
		     PrintWriter out = response.getWriter();
		     
		     String name=request.getParameter("pname"); 
		     HttpSession session=  request.getSession();
		     int id= (int) session.getAttribute("id");
		     User user=new User();
		     user.setId(id);
		     
		     int accountNo=Integer.parseInt(request.getParameter("accountNo"));
		     String bankName=request.getParameter("bankName");  
		     String city=request.getParameter("city"); 
		     
		     Account account=new Account();  
		     account.setName(name);  
		     account.setBankNmae(bankName);  
		     account.setAccountNo(accountNo);  
		     account.setCity(city);
		     account.setUser(user);
		     
		     UserDao userdao=new UserDao();
		     userdao.addDetails(account); 
	         out.print("details inserted");     
		      out.close();  
	    }
	}

