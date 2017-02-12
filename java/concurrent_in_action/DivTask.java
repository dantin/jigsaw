import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DivTask implements Runnable {
    private int a;
    private int b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double ans = a / b;
        System.out.println(ans);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor pools = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            //
            // 1. use execute() to show exception stack
            //
            // pools.execute(new DivTask(100, i));
            //
            // 2. use Future to show exception
            //
            // Future re = pools.submit(new DivTask(100, i));
            // re.get();
            pools.submit(new DivTask(100, i));
        }
    }
}