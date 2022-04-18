package com.gogo.service;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gogo.dao.MoneyDAO;
import com.gogo.entity.Category;
import com.gogo.entity.Financial;
import com.gogo.entity.Outcome;



@Service
public class MoneyServiceImpl implements MoneyService {

	@Autowired
	private MoneyDAO moneyDAO;
	
	@Override
	@Transactional
	public List<Financial> getIncomes(int user_id) {
		// TODO Auto-generated method stub
		return moneyDAO.getIncomes(user_id); 
	}

	@Override
	@Transactional
	public List<Financial> getOutcomes(int user_id) {
		
		return moneyDAO.getOutcomes(user_id);
	}

	@Override
	@Transactional
	public List<Category> getCategorys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Financial getIncome(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Financial getOucome(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void saveIncome(Financial theIncome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void saveOutcome(Financial theOutcome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void saveCategory(Category theCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteIncome(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteOutcome(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
	}
}
