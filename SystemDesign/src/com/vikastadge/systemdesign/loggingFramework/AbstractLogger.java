package com.vikastadge.systemdesign.loggingFramework;

public abstract class AbstractLogger {
    protected int level;

    private AbstractLogger nextLoggingLevel;

    public void setNextLoggingLevel(AbstractLogger nextLoggingLevel) {
        this.nextLoggingLevel = nextLoggingLevel;
    }

    void logMessage(int level, String message, LogSubject logSubject){
        if(this.level == level){
            display(message, logSubject);
        }else if(nextLoggingLevel != null) {
            nextLoggingLevel.logMessage(level, message, logSubject);
        }
    }

    protected abstract void display(String message, LogSubject logSubject);

}
