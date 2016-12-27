import java.util.Arrays;

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int zero = 0, one = 0;
            int mask = 1 << i;
            for (int n : nums) {
                if ((mask & n) == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            ans += one * zero;
        }
        return ans;
    }

    public int totalHammingDistance1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                ans += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 14, 2};

        System.out.println(Arrays.toString(nums));
        TotalHammingDistance solution = new TotalHammingDistance();
        System.out.println(solution.totalHammingDistance(nums));
    }
}