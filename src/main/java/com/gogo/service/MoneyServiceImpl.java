package com.gogo.service;

import java.util.Arrays;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gogo.dao.MoneyDAO;
import com.gogo.entity.Category;
import com.gogo.entity.Income;
import com.gogo.entity.Outcome;
import com.gogo.service.FormOptionsService;

import zcom.gogo.exception.NotFoundException;

@Service
public class MoneyServiceImpl implements MoneyService {

	@Autowired
	private MoneyDAO moneyDAO;
	
	@Override
	@Transactional
	public List<Income> getIncomes() {
		// TODO Auto-generated method stub
		return moneyDAO.getIncomes();
	}

	@Override
	@Transactional
	public List<Outcome> getOutcomes() {
		// TODO Auto-generated method stub
		return moneyDAO.getOutcomes();
	}

	@Override
	@Transactional
	public List<Category> getCategorys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Income getIncome(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Outcome getOucome(int id) {
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
	public void saveIncome(Income theIncome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void saveOutcome(Outcome theOutcome) {
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
