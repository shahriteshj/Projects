package com.ca.app;

public class ThreadDemo implements Runnable{
    private String statement;

    public ThreadDemo(String statement) {
        this.statement = statement;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < statement.length(); i++) {
                //System.out.println(Thread.currentThread().getName());
                System.out.print(" " + statement.charAt(i));
                Thread.sleep(500);
            }
        }catch (InterruptedException ex){

        }
    }

    public static void main(String[] args) {

        //Create TASK
        ThreadDemo d = new ThreadDemo("The quick brown fox jumps over the lazy dog.");
        ThreadDemo d2 = new ThreadDemo("123456789124564564645464");

        //Create WORKER thread and assign task
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d2);

        //Launch THREAD
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of program");
    }
}
