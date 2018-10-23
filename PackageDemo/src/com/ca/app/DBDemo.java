package com.ca.app;

import org.apache.log4j.Logger;

import javax.management.loading.ClassLoaderRepository;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBDemo {

    static Logger Log = Logger.getLogger(DBDemo.class);

    public static void main(String[] args) {
        Properties p = new Properties();
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            p.load(ClassLoaderRepository.class.getResourceAsStream("/resources/db.properties"));
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(p.getProperty("url"), p);

            s = conn.createStatement();
            rs = s.executeQuery("Select * from Employee");
            while (rs.next()) {
                Log.info(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (ClassNotFoundException | SQLException | IOException cnfEx) {
            cnfEx.printStackTrace();
        } finally {
            try {
                if ( rs != null )
                    rs.close();
                if ( s != null )
                    s.close();
                if ( conn != null )
                    conn.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }

        }
    }
}
