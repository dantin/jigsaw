import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int num) {
        if (num <= 0) return new int[] {0};
        int[] dp = new int[num + 1];
        int offset = 1;
        for (int i = 1; i <= num; i++) {
            if (i == (offset << 1)) offset <<= 1;
            dp[i] = dp[i - offset] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        int num = 5;

        CountingBits solution = new CountingBits();
        System.out.println(Arrays.toString(solution.countBits(num)));
    }
}