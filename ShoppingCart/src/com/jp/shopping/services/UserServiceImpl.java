package com.jp.shopping.services;

import com.jp.shopping.dao.UserDAO;
import com.jp.shopping.dao.UserDAOImpl;
import com.jp.shopping.entities.User;
import com.jp.shopping.exceptions.CartException;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = null;
	
	public UserServiceImpl() throws CartException{
		userDAO = new UserDAOImpl();
	}
	
	@Override
	public User findByUsername(String username) throws CartException {
		return userDAO.getUser(username);
		
	}

	@Override
	public boolean addNewUser(User user) throws CartException {
		return userDAO.insertUser(user);
	}

}
