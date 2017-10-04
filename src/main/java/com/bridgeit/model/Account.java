package com.bridgeit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="customer_details")
public class Account {
	//Account Details

    		@Id
    		@GeneratedValue(strategy=GenerationType.AUTO, generator="mygen")
    		@GenericGenerator(strategy="native", name="mygen")
    		@Column(name="id")
			private int id;
    		
    		@ManyToOne
    		@JoinColumn(name="userId")
    		private User user;
    		
    		public User getUser() {
				return user;
			}
			public void setUser(User user) {
				this.user = user;
			}
			/*@Column(name="user_id")
    		private int user_id;*/
    		
    		@Column(name="name")
			private String name;
    		
    		@Column(name="accountNo")
    		private int accountNo;
    		
    		
			
    		@Column(name="bankName")
			private String bankName;
			
    		@Column(name="city")
			private String city;
			/*
			public int getUser_id() {
				return user_id;
			}
			public void setUser_id(int user_id) {
				this.user_id = user_id;
			}*/
			public String getBankName() {
				return bankName;
			}
			public void setBankName(String bankName) {
				this.bankName = bankName;
			}
			
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getAccountNo() {
				return accountNo;
			}
			public void setAccountNo(int accountNo) {
				this.accountNo = accountNo;
			}
			
			public String getBankNmae() {
				return bankName;
			}
			public void setBankNmae(String bankNmae) {
				this.bankName = bankNmae;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
	}