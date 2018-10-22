package com.ca.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.function.Consumer;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.nio.file.Paths;

public class PropertyDemo {

    public static void main(String[] args) {

        //get single property value
        System.out.println(System.getProperty("user.home"));

        //get all properties
        Properties p = System.getProperties();

        //USING BASIC WHILE Loop
//        Iterator<String> s = p.stringPropertyNames().iterator();
//        while (s.hasNext()) {
//            String key = s.next();
//            System.out.println(key);
//            System.out.println(System.getProperty(key));
//        }

//        for (String key : p.stringPropertyNames()) {
//            System.out.println(key);
//            System.out.println(System.getProperty(key));
//        }

        //USING forEach
//        p.stringPropertyNames().forEach(key -> {
//            System.out.println(key);
//            System.out.println(System.getProperty(key));
//        });


//        p.stringPropertyNames().forEach(new Consumer<String>() {
//            @Override
//            public void accept(String key) {
//                System.out.println(key);
//                System.out.println(System.getProperty(key));
//            }
//        });

        p.stringPropertyNames().forEach(PropertyDemo::accept);


        //load property from file
        Properties p1 = new Properties();
        try {
            p1.load(PropertyDemo.class.getResourceAsStream("/resources/app.properties"));
            p1.setProperty("db.port", "1257");
            // p1.store(new FileOutputStream("./resources/app.properties"),"modified file");
            p1.store(new FileOutputStream(new File("./out/production/PackageDemo/resources/app.properties")),
                    "modified file");
        } catch (IOException ioEx) {
            System.out.println("Unable to load properties");
            ioEx.printStackTrace();
        }
    }

    public static void accept(String key) {
        System.out.println(key);
        System.out.println(System.getProperty(key));
    }
}
