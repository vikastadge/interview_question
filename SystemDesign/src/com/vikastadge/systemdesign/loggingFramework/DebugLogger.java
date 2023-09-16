package com.vikastadge.systemdesign.loggingFramework;

public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level) {
        super.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        String debugMessage = "DEBUG : " + message;
        logSubject.notifyAllObserver(this.level, debugMessage);
    }
}
