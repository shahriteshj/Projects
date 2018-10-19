package com.ca.app;

public class Student implements Comparable<Student> {

    private int rollNo;
    private String firstName;
    private String lastName;
    private int age;

    public Student(int rollNo, String firstName, String lastName, int age) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String toString() {
        return rollNo + " ,Name: " + firstName + " " + lastName + " age:  " + age;
    }


    @Override
    public int compareTo(Student o) {
        System.out.println("Using compareTo!!");
        return this.rollNo - o.rollNo;
    }

}
