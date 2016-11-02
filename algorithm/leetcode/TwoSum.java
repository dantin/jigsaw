import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(nums[i]) && i != cache.get(nums[i])) {
                return new int[] {i, cache.get(nums[i])};
            }
            cache.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2, 7, 11, 15};
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(input, 9);

        System.out.printf("%d %d\n", result[0], result[1]);
    }
}