package com.gogo.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gogo.entity.Financial;




@Repository
public class MoneyDAOImpl implements MoneyDAO { 

	//needs testing
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Financial> getIncomes(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Financial> query = session.createQuery(
				"From Financial where user_id = :user_id AND income_outcome = :income order by transaction_date desc", Financial.class);
		query.setParameter("user_id", user_id);
		query.setParameter("income", "income");
		
		return query.getResultList();
	}

	@Override
	public List<Financial> getOutcomes(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Financial> query = session.createQuery(
				"From Financial where user_id = :user_id AND income_outcome = :outcome order by transaction_date desc", Financial.class);
		query.setParameter("user_id", user_id);
		query.setParameter("outcome", "outcome");
		
		return query.getResultList();
	}
	
	@Override
	public List<Financial> getFinances(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Financial> query = session.createQuery("From Financial where user_id = :user_id", Financial.class);
		query.setParameter("user_id", user_id);
		
		return query.getResultList();
	}
	
	@Override
	public List<Financial> getFinancesCurrent(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Financial> query = session.createQuery(
				"From Financial where user_id = :user_id and ( recurring = 'TRUE' or income_outcome = 'Income' ) ", 
				Financial.class);
		query.setParameter("user_id", user_id);
		
		return query.getResultList();
	}
	
	//Query<Financial> query = session.createQuery("From Financial where user_id = :user_id and recurring = 'TRUE'", Financial.class);
	
	
	@Override
	public Financial getFinance(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Financial.class, id);
	}
	
	@Override
	public void saveFinances(Financial financial)
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(financial);
	}
	
	@Override
	public void deleteFinance(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Financial financial = session.get(Financial.class, id);
		session.remove(financial);
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

//	@Override
//	public com.gogo.dao.Income getIncome(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public com.gogo.dao.Outcome getOucome(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public com.gogo.dao.Category getCategory(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

}














