package com.vikastadge.systemdesign.loggingFramework;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        super.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        String errorMessage = "ERROR : "+ message;
        logSubject.notifyAllObserver(level, errorMessage);
    }
}
