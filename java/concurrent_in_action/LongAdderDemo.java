import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * 解决伪共享
 *
 *   @sun.misc.Contended
 *
 * java -XX:-RestrictContended LongAdderDemo
 */
public class LongAdderDemo {
    private static final int MAX_THREADS = 3;
    private static final int TASK_COUNT = 3;
    private static final int TARGET_COUNT = 10000000;

    private AtomicLong account = new AtomicLong(0L);
    private LongAdder laccount = new LongAdder();
    private long count = 0L;

    static CountDownLatch cdlsync = new CountDownLatch(TASK_COUNT);
    static CountDownLatch cdlatomic = new CountDownLatch(TASK_COUNT);
    static CountDownLatch cdladdr = new CountDownLatch(TASK_COUNT);

    protected synchronized long incr() {
        return count++;
    }

    protected synchronized long getCount() {
        return count;
    }

    public class SyncThread implements Runnable {
        protected String name;
        protected long starttime;
        LongAdderDemo out;

        public SyncThread(LongAdderDemo o, long starttime) {
            out = o;
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = out.getCount();
            while (v < TARGET_COUNT) {
                v = out.incr();
            }
            long endtime = System.currentTimeMillis();
            System.out.printf("SyncThread spend: %d ms, v = %d\n", (endtime - starttime), v);
            cdlsync.countDown();
        }
    }

    public class AtomicThread implements Runnable {
        protected String name;
        protected long starttime;

        public AtomicThread(long starttime) {
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = account.get();
            while (v < TARGET_COUNT) {
                v = account.incrementAndGet();
            }
            long endtime = System.currentTimeMillis();
            System.out.printf("SyncThread spend: %d ms, v = %d\n", (endtime - starttime), v);
            cdlatomic.countDown();
        }
    }

    public class LongAdderThread implements Runnable {
        protected String name;
        protected long starttime;

        public LongAdderThread(long starttime) {
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = laccount.sum();
            while (v < TARGET_COUNT) {
                laccount.increment();
                v = laccount.sum();
            }
            long endtime = System.currentTimeMillis();
            System.out.printf("LongAdder spend: %d ms, v = %d\n", (endtime - starttime), v);
            cdladdr.countDown();
        }
    }

    public void testSync() throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        SyncThread sync = new SyncThread(this, starttime);
        for (int i = 0; i < MAX_THREADS; i++) {
            exec.submit(sync);
        }
        cdlsync.await();
        exec.shutdown();
    }

    public void testAtomic() throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        AtomicThread atomic = new AtomicThread(starttime);
        for (int i = 0; i < MAX_THREADS; i++) {
            exec.submit(atomic);
        }
        cdlatomic.await();
        exec.shutdown();
    }

    public void testLongAdder() throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        LongAdderThread addr = new LongAdderThread(starttime);
        for (int i = 0; i < MAX_THREADS; i++) {
            exec.submit(addr);
        }
        cdladdr.await();
        exec.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        LongAdderDemo demo = new LongAdderDemo();
        demo.testSync();
        demo.testAtomic();
        demo.testLongAdder();
    }
}