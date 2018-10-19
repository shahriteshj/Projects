package com.ca.app;

public class VarArgDemo {
    public static void main(String[] args) {
        System.out.println(doSum1(1, 2, 3, 4, 5));
    }

    static int doSum(int[] data) {
        int sum = 0;
        for (int i : data) {
            sum += i;
        }
        return sum;
    }

    static int doSum1(int... data) {
        System.out.println("varargs");
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }
}
