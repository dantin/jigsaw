import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EnhancedDivTask implements Runnable {
    private int a;
    private int b;

    public EnhancedDivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double ans = a / b;
        System.out.println(ans);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor pools = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            pools.execute(new DivTask(100, i));
        }
    }
}