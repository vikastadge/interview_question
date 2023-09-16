package com.vikastadge.systemdesign.loggingFramework;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        super.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        String infoMessage = "INFO : " + message;
        logSubject.notifyAllObserver(level, infoMessage);
    }
}
