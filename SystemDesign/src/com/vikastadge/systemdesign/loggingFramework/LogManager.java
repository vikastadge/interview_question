package com.vikastadge.systemdesign.loggingFramework;

public class LogManager {

    public static AbstractLogger buildChainOfLogger() {
        AbstractLogger debugLogger = new DebugLogger(1);
        AbstractLogger infoLogger = new InfoLogger(2);
        AbstractLogger errorLogger = new ErrorLogger(3);

        debugLogger.setNextLoggingLevel(infoLogger);
        infoLogger.setNextLoggingLevel(errorLogger);
        return debugLogger;
    }

    public static LogSubject buildSubject(){
        LogSubject logSubject = new LogSubject();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();
        logSubject.addObserver(3, consoleLogger);
        logSubject.addObserver(1, fileLogger);
        logSubject.addObserver(2, fileLogger);
        logSubject.addObserver(3, fileLogger);
        return logSubject;
    }
}
