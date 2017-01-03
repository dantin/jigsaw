import java.util.Arrays;
import java.util.LinkedList;

public class HouseRobber {

    public int rob1(int[] nums) {
        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
        LinkedList<Integer> dp = new LinkedList<>();
        dp.add(nums[0]);
        dp.add(Math.max(nums[0], nums[1]));
        for (int i = 2; i < nums.length; i++) {
            dp.add(Math.max(nums[i] + dp.get(i - 2), dp.peekLast()));
        }
        return dp.peekLast();
    }

    public int rob2(int[] nums) {
        int odd = 0, even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even += nums[i];
                even = Math.max(odd, even);
            } else {
                odd += nums[i];
                odd = Math.max(odd, even);
            }
        }
        return Math.max(odd, even);
    }

    public int rob(int[] nums) {
        int ans = 0;
        int hist = 0, pre = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(hist + nums[i], pre);
            hist = pre;
            pre = ans;
        }

        return Math.max(ans, pre);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5, 10, 1, 23, 8};

        HouseRobber solution = new HouseRobber();
        System.out.println(Arrays.toString(nums));
        System.out.println(solution.rob(nums));
    }
}