package com.ca.app;

import java.util.*;
import static java.util.Arrays.*;

public class CollectionDemo {
    public static void main(String[] args) {
        List data = new ArrayList();
        data.add(100);
        data.add(123);
        data.add(100);
        data.add("Hello");
        data.add(12.99);
        data.add("Hello");

        Iterator it = data.iterator();
        System.out.println("Displaying all elements from List");
        while(it.hasNext()){
            System.out.println(it.next());
        }


        Set data2 = new HashSet();
        data2.addAll(data);
        it = data2.iterator();
        System.out.println("Displaying all elements from Set");
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //to move backward.
        //Can be only used for List
        ListIterator lit = data.listIterator();

        Integer n = 110;
        Integer s =  110;
        System.out.println(n.compareTo(s));


    }
}
