package com.gogo.dao;

import java.util.List;

import com.gogo.entity.User;


//import main.java.com.gogo.entity.User;


public interface UserDAO {

	public List<User> getUsers();
	
	public User getUser(int id);
	
	public void saveUser(User theUser);
	
	public void deleteUser(int id);
	
	public List<User> getEmail(String email, String password);
	
	public User getUserInfo(String email); 

}
