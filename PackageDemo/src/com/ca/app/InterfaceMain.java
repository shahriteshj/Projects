package com.ca.app;

import com.ca.logic.Computer;
import com.ca.logic.HardDisk;
import com.ca.logic.Monitor;

public class InterfaceMain {
    public static void main(String[] args) {
        Computer c = new Computer(new HardDisk(),new Monitor());
        c.display();
    }
}
