package com.gogo.service;

import java.util.List;



import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gogo.entity.Category;
import com.gogo.entity.Income;
import com.gogo.entity.Outcome;

//import main.java.com.gogo.entity.Category;
//import main.java.com.gogo.entity.Income;
//import main.java.com.gogo.entity.Outcome;

@Service
public interface MoneyService {
	
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
