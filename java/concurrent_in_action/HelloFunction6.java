import java.util.Arrays;
import java.util.function.IntConsumer;

public class HelloFunction6 {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {
        IntConsumer outprintln = System.out::println;
        IntConsumer errprintln = System.err::println;
        Arrays.stream(arr).forEach(outprintln.andThen(errprintln));
    }
}