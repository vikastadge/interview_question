package com.vikastadge.systemdesign.loggingFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {
    private final Map<Integer, List<LogObserver>> logObservers = new HashMap<>();

    public void addObserver(int level, final LogObserver logObserver){
        final List<LogObserver> list = logObservers.getOrDefault(level, new  ArrayList<>());
        list.add(logObserver);
        logObservers.put(level, list);
    }

    void notifyAllObserver(int level, String message){
        final List<LogObserver> observersToNotify = logObservers.getOrDefault(level, new ArrayList<>());
        observersToNotify.forEach(o -> o.log(message));

    }
}
