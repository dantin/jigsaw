import java.util.Arrays;
import java.util.function.IntConsumer;

public class HelloFunction2 {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {
        Arrays.stream(arr).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
    }
}