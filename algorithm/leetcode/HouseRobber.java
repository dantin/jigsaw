import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int res = Math.max(nums[0], nums[1]);
        if(nums.length == 2) return res;

        int hist = nums[0];
        int pre = res;
        for(int i = 2; i < nums.length; i++) {
            res = Math.max(hist + nums[i], pre);
            hist = pre;
            pre = res;
        }

        return Math.max(res, pre);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 10, 1, 23, 8};

        HouseRobber solution = new HouseRobber();
        System.out.println(Arrays.toString(nums));
        System.out.println(solution.rob(nums));
    }
}