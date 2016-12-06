import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int sum = nums[low] + nums[high];
            if(sum == target) return new int[]{low+1, high+1};
            else if(sum < target) low++;
            else high--;
        }
        return new int[2];
    }

    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            int low = i + 1, high = nums.length - 1;
            while(low < high) {
                int mid = (low + high) / 2;
                if(t == nums[mid]) return new int[]{i+1, mid+1};
                else if(nums[mid] < t) low = mid + 1;
                else high = mid;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(nums));
        TwoSumIIInputArrayIsSorted solution = new TwoSumIIInputArrayIsSorted();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}