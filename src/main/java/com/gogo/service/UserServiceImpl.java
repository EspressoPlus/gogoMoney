package com.gogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gogo.dao.UserDAO;
import com.gogo.entity.User;

//import main.java.com.gogo.dao.UserDAO;
//import main.java.com.gogo.entity.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public List<User> getUsers() 
	{
		// TODO Auto-generated method stub
//		List<User> users = new ArrayList<>();
//		users.add("user33");
////		users.add("user02");
//		users.add("user03");
		//return null;
		return userDAO.getUsers();
	}
	
	@Override
	@Transactional
	public User getUser(int user_id) 
	{
		return userDAO.getUser(user_id);
	}
	
	@Override
	@Transactional
	public Boolean validateLogin(String email, String password)
	{
		List<User> matches = userDAO.getEmail(email,password);
		int i = matches.size();
		System.out.println("Matches in USI says = " + matches + ", and the size is = " + i);
		if(matches.size()==0)
		{
			return false;
		}
		else
		{
			
			return true;
		}
	}
	
	@Override
	@Transactional
	public User getUserInfo(String email) 
	{
		return userDAO.getUserInfo(email);
	}

	@Override
	@Transactional
	public void createUser(User user) {
		userDAO.saveUser(user);
	}
 

}
