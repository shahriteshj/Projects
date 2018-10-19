package com.ca.logic;

public class Computer {
    private Storage disk;
    private Display display;

    public Computer(Storage storage, Display display) {
        this.disk = storage;
        this.display = display;
    }

    public void display() {
        this.disk.read();
        this.disk.write();
        this.display.show();
    }

}
