import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(nums));
        Solution obj = new Solution(nums);
        int[] param_1 = obj.reset();
        System.out.println(Arrays.toString(param_1));
        int[] param_2 = obj.shuffle();
        System.out.println(Arrays.toString(param_2));
    }
}

class Solution {

    private int[] nums;
    private Random random = new Random();
    
    public Solution(int[] nums) {
        this.nums = new int[nums.length];
        System.arraycopy(nums, 0, this.nums, 0, nums.length);    
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] nums = new int[this.nums.length];
        System.arraycopy(this.nums, 0, nums, 0, this.nums.length);
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] nums = new int[this.nums.length];
        int length = this.nums.length;
        System.arraycopy(this.nums, 0, nums, 0, length);
        for(int i = 0; i < length; i++) {
            int j = random.nextInt(length - i);
            int tmp = nums[length-1-i];
            nums[length-1-i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
