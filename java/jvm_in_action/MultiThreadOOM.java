public class MultiThreadOOM {

    public static class SleepThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1500; i++) {
            new Thread(new SleepThread(), "Thread" + i).start();
            System.out.printf("Thread %d created\n", i);
        }
    }
}