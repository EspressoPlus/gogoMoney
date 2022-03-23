package com.gogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gogo.entity.User;
import com.gogo.service.UserService;

@Controller
public class ControllerSOAP {
	
	@Autowired
	private UserService userService;
	
	// index.jsp
	@RequestMapping("/")
	public String indexPage(Model m) {
		List<String> users = userService.getUsers();
		m.addAttribute("users", users);
		System.out.println("### ControllerSOAP users: " + users);
		return "index";
		// submit action is /showTransactions
	}
	
}
















