package com.ca.app;

public class Test {
    public static void main(String[] args) {
        String propValue = System
                .getProperty("java.nio.file.spi.DefaultFileSystemProvider");

        System.out.println(propValue);
    }
}
