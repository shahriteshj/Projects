package com.ca.dao;

import com.ca.entity.Department;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

/**
 * DepartmentDAO class
 */
public class DepartmentDAO {

    private static final String SQLDEPARTMENT = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, " +
            "LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";

    /**
     *
     * Method to connect to database and get department details of department 30
     */
    public static void main(String[] args) {

        Department d = new Department();
        try {
            JdbcRowSet rset = RowSetProvider.newFactory().createJdbcRowSet();
            rset.setUrl("jdbc:oracle:thin:@localhost:1521/orcl");
            rset.setUsername("hr");
            rset.setPassword("hr");
            rset.setCommand(SQLDEPARTMENT);
            rset.setInt(1, 30);
            rset.execute();

            while (rset.next()) {
                d.setDepartment_id(rset.getInt(1));
                d.setDepartment_name(rset.getString(2));
                d.setManager_id(rset.getInt(3));
                d.setLocation_id(rset.getInt(4));
            }
            System.out.println(d.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}