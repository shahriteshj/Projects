package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.DaoEmployee;

@Repository("daoDS")
public class DaoEmployeeImplDS implements DaoEmployee {

	@Autowired
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
				// factory.closeConnection();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
		return empList;
	}

	@Override
	public Employee getEmpDetails(int empId) throws HrException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertNewRecord(Employee emp) throws HrException {
		// TODO Auto-generated method stub
		return false;
	}

}
