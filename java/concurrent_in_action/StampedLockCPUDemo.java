import java.util.concurrent.locks.StampedLock;
import java.util.concurrent.locks.LockSupport;

public class StampedLockCPUDemo {
    static Thread[] holdCpuThreads = new Thread[3];
    static final StampedLock lock = new StampedLock();

    public static class HoldCpuReadThread implements Runnable {
        @Override
        public void run() {
            long locker = lock.readLock();
            System.out.printf("%s 获得读锁\n", Thread.currentThread().getName());
            lock.unlockRead(locker);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                long readLong = lock.writeLock();
                LockSupport.parkNanos(600000000000L);
                lock.unlockWrite(readLong);
            }
        } .start();

        Thread.sleep(100);
        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i] = new Thread(new HoldCpuReadThread());
            holdCpuThreads[i].start();
        }
        Thread.sleep(10000);
        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i].interrupt();
        }
    }
}