import java.util.Arrays;

public class HelloFunction3 {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {
        Arrays.stream(arr).forEach((final int x) -> {
            System.out.println(x);
        });
    }
}