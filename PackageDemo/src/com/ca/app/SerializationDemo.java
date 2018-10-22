package com.ca.app;

import com.ca.logic.Employee;

import java.io.*;
import java.time.LocalDate;

public class SerializationDemo {

    static void writeFile(String filename) {
        Employee emp = new Employee("Vijay", "Malya", 68, LocalDate.of(1990, 02, 12));

        try {
            File file = new File(filename);
            if ( !file.exists() ) {
                file.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(file, true);
            ObjectOutputStream objout = new ObjectOutputStream(out);
            objout.writeObject(emp);
            objout.close();
        } catch (IOException ioex) {
            ioex.getMessage();
        }


    }


    static void readFile(String filename) {
        try {
            FileInputStream in = new FileInputStream(filename);
            ObjectInputStream oin = new ObjectInputStream(in);

            Object obj = oin.readObject();
            while (obj != null) {
                if ( obj instanceof Employee ) {
                    System.out.println(obj.toString());
                }
                obj = oin.readObject();
            }
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
            ioEx.printStackTrace();
        } catch (ClassNotFoundException cnfEx) {
            System.out.println(cnfEx.getMessage());
            cnfEx.printStackTrace();
        }
    }


    public static void main(String[] args) {
        writeFile("D:\\Projects\\emp");
        readFile("D:\\Projects\\emp");
    }
}
