package com.gogo.service;

import java.util.List;



import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import com.gogo.entity.Category;
import com.gogo.entity.Income;
import com.gogo.entity.Outcome;

//import main.java.com.gogo.entity.Category;
//import main.java.com.gogo.entity.Income;
//import main.java.com.gogo.entity.Outcome;
=======
import main.java.com.gogo.entity.Category;
import main.java.com.gogo.entity.Financial;
>>>>>>> a6a137565aa5f96ae5509727f186cdf53aa2b956

@Service
public interface MoneyService {
	
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
