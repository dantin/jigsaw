import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> ans = new LinkedList<>();
        
        Arrays.sort(nums);

        int prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == prev) {
                ans.add(nums[i]);
            }
            prev = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(Arrays.toString(nums));

        FindAllDuplicatesInAnArray solution = new FindAllDuplicatesInAnArray();
        System.out.println(solution.findDuplicates(nums));
    }
}