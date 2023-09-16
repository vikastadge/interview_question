package com.vikastadge.systemdesign.RateLimiter.SlidingWindow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        UserBucketCreator userBucketCreator = new UserBucketCreator("vikas");
        ExecutorService service = Executors.newFixedThreadPool(12);
        for(int i = 0;i<12;i++){
            service.execute(() -> userBucketCreator.accessApplication("vikas"));
        }
    }
}
