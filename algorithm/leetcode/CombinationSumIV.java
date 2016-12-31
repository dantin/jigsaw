import java.util.Arrays;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int n : nums) {
                if (i >= n) dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        int target = 4;

        CombinationSumIV solution = new CombinationSumIV();
        System.out.println(Arrays.toString(nums));
        System.out.println(target);

        System.out.println(solution.combinationSum4(nums, target));
    }
}