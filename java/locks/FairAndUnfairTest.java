import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairTest {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    public static void main(String[] args) {
        // System.out.println("fair lock");
        // testLock(fairLock);
        // System.out.println();

        System.out.println("unfair lock");
        testLock(unfairLock);
    }

    private static void testLock(Lock lock) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Job(lock), String.valueOf(i)).start();
        }
    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                // 连续多次打印当前Tread和队列中的Thread
                for (int i = 0; i < 2; i++) {
                    System.out.print("Lock by [" + Thread.currentThread().getName() + "] ");
                    print_list(lock);
                }
            } finally {
                lock.unlock();
            }
        }

        private void print_list(Lock lock) {
            ReentrantLock2 t_lock = (ReentrantLock2)lock;
            Collection<Thread> threads = t_lock.getQueuedThreads();
            System.out.print("waiting by: ");
            for (Thread t : threads) {
                System.out.print(t.getName() + " ");
            }
            System.out.println();
        }
    }


    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}