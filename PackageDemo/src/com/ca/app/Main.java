package com.ca.app;

import com.ca.logic.*;

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        //System.out.println(c.doSum(12.2,14.4));

        Dog g = new Dog();
        System.out.println(g.getInfo());

        Dog g1 = new Dog("Maltese", "small", 5, "white");
        System.out.println(g1.getInfo());

        Student s1 = new Student(38,48,50);
        Student s2 = new Student(48,58,68);
        Student s3 = new Student(58,68,78);

        System.out.println("Result for student 1: "+s1.checkResult());
        System.out.println("Result for student 2: "+s2.checkResult());
        System.out.println("Result for student 3: "+s3.checkResult());

        Student.setPassing(40);

        System.out.println("Result for student 1: "+s1.checkResult());
        System.out.println("Result for student 2: "+s2.checkResult());
        System.out.println("Result for student 3: "+s3.checkResult());

        Student.setPassing(50);

        System.out.println("Result for student 1: "+s1.checkResult());
        System.out.println("Result for student 2: "+s2.checkResult());
        System.out.println("Result for student 3: "+s3.checkResult());

    }
}
