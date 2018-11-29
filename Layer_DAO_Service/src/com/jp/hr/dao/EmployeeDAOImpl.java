package com.jp.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HRException;
import com.jp.hr.utilities.ConnectionFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

	private ConnectionFactory factory;

	public EmployeeDAOImpl() throws HRException {
		try {
			factory = new ConnectionFactory();
		} catch (ClassNotFoundException | SQLException e) {
			throw new HRException("Problem in creating database connection",e);
		}

	}

	private void closeConnection(Connection conn) throws HRException {
//		try {
//			factory.closeConnection();
//		} catch (SQLException e) {
//			throw new HRException("Problem in releasing database connection",e);
//		}
	}

	@Override
	public ArrayList<Employee> getEmployeeList() throws HRException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			conn = factory.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT employee_id, first_name, last_name FROM EMP_DETAILS");
			while (rs.next()) {
				int empId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				empList.add(new Employee(empId, firstName, lastName));
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
				closeConnection(conn);
			} catch (SQLException e) {
				throw new HRException("Problem in closing resources.", e);
			}

		}
		return empList;
	}

	@Override
	public Employee getEmpDetails(int empId) throws HRException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String strQuery = "SELECT employee_id, first_name, last_name FROM EMP_DETAILS WHERE employee_id=?";
		try {
			conn = factory.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setInt(1, empId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				return new Employee(empId, firstName, lastName);
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
				closeConnection(conn);
			} catch (SQLException e) {
				throw new HRException("Problem in closing resources.", e);
			}

		}

	}

	@Override
	protected void finalize() throws Throwable {
		factory.closeConnection();
		super.finalize();
	}

	@Override
	public boolean insertNewRecord(Employee emp) throws HRException {
		Connection conn = null;
		PreparedStatement stmt = null;

		String strQuery = "INSERT INTO EMP_DETAILS (employee_id,first_name,Last_name) VALUES(?,?,?)";
		try {
			conn = factory.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setInt(1, emp.getEmpId());
			stmt.setString(2, emp.getFirstName());
			stmt.setString(3, emp.getLastName());
			int recInserted = stmt.executeUpdate();
			return recInserted == 1 ? true : false;

		} catch (SQLException e) {
			throw new HRException("Problem in fetching data.", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				closeConnection(conn);
			} catch (SQLException e) {
				throw new HRException("Problem in closing resources.", e);
			}

		}
	}

}
