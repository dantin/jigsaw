import java.util.Arrays;

public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];

        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int left, int right) {
        int ans = 0;
        int pre = 0, hist = 0;
        for (int i = left; i < right; i++) {
            ans = Math.max(hist + nums[i], pre);
            hist = pre;
            pre = ans;
        }
        return Math.max(ans, pre);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5, 10, 1, 23, 8};
        System.out.println(Arrays.toString(nums));

        HouseRobberII solution = new HouseRobberII();
        System.out.println(solution.rob(nums));
    }
}