package RateLimiter.src.impl.leakyBucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {

        UserBucketCreator userBucketCreator1 = new UserBucketCreator("USER-1");
        ExecutorService service = Executors.newFixedThreadPool(12);
        for (int i = 0; i < 12; i++) {
            service.execute(() -> userBucketCreator1.accessApplication("USER-1"));
        }
        service.shutdown();
    }

}

//class Solution {
//    public static boolean rateLimiter(String userID, int limit) {
//
//        return false;
//    }
//}


/*
    USER-1 sec-1 true
    USER-1 sec-2 false
    USER-1 sec-3 true
    USER-1 sec-4 false
    USER-2 sec-4 true
    USER-2 sec-5 false
 */
