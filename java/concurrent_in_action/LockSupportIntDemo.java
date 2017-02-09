import java.util.concurrent.locks.LockSupport;

public class LockSupportIntDemo {
    public static Object u = new Object();

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.out.println(getName() + " 被中断了");
                }
                System.out.println(getName() + "执行结束");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ChangeObjectThread("t1");
        Thread t2 = new ChangeObjectThread("t2");
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}