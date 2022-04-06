package com.gogo.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gogo.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired // tells hibernate to look for sessionFactory bean
	private SessionFactory sessionFactory;
	
	//Queries the table and gets a list of users back
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("From User", User.class);
		for(User user : query.getResultList()) {
			System.out.println(user.getUname());
		}
		return query.getResultList();
	}

	//uses id to get the user directly from the sessionfactory
	@Override
	public User getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}


}
