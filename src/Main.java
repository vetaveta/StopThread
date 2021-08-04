import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
