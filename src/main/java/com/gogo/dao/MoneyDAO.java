package main.java.com.gogo.dao;

import java.util.List;

import main.java.com.gogo.entity.Category;
import main.java.com.gogo.entity.Income;
import main.java.com.gogo.entity.Outcome;





public interface MoneyDAO {
	
	public List<Income> getIncomes(int user_id);
//	
    public List<Outcome> getOutcomes(int user_id);
	
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


