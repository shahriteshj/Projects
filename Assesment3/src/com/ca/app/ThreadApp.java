package com.ca.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ThreadApp
 *
 * @author Ritesh Shah
 * @version 1.0
 * Date 10/31/2018
 * Thread using “Runnable” Interface to display Current Date & Time with interval of 1 second.
 */

public class ThreadApp implements Runnable {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * run method of thread with infinite loop to display current date and time every 1 second
     */
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(LocalDateTime.now().format(formatter)); //Display current date and time
                Thread.sleep(1000); //Thread sleep for 1 sec

            }
        } catch (InterruptedException intEx) {
            System.out.println(intEx.getMessage());
            intEx.printStackTrace();
        }
    }

    /**
     * Main method to create and run thread to display Date and time every 1 sec
     */
    public static void main(String[] args) {
        //Create TASK
        ThreadApp tApp = new ThreadApp();

        //Create WORKER thread and assign task
        Thread t = new Thread(tApp);

        //Launch THREAD
        t.start();
    }
}
