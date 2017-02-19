import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExceptionDemo {

    public static Integer calc(Integer para) {
        return para / 0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calc(50))
        .exceptionally(ex -> {
            ex.printStackTrace();
            return 0;
        })
        .thenApply((i) -> Integer.toString(i))
        .thenApply((str) -> "\"" + str + "\"")
        .thenAccept(System.out::println);
        future.get();
    }
}