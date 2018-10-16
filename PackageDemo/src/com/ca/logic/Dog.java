package com.ca.logic;

public class Dog {
    private String breed;
    private String size;
    private int age;
    private String color;


    public Dog() {
        breed = "Unknown";
        size = "unknown";
        age = 1;
        color = "unknown";
    }

    public Dog(String breed, String size, int age, String color) {
        this.breed = breed;
        this.size = size;
        this.age = age;
        this.color = color;
    }

    public String getInfo() {
        return ("Breed is " + breed + " Size is " + size + " Age is " + age + " color is " + color);
    }
}


