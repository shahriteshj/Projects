package com.ca.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String propValue = System
                .getProperty("java.nio.file.spi.DefaultFileSystemProvider");

        System.out.println(propValue);

        DateTimeFormatter formatter = null;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s = scan.next();
        System.out.println(s);
        LocalDate d = LocalDate.parse(s,formatter);
        System.out.println(d.toString());
    }
}
