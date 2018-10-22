package com.ca.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.net.URI;

public class FileDemo {
    public static void main(String[] args) {
        try {

            //File using URI
            File f1 = new File(URI.create("file:///d:/projects"));
            if ( f1.exists() ) {
                System.out.println("It exists");
            }
            if ( f1.isDirectory() ) {
                System.out.println("It is a directory");
            } else {
                System.out.println("Its not a directory");
            }


            //File using windows path
            File f = new File("D:\\Projects\\SampleText.txt");
            if ( f.exists() ) {
                System.out.println("It exists");
            }
            if ( f.isDirectory() ) {
                System.out.println("It is a directory");
            } else {
                System.out.println("Its not a directory");
            }


            File newFile = new File(f.getParent(), "abcd.txt");
            if ( newFile.exists() ) {
                System.out.println("File already exists");
                newFile.delete();
            } else {
                System.out.println("File does not exist");
                newFile.createNewFile();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
