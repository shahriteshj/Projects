package com.ca.app;

public class SwitchExample {

    public static void main(String[] args) {
        int numOfAngles = 3;

        switch (numOfAngles) {
            case 3:
                System.out.println("triangle");

            case 4:
                System.out.println("rectangle");
                break;
            case 5:
                System.out.println("pentagon");
                break;
            default:
                System.out.println("Unknown shape");

        }
    }
}
