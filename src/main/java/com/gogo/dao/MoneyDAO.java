package com.gogo.dao;

import java.util.List;



import com.gogo.entity.Category;
import com.gogo.entity.Financial;
//import com.gogo.entity.Income;
import com.gogo.entity.Outcome;


//import main.java.com.gogo.entity.Category;
//import main.java.com.gogo.entity.Income;
//import main.java.com.gogo.entity.Outcome;

//import main.java.com.gogo.entity.Category;
//import main.java.com.gogo.entity.Financial;






public interface MoneyDAO {
	
	public List<Financial> getIncomes(int user_id);
//	
    public List<Financial> getOutcomes(int user_id); 
	
	public List<Category> getCategorys();
	
	public Financial getIncome(int id);
	
	public Financial getOucome(int id);
	
	public Category getCategory(int id);
	
	public void saveIncome(Financial theIncome);
	
	public void saveOutcome(Financial theOutcome);
	
	public void saveCategory(Category theCategory);
	
	public void deleteIncome(int id);
	
	public void deleteOutcome(int id);
	
	public void deleteCategory(int id);
	
	
}


