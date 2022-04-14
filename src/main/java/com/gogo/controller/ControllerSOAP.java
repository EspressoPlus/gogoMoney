package com.gogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gogo.entity.Income;
import com.gogo.entity.Outcome;
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
		List<String> users = userService.getUsers();
		m.addAttribute("users", users);  // needed if 
		//System.out.println("### ControllerSOAP users: " + users);
		return "landingPage";
		// submit action is /showTransactions
	}
	@RequestMapping("/validate")
	public String validate() {
		//List<User> users = userService.getUsers();
		//m.addAttribute("users", users);  // needed if 
		//System.out.println("### ControllerSOAP users: " + users);
		return "validate";
		// submit action is /showTransactions
	}
	
	// createAccount.jsp
	// -> displaySummary
	@RequestMapping("/createAccount")
	public String createAccount() {
		return "createAccount";
	}
	
	// displaySummary.jsp
	@RequestMapping("/displaySummary")
	public String displaySummary() {
		return "displaySummary";
	}
	
	// displayTransactions.jsp
	@RequestMapping("/displayTransactions")
	public String displayTransactions(Model m) {
		List<Outcome> outcomes = moneyService.getOutcomes();
		m.addAttribute("outcomes", outcomes);
		//System.out.println("### -> " + outcomes.get(0));
		System.out.println("### -> " + outcomes);
		List<Income> incomes = moneyService.getIncomes();
		m.addAttribute("incomes", incomes);
		return "displayTransactions";
	}
	
	// populateFinances.jsp
		@RequestMapping("/populateFinances")
		public String populateFinances() {
			return "populateFinances";
		}
	
	// THIS COMMENT IS TO PRACTICE MY GITHUB PUSH

	
	
}
















