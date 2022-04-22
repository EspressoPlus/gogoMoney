package com.gogo.service;

import java.sql.Date;
import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gogo.dao.MoneyDAO;
import com.gogo.entity.Financial;
import com.gogo.entity.User;




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
	public int getSavingsTime(Date date, User user)
	{
		int i = 0;
		List<Financial> income = moneyDAO.getIncomes(user.getUser_id());
		List<Financial> outcome = moneyDAO.getOutcomes(user.getUser_id());
		
		Double inMonth = 0.00;
		Double outMonth = 0.00;
		
		for(int j = 0; j < income.size();j++)
		{
			if(income.get(j).getTransaction_date().after(date))
			{
				inMonth = inMonth + income.get(j).getAmount();
			}
		}
		
		for(int j = 0; j < outcome.size();j++)
		{
			if(outcome.get(j).getTransaction_date().after(date))
			{
				outMonth = outMonth + outcome.get(j).getAmount();
			}
		}
		
		Double total = inMonth - outMonth;
		Double save = user.getAmount_to_save();
		Double mon = 0.0;
		if(save%total>0.01)
		{
			Double t = (save/total) + 1;
			i = t.intValue();
		}
		else
		{
			Double t = (save/total);
			i = t.intValue();
		}
			
		
		return i;
	}
	
	@Override
	@Transactional
	public Double getSurplus(int user_id)
	{
		Double income = 0.0;
		Double outcome = 0.0;
		
		List<Financial> in = moneyDAO.getIncomes(user_id);
		List<Financial> out = moneyDAO.getOutcomes(user_id);
		
		for(int i = 0; i < in.size(); i++)
		{
			income+=in.get(i).getAmount();
		}
		
		for(int i = 0; i < out.size(); i++)
		{
			outcome+=out.get(i).getAmount();
		}
		
		return income - outcome;
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
	public void deleteIncome(int id) {
		moneyDAO.deleteIncome(id);
		
	}

	@Override
	@Transactional
	public void deleteOutcome(int id) {
		moneyDAO.deleteOutcome(id);
		
		
	}
}
