import java.util.stream.IntStream;

public class PrimeSum {
    public static void main(String[] args) {
        int limit = 50;
        int numThreads = Runtime.getRuntime().availableProcessors();

        int[] primeSum = {0};

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            final int start = (i * limit / numThreads) + 1;
            final int end = (i + 1) * limit / numThreads;

            threads[i] = new Thread(() -> {
                int localSum = IntStream.rangeClosed(start, end)
                        .filter(PrimeSum::isPrime)
                        .sum();

                synchronized (primeSum) {
                    primeSum[0] += localSum;
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum of prime numbers up to " + limit + ": " + primeSum[0]);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
