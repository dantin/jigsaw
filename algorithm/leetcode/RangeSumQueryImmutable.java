import java.util.Arrays;

public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        int[] nums = new int[] { -2, 0, 3, -5, 2, -1};

        System.out.println(Arrays.toString(nums));

        NumArray numArray = new NumArray(nums);
        System.out.println("sumRange(0, 1): " + numArray.sumRange(0, 1));
        System.out.println("sumRange(1, 2): " + numArray.sumRange(1, 2));
    }
}

class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        this.sums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                sums[0] = nums[0];
                continue;
            }
            sums[i] = sums[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return sums[j];
        return sums[j] - sums[i-1];
    }
}
