package com.ca.app;

import org.apache.log4j.Logger;


public class LoggerDemo1 {

    static Logger log = Logger.getLogger(LoggerDemo1.class);

    public static void main(String[] args) {
        log.warn("Warn Message");
        log.trace("Trace Message");
        log.info("Info Message");
        log.debug("Debug Message");
        log.error("Error Message");
        log.fatal("Exception Occurred", new RuntimeException("Dummy"));


    }


}
