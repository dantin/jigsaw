import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumXorOfTwoNumbersInAnArray {

    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 10, 5, 25, 2, 8};
        System.out.println(Arrays.toString(nums));

        MaximumXorOfTwoNumbersInAnArray solution = new MaximumXorOfTwoNumbersInAnArray();
        System.out.println(solution.findMaximumXOR(nums));
    }
}