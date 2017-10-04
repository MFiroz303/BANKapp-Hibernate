package com.bridgeit.hibernateutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {

	private static  SessionFactory sessionfactory;
	
	static {
		sessionfactory =new Configuration().configure().buildSessionFactory();
	}
	 public static SessionFactory getSessionFactory() {
	        return sessionfactory;
	}
	
}

