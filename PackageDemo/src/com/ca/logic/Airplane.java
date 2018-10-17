package com.ca.logic;

public class Airplane implements Flyable {

    public void fly(){
        System.out.println("Airplane fly");
    }

    public static void main(String[] args) {
        Airplane plane = new Airplane();
        plane.fly();
        Flyable.navigate();

    }
}
