package com.jp.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HRException;

public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		String userName = "hr";
		String password = "hr";

		// try {
		Class.forName(driverName);
		return DriverManager.getConnection(url, userName, password);
		// } catch (ClassNotFoundException e) {
		// throw new HRException("Driver class missing");
		// } catch (SQLException e) {
		// throw new HRException("Connection Failed");
		// }

	}

	private void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public ArrayList<Employee> getEmployeeList() throws HRException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT employee_id, first_name, last_name FROM EMPLOYEES");
			while (rs.next()) {
				int empId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				empList.add(new Employee(empId, firstName, lastName));
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new HRException("Problem in fetching data.", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				closeConnection(conn);
			} catch (SQLException e) {
				throw new HRException("Problem in closing resources.", e);
			}

		}
		return empList;
	}

}
