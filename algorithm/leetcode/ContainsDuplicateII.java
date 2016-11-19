import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicateII {

    public boolean containsDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if(i > k) {
                set.remove(nums[i - k - 1]);
            }

            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        int k = 1;

        ContainsDuplicateII solution = new ContainsDuplicateII();
        System.out.println(Arrays.toString(nums));
        System.out.println("k: " + k);
        System.out.printf("%s duplicates.\n", solution.containsDuplicate(nums, k) ? "Contains" : "Not contains");
    }
}