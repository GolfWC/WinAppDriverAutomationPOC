package Utils;

import java.util.function.Supplier;

public class RetryUtils {

    public static <T> T retry(Supplier<T> operation, int maxRetries, long delayInMillis) {
        int attempt = 0;
        while (attempt < maxRetries) {
            try {
                return operation.get();
            } catch (Exception e) {
                attempt++;
                if (attempt >= maxRetries) {
                    throw e;
                }
                try {
                    Thread.sleep(delayInMillis);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Retry operation interrupted", ie);
                }
            }
        }
        throw new RuntimeException("Retry operation failed after " + maxRetries + " attempts");
    }
}