import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> future = new FutureTask<String>(new RealData("a"));

        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.submit(future);

        System.out.println("请求完毕");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("数据: %s\n", future.get());
        exec.shutdown();
    }
}

class RealData implements Callable<String> {
    private String result;

    public RealData(String para) {
        this.result = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            buf.append(result);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return buf.toString();
    }
}