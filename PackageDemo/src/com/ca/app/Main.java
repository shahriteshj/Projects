package com.ca.app;

import com.ca.logic.*;

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        //System.out.println(c.doSum(12.2,14.4));

        Dog g = new Dog();
        System.out.println(g.getInfo());

        Dog g1 = new Dog("Maltese","small",5,"white");
        System.out.println(g1.getInfo());

    }
}
