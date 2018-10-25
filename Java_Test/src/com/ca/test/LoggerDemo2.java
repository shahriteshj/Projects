package com.ca.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo2 {

       static Logger log = LogManager.getLogger(LoggerDemo2.class);

    public static void main(String[] args) {
        log.warn("Warn Message");
        log.trace("Trace Message");
        log.info("Info Message");
        log.debug("Debug Message");
        log.error("Error Message");
        log.fatal("Exception Occurred", new RuntimeException("Dummy"));


    }


}
