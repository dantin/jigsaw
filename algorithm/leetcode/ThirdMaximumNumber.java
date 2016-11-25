import java.util.Arrays;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Integer a = nums[0], b = null, c = null;

        for(int i = 1; i < nums.length; i++) {
            if((a != null && nums[i] == a) || 
                (b != null && nums[i] == b) ||
                (c != null && nums[i] == c))
                continue;
            if(a == null || nums[i] > a) {
                c = b;
                b = a;
                a = nums[i];
            } else if(b == null || nums[i] > b) {
                c = b;
                b = nums[i];
            } else if(c == null || nums[i] > c) {
                c = nums[i];
            }
        }

        if(c != null) return c;
        if(b != null) return a;
        return a;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2};

        ThirdMaximumNumber solution = new ThirdMaximumNumber();
        System.out.println("Input:  " + Arrays.toString(nums));
        System.out.println("output: " + solution.thirdMax(nums));
    }
}