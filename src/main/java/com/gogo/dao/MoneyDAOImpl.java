package com.gogo.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.gogo.entity.Category;
import com.gogo.entity.Income;
import com.gogo.entity.Outcome;

//import main.java.com.gogo.entity.Category;
//import main.java.com.gogo.entity.Income;
//import main.java.com.gogo.entity.Outcome;


//import com.gogo.entity.Transaction;
=======
import main.java.com.gogo.entity.Category;
import main.java.com.gogo.entity.Financial;
>>>>>>> a6a137565aa5f96ae5509727f186cdf53aa2b956


@Repository
public class MoneyDAOImpl implements MoneyDAO { 

	//needs testing
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Financial> getIncomes(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Financial> query = session.createQuery("From Financial where user_id = :user_id AND income_outcome = :income", Financial.class);
		query.setParameter("user_id", user_id);
		query.setParameter("income", "income");
		
		return query.getResultList();
	}

	@Override
	public List<Financial> getOutcomes(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Financial> query = session.createQuery("From Financial where user_id = :user_id AND income_outcome = :outcome", Financial.class);
		query.setParameter("user_id", user_id);
		query.setParameter("outcome", "outcome");
		
		return query.getResultList();
	}

	@Override
	public List<Category> getCategorys() {
		Session session = sessionFactory.getCurrentSession();
		Query<Category> query = session.createQuery("From Category", Category.class);
		
		return query.getResultList();
	}

	@Override
	public Financial getIncome(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Financial.class, id);
	}

	@Override
	public Financial getOucome(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Financial.class, id);
	}

	@Override
	public Category getCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Category.class, id);
	}

	@Override
	public void saveIncome(Financial theIncome) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theIncome);
		
	}

	@Override
	public void saveOutcome(Financial theOutcome) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theOutcome);
		
	}

	@Override
	public void saveCategory(Category theCategory) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCategory);
		
	}

	@Override
	public void deleteIncome(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Financial where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public void deleteOutcome(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Financial where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public void deleteCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Category where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

//	@Override
//	public main.java.com.gogo.dao.Income getIncome(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public main.java.com.gogo.dao.Outcome getOucome(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public main.java.com.gogo.dao.Category getCategory(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

}














