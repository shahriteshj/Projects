package com.jp.shopping.services;

import com.jp.shopping.entities.User;
import com.jp.shopping.exceptions.CartException;

public interface UserService {
	
	public User findByUsername(String username) throws CartException;
	
	public boolean addNewUser(User user) throws CartException;
	

}
