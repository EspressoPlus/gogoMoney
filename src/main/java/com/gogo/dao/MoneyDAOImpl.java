package com.gogo.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.gogo.entity.Transaction;


@Repository
public class MoneyDAOImpl implements MoneyDAO {

	//needs testing
	
	@Autowired
	private SessionFactory sessionFactory;

//	@Override	
//	public List<Transaction> getIncome(int uId) {
//		Session session = sessionFactory.getCurrentSession();
//		Query<Transaction> query = session.createQuery("From income", Transaction.class); //needs to be changed when entity layer is done
//		
//		return query.getResultList();
//	}
//
//	@Override
//	public List<Transaction> getOutcome(int uId) {
//		Session session = sessionFactory.getCurrentSession();
//		Query<Transaction> query = session.createQuery("From outcome", Transaction.class); //needs to be changed when entity layer is done
//		
//		return query.getResultList();
//	}

	@Override
	public int getSavings(int uId) {
		
		return 0;
	}

	@Override
	public void addIncome() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOutcome() {
		// TODO Auto-generated method stub
		
	}
	
	

}














