package com.jp.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.jp.hr.entities.User;
import com.jp.hr.exceptions.HRException;
import com.jp.hr.utilities.ConnectionFactoryTomcat;

public class UserDAOImpl implements UserDAO {

	DataSource dataSource=null;
	
	public UserDAOImpl() throws HRException{
		ConnectionFactoryTomcat factory = ConnectionFactoryTomcat.getConnectionFactory();
		dataSource = factory.getDataSource();
	}
	
	@Override
	public User getUser(String username) throws HRException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String strQuery = "SELECT * FROM USERS WHERE UserId=?";
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String username1 = rs.getString("userId");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String role = rs.getString("role");
				
				return new User(name,username1,password,email,role);
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw new HRException("Problem in fetching data.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new HRException("Problem in closing resources.", e);
			}

		}

	}

	@Override
	public boolean insertUser(User user) throws HRException {
		Connection conn = null;
		PreparedStatement stmt = null;

		String strQuery = "INSERT INTO Users (name,userid,password,email,role) VALUES(?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getRole());
			int recInserted = stmt.executeUpdate();
			return recInserted == 1 ? true : false;

		} catch (SQLException e) {
			throw new HRException("Problem in fetching data.", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new HRException("Problem in closing resources.", e);
			}

		}
	}

}
