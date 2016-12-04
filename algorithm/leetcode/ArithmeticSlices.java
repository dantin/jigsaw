import java.util.Arrays;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int sum = 0, count = 0;
        int delta = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == delta) {
                count++;
                sum += count;
            } else {
                delta = A[i] - A[i - 1];
                count = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5, 6};

        System.out.println(Arrays.toString(array));

        ArithmeticSlices solution = new ArithmeticSlices();
        System.out.printf("%s arithmetic slices\n", solution.numberOfArithmeticSlices(array));
    }
}