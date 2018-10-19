package com.ca.app;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            
            Thread.sleep(100000);
            System.out.println("hello world");

            int k = 100 / 2;
            int data[] = new int[1];
            data[1] = k;
            System.out.println("Answer: " + k);
        } catch (ArithmeticException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid index " + ex.getMessage());
        } finally {
            System.out.println("In Finally Block");
        }
        System.out.println("End of Main");

        try {
            calc(230, 13.5, 36);
        }catch(Exception ex){
            System.out.println("Something went wrong: " + ex.getMessage());
        }
    }

    static void calc(double p, double r, int d) throws Exception{
        if ( p < 10000 || p > 10000000 )
            throw new Exception("Principal amount must be in range of 10000 to 10000000");
        if ( r < 4 || r > 25 )
            throw new Exception("Rate of interest must be in range 4 to 25");
        if ( d < 12 || d > 240 )
            throw new Exception("Duration must be in range 12 to 240 months");

        double interest = p * r / 100 * d / 12;
        System.out.println("Interest: " + interest);
    }
}
