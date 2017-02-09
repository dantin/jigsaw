import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ReenterLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        lock.lock();
        try {
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition r = new ReenterLockCondition();
        Thread t = new Thread(r);
        t.start();
        Thread.sleep(2000);
        // 通知线程t继续执行
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}