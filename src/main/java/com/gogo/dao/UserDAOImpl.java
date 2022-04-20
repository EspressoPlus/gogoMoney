package com.gogo.dao;

import java.util.List;



import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gogo.entity.User;

//import main.java.com.gogo.entity.User;


@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired // tells hibernate to look for sessionFactory bean
	private SessionFactory sessionFactory;
	
	//Queries the table and gets a list of users back
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("From User", User.class);
		
		return query.getResultList();
	}

	//uses id to get the user directly from the sessionfactory
	@Override
	public User getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}

	@Override
	public void saveUser(User theUser) {
		Session session = sessionFactory.getCurrentSession();
		//session.save(theStudent);	
		session.saveOrUpdate(theUser);
		
	}

	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("delete from User where id = :id", User.class);
		query.setParameter("id", id);
		query.executeUpdate();
		
	}
	
	@Override
	public List<User> getEmail(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where email like :email AND password like :password", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		return query.getResultList();
		
	}
	
	@Override 
	public User getUserInfo(String email)
	{
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where email like :email", User.class);
		
		query.setParameter("email", email);
		
		return query.getSingleResult();
	}


}
