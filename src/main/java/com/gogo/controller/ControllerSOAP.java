package com.gogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gogo.entity.User;
import com.gogo.service.MoneyService;
import com.gogo.service.UserService;

@Controller
public class ControllerSOAP {
	
	@Autowired
	private UserService userService;
	private MoneyService moneyService;
	
	// landingPage.jsp
	// landing page for user login / create acct
	// login -> /displaySummary
	// create -> /createAcct
	@RequestMapping("/")
	public String userPage() {
		//List<User> users = userService.getUsers();
		//m.addAttribute("users", users);  // needed if 
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
		return "createAccount.jsp";
	}
	
	// displaySummary.jsp
	@RequestMapping("/displaySummary")
	public String displaySummary() {
		return "displaySummary.jsp";
	}
	
	// displayTransactions.jsp
	@RequestMapping("/displayTransactions")
	public String displayTransactions() {
		return "displayTransactions.jsp";
	}

	
	
}
















