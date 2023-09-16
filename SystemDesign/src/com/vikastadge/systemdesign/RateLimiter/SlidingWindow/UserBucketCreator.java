package com.vikastadge.systemdesign.RateLimiter.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    private final Map<String, SlidingWindow> buckets = new HashMap<>();

    public UserBucketCreator(String userId) {
        SlidingWindow window = new SlidingWindow(1, 10);
        buckets.put(userId, window);
    }

    void accessApplication(String id){
        if(buckets.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        }else{
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }
}
