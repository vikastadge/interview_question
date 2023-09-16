package com.vikastadge.systemdesign.loggingFramework;

public class Application {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.debug("this is debug");
        logger.info("this is info");
        logger.error("this is error");
    }
}
