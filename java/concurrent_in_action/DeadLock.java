public class DeadLock extends Thread {

    protected Object tool;
    static Object fork1 = new Object();
    static Object fork2 = new Object();

    public DeadLock(Object obj) {
        this.tool = obj;
        if (tool == fork1) {
            this.setName("哲学家A");
        }
        if (tool == fork2) {
            this.setName("哲学家B");
        }
    }

    @Override
    public void run() {
        if (tool == fork1) {
            synchronized (fork1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (fork2) {
                System.out.println("哲学家A开始吃饭");
            }
        }

        if (tool == fork2) {
            synchronized (fork2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (fork1) {
                System.out.println("哲学家B开始吃饭");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread a = new DeadLock(fork1);
            Thread b = new DeadLock(fork2);
            a.start();
            b.start();
            Thread.sleep(1000);
            a.join();
            b.join();
        }
    }
}