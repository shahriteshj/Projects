package com.ca.app;

public class GenericStudent<T> {
    private int age;
    private int id;
    private String firstName;
    private String lastName;

    public int compareTo(T t) {
        System.out.println("Using compareTo!!");
        return 1;
    }

}
