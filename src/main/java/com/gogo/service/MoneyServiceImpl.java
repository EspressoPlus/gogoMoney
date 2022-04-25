package com.gogo.service;

import java.sql.Date;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gogo.dao.MoneyDAO;
import com.gogo.entity.Financial;
import com.gogo.entity.FinancialRegService;
import com.gogo.entity.User;




@Service
public class MoneyServiceImpl implements MoneyService {

	@Autowired
	private MoneyDAO moneyDAO;
	@Autowired
	private FinancialRegService finRegSrv;
	
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
	public List<Financial> getFinancesCurrent(int user_id)
	{
		//return moneyDAO.getFinances(user_id);
		return moneyDAO.getFinancesCurrent(user_id);
	}
	
	@Override
	@Transactional
	public Financial getFinance(int user_id)
	{
		return moneyDAO.getFinance(user_id);
	}
	
	@Override
	@Transactional
	public HashMap<String,Double> getSpendingByCategory(int user_id) {
	//public HashMap<Integer,Double> getSpendingByCategory(int user_id) {
		
		List<Financial> spending = moneyDAO.getOutcomes(user_id);  // get all spending
		
		// use accumulator pattern to summarize by category
		// this is so much easier in Python !!!
		// https://stackoverflow.com/a/36554525
		HashMap<Integer,Double> iMap = new HashMap<Integer,Double>();
		for (Financial f : spending) {
			int category = f.getCategory();
			//double amount = f.getAmount();
			double amount = iMap.containsKey(category) ? iMap.get(category) : 0;
			amount += f.getAmount();
			iMap.put(category, amount);
		}
		
		// convert category integer code to real category description
		HashMap<String,Double> sMap  = new HashMap<String,Double>();
		Map<Integer,String> catMap = finRegSrv.populateCategory();
		for (Integer i : iMap.keySet()) {
			String cat = catMap.get(i);   // get category string from catMap
			sMap.put(cat,iMap.get(i));    // write name and value to sMap
		}
		
		//return moneyDAO.getOutcomes(user_id);
		return sMap;
	}
	
	@Override
	@Transactional
	public int getSavingsTime(Date date, User user)
	{
		int i = 0;
		
		//gets all income and outcome
		List<Financial> income = moneyDAO.getIncomes(user.getUser_id());
		List<Financial> outcome = moneyDAO.getOutcomes(user.getUser_id());
		
		//to put income and outcome totals in
		Double inMonth = 0.00;
		Double outMonth = 0.00;
		
		
		//only adds recurring amounts
		for(int j = 0; j < income.size();j++)
		{
			if(income.get(j).getTransaction_date().after(date))
			{
				if(income.get(j).getRecurring().equals("TRUE"))
				{
					inMonth = inMonth + income.get(j).getAmount();
				}
			}
		}
		
		//only adds recurring amounts
		for(int j = 0; j < outcome.size();j++)
		{
			if(outcome.get(j).getTransaction_date().after(date))
			{
				if(outcome.get(j).getRecurring().equals("TRUE"))
				{
					outMonth = outMonth + outcome.get(j).getAmount();
				}
			}
		}
		
		//total surplus
		Double total = inMonth - outMonth;
		
		//save goal amount
		Double save = user.getAmount_to_save();
		
		//if there is a left over amount, add an additional month
		if(save%total>0.01)
		{
			Double t = (save/total) + 1;
			i = t.intValue();
		}
		else //if saved/total = 0, then i is the exact amount of months it will take to save
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
		
		//gets all income and outcome
		List<Financial> in = moneyDAO.getIncomes(user_id);
		List<Financial> out = moneyDAO.getOutcomes(user_id);
		
		
		//only add the recurring amounts
		for(int i = 0; i < in.size(); i++)
		{
			//if(in.get(i).getRecurring().equals("TRUE"))
			//{
				income+=in.get(i).getAmount();
			//}
		}
		
		//only add the recurring amounts
		for(int i = 0; i < out.size(); i++)
		{
			//if(out.get(i).getRecurring().equals("TRUE"))
			//{
				outcome+=out.get(i).getAmount();
			//}
		}
		
		return income - outcome; //surplus amount
	}
	
	//gets only the one time occurrence outcomes
	@Override
	@Transactional
	public List<Financial> getOutcomesOneTime(int user_id)
	{
		List<Financial> out = moneyDAO.getOutcomes(user_id);
		List<Financial> outcome = new ArrayList<Financial>();
		//only add the recurring amounts
		for(int i = 0; i < out.size(); i++)
		{
			if(out.get(i).getRecurring().equals("FALSE"))
			{
				outcome.add(out.get(i));
			}
		}
		
		return outcome;
	}
	
	//gets only the one time occurrence incomes
	@Override
	@Transactional
	public List<Financial> getIncomesOneTime(int user_id)
	{
		List<Financial> in = moneyDAO.getIncomes(user_id);
		List<Financial> income = new ArrayList<Financial>();
		//only add the recurring amounts
		for(int i = 0; i < in.size(); i++)
		{
			if(in.get(i).getRecurring().equals("FALSE"))
			{
				income.add(in.get(i));
			}
		}
		
		return income;
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
