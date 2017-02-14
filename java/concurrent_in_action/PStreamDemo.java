import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PStreamDemo {
    public static void main(String[] args) {
        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();

        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                Msg msg = new Msg();
                msg.i = i;
                msg.j = j;
                msg.org = String.format("((%f + %f) * %f) / 2", msg.i, msg.j, msg.i);
                Plus.bq.add(msg);
            }
        }
    }
}

class Msg {
    public double i;
    public double j;
    public String org = null;
}

class Plus implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.j = msg.i + msg.j;
                Multiply.bq.put(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Multiply implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.i = msg.i * msg.j;
                Div.bq.put(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Div implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.i /= 2;
                System.out.printf("%s = %f\n", msg.org, msg.i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}