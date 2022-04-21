package com.gogo.service;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gogo.dao.MoneyDAO;
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
	public Financial getIncome(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public List<Financial> getFinances(int user_id)
	{
		return moneyDAO.getFinances(user_id);
	}
	
	@Override
	@Transactional
	public Financial getFinance(int user_id)
	{
		return moneyDAO.getFinance(user_id);
	}
	
	@Override
	@Transactional
	public void saveFinances(Financial financial)
	{
		moneyDAO.saveFinances(financial);
	}
	
	@Override
	@Transactional
	public void deleteFinance(int id)
	{
		moneyDAO.deleteFinance(id);
	}

	@Override
	@Transactional
	public Financial getOucome(int id) {
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
		moneyDAO.deleteIncome(id);
		
	}

	@Override
	@Transactional
	public void deleteOutcome(int id) {
		moneyDAO.deleteOutcome(id);
		
		
	}

	@Override
	@Transactional
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
	}
}
