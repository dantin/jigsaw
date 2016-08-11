import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者的经典模式，等待／通知经典范式
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();
    static DateFormat format = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Nofity(), "NotifyThread");
        notifyThread.start();
    }

    /**
     * 消费者
     *
     * 获取对象的锁
     * 如果条件不满足，那么调用对象的wait()方法，被通知后仍要检查条件
     * 条件满足则执行对应的逻辑
     *
     * synchronized(对象) {
     *     while(条件不满足) {
     *         对象.wait();
     *     }
     *     对应的处理逻辑
     * }
     */
    static class Wait implements Runnable {
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 当条件不满足时，继续wait,同时释放了lock的锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait@ " + format.format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                // 条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. running@ " + format.format(new Date()));
            }
        }
    }

    /**
     * 生产者
     *
     * 获得对象的锁
     * 改变条件
     * 通知所有等待在对象上的线程
     *
     * synchronized(对象) {
     *     改变条件
     *     对象.notifyAll();
     * }
     */
    static class Nofity implements Runnable {
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
                // 直到当前线程释放了lock后，WaitThread才能从wait()方法中返回
                System.out.println(Thread.currentThread() + " hold lock, notify @ " + format.format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " + format.format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}