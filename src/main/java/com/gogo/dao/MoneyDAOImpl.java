package com.gogo.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gogo.entity.Category;
import com.gogo.entity.Income;
import com.gogo.entity.Outcome;

//import main.java.com.gogo.entity.Category;
//import main.java.com.gogo.entity.Income;
//import main.java.com.gogo.entity.Outcome;


//import com.gogo.entity.Transaction;


@Repository
public class MoneyDAOImpl implements MoneyDAO { 

	//needs testing
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Income> getIncomes(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Income> query = session.createQuery("From Income where user_id = :user_id", Income.class);
		query.setParameter("user_id", user_id);
		
		return query.getResultList();
	}

	@Override
	public List<Outcome> getOutcomes(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Outcome> query = session.createQuery("From Outcome where user_id = :user_id", Outcome.class);
		query.setParameter("user_id", user_id);
		
		return query.getResultList();
	}

	@Override
	public List<Category> getCategorys() {
		Session session = sessionFactory.getCurrentSession();
		Query<Category> query = session.createQuery("From Category", Category.class);
		
		return query.getResultList();
	}

	@Override
	public Income getIncome(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Income.class, id);
	}

	@Override
	public Outcome getOucome(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Outcome.class, id);
	}

	@Override
	public Category getCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Category.class, id);
	}

	@Override
	public void saveIncome(Income theIncome) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theIncome);
		
	}

	@Override
	public void saveOutcome(Outcome theOutcome) {
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
		Query query = session.createQuery("delete from Income where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public void deleteOutcome(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Outcome where id = :id");
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














