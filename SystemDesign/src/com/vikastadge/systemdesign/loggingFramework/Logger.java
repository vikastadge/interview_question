package com.vikastadge.systemdesign.loggingFramework;

import static com.vikastadge.systemdesign.loggingFramework.LogManager.buildChainOfLogger;
import static com.vikastadge.systemdesign.loggingFramework.LogManager.buildSubject;

public class Logger {

    private static Logger INSTANCE;
    private static  AbstractLogger chainOfLogger;
    private static LogSubject logSubject;
    private Logger(){
        if(INSTANCE != null){
            throw new IllegalStateException("Object already exists");
        }
    }

    public static final Logger getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Logger();
            chainOfLogger = buildChainOfLogger();
            logSubject = buildSubject();
        }
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected  Object readResolve(){
        return INSTANCE;
    }

    private void createMessage(int level, String message){
        chainOfLogger.logMessage(level, message, logSubject);
    }

    public void debug(String message){
        createMessage(1, message);
    }

    public void info(String message){
        createMessage(2, message);
    }

    public void error(String message){
        createMessage(3, message);
    }

}
