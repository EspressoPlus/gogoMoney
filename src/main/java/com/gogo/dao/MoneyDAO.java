package com.gogo.dao;

import java.util.List;

import com.gogo.entity.Financial;


public interface MoneyDAO {
	
	public List<Financial> getIncomes(int user_id);
//	
    	public List<Financial> getOutcomes(int user_id); 
	
	public List<Financial> getFinances(int user_id);
	
	public Financial getFinance(int id);
	
	public Financial getIncome(int id);
	
	public Financial getOucome(int id);
	
	public void saveFinances(Financial financial);
	
	public void deleteFinance(int id);
	
	public void saveIncome(Financial theIncome);
	
	public void saveOutcome(Financial theOutcome);
	
	public void deleteIncome(int id);
	
	public void deleteOutcome(int id);
	
	
}


