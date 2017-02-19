import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCombineDemo {

  public static Integer calc(Integer para) {
    return para / 2;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> intFunc = CompletableFuture.supplyAsync(() -> calc(50));
    CompletableFuture<Integer> intFunc2 = CompletableFuture.supplyAsync(() -> calc(25));

    CompletableFuture<Void> future = intFunc.thenCombine(intFunc2, (i, j) -> (i + j))
                                     .thenApply((i) -> Integer.toString(i))
                                     .thenApply((str) -> "\"" + str + "\"")
                                     .thenAccept(System.out::println);
    future.get();
  }
}