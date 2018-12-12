package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.DaoEmployee;

@Repository("daoDS")
public class DaoEmployeeImplDS implements DaoEmployee {

	@Autowired
	@Qualifier("ds")
	private DataSource dataSource;

	@Override
	public ArrayList<Employee> getEmpList() throws HrException {
		ArrayList<Employee> empList = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.createStatement();
			rs = stmt.executeQuery("Select EMPLOYEE_ID,FIRST_NAME,LAST_NAME from employees");
			while (rs.next()) {
				int empId = rs.getInt("EMPLOYEE_ID");
				String firstNm = rs.getString("FIRST_NAME");
				String lastNm = rs.getString("LAST_NAME");
				empList.add(new Employee(empId, firstNm, lastNm));
			}
		} catch (SQLException e) {
			throw new HrException("Problem in fetching.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				connect.close();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
		return empList;
	}

	@Override
	public Employee getEmpDetails(int empId) throws HrException {
		String qry = "Select EMPLOYEE_ID,FIRST_NAME,LAST_NAME from employees where EMPLOYEE_ID = ?";
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.prepareStatement(qry);
			stmt.setInt(1, empId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String firstNm = rs.getString("FIRST_NAME");
				String lastNm = rs.getString("LAST_NAME");
				return new Employee(empId, firstNm, lastNm);
			} else {
				// Id is wrong.
				return null;
			}
		} catch (SQLException e) {
			throw new HrException("Problem in fetching.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				connect.close();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
		
	}

	@Override
	public boolean insertNewRecord(Employee emp) throws HrException {
		String qry = "INSERT INTO employees (EMPLOYEE_ID,FIRST_NAME,LAST_NAME) VALUES (?,?,?)";
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.prepareStatement(qry);
			stmt.setInt(1, emp.getEmpId());
			stmt.setString(2, emp.getFirstName());
			stmt.setString(3, emp.getLastName());

			int recInserted = stmt.executeUpdate();
			return recInserted == 1 ? true : false;

		} catch (SQLException e) {
			throw new HrException("Problem in fetching.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				connect.close();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
	}

}
