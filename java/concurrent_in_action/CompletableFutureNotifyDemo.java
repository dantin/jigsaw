import java.util.concurrent.CompletableFuture;

public class CompletableFutureNotifyDemo {
    public static class AskThread implements Runnable {
        CompletableFuture<Integer> re = null;

        public AskThread(CompletableFuture<Integer> re) {
            this.re = re;
        }

        @Override
        public void run() {
            int ans = 0;
            try {
                ans = re.get() * re.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        Thread.sleep(1000);
        future.complete(60);
    }
}