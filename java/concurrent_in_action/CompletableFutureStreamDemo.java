import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureStreamDemo {

    public static Integer calc(Integer para) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para * para;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calc(50))
                                               .thenApply((i) -> Integer.toString(i))
                                               .thenApply((str) -> "\"" + str + "\"")
                                               .thenAccept(System.out::println);
        future.get();
    }
}