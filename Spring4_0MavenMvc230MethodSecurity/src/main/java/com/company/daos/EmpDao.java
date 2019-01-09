package com.company.daos;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;

@Repository("empDao")
public class EmpDao {
	private DataSource dataSource;
	
	public EmpDao(){
	}
	
	// Default For type
	@Autowired
	public void setDataSource1(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Secured("ROLE_USER") //IS_AUTHENTICATED_ANONYMOUSLY, ROLE_USER, ROLE_TELLER
	//@PreAuthorize("hasAuthority('ROLE_TELLER')") // @PreAuthorize("isAnonymous()")
	public List<Emp> getAllEmps() {
		// Report details
		String qry = "Select EMP_ID, EMP_NAME, EMP_SAL from Emp_JT";
		List<Emp> l = new ArrayList<Emp>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(qry);
			
			while(rs.next()){
				Emp ep = new Emp();
				ep.setEmpNo(rs.getInt("EMP_ID"));
				ep.setEmpNm(rs.getString("EMP_NAME"));
				ep.setEmpSal(rs.getFloat("EMP_SAL"));
				l.add(ep);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try { rs.close(); stmt.close(); conn.close(); } catch(Exception e) { }
		}
		
		return l;
	}
}
