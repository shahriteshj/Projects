package com.jp.hr.services;

import com.jp.hr.dao.UserDAO;
import com.jp.hr.dao.UserDAOImpl;
import com.jp.hr.entities.User;
import com.jp.hr.exceptions.HRException;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = null;
	
	public UserServiceImpl() throws HRException{
		userDAO = new UserDAOImpl();
	}
	
	@Override
	public User findByUsername(String username) throws HRException {
		return userDAO.getUser(username);
		
	}

	@Override
	public boolean addNewUser(User user) throws HRException {
		return userDAO.insertUser(user);
	}

}
