package com.gogo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired // tells hibernate to look for sessionFactory bean
	private SessionFactory sessionFactory;
	

}
