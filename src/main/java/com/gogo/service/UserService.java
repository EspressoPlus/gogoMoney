package com.gogo.service;


import java.util.List;

import com.gogo.entity.Transaction;
import com.gogo.entity.User;

public interface UserService {

	public List<User> getUsers();

	public User getUser(int id);

}
