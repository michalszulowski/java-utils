package time;

public class Timer {
    private long startTime;

    public static long measureTimeOf(Runnable task) {
        Timer timer = new Timer();
        timer.start();
        task.run();
        return timer.getTime();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public long getTime() {
        return System.currentTimeMillis() - startTime;
    }
}
