package com.ca.app;

import com.sun.org.apache.bcel.internal.util.ClassLoaderRepository;
import java.io.IOException;
import java.util.Properties;

public class DBConnection {
    public static void main(String[] args) {
        Properties p = new Properties();

        try {
            p.load(ClassLoaderRepository.class.getResourceAsStream("/resources/db.properties"));
            for (String key : p.stringPropertyNames()) {
                System.out.println(key+ ": "+ p.getProperty(key));
            }

        }catch(IOException ioEx){
            System.out.println("Unable to load database Properties file");
            ioEx.printStackTrace();
        }
    }


}
