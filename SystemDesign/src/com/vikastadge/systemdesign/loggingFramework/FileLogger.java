package com.vikastadge.systemdesign.loggingFramework;

public class FileLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("FILE : "+message);
    }
}
