package RateLimiter.src.impl.leakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {

    Map<String, LeakyBucket> bucket;

    public UserBucketCreator(String userID) {
        this.bucket = new HashMap<>();
        this.bucket.put(userID, new LeakyBucket(10));
    }

    void accessApplication(String userID) {
        if (bucket.get(userID).grantAccess()) {
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Too many requests, Please try after sometime!!");
        }

    }
}
