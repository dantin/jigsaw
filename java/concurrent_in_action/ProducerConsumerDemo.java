import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerDemo {
    public static class Producer implements Runnable {
        private volatile boolean isRunning = true;
        private BlockingQueue<PCData> queue;
        private static AtomicInteger count = new AtomicInteger();
        private static int SLEEP_TIME = 1000;

        public Producer(BlockingQueue<PCData> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            PCData data = null;
            Random random = new Random();

            System.out.printf("Start producer id = %d\n", Thread.currentThread().getId());
            try {
                while (isRunning) {
                    Thread.sleep(random.nextInt(SLEEP_TIME));
                    data = new PCData(count.incrementAndGet());
                    System.out.printf("%s is put into queue\n", count.toString());
                    if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                        System.err.printf("failed to put data: %s\n", data);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        public void stop() {
            isRunning = false;
        }
    }

    public static class Consumer implements Runnable {
        private BlockingQueue<PCData> queue;
        private static final int SLEEP_TIME = 1000;

        public Consumer(BlockingQueue<PCData> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            System.out.printf("start Consumer id = %d\n", Thread.currentThread().getId());
            Random random = new Random();

            try {
                while (true) {
                    PCData data = queue.take();
                    if (null != data) {
                        int re = data.getData() * data.getData();
                        System.out.printf("%d * %d = %d\n", data.getData(), data.getData(), re);
                        Thread.sleep(random.nextInt(SLEEP_TIME));
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public static final class PCData {
        private final int sequence;

        public PCData(int seq) {
            sequence = seq;
        }

        public int getData() {
            return this.sequence;
        }

        @Override
        public String toString() {
            return "data: " + sequence;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<>(10);

        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(p1);
        exec.execute(p2);
        exec.execute(p3);
        exec.execute(c1);
        exec.execute(c2);
        exec.execute(c3);
        Thread.sleep(10 * 1000);
        p1.stop();
        p2.stop();
        p3.stop();
        Thread.sleep(3000);
        System.out.println("shutdown");
        exec.shutdown();
    }
}