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
import com.gogo.entity.User;

//import com.gogo.entity.Transaction;


@Repository
public class MoneyDAOImpl implements MoneyDAO {

	//needs testing
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Income> getIncomes() {
		Session session = sessionFactory.getCurrentSession();
		Query<Income> query = session.createQuery("From Income", Income.class);
		
		return query.getResultList();
	}

	@Override
	public List<Outcome> getOutcomes() {
		Session session = sessionFactory.getCurrentSession();
		Query<Outcome> query = session.createQuery("from Outcome", Outcome.class);
		//Integer id = 1;
		//String n = "Rent";
		//String r = "TRUE";
		//Query<Outcome> query = session.createQuery("from Outcome o where o.user_id = " + id, Outcome.class);
		//Query<Outcome> query = session.createQuery("from Outcome o where o.recurring = " + r, Outcome.class);
		//System.out.println("###BORT###" + query.getResultList());
		//System.out.println("###BORT###" + query.toString());
		//System.out.println("###BORT###" + query.getNamedParameters());
		//System.out.println("###BORT###" + query.getQueryString());
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
	
	

}














