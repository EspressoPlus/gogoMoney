package com.gogo.controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gogo.entity.Financial;
import com.gogo.entity.User;
import com.gogo.service.MoneyService;
import com.gogo.service.UserService;

@Controller
public class ControllerSOAP {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MoneyService moneyService;
	
	// landingPage.jsp
	// landing page for user login / create acct
	// login -> /displaySummary
	// create -> /createAcct
	@RequestMapping("/")
	public String landingPage(Model m) {
		List<User> users = userService.getUsers(); //to add customer email and password to model
		Boolean error = false; //hides the "invalid email and password" error message ***See validate method***
		m.addAttribute("users", users);
		m.addAttribute("error", error);
		
		return "landingPage";
	}
	@RequestMapping("/validate")
	public String validate(@ModelAttribute("users") User login, Model model) 
	{
		Boolean valid = userService.validateLogin(login.getEmail(),login.getPassword()); //verifies both the email and password are valid
		if(valid == true)
		{
			User user = userService.getUserInfo(login.getEmail());
			List<Financial> income = moneyService.getIncomes(user.getUser_id());
			List<Financial> outcome = moneyService.getOutcomes(user.getUser_id());
			model.addAttribute("user", user);
			model.addAttribute("income", income); 
			model.addAttribute("outcome", outcome);
			return "validate";
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
	public String createAccount(@ModelAttribute("fName") String fName, @ModelAttribute("lName") String lName,
			@ModelAttribute("email") String email, @ModelAttribute("password") String password,
			@ModelAttribute("start_balance") String start_balance, @ModelAttribute("amount_to_save") String amount_to_save) {
		
		Double sBal = 0.0;
		Double toSave = 0.0;
		
		try {
			sBal = Double.parseDouble(start_balance);
			toSave = Double.parseDouble(amount_to_save);
		} catch (Exception e) {
			//to make more sophisticated, maybe an error page
			//or go back to the form with a form error?
			//TBD
		}
		
		//code to encrypt password
		
		User user = new User(fName, lName, email, password, sBal, toSave);
		
		userService.createUser(user);
		
		return "populateFinances";
	}
	
	// displaySummary.jsp
	@RequestMapping("/displaySummary")
	public String displaySummary() {
		return "displaySummary";
	}
	
	// displayTransactions.jsp
	@RequestMapping("/displayTransactions")
	public String displayTransactions() {
		return "displayTransactions";
	}
	
	// populateFinances.jsp
		@RequestMapping("/populateFinances")
		public String populateFinances() {
			return "populateFinances";
		}
	
	// THIS COMMENT IS TO PRACTICE MY GITHUB PUSH

	
	
}
















