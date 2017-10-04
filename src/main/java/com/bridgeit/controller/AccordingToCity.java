package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.bridgeit.dao.UserDao;
import com.bridgeit.model.User;

public class AccordingToCity extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			              throws ServletException, IOException {
					
		                  response.setContentType("text/html");
		                  PrintWriter out=response.getWriter();
		                  
		                  String city=request.getParameter("city");
		                  HttpSession session = request.getSession();
		                  int id= (int) session.getAttribute("id");
		                  System.out.println("id "+id);
		                  
		                  User user = new User();
		                  user.setId(id);
		                  UserDao userdao=new UserDao();
		             
		                  JSONArray accountData= new JSONArray();
		                  accountData = userdao.display(city,user);
		          	             out.print(accountData.toString());
		          		         out.close();  
		          		 }  

}