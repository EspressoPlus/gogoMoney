package com.gogo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MoneyDAOImpl implements MoneyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	

}














