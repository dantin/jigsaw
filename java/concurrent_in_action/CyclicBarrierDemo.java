import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclic;

        public Soldier(String soldier, CyclicBarrier cyclic) {
            this.soldier = soldier;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                cyclic.await();
                doWork();
                cyclic.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(new Random().nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ": 任务完成");
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int n;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            this.n = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令: 士兵" + n + "个，任务完成！");
            } else {
                System.out.println("司令: 士兵" + n + "个，集合完毕！");
                flag = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int N = 10;
        Thread[] soldiers = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("集合！");
        for (int i = 0; i < N; i++) {
            System.out.println("士兵" + i + "报道!");
            soldiers[i] = new Thread(new Soldier("士兵" + i, cyclic));
            soldiers[i].start();
            // if(i==5) {
            //     soldiers[i].interrupt();
            // }
        }
    }
}