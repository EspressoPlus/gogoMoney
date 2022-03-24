package com.gogo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gogo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<String> getUsers() {
		// TODO Auto-generated method stub
		List<String> users = new ArrayList<>();
		users.add("user33");
		users.add("user02");
		users.add("user03");
		//return null;
		return users;
	}


}
