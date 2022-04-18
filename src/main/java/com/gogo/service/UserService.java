package com.gogo.service;


import java.util.List;

import com.gogo.entity.User;


//import main.java.com.gogo.entity.User;


public interface UserService {

	public List<User> getUsers();
	
	public Boolean validateLogin(String email, String password);
	
	public User getUserInfo(String email); 
}
