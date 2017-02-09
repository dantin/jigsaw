import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class CountDownLatchDemo1 implements Runnable {

    static final CountDownLatch end = new CountDownLatch(1);

    @Override
    public void run() {
        try {
            end.await();
            System.out.println(Thread.currentThread().getId() + " begin");
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println(Thread.currentThread().getId() + " end");
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo1 r = new CountDownLatchDemo1();
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(r);
        }

        System.out.println("Fire!");
        end.countDown();

        Thread.sleep(11 * 1000);
        exec.shutdown();
    }
}