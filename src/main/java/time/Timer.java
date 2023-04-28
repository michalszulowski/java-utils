package time;

public class Timer {
    public static long measureTimeOf(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        long stop = System.currentTimeMillis();
        return stop - start;
    }
}
