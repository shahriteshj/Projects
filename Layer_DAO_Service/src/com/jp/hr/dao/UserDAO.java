package com.jp.hr.dao;

import com.jp.hr.entities.User;
import com.jp.hr.exceptions.HRException;

public interface UserDAO {
	
	public User getUser(String username) throws HRException;
		
	public boolean insertUser(User user) throws HRException;

}
