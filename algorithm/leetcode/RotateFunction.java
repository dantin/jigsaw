import java.util.Arrays;

public class RotateFunction {

    public int maxRotateFunction(int[] A) {
        int t = 0, sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            t += i * A[i];
        }

        int max = t;
        for(int i = 1; i < A.length; i++) {
            t = t + sum - A.length * A[A.length - i];
            max = Math.max(max, t);
        }
        
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 6};

        RotateFunction solution = new RotateFunction();
        System.out.println("Nums: " + Arrays.toString(nums));
        System.out.println("Max: " + solution.maxRotateFunction(nums));
    }
}