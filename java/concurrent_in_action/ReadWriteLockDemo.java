import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public void handleRead(Lock lock) throws InterruptedException {
        lock.lock();
        try {
            Thread.sleep(1000);
            // return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int value) throws InterruptedException {
        lock.lock();
        try {
            Thread.sleep(1000);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable read = new Runnable() {
            @Override
            public void run() {
                try {
                    // demo.handleRead(readLock);
                    demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable write = new Runnable() {
            @Override
            public void run() {
                try {
                    // demo.handleWrite(writeLock, new Random().nextInt());
                    demo.handleWrite(lock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(read).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(write).start();
        }
    }
}