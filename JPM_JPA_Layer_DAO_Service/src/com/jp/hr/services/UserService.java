package com.jp.hr.services;

import com.jp.hr.entities.User;
import com.jp.hr.exceptions.HRException;

public interface UserService {
	
	public User findByUsername(String username) throws HRException;
	
	public boolean addNewUser(User user) throws HRException;
	

}
