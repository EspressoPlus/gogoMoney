package com.gogo.service;

import java.util.List;

//import com.gogo.entity.Money;
//import com.gogo.entity.Transaction;
import com.gogo.entity.Category;
import com.gogo.entity.Income;
import com.gogo.entity.Outcome;

public interface MoneyService {
	
	public List<Income> getIncomes();
//	
    public List<Outcome> getOutcomes();
	
	public List<Category> getCategorys();
	
	public Income getIncome(int id);
	
	public Outcome getOucome(int id);
	
	public Category getCategory(int id);
	
	public void saveIncome(Income theIncome);
	
	public void saveOutcome(Outcome theOutcome);
	
	public void saveCategory(Category theCategory);
	
	public void deleteIncome(int id);
	
	public void deleteOutcome(int id);
	
	public void deleteCategory(int id);
	
	
}
