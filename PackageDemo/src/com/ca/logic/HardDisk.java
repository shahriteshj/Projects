package com.ca.logic;

public class HardDisk implements Storage {
    @Override
    public void read() {
        System.out.println("In Hard Disk Read");
    }

    @Override
    public void write() {
        System.out.println("In Hard Disk Write");
    }
}
