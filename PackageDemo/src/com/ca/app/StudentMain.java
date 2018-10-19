package com.ca.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        List students = new ArrayList();
        students.add(new Student(101,"Tony","Jaa",12));
        students.add(new Student(102,"Charles","Chaplin",14));
        students.add(new Student(103,"John","Snow",15));
        students.add(new Student(104,"Will","Smith",11));

        Collections.sort(students);
        System.out.println("After sorting...");

        for(Object o: students){
            System.out.println(o);
        }
    }
}
