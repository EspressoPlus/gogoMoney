package com.gogo.dao;

import java.util.List;

import com.gogo.entity.Transaction;

public interface MoneyDAO {
	
	public List<Transaction> getIncome(int uId);
	
	public List<Transaction> getOutcome(int uId);
	
	public int getSavings(int uId);
	
	public void addIncome();
	
	public void addOutcome();
	
	
}


