package com.bridgeit.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.resource.jdbc.LogicalConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import com.bridgeit.hibernateutil.Utility;
import com.bridgeit.model.Account;
import com.bridgeit.model.User;

public class UserDao {

	public void saveUser(User user) {
		System.out.println("Linedao......");

		SessionFactory sf = Utility.getSessionFactory();

		/*
		 * Configuration configuration = new Configuration();
		 * configuration.configure("hibernate.cfg.xml"); SessionFactory
		 * sf=configuration.buildSessionFactory();
		 */

		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.persist(user);
		tx.commit();
		session.close();
	}

	public User ValidateLogin(String email, String password) {
		String name;
		SessionFactory sf = Utility.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		List<User> list = criteria.list();

		/*
		 * for(Iterator<User> iterator = list.iterator(); iterator.hasNext();){
		 * User user =iterator.next();
		 */

		Iterator<User> iterator = list.iterator();
		iterator.hasNext();
		User user = iterator.next();

		/* for(User user : list) */
		name = user.getFullName();
		session.close();
		return user;

	}

	public void addDetails(Account account) {

		SessionFactory sf = Utility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(account);
		tx.commit();
		session.close();

	}

	public JSONArray display(String city, User user) {
		JSONArray jArray = new JSONArray();
		SessionFactory sf = Utility.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("city", city));
		criteria.add(Restrictions.eq("user", user));
		List<Account> list = criteria.list();

		for (Account account : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", account.getId());
			jsonObject.put("name", account.getName());
			jsonObject.put("accountNo", account.getAccountNo());
			jsonObject.put("bankName", account.getBankName());
			jsonObject.put("city", account.getCity());
			jArray.put(jsonObject);
		}
		session.close();
		return jArray;
	}

	public static void delete(int id) {

		SessionFactory sf = Utility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * Account account = (Account) session.createCriteria(Account.class)
		 * .add(Restrictions.eq("id", id));
		 */
		Account account = new Account();
		account.setId(id);
		session.delete(account);
		tx.commit();
		session.close();
	}

	public JSONObject inbox(int id) {
		JSONObject jsonObject = new JSONObject();
		SessionFactory sf = Utility.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("id", id));
		List<Account> list = criteria.list();

		for (Account account : list) {

			jsonObject.put("id", account.getId());
			jsonObject.put("name", account.getName());
			jsonObject.put("accountNo", account.getAccountNo());
			jsonObject.put("bankName", account.getBankName());
			jsonObject.put("city", account.getCity());
		}
		session.close();
		return jsonObject;
	}

	public void update(int id, String name, int accountNo, String bankName, String city, int userId) {

		SessionFactory sf = Utility.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setId(userId);
		Account account = new Account();
		account.setId(id);
		account.setName(name);
		account.setAccountNo(accountNo);
		account.setBankName(bankName);
		account.setCity(city);
		account.setUser(user);

		session.saveOrUpdate(account);
		tx.commit();
		session.close();
	}
}
