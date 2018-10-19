package com.ca.app;

public class GenericStudent<T> {

    public int compareTo(T t) {
        System.out.println("Using compareTo!!");
        return this.rollNo - o.rollNo;
    }

}
