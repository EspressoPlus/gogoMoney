package com.gogo.controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gogo.entity.Financial;
import com.gogo.entity.FinancialRegService;
import com.gogo.entity.User;
import com.gogo.service.MoneyService;
import com.gogo.service.UserService;


@Controller
public class ControllerSOAP {
	User userTemp; // placeholder to pass user from displaySummary to displayTransactions
	boolean modelAttribute = false; // I need this to check so that returning to displaySummary from displayTransactions does not cause an error
	@Autowired
	private UserService userService;
	@Autowired
	private MoneyService moneyService; // comment
	@Autowired
	private FinancialRegService regService;
	
	// landingPage.jsp
	// landing page for user login / create acct
	// login -> /displaySummary
	// create -> /createAcct
	@RequestMapping("/")
	public String landingPage(Model m) {
		//List<User> users = userService.getUsers(); //to add customer email and password to model
		Boolean error = false; //hides the "invalid email and password" error message ***See validate method***
		User user = new User();
		m.addAttribute("user", user);
		m.addAttribute("error", error);
		
		return "landingPage"; // redirect to the summary instead of validate which I commented out below for now
	}
	
	 @RequestMapping("/validate") 
	 public String validate(@ModelAttribute("users") User login, Model model) { 
		 Boolean valid = userService.validateLogin(login.getEmail(),login.getPassword()); //verifies both the email and password are valid 
		 if(valid == true) 
		 { 
			 User user = userService.getUserInfo(login.getEmail());
			 List<Financial> income = moneyService.getIncomes(user.getUser_id());
			 List<Financial> outcome = moneyService.getOutcomes(user.getUser_id());
			 model.addAttribute("user", user);
			 model.addAttribute("income", income);
			 model.addAttribute("outcome", outcome);
			 return "validate";//comment
		 }
		 else 
		 {
			 Boolean error = true; //triggers the invalid error message
			 model.addAttribute("error", error);
			 return "landingPage"; //redirects to landing page, keeping the validate mapping.
		 } 
	 }
	 
	
	// createAccount.jsp
	// -> displaySummary
	//No, I don't want to do that, I think it would be far better to just direct to populate finances
	@RequestMapping("/createAccount")
	public String createAccount(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		//userService.createUser(user);
		
		return "createAccount";
	}
	
	@RequestMapping("/processAccount")
	public String processAccount(@ModelAttribute("user") User user, RedirectAttributes r)
	{
		userService.createUser(user);
		System.out.println("********* processAccount email: " + user.getEmail());
		userTemp = userService.getUserInfo(user.getEmail());
		
		r.addFlashAttribute("user", user);  // allows entire user object to be added
		return "redirect:/populateFinances";
	}
	
	// displaySummary.jsp
	@RequestMapping("/displaySummary")
	public String displaySummary(@ModelAttribute("user") User login, Model m) {
		if(modelAttribute == false) {//so that returning to displaySummary from displayTransactions does not cause an error
			userTemp = userService.getUserInfo(login.getEmail()); // gets user based on the email they entered on landingPage
		}
		User pass = userService.getUserInfo(login.getEmail());
		userTemp = pass;
		//to pass user information to other pages
		User user = new User();
		
		m.addAttribute("user", user);
		m.addAttribute("pass", pass);
		
		//get surplus amount
		Double surplus = moneyService.getSurplus(userTemp.getUser_id());
		System.out.println("*** displaySummary surplus : " + surplus);
		m.addAttribute("surplus", surplus);
		
		return "displaySummary";
	}
	
	// displayTransactions.jsp
	@RequestMapping("/displayTransactions")
	public String displayTransactions(Model model) {
		
		List<Financial> income = moneyService.getIncomesOneTime(userTemp.getUser_id());
		List<Financial> outcome = moneyService.getOutcomesOneTime(userTemp.getUser_id());
		
		model.addAttribute("user", userTemp);
		model.addAttribute("income", income); 
		model.addAttribute("outcome", outcome);
		modelAttribute = true;//so that returning to displaySummary from displayTransactions does not cause an error
		return "displayTransactions";
	}
	@RequestMapping("/deleteTransaction")
	public String deleteStudent( @RequestParam(value ="incomeId", required=false) Integer incomeId,@RequestParam(value="outcomeId",required=false) Integer outcomeId) {
		
		if(incomeId!=null) {
			moneyService.deleteIncome(incomeId);
		}
		if(outcomeId!=null) {
			moneyService.deleteIncome(outcomeId);
		}
		
		return "redirect:/displayTransactions";	
	}

	// populateFinances.jsp
	@RequestMapping("/populateFinances")
	public String populateFinances(@ModelAttribute("user") User user, Model m) 
	{
		//User user = userService.getUser(4);
		Financial financial = new Financial();
		userTemp.add(financial);
		List<Financial> current = moneyService.getFinancesCurrent(userTemp.getUser_id());
		
		java.util.Date uDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(uDate.getTime());
		
		//time in months it will take if everything stays the same.If surplus is negative, 
		int time = moneyService.getSavingsTime(date, userTemp);
		
		//get surplus amount
		Double surplus = moneyService.getSurplus(userTemp.getUser_id());
			
		m.addAttribute("user", userTemp);
		m.addAttribute("financial", financial);
		m.addAttribute("current", current);
		m.addAttribute("surplus", surplus);
		if(surplus == 0.0)
		{
			String noSurplus = "No Surplus Available";
			m.addAttribute("time", noSurplus);
		}
		else
		{
			m.addAttribute("time", time);
		}
			
		return "populateFinances";
	}
	
	//adds the financial line to table
	@RequestMapping("/processUser/{user_Id}")
	public String processUser(@PathVariable int user_Id, @ModelAttribute("financial") Financial financial, Model m)
	{
		User use = userService.getUser(user_Id);
		financial.setUser(use);
	
		java.util.Date uDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(uDate.getTime());
		financial.setEntry_date(date);
		moneyService.saveFinances(financial);
		
		return "redirect:/populateFinances";
	}
	
	//deletes row of finance
	@RequestMapping("/deleteFinance")
	public String deleteOrder(@RequestParam("financial_id") int id, @RequestParam("user_id") int user_id)
	{
		User user = userService.getUser(user_id);
		Financial financial = moneyService.getFinance(id);
		
		moneyService.deleteFinance(id);
		user.remove(financial);
		
		return"redirect:/populateFinances";
	}
	
	// This will allow the drop down lists to be populated
	@ModelAttribute
	public void populateFormWithData(Model model)
	{
		model.addAttribute("financeList", regService.populateCategory()); //category list
		model.addAttribute("recurrList", regService.populateRecurrence()); //true or false
		model.addAttribute("intervalList", regService.populateInterval()); //monthly, weekly, bi-weekly, once
		model.addAttribute("inOrOutList", regService.populateIncomeOutcome());//income/expense
	}
	
	
}
















