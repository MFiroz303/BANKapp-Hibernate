package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.bridgeit.dao.UserDao;

public class InboxDetails {

	 
/*
		*//**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 *//*
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		

	        response.setContentType("text/html");
	        PrintWriter out=response.getWriter();
	        
	        int uid=Integer.parseInt(request.getParameter("id"));
	        
	       // Account account1=new Account();
	    //    account1.setCity(city);
	     
	        JSONObject jObject=new JSONObject();
	        UserDao userdao=new UserDao();
	         JSONObject result=userdao.inbox(uid);
	       // JSONArray result=userdao.inbox(id);
		             out.print(result.toString());
			        out.close();  
	        
	        
			 }  */

	}

