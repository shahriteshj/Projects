package com.ca.db;

import org.apache.log4j.Logger;

import javax.management.loading.ClassLoaderRepository;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class OracleConnection {

    static Logger log = Logger.getLogger(OracleConnection.class);
    private static String driver;
    private static String user;
    private static String password;
    private static String url;

    static {
        Properties p = new Properties();
        try {
            p.load(ClassLoaderRepository.class.getResourceAsStream("/resources/db.properties"));
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            user = p.getProperty("user");
            password = p.getProperty("password");

        } catch (IOException ioEx) {
            log.error("Database property file not found");
            ioEx.printStackTrace();
        }
    }

    private static void RegisterDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException cnfEx) {
            log.error("Driver Class Not found");
            cnfEx.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con=null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException sqlEx) {
            log.error("Could not create DB connection");
            sqlEx.printStackTrace();
        }
        return con;
    }



}
