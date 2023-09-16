package com.vikastadge.systemdesign.RateLimiter.SlidingWindow;

import com.vikastadge.systemdesign.RateLimiter.RateLimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow implements RateLimiter {

    private final Queue<Long> queue;
    private final int timeWindowInSecs;
    private final int capacity;

    public SlidingWindow(int timeWindowInSecs, int capacity) {
        this.queue = new ConcurrentLinkedQueue<>();
        this.timeWindowInSecs = timeWindowInSecs;
        this.capacity = capacity;
    }

    @Override
    public boolean grantAccess() {
        ensureCapacity();
        long currentTime = System.currentTimeMillis();
        if (queue.size() < capacity) {
            queue.offer(currentTime);
            return true;
        }
        return false;
    }

    private void ensureCapacity() {
        if (queue.isEmpty()) {
            return;
        }
        long currentTime = System.currentTimeMillis();
        long calculatedTime = (currentTime - queue.peek()) / 1000;
        while (calculatedTime >= timeWindowInSecs && !queue.isEmpty()) {
            calculatedTime = (currentTime - queue.poll()) / 1000;
        }
    }

}
