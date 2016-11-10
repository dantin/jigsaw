import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int fast = 1;
        int slow = 0;
        while(fast < nums.length) {
            if(nums[slow] == nums[fast]) {
                fast++;
            } else if(slow + 1 != fast) {
                nums[++slow] = nums[fast++];
            } else {
                slow++;
                fast++;
            }
        }
        return slow+1;
    }

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int j = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }   
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};

        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        System.out.println(Arrays.toString(nums));
        int len = solution.removeDuplicates(nums);
        System.out.printf("%s, length = %d\n", Arrays.toString(nums), len);
    }
}