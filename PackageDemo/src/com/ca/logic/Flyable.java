package com.ca.logic;

public interface Flyable {

    int speed = 100;

    default void fly(){
        System.out.println("default ");
    }

    static void navigate(){
        System.out.println("Static Navigation");
    }
}
