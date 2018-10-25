package com.ca.db;

import oracle.jdbc.replay.OracleDataSourceFactory;

import javax.management.loading.ClassLoaderRepository;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class JDBCConnectionPooling {
    int initialConnections = 5;
    Vector connectionsAvailable = new Vector();
    Vector connectionsUsed = new Vector();
    private static String driver;
    private static String user;
    private static String password;
    private static String url;

    static {
        Properties p = new Properties();
        try {
            p.load(ClassLoaderRepository.class.getResourceAsStream("/resources/db.properties"));
            driver = p.getProperty("db.driver");
            url = p.getProperty("db.url");
            user = p.getProperty("db.user");
            password = p.getProperty("db.password");

            Class.forName(driver);

        } catch (IOException ioEx) {
            System.out.println("Database property file not found");
            ioEx.printStackTrace();
        }catch (ClassNotFoundException cnfEx) {
            System.out.println("Driver Class Not found");
            cnfEx.printStackTrace();
        }
    }

    public JDBCConnectionPooling() throws SQLException{
        for(int count=0;count<initialConnections;count++){
            connectionsAvailable.add(getConnection());
        }
    }

    private Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

}
