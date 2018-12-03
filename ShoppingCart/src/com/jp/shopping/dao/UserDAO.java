package com.jp.shopping.dao;

import com.jp.shopping.entities.User;
import com.jp.shopping.exceptions.CartException;

public interface UserDAO {
	
	public User getUser(String username) throws CartException;
		
	public boolean insertUser(User user) throws CartException;

}
