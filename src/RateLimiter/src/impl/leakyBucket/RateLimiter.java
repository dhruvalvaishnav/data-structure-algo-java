package RateLimiter.src.impl.leakyBucket;

public interface RateLimiter {

    boolean grantAccess();
}
