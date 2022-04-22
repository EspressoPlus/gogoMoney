package com.gogo.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class FinancialRegService 
{
	public Map<Integer,String>populateCategory()
	{
		Map<Integer,String> financeList = new LinkedHashMap<Integer,String>();
		financeList.put(1, "Housing");
		financeList.put(2, "Insurance");
		financeList.put(3, "Savings");
		financeList.put(4, "Utilities");
		financeList.put(5, "Essentials");
		financeList.put(6, "Healthcare");
		financeList.put(7, "Transportation");
		financeList.put(8, "Recreation/Entertainment");
		financeList.put(9, "Personal");
		financeList.put(10, "Other");
		financeList.put(11, "Income");
		
		return financeList;
	}
	
	public Map<String,String>populateRecurrence()
	{
		Map<String,String> recurrList = new LinkedHashMap<String,String>();
		recurrList.put("TRUE", "TRUE");
		recurrList.put("FALSE", "FALSE");
		
		return recurrList;
	}
	
	public Map<String,String>populateIncomeOutcome()
	{
		Map<String,String> inOrOutList = new LinkedHashMap<String,String>();
		inOrOutList.put("Outcome", "Expense");
		inOrOutList.put("Income", "Income");
		
		return inOrOutList;
	}
	
	public Map<String,String>populateInterval()
	{
		Map<String,String> intervalList = new LinkedHashMap<String,String>();
		intervalList.put("Monthly", "Monthly");
//		intervalList.put("Weekly", "Weekly");
//		intervalList.put("Bi-Weekly", "Bi-Weekly");
		intervalList.put("Once", "Once");
		
		return intervalList;
	}
}
