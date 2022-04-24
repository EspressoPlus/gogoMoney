package com.gogo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gogo.entity.Financial;
import com.gogo.entity.User;




@Service
public interface MoneyService {
	
	public List<Financial> getIncomes(int user_id);
//	
    public List<Financial> getOutcomes(int user_id);
	
	public List<Financial> getIncomesOneTime(int user_id);
    
    public List<Financial> getOutcomesOneTime(int user_id);
	
	public List<Financial> getFinancesCurrent(int user_id);
	
	public Financial getFinance(int id);
	
	public Financial getIncome(int id);
	
	public Financial getOucome(int id); 
	
	public int getSavingsTime(Date date, User user);
	
	public Double getSurplus(int user_id);
	
	public void saveFinances(Financial financial);
	
	public void deleteFinance(int id);
	
	public void saveIncome(Financial theIncome);
	
	public void saveOutcome(Financial theOutcome);
	
	public void deleteIncome(int id);
	
	public void deleteOutcome(int id);
	
	public HashMap<String,Double> getSpendingByCategory(int user_id);
}
