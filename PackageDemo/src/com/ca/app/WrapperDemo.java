package com.ca.app;

public class WrapperDemo {
    public static void main(String[] args) {
        System.out.println(Integer.toHexString(255));
        System.out.println(Integer.toOctalString(255));
        System.out.println(Integer.toBinaryString(255));

        System.out.println(Character.isDigit('9'));

        Long n = 10000000L;

        Object o = n; //Upward casting
        Long k = (Long) o; //Downward casting

    }


}
